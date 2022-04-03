function enableButton2() {
    document.getElementById("button2").disabled = false;
}


function showDetails() {
    var table = document.createElement("table");
    var thead = document.createElement('thead');
    var tbody = document.createElement("tbody");

    var row1 = document.createElement('tr');

    //creation of headers

    var heading1 = document.createElement('th');
    heading1.innerHTML = "Name:";

    var heading2 = document.createElement('th');
    heading2.innerHTML = "Email:";

    var heading3 = document.createElement('th');
    heading3.innerHTML = "Topping:";

    var heading4 = document.createElement('th');
    heading4.innerHTML = "Delivery:";

    var heading5 = document.createElement('th');
    heading5.innerHTML = "Tip %:";

    var heading6 = document.createElement('th');
    heading6.innerHTML = "Address:";

    var heading7 = document.createElement('th');
    heading7.innerHTML = "Total:";

    row1.appendChild(heading1);
    row1.appendChild(heading2);
    row1.appendChild(heading3);
    row1.appendChild(heading4);
    row1.appendChild(heading5);
    row1.appendChild(heading6);
    row1.appendChild(heading7);
    thead.appendChild(row1);

    //Adding data into a table 
    var row2 = document.createElement('tr');
    var row2col1 = document.createElement('td');
    row2col1.innerHTML = document.getElementById("name").value;

    var row2col2 = document.createElement('td');
    row2col2.innerHTML = document.getElementById("email").value;

    var checkboxes = document.getElementsByName('topping[]');
    var vals = "";
    var count = 0;
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        if (checkboxes[i].checked) {
            vals += checkboxes[i].value + ",";
            count++;
        }
    }

    var row2col3 = document.createElement('td');
    row2col3.innerHTML = vals;

    radVal = document.pizzaForm.yesNo.value;

    var row2col4 = document.createElement('td');
    row2col4.innerHTML = radVal;

    var row2col5 = document.createElement('td');
    row2col5.innerHTML = document.getElementById("tip").value;

    var row2col6 = document.createElement('td');
    row2col6.innerHTML = document.getElementById("addr").value;

    var total = 10 + (1.5 * count) + (5 * 1.0) + parseInt(document.getElementById("tip").value);
    var row2col7 = document.createElement('td');
    row2col7.innerHTML = total;

    row2.appendChild(row2col1);
    row2.appendChild(row2col2);
    row2.appendChild(row2col3);
    row2.appendChild(row2col4);
    row2.appendChild(row2col5);
    row2.appendChild(row2col6);
    row2.appendChild(row2col7);

    tbody.appendChild(row2);

    table.appendChild(thead);
    table.appendChild(tbody);

    document.getElementById("summary").appendChild(table);
    table.setAttribute("border", "2");
}