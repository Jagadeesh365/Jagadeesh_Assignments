/**
  5.Extended parameter handling:
  a.Write a add() with default values.
  b.Write a function userFriends() that takes 2 arguments username & array of user friends.
        The function should print username & his list of friends. (Use rest parameters)
  c.Write a function printCapitalNames() that takes five names as argument & prints them in 
        capital letters. Use spread operator in order to call printCapitalNames() function.
  */
 

// A. Defaul values ad()

function add(value1,value2=30){
    console.log(value1+value2);
}

add(20,30);
add(15);

// // b.Write a function userFriends() that takes 2 arguments username & array of user friends.
// The function should print username & his list of friends. (Use rest parameters)
// c.Write a function printCapitalNames() that takes five names as argument & prints them in 

let  userFriends=(username,...arg)=>{
    console.log("Name: "+username);
    console.log("Friends: ")
    for(i in arg){
    console.log(arg[i])
    }
}
 userFriends("john","tom","dick","harry");


//  c.Write a function printCapitalNames() that takes five names as argument & prints them in 
//         capital letters. Use spread operator in order to call printCapitalNames() function.
 function printCapitalNames(name1,name2,name3,name4,name5){
     console.log("Names after")
     console.log(name1.toUpperCase()+" "+name2.toUpperCase()+" "+name3.toUpperCase()+" "+name4.toUpperCase()+" "+name5.toUpperCase());
 } 

var nameList=["john","tom","nik","sam","wick"];
console.log("Names Before: ",nameList)
printCapitalNames(...nameList);
