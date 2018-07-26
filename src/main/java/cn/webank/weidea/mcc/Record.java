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
public final class Record extends Contract {
    private static String BINARY = "60606040526000600055341561001157fe5b5b610a19806100216000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063162841951461005c57806334461067146100825780636044306c1461046e5780636d4ce63c14610672575bfe5b341561006457fe5b61006c610698565b6040518082815260200191505060405180910390f35b341561008a57fe5b6100a0600480803590602001909190505061069e565b604051808060200180602001806020018060200180602001806020018060200188810388528f8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101415780601f1061011657610100808354040283529160200191610141565b820191906000526020600020905b81548152906001019060200180831161012457829003601f168201915b505088810387528e8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101c45780601f10610199576101008083540402835291602001916101c4565b820191906000526020600020905b8154815290600101906020018083116101a757829003601f168201915b505088810386528d8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156102475780601f1061021c57610100808354040283529160200191610247565b820191906000526020600020905b81548152906001019060200180831161022a57829003601f168201915b505088810385528c8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156102ca5780601f1061029f576101008083540402835291602001916102ca565b820191906000526020600020905b8154815290600101906020018083116102ad57829003601f168201915b505088810384528b81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561034d5780601f106103225761010080835404028352916020019161034d565b820191906000526020600020905b81548152906001019060200180831161033057829003601f168201915b505088810383528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156103d05780601f106103a5576101008083540402835291602001916103d0565b820191906000526020600020905b8154815290600101906020018083116103b357829003601f168201915b50508881038252898181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156104535780601f1061042857610100808354040283529160200191610453565b820191906000526020600020905b81548152906001019060200180831161043657829003601f168201915b50509e50505050505050505050505050505060405180910390f35b341561047657fe5b610658600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506106e9565b604051808215151515815260200191505060405180910390f35b341561067a57fe5b610682610833565b6040518082815260200191505060405180910390f35b60005481565b6001818154811015156106ad57fe5b906000526020600020906007020160005b9150905080600001908060010190806002019080600301908060040190806005019080600601905087565b6000600180548060010182816106ff919061083e565b916000526020600020906007020160005b60e0604051908101604052808c81526020018b81526020018a81526020018981526020018881526020018781526020018681525090919091506000820151816000019080519060200190610765929190610870565b506020820151816001019080519060200190610782929190610870565b50604082015181600201908051906020019061079f929190610870565b5060608201518160030190805190602001906107bc929190610870565b5060808201518160040190805190602001906107d9929190610870565b5060a08201518160050190805190602001906107f6929190610870565b5060c0820151816006019080519060200190610813929190610870565b50505050600160005401600081905550600190505b979650505050505050565b600060005490505b90565b81548183558181151161086b5760070281600702836000526020600020918201910161086a91906108f0565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106108b157805160ff19168380011785556108df565b828001600101855582156108df579182015b828111156108de5782518255916020019190600101906108c3565b5b5090506108ec9190610980565b5090565b61097d91905b8082111561097957600060008201600061091091906109a5565b60018201600061092091906109a5565b60028201600061093091906109a5565b60038201600061094091906109a5565b60048201600061095091906109a5565b60058201600061096091906109a5565b60068201600061097091906109a5565b506007016108f6565b5090565b90565b6109a291905b8082111561099e576000816000905550600101610986565b5090565b90565b50805460018160011615610100020316600290046000825580601f106109cb57506109ea565b601f0160209004906000526020600020908101906109e99190610980565b5b505600a165627a7a723058202bb9efa9570dec05011e9a870c3927cd72c683627ae061c884900a493b88785e0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"numRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"records\",\"outputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"item\",\"type\":\"string\"},{\"name\":\"diagnosis\",\"type\":\"string\"},{\"name\":\"proposal\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"item\",\"type\":\"string\"},{\"name\":\"diagnosis\",\"type\":\"string\"},{\"name\":\"proposal\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"}],\"name\":\"saveMedicalRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"}]";

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

    public Future<Uint256> get() {
        Function function = new Function("get", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
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
