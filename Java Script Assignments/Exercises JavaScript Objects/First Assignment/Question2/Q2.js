

class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }
}

Rectangle.prototype.getArea = function () {
    return " Area of rectangle is: " + (this.width * this.height);
}

var sides1 = new Rectangle(18, 19);
var sides2 = new Rectangle(5, 6);

console.log(sides1.getArea());
console.log(sides2.getArea());