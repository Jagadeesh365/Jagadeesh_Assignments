/*  TypeScript Interfaces: Write an interface Printable. Create 2 objects circle & employee those implement 
Printable interface. Write a function printAll() that takes all objects as argument & invoke print() method on every object. */

interface Printable {
    print(): void;
  }
  
  class Circle implements Printable {
    radius: number;
    area: number;
    constructor(radius: number) {
      this.radius = radius;
      this.area = Math.PI * radius * radius;
    }
    print(): void {
      console.log(`Radius of Circle is: ${this.area}`);
    }
  }
  
  class Employee implements Printable {
    emp_id: number;
    emp_name: String;
    constructor(emp_id: number, emp_name: String) {
      this.emp_id = emp_id;
      this.emp_name = emp_name;
    }
    print() {
      console.log(`Employee ID: ${this.emp_id}\nEmployee Name: ${this.emp_name}`);
    }
  }
  
  let circle = new Circle(10);
  let employee = new Employee(1161, "Nitesh");
  
  function printAll(object1: any, object2: any) {
    object1.print();
    object2.print();
  }
  
  printAll(circle, employee);