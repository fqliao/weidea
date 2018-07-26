pragma solidity ^0.4.2;
/**
This 用户身份信息注册
 */
contract Kyc{
    
    struct Person{
        string idCard;//身份证哈希值明文
        string publicKey; //明文
        string userName;//密文
        string phone;//密文
        string token;//明文 口令哈希
        uint8  sex; ////密文1 男，0女
    }
    uint public numPerson = 0;
    //uint public flag = 1;
    Person[] public persons;
    // mapping(string => Person) persons;

    function register(string idCard, string publicKey, string userName, string phone, //注册功能
             string token, uint8 sex)  returns (bool)
    {
        // 防止恶意用户重复注册
        for (uint i = 0; i < numPerson; i++)
        {
            if( keccak256(idCard) == keccak256(persons[i].idCard))
            {
               // flag = 1;
                return false;//return 出去 不能返回错误码,无论哪种情况都return出交易hash
            }
        }
        
        persons.push(Person(
            { idCard:idCard,
              publicKey:publicKey,
              userName:userName,
              phone:phone,
              token:token,
              sex:sex
        }));
        //flag = 0;
        numPerson = numPerson +1;
        return true;


    }

    function getPublicKey(string idCard) constant returns (string)
    {
        
        for (uint i = 0; i < numPerson; i++)
        {
            if(keccak256(idCard) == keccak256(persons[i].idCard))
            {
                return persons[i].publicKey;
            }
        }
        return "";
    }
        function getToken(string idCard) constant returns (string)
    {
        
        for (uint i = 0; i < numPerson; i++)
        {
            if(keccak256(idCard) == keccak256(persons[i].idCard))
            {
                return persons[i].token;//返回目的-对比token是否真实
            }
        }
        return "";
    }

    

}
