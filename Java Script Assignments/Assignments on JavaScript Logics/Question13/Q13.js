function sumArray() {
    var arr1 = document.getElementById("arr1").value;
    var array1 = arr1.split(",");
    var j = 0, sumForLoop = 0, sumWhileLoop = 0, sumDoWhileLoop = 0;
    var arrInteger = [];
    for (var i = 0; i < array1.length; i++) {
        arrInteger.push(parseInt(array1[i]));
    }

    for (var i = 0; i < arrInteger.length; i++) {
        sumForLoop += arrInteger[i];
    }
    document.write("Sum of Array using for loop: " + sumForLoop);


    while (j < arrInteger.length) {
        sumWhileLoop += arrInteger[j];
        j += 1;
    }
    document.write("<br>Sum of Array using While loop: " + sumWhileLoop);

    var k = 0;
    do {
        sumDoWhileLoop += arrInteger[k];
        k += 1;
    } while (k < arrInteger.length);
    document.write("<br>Sum of Array using do While loop: " + sumDoWhileLoop);
}