pragma solidity ^0.4.2;

contract Record{
    
    struct MedicalRecord{
        string idCard;
        string hospital;
        string category;
        string item;
        string diagnosis;
        string proposal;
        string date;
    }
    uint public numRecord = 0;
    MedicalRecord[] public records;
    
    function saveMedicalRecord(string idCard, string hospital, string category, string item,
      string diagnosis, string proposal,  string date) returns (bool)
    {
        records.push(MedicalRecord(
            { idCard: idCard,
              hospital: hospital,
              category: category,
              item: item,
              proposal: proposal,
              diagnosis: diagnosis,
              date:date
            }));
        numRecord = numRecord + 1;
        return true;
    }
/*
    function get() constant returns (uint)
    {
        
        return numRecord;
    }
*/
    

}