/* TypeScript classes & types: Write a class Account with attributes id, name, balance. Add two sub classes SavingAccount & CurrentAccount 
having specific attribute interest & cash_credit respectively. Create multiple saving & current account objects. Write a functionality to 
find out total balance in the bank. */

class Account {
    id: any;
    name: String;
    balance: number;
    constructor(id: any, name: String, balance: number) {
      this.id = id;
      this.name = name;
      this.balance = balance;
    }
  
    totalBalance(): number {
      return this.balance;
    }
  }
  
  class SavingAccount extends Account {
    constructor(id: any, name: String, balance: number, interest: number) {
      super(id, name, (balance = balance + (balance * interest) / 100));
    }
  }
  
  class CurrentAccount extends Account {
    constructor(id: any, name: String, balance: number, cash_credit: number) {
      super(id, name, (balance = balance + cash_credit));
    }
  }
  
  let savingAccount = new SavingAccount(1161, "Nitesh", 40000, 8);
  console.log(savingAccount.totalBalance());
  
  let currentAccount = new CurrentAccount(1201, "Sourav", 60000, 12000);
  console.log(currentAccount.totalBalance());