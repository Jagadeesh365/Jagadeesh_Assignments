function createTable() {

    var r = prompt("Enter Number of Rows: ");
    var c = prompt("Enter Number of Columns: ");

    var table = newFunction(r, c);

    document.getElementById("tb").appendChild(table);
}

function newFunction(r, c) {
    var table = document.createElement("table");
    var tbody = document.createElement("tbody");

    for (var i = 0; i < r; i++) {
        var row = document.createElement("tr");
        for (var j = 0; j < c; j++) {
            var cell = document.createElement("td");
            var cellText = document.createTextNode("Row[" + i + "]" + " Col[" + j + "]");
            cell.appendChild(cellText);
            row.appendChild(cell);
        }
        tbody.appendChild(row);
    }
    table.appendChild(tbody);
    tb.appendChild(table);
    table.setAttribute("border", "2");
    return table;
}