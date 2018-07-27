package cn.webank.weidea.mcc;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class QueryRecord extends Contract {
    private static String BINARY = "60606040526000600055341561001157fe5b5b6105d8806100216000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063a15faa4f14610051578063afb63d0414610220578063b8da897214610309575bfe5b341561005957fe5b61006f600480803590602001909190505061032f565b604051808060200180602001858152602001806020018481038452888181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101065780601f106100db57610100808354040283529160200191610106565b820191906000526020600020905b8154815290600101906020018083116100e957829003601f168201915b50508481038352878181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101895780601f1061015e57610100808354040283529160200191610189565b820191906000526020600020905b81548152906001019060200180831161016c57829003601f168201915b505084810382528581815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561020c5780601f106101e15761010080835404028352916020019161020c565b820191906000526020600020905b8154815290600101906020018083116101ef57829003601f168201915b505097505050505050505060405180910390f35b341561022857fe5b610307600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061036c565b005b341561031157fe5b61031961042f565b6040518082815260200191505060405180910390f35b60018181548110151561033e57fe5b906000526020600020906004020160005b915090508060000190806001019080600201549080600301905084565b600180548060010182816103809190610435565b916000526020600020906004020160005b60806040519081016040528088815260200187815260200186815260200185815250909190915060008201518160000190805190602001906103d4929190610467565b5060208201518160010190805190602001906103f1929190610467565b50604082015181600201556060820151816003019080519060200190610418929190610467565b505050506001600054016000819055505b50505050565b60005481565b8154818355818115116104625760040281600402836000526020600020918201910161046191906104e7565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104a857805160ff19168380011785556104d6565b828001600101855582156104d6579182015b828111156104d55782518255916020019190600101906104ba565b5b5090506104e3919061053f565b5090565b61053c91905b808211156105385760006000820160006105079190610564565b6001820160006105179190610564565b600282016000905560038201600061052f9190610564565b506004016104ed565b5090565b90565b61056191905b8082111561055d576000816000905550600101610545565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061058a57506105a9565b601f0160209004906000526020600020908101906105a8919061053f565b5b505600a165627a7a72305820028310f7fc6d24356760fb5a18fa5e1f461156d0bfc73479bb3c3b1a389897ad0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"historyRecords\",\"outputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital_doctor\",\"type\":\"string\"},{\"name\":\"numRecord\",\"type\":\"uint256\"},{\"name\":\"date\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_idCard\",\"type\":\"string\"},{\"name\":\"_hospital_doctor\",\"type\":\"string\"},{\"name\":\"_numRecord\",\"type\":\"uint256\"},{\"name\":\"_date\",\"type\":\"string\"}],\"name\":\"saveHistoryRecord\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"numhistoryRecords\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"}]";

    private QueryRecord(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private QueryRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private QueryRecord(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private QueryRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<List<Type>> historyRecords(Uint256 param0) {
        Function function = new Function("historyRecords", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> saveHistoryRecord(Utf8String _idCard, Utf8String _hospital_doctor, Uint256 _numRecord, Utf8String _date) {
        Function function = new Function("saveHistoryRecord", Arrays.<Type>asList(_idCard, _hospital_doctor, _numRecord, _date), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void saveHistoryRecord(Utf8String _idCard, Utf8String _hospital_doctor, Uint256 _numRecord, Utf8String _date, TransactionSucCallback callback) {
        Function function = new Function("saveHistoryRecord", Arrays.<Type>asList(_idCard, _hospital_doctor, _numRecord, _date), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> numhistoryRecords() {
        Function function = new Function("numhistoryRecords", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<QueryRecord> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(QueryRecord.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<QueryRecord> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(QueryRecord.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static QueryRecord load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new QueryRecord(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static QueryRecord load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new QueryRecord(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static QueryRecord loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new QueryRecord(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static QueryRecord loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new QueryRecord(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}
