let concatenateTwoArrays =function(array1,array2){
    concatenateArray=[];
    let lenght=array1.lenght+array2.lenght;
    concatenateArray=[lenght];
    let pos=0
    for(let index in array1)
    {
        
        concatenateArray[pos]=array1[index];
      pos++;
    }
    for(let index in array2)
    {
        concatenateArray[pos]=array2[index];
      pos++;
    }
       let result="";
         for(let index in concatenateArray)
            {
                result+=`INDEX :${index} => VALUE : ${concatenateArray[index]}\n`;
             }
  console.log(result);
  };
  concatenateTwoArrays(array1=[10,20,30,40],array2=[50,60,70,80]);