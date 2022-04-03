/*
 4.	Arrow functions: Take an array of strings & convert it into another array of object which has two properties {string, string_length}. For example:
let names = [‘Tom’, ‘Ivan’, ‘Jerry’]
Output: [ {name: ’Tom’, length: 3}, {name: ’Ivan’, length: 4 }, {name: ’Jerry’, length: 5} ]
 */
let names = ['Tom', 'Ivan', 'Jerry']
var arrowFunction = (names)=>{
   let tempArray=[];
    names.map((element)=>{
       let object={
           name:"",
           length:0
       };
       object.name=element;
       object.length= element.length;
       tempArray.push(object);
    })
    return tempArray;
}
console.log(arrowFunction(names));                               