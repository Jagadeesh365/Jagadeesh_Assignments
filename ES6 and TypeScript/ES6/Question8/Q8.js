/*
8)Classes & Modules: 
Write a class Account with attributes id, name, balance. 
Add two sub classes SavingAccount & CurrentAccount having specific attribute interest & cash_credit respectively.
 Create multiple saving & current account objects. 
Write a functionality to find out total balance in the bank.*/
import {SavingAccount} from "./SavingAccount/SavingAccount.js";
let savingAccount = new SavingAccount(11,"lokesk",1500,10);
console.log("Total Balance in Saving Account:"+savingAccount.getBalance())
import {CurrentAccount} from "./CurrentAccounts/CurrentAccount.js";
let CurrentAccountObj = new CurrentAccount(11,"pavan",15000,500);
console.log("Total Balance in Current Account:"+CurrentAccountObj.getBalance())