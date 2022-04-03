function printNumbers(startNumbers ,endNumbers,increment){
    let sum=0;
    for( let i=startNumbers;i<=endNumbers;i+=increment)
    {
      if(i%3==0 || i%5==0)
      {
        console.log(i);
        sum+=i;
      }

    }
   console.log(sum);
  }
  
  let endNumber=parseInt(prompt("Enter Ending numner:"))
  printNumbers(startNumbers=1, endNumber, increment=1);