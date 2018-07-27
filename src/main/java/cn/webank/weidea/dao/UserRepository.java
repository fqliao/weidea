package cn.webank.weidea.dao;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.webank.weidea.dao.exception.BlockChainException;
import cn.webank.weidea.entity.ContractAddress;
import cn.webank.weidea.entity.User;
import cn.webank.weidea.mcc.Kyc;

@Repository
public class UserRepository {
	@Autowired
	private Service service;
	@Autowired
	private ContractAddressRepository contractAddressRepository;
	private Kyc kyc;

	@PostConstruct
	private void init() {
		try {
			service.run();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	private Kyc getKcy() {
		if (kyc == null) {
			try {
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
				String contractAddress = contractAddressRepository.findAddressByCategory(Kyc.class.getName());
				if (contractAddress == null) {
					this.kyc = Kyc.deploy(web3, credentials, gasPrice, gasLimit, initialWeiValue).get();
					contractAddressRepository.save(new ContractAddress(kyc.getContractAddress(), Kyc.class.getName()));
				} else {
					this.kyc = Kyc.load(contractAddress, web3, credentials, gasPrice, gasLimit);
				}
			} catch (Exception e) {
				throw new BlockChainException(e);
			}
		}
		return this.kyc;
	}

	public String findPublishKey(String idCard) {
		Kyc kcy = getKcy();
		try {
			return kcy.getPublicKey(new Utf8String(idCard)).get().toString();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public void save(User user) {
		Kyc kcy = getKcy();
		try {
			kcy.register(new Utf8String(user.getIdCard()), new Utf8String(user.getPublishKey()),
					new Utf8String(user.getUsername()), new Utf8String(user.getPhone()), new Uint8(user.getSex()))
					.get();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public int count() {
		Kyc kcy = getKcy();
		try {
			return kcy.numPerson().get().getValue().intValue();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public User findByIndex(int index) {
		Kyc kcy = getKcy();
		try {
			User user = new User();
			List<Type> list = kcy.persons(new Uint256(index)).get();
			user.setIdCard(list.get(0).getValue().toString());
			user.setPublishKey(list.get(1).getValue().toString());
			user.setUsername(list.get(2).getValue().toString());
			user.setPhone(list.get(3).getValue().toString());
			user.setToken(list.get(4).getValue().toString());
			user.setSex(Integer.valueOf(list.get(5).getValue().toString()));
			return user;
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public void updatePhoneByIdCardAndToken(String idCard, String token, String phone) {
		try {
			getKcy().updatePhone(new Utf8String(idCard), new Utf8String(phone)).get();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}
}
