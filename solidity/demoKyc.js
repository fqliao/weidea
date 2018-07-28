
/**
 * @file: demoKyc.js
 * @author: fisco-dev
 * 
 * @date: 2018
 */

var Web3= require('web3');
var config=require('../web3lib/config');
var fs=require('fs');
var execSync =require('child_process').execSync;
var web3sync = require('../web3lib/web3sync');
var BigNumber = require('bignumber.js');


if (typeof web3 !== 'undefined') {
  web3 = new Web3(web3.currentProvider);
} else {
  web3 = new Web3(new Web3.providers.HttpProvider(config.HttpProvider));
}

console.log(config);




var filename="Kyc";




var address=fs.readFileSync(config.Ouputpath+filename+'.address','utf-8');
var abi=JSON.parse(fs.readFileSync(config.Ouputpath/*+filename+".sol:"*/+filename+'.abi', 'utf-8'));
var contract = web3.eth.contract(abi);
var instance = contract.at(address);



console.log(filename+"contract address:"+address);



(async function(){
console.log("Test1 ");
// var name=instance.get(123);
 console.log("Test2 ");
  
  var func = "register(string,string,string,string,uint8)";//register注册功能 
 console.log("Test3");
	var params = ["456","pkc","groupone2","+81","002",1];//值依次为idCard，username，phoneNumber，token，sex
	//var params = ["123","groupone","+86","001",1];
 //var params = ["123","lfq","+86","token",1];
//	var userName = instance.register("123","lfq","+86","token",1);
	console.log("Test4");
  var receipt = await web3sync.sendRawTransaction(config.account, config.privKey, address, func, params);
	console.log("Test5");


 // console.log("Kyc contract set function call , "+'(transaction hash ：'+receipt.transactionHash+')');
	
 var  name=instance.get("123");//查询功能，需要输入idCard

  console.log("Contract get function call again:" + name);

 

})()
