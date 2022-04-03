function randomArrayOperations() {
    var arr = [];
    var even = 0, odd = 0, sum = 0, average = 0;
    for (var i = 0, maximum = 500; i < 100; i++) {
        arr.push(Math.round(Math.random() * maximum))
    }

    document.write("Original array is: " + arr);

    document.write("<br><br>Largest number from array is: " + Math.max.apply(Math, arr));
    document.write("<br>Smallest number from array is: " + Math.min.apply(Math, arr));

    for (var i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 0) {
            even++;
        }
        else {
            odd++;
        }
    }

    if (even > odd) {
        document.write("<br>Even numbers are higher: " + even);
    }
    else {
        document.write("<br>Odd numbers are higher: " + odd);
    }

    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    document.write("<br>Sum of Array is: " + sum);
    document.write("<br>Average of Array is: " + sum / 100);


}