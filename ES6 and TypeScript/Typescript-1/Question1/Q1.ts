class FiboNumber {
    previousNo = Symbol();
    currentNo = Symbol();
    constructor(currentNum) {
      this.previousNo = currentNum;
    }
    next() {
      return Math.round((this.previousNo * (1 + Math.sqrt(5))) / 2.0);
    }
  }
  let fiboNumber = new FiboNumber(5);
  console.log(fiboNumber.next());