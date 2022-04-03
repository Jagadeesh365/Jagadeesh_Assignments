

class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }
}

var sides1 = new Rectangle(18, 19);
var sides2 = new Rectangle(5, 6);

console.log("Sides of first Rectangle is :Width: " + sides1.width, ", Height: " + sides1.height);
console.log("Sides of Second Rectangle is :Width: " + sides2.width, ", Height: " + sides2.height);