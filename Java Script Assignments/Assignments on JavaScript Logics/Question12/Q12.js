function findLongestWord(str) {
   var str1="",str2="";
   for(let i=0;i<str.length;i++)
   {
       if((str[i]!='a'&& str[i]!='b'))
       {
        str1+=str[i];
       }
       else if(str1.length>str2.length)
       {
           str2=str1;
           str1="";
       }
   }
    
    return str2;
  }
  document.write(findLongestWord("ababcdababefgababhiab"));
  
  document.write(findLongestWord("aba"));