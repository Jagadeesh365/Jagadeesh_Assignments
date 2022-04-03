function printNumbers(startNumbers ,endNumbers,increment){
    let sum=0;
    for( let i=startNumbers;i<=endNumbers;i+=increment)
    {
      sum+=i;

    }
    document.write("sum from "+startNumbers+" to "+endNumbers+":"+sum);
  }
  
  let endNumber=parseInt(prompt("Enter Ending numner:"))
  printNumbers(startNumbers=1, endNumber, increment=1);5