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
    private static String BINARY = "60606040526000600055341561001157fe5b5b6109bd806100216000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063162841951461005157806334461067146100775780636044306c14610463575bfe5b341561005957fe5b61006161064f565b6040518082815260200191505060405180910390f35b341561007f57fe5b6100956004808035906020019091905050610655565b604051808060200180602001806020018060200180602001806020018060200188810388528f8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101365780601f1061010b57610100808354040283529160200191610136565b820191906000526020600020905b81548152906001019060200180831161011957829003601f168201915b505088810387528e8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156101b95780601f1061018e576101008083540402835291602001916101b9565b820191906000526020600020905b81548152906001019060200180831161019c57829003601f168201915b505088810386528d81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561023c5780601f106102115761010080835404028352916020019161023c565b820191906000526020600020905b81548152906001019060200180831161021f57829003601f168201915b505088810385528c8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156102bf5780601f10610294576101008083540402835291602001916102bf565b820191906000526020600020905b8154815290600101906020018083116102a257829003601f168201915b505088810384528b8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156103425780601f1061031757610100808354040283529160200191610342565b820191906000526020600020905b81548152906001019060200180831161032557829003601f168201915b505088810383528a8181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156103c55780601f1061039a576101008083540402835291602001916103c5565b820191906000526020600020905b8154815290600101906020018083116103a857829003601f168201915b50508881038252898181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156104485780601f1061041d57610100808354040283529160200191610448565b820191906000526020600020905b81548152906001019060200180831161042b57829003601f168201915b50509e50505050505050505050505050505060405180910390f35b341561046b57fe5b61064d600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506106a0565b005b60005481565b60028181548110151561066457fe5b906000526020600020906007020160005b9150905080600001908060010190806002019080600301908060040190806005019080600601905087565b600280548060010182816106b491906107e2565b916000526020600020906007020160005b60e0604051908101604052808b81526020018a8152602001898152602001888152602001878152602001868152602001858152509091909150600082015181600001908051906020019061071a929190610814565b506020820151816001019080519060200190610737929190610814565b506040820151816002019080519060200190610754929190610814565b506060820151816003019080519060200190610771929190610814565b50608082015181600401908051906020019061078e929190610814565b5060a08201518160050190805190602001906107ab929190610814565b5060c08201518160060190805190602001906107c8929190610814565b505050506001600054016000819055505b50505050505050565b81548183558181151161080f5760070281600702836000526020600020918201910161080e9190610894565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061085557805160ff1916838001178555610883565b82800160010185558215610883579182015b82811115610882578251825591602001919060010190610867565b5b5090506108909190610924565b5090565b61092191905b8082111561091d5760006000820160006108b49190610949565b6001820160006108c49190610949565b6002820160006108d49190610949565b6003820160006108e49190610949565b6004820160006108f49190610949565b6005820160006109049190610949565b6006820160006109149190610949565b5060070161089a565b5090565b90565b61094691905b8082111561094257600081600090555060010161092a565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061096f575061098e565b601f01602090049060005260206000209081019061098d9190610924565b5b505600a165627a7a723058209eee0d4de765fe9feb688ed2778a03b579d396cc70f4639165c9fad282779c630029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"numRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"records\",\"outputs\":[{\"name\":\"idCard\",\"type\":\"string\"},{\"name\":\"hospital_doctor\",\"type\":\"string\"},{\"name\":\"category\",\"type\":\"string\"},{\"name\":\"item\",\"type\":\"string\"},{\"name\":\"diagnosis\",\"type\":\"string\"},{\"name\":\"proposal\",\"type\":\"string\"},{\"name\":\"date\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_idCard\",\"type\":\"string\"},{\"name\":\"_hospital_doctor\",\"type\":\"string\"},{\"name\":\"_category\",\"type\":\"string\"},{\"name\":\"_item\",\"type\":\"string\"},{\"name\":\"_diagnosis\",\"type\":\"string\"},{\"name\":\"_proposal\",\"type\":\"string\"},{\"name\":\"_date\",\"type\":\"string\"}],\"name\":\"saveMedicalRecord\",\"outputs\":[],\"payable\":false,\"type\":\"function\"}]";

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

    public Future<TransactionReceipt> saveMedicalRecord(Utf8String _idCard, Utf8String _hospital_doctor, Utf8String _category, Utf8String _item, Utf8String _diagnosis, Utf8String _proposal, Utf8String _date) {
        Function function = new Function("saveMedicalRecord", Arrays.<Type>asList(_idCard, _hospital_doctor, _category, _item, _diagnosis, _proposal, _date), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void saveMedicalRecord(Utf8String _idCard, Utf8String _hospital_doctor, Utf8String _category, Utf8String _item, Utf8String _diagnosis, Utf8String _proposal, Utf8String _date, TransactionSucCallback callback) {
        Function function = new Function("saveMedicalRecord", Arrays.<Type>asList(_idCard, _hospital_doctor, _category, _item, _diagnosis, _proposal, _date), Collections.<TypeReference<?>>emptyList());
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
