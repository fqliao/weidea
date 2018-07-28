pragma solidity ^0.4.2;

contract QueryRecord{
    
    struct HistoryRecord{
        string idCard; 
        string hospital_doctor;
        uint numRecord;
        string date;
    }
    uint public numhistoryRecords = 0;
    HistoryRecord[] public historyRecords;
    
    function saveHistoryRecord(string _idCard, string _hospital_doctor, uint _numRecord, string _date)
    {
        historyRecords.push(HistoryRecord(_idCard, _hospital_doctor, _numRecord, _date));
        numhistoryRecords = numhistoryRecords + 1;
    }
    

}