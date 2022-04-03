/*
   3.	Enhanced object properties: Create an ‘Order’ object having data members  ‘id’, ‘title’, ‘price’.
    Add the methods printOrder() & getPrice(). Now, 
   copy the order object using Object.assign().
  */

 let Order={
    id:10,
    title:'family pack Biryani',
    price:360,
    printOrder(){
        console.log(id+" "+this.title+" "+this.price)
    },
    getPrice(){
        return this.price;
    }
}

let CopyObject = Object.assign(Order);


console.log(CopyObject)