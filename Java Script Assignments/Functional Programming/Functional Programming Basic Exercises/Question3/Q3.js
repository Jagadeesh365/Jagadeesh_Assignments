function isEven(num){
    if(num%2==0){
        return true;
    }
    else
        return false;
}
let arr=[1,3,5,4,2];
function find(arr,func){
    for(var i=0;arr.length;i++){
        if(func(arr[i])==true)
            return arr[i];
    }

}
console.log(find(arr,isEven));