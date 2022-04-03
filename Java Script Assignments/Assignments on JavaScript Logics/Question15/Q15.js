function sorting() {
    var arr = [];
    for (var i = 0, maximum = 100; i < 20; i++) {
        arr.push(Math.round(Math.random() * maximum))
    }

    document.write("Original array is: " + arr);
    document.write("<br>Sorting through Bubble sort: " + bubbleSort(arr));
}

function bubbleSort(array) {
    for (var i = 0; i < array.length; i++) {
        for (var j = 0; j < array.length; j++) {
            if (array[j] > array[j + 1]) {
                var temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;
}