package cn.webank.weidea.dao;

import java.math.BigInteger;
import java.util.List;

import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.channel.client.Service;
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
import cn.webank.weidea.entity.MedicalQueryRecord;
import cn.webank.weidea.mcc.QueryRecord;

@Repository
public class QueryRecordRepository {
	@Autowired
	private Service service;
	@Autowired
	private ContractAddressRepository contractAddressRepository;
	private QueryRecord queryRecord;

	private QueryRecord getQueryRecord() {
		if (queryRecord == null) {
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
				String contractAddress = contractAddressRepository.findAddressByCategory(QueryRecord.class.getName());
				if (contractAddress == null) {
					this.queryRecord = QueryRecord.deploy(web3, credentials, gasPrice, gasLimit, initialWeiValue).get();
					contractAddressRepository
							.save(new ContractAddress(queryRecord.getContractAddress(), QueryRecord.class.getName()));
				} else {
					this.queryRecord = QueryRecord.load(contractAddress, web3, credentials, gasPrice, gasLimit);
				}
			} catch (Exception e) {
				throw new BlockChainException(e);
			}
		}
		return this.queryRecord;
	}

	public int count() {
		QueryRecord queryRecord = getQueryRecord();
		try {
			return queryRecord.numhistoryRecords().get().getValue().intValue();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public MedicalQueryRecord findByIndex(int index) {
		QueryRecord queryRecord = getQueryRecord();
		try {
			List<Type> list = queryRecord.historyRecords(new Uint256(index)).get();
			MedicalQueryRecord medicalQueryRecord = new MedicalQueryRecord();
			medicalQueryRecord.setIdCard(list.get(0).getValue().toString());
			medicalQueryRecord.setHospitalAndDoctor(list.get(1).getValue().toString());
			medicalQueryRecord.setRecordHash(list.get(0).getValue().toString());
			medicalQueryRecord.setDate((list.get(0).getValue().toString()));
			return medicalQueryRecord;
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public void save(MedicalQueryRecord medicalQueryRecord) {
		QueryRecord queryRecord = getQueryRecord();
		try {
			queryRecord.saveHistoryRecord(new Utf8String(medicalQueryRecord.getIdCard()),
					new Utf8String(medicalQueryRecord.getHospitalAndDoctor()),
					new Uint256(medicalQueryRecord.getIndex()), new Utf8String(medicalQueryRecord.getDate()));
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}
}
