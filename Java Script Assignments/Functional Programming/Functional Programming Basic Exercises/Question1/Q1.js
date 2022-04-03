function square(x){
    return x*x;
}
function double(x){
    return 2*x;
}
function composedValue(square,double,f){
    return(square(double(f)));
}
console.log(composedValue(square(double(5))));