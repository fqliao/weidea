package cn.webank.weidea.dao;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.bcos.channel.client.Service;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.EthBlockNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.webank.weidea.dao.exception.BlockChainException;
import cn.webank.weidea.mcc.Kyc;

@Repository
public class UserRepository {
	@Autowired
	private Service service;

	@PostConstruct
	private void init() {
		try {
			service.run();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	private Kyc getKcy() {

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
			return Kyc.deploy(web3, credentials, gasPrice, gasLimit, initialWeiValue).get();
		} catch (Exception e) {
			throw new BlockChainException(e);
		}
	}

	public void find() {
		Kyc kcy = getKcy();
	}
}
