import { Account } from "../Accounts/Account.js";
export class CurrentAccount extends Account{
    constructor(id,name,balance,cash_credit){
           super(id,name,balance);
           this.cash_credit  = cash_credit;
    }
    getBalance(){
        this.totalBalance=0;
        this.totalBalance = this.balance -this.cash_credit;
        return this.totalBalance;
    }
 }