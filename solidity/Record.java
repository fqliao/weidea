package MCC;

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
public final class Record extends Contract {
    private static String BINARY = "60606040526000600055341561001157fe5b5b6109dd806100216000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063162841951461005157806334461067146100775780636044306c14610463575bfe5b341561005957fe5b610061610667565b6040518082815260200191505060405180910390f35b341561007f57fe5b610095600480803590602001909190505061066d565b604051808060200180602001806020018060200180602001806020018060200188810388528f8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101365780601f1061010b57610100808354040283529160200191610136565b820191906000526020600020905b81548152906001019060200180831161011957829003601f168201915b505088810387528e8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101b95780601f1061018e576101008083540402835291602001916101b9565b820191906000526020600020905b81548152906001019060200180831161019c57829003601f168201915b505088810386528d81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561023c5780601f106102115761010080835404028352916020019161023c565b820191906000526020600020905b81548152906001019060200180831161021f57829003601f168201915b505088810385528c8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156102bf5780601f10610294576101008083540402835291602001916102bf565b820191906000526020600020905b8154815290600101906020018083116102a257829003601f168201915b505088810384528b8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156103425780601f1061031757610100808354040283529160200191610342565b820191906000526020600020905b81548152906001019060200180831161032557829003601f168201915b505088810383528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156103c55780601f1061039a576101008083540402835291602001916103c5565b820191906000526020600020905b8154815290600101906020018083116103a857829003601f168201915b50508881038252898181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156104485780601f1061041d57610100808354040283529160200191610448565b820191906000526020600020905b81548152906001019060200180831161042b57829003601f168201915b50509e50505050505050505050505050505060405180910390f35b341561046b57fe5b61064d600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506106b8565b604051808215151515815260200191505060405180910390f35b60005481565b60018181548110151561067c57fe5b906000526020600020906007020160005b9150905080600001908060010190806002019080600301908060040190806005019080600601905087565b6000600180548060010182816106ce9190610802565b916000526020600020906007020160005b60e0604051908101604052808c81526020018b81526020018a81526020018981526020018881526020018781526020018681525090919091506000820151816000019080519060200190610734929190610834565b506020820151816001019080519060200190610751929190610834565b50604082015181600201908051906020019061076e929190610834565b50606082015181600301908051906020019061078b929190610834565b5060808201518160040190805190602001906107a8929190610834565b5060a08201518160050190805190602001906107c5929190610834565b5060c08201518160060190805190602001906107e2929190610834565b50505050600160005401600081905550600190505b979650505050505050565b81548183558181151161082f5760070281600702836000526020600020918201910161082e91906108b4565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061087557805160ff19168380011785556108a3565b828001600101855582156108a3579182015b828111156108a2578251825591602001919060010190610887565b5b5090506108b09190610944565b5090565b61094191905b8082111561093d5760006000820160006108d49190610969565b6001820160006108e49190610969565b6002820160006108f49190610969565b6003820160006109049190610969565b6004820160006109149190610969565b6005820160006109249190610969565b6006820160006109349190610969565b506007016108ba565b5090565b90565b61096691905b8082111561096257600081600090555060010161094a565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061098f57506109ae565b601f0160209004906000526020600020908101906109ad9190610944565b5b505600a165627a7a72305820fe1ba31ec50c16125388b71743a2b6727d9bb4005c234abebdab10c4915bd4240029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"numRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"records\",\"outputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"item\",\"type\":\"string\"},{\"name\":\"diagnosis\",\"type\":\"string\"},{\"name\":\"proposal\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"item\",\"type\":\"string\"},{\"name\":\"diagnosis\",\"type\":\"string\"},{\"name\":\"proposal\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"}],\"name\":\"saveMedicalRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"}]";

    private Record(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private Record(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private Record(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public Future<Uint256> numRecord() {
        Function function = new Function("numRecord", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> records(Uint256 param0) {
        Function function = new Function("records", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> saveMedicalRecord(Utf8String idCard, Utf8String hospital, Utf8String category, Utf8String item, Utf8String diagnosis, Utf8String proposal, Utf8String date) {
        Function function = new Function("saveMedicalRecord", Arrays.<Type>asList(idCard, hospital, category, item, diagnosis, proposal, date), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void saveMedicalRecord(Utf8String idCard, Utf8String hospital, Utf8String category, Utf8String item, Utf8String diagnosis, Utf8String proposal, Utf8String date, TransactionSucCallback callback) {
        Function function = new Function("saveMedicalRecord", Arrays.<Type>asList(idCard, hospital, category, item, diagnosis, proposal, date), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<Record> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Record.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<Record> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Record.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Record load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static Record load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static Record loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static Record loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Record(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }
}
