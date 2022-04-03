function square(x){
    return x*x;
}
function double(x){
    return 2*x;
}
let f1= function (func1,func2,f)
{
   return(func1(func2(f)));
};
let f2= function (func1,func2,f)
{
   return(func1(func2(f)));
};
console.log("*****f1()*****");
console.log(f1(square,double,5));
console.log(f1(square,double,10));

console.log("*****f2()*****");
console.log(f2(double,square,5));
console.log(f2(double,square,10));