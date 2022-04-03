function display(val) {
    document.getElementById("show").value += val;
}

function calculate() {
    var x = document.getElementById("show").value;
    var y = eval(x);
    document.getElementById("show").value = y;
}

function clear1() {
    document.getElementById("show").value = "";
}