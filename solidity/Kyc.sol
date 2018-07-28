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
        uint8  sex; ////密文1 男，0女
    }
    uint public numPerson = 0;
    Person[] public persons;

    function register(string _idCard, string _publicKey, string _userName, string _phone, //注册功能
             uint8 _sex)  returns (bool)
    {
        // 防止恶意用户重复注册
        for (uint i = 0; i < numPerson; i++)
        {
            if( keccak256(_idCard) == keccak256(persons[i].idCard))
            {
                return false;//return 出去 不能返回错误码,无论哪种情况都return出交易hash
            }
        }
        
        persons.push(Person(
            { idCard: _idCard,
              publicKey: _publicKey,
              userName: _userName, 
              phone: _phone, 
              sex: _sex
              }));
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

    
    function updatePhone(string _idCard, string _phone)
    {
        
        for (uint i = 0; i < numPerson; i++)
        {
            if(keccak256(_idCard) == keccak256(persons[i].idCard))
            {
                persons[i].phone = _phone;
                return;
            }
        }
        
    }

    

}