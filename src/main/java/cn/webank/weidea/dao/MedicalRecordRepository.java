package cn.webank.weidea.dao;

import java.math.BigInteger;
import java.util.List;

import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.webank.weidea.dao.exception.BlockChainException;
import cn.webank.weidea.entity.ContractAddress;
import cn.webank.weidea.entity.MedicalRecord;
import cn.webank.weidea.mcc.Record;

@Repository
public class MedicalRecordRepository {
	@Autowired
	private Service service;
	@Autowired
	private ContractAddressRepository contractAddressRepository;
	private Record record;

	private Record getRecord() {
		if (record == null) {
			try {
				service.run();
				ChannelEthereumService channelEthereumService = new ChannelEthereumService();
				channelEthereumService.setChannelService(service);

				// 使用AMOP消息信道初始化web3j
				Web3j web3 = Web3j.build(channelEthereumService);

				// 初始化交易签名私钥
				ECKeyPair keyPair = Keys.createEcKeyPair();
				Credentials credentials = Credentials.create(keyPair);

				// 初始化交易参数
				java.math.BigInteger gasPrice = new BigInteger("30000000");
				java.math.BigInteger gasLimit = new BigInteger("30000000");
				java.math.BigInteger initialWeiValue = new BigInteger("0");
				// 部署合约
				String contractAddress = contractAddressRepository.findAddressByCategory(Record.class.getName());
				if (contractAddress == null) {
					this.record = Record.deploy(web3, credentials, gasPrice, gasLimit, initialWeiValue).get();
					contractAddressRepository
							.save(new ContractAddress(record.getContractAddress(), Record.class.getName()));
				} else {
					this.record = Record.load(contractAddress, web3, credentials, gasPrice, gasLimit);
				}
			} catch (Exception e) {
				throw new BlockChainException(e);
			}
		}
		return this.record;
	}

	public int count() {
		Record record = getRecord();
		try {
			return record.numRecord().get().getValue().intValue();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public MedicalRecord findByIndex(int index) {
		Record record = getRecord();
		try {
			MedicalRecord medicalRecord = new MedicalRecord();
			List<Type> list = record.records(new Uint256(index)).get();
			medicalRecord.setIdCard(list.get(0).getValue().toString());
			medicalRecord.setHospitalAndDoctor(list.get(1).getValue().toString());
			medicalRecord.setCategory(list.get(2).getValue().toString());
			medicalRecord.setItem(list.get(3).getValue().toString());
			medicalRecord.setDiagnosis(list.get(4).getValue().toString());
			medicalRecord.setProposal(list.get(5).getValue().toString());
			medicalRecord.setDate(list.get(6).getValue().toString());
			return medicalRecord;
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public void save(MedicalRecord medicalRecord) {
		Record record = getRecord();
		try {
			record.saveMedicalRecord(new Utf8String(medicalRecord.getIdCard()),
					new Utf8String(medicalRecord.getHospitalAndDoctor()), new Utf8String(medicalRecord.getCategory()),
					new Utf8String(medicalRecord.getItem()), new Utf8String(medicalRecord.getDiagnosis()),
					new Utf8String(medicalRecord.getProposal()), new Utf8String(medicalRecord.getDate())).get();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

}
