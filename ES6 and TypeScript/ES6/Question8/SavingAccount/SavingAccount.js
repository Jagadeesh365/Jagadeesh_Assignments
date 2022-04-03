import { Account } from "../Accounts/Account.js";
export class SavingAccount extends Account{
    constructor(id,name,balance,interest){
           super(id,name,balance);
           this.interest  = interest;
    }
    getBalance(){
        this.totalBalance=0;
        this.totalBalance = this.balance + (this.balance*this.interest);
        return this.totalBalance;
    }
 }