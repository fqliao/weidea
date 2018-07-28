pragma solidity ^0.4.2;

contract Record{
    
    struct MedicalRecord{
        string idCard;
        string hospital_doctor;
        string category;
        string item;
        string diagnosis;
        string proposal;
        string date;
    }
    uint public numRecord = 0;
    string recordHash;
    MedicalRecord[] public records;
    
    function saveMedicalRecord(string _idCard, string _hospital_doctor, string _category, string _item,
      string _diagnosis, string _proposal, string _date)
    {
        records.push(MedicalRecord(
            {
                idCard: _idCard, 
                hospital_doctor: _hospital_doctor, 
                category: _category, 
                item: _item, 
                proposal: _proposal, 
                diagnosis: _diagnosis, 
                date: _date
            }));
        numRecord = numRecord + 1;
    } 

}