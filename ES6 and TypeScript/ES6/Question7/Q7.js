/**
7.	De-structuring assignment:
a.	Suppose there is a javascript array with 4 elements.
     Print the value of 3rd element using array matching.
b.	Create an organization object having attributes name, address.
     Write a program to retrieve pin code of an address using object deep matching.
 */

let names = ["pavan", "lokesh", "teja", "goutam"];
let [firstname,secondname,thirdname,fourthname]= names;
console.log(thirdname);



var organization ={
    name:"best",
    address:{
        city:"Near",
        state:"All",
        pincode:524023
    }
}

const {address:{city:city1,state:state1,pincode:pincode1}}=organization;

console.log(pincode1);