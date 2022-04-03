let reverseArray=function()  {
    
    document.write("Original Array: " + arr);
    var reverseArr = arr.reverse();
    document.write("<br>After Reversing: " + reverseArr);

};
var arr = [];
    for (var i = 0, maximum = 48; i < 9; i++) {
        arr.push(Math.round(Math.random() * maximum))
    }
reverseArray(arr);