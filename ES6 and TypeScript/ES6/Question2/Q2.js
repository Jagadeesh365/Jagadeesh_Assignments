/*
 * 2.	Scoping: Declare a variable inside if condition & make sure that it is not  accessible outside if condition
 */

 let test=(num)=>{
    if(num%2){
        let x = num;
        console.log(x);
    }
    else{
        console.log(x);  
    }
}

test(10);