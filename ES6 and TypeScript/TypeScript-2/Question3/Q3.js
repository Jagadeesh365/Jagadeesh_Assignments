/*  TypeScript Interfaces: Write an interface Printable. Create 2 objects circle & employee those implement
Printable interface. Write a function printAll() that takes all objects as argument & invoke print() method on every object. */
var Circle = /** @class */ (function () {
    function Circle(radius) {
        this.radius = radius;
        this.area = Math.PI * radius * radius;
    }
    Circle.prototype.print = function () {
        console.log("Radius of Circle is: ".concat(this.area));
    };
    return Circle;
}());
var Employee = /** @class */ (function () {
    function Employee(emp_id, emp_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }
    Employee.prototype.print = function () {
        console.log("Employee ID: ".concat(this.emp_id, "\nEmployee Name: ").concat(this.emp_name));
    };
    return Employee;
}());
var circle = new Circle(10);
var employee = new Employee(1161, "Nitesh");
function printAll(object1, object2) {
    object1.print();
    object2.print();
}
printAll(circle, employee);