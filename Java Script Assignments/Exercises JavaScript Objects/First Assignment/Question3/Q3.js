
class Rectangle {
    constructor(width, height) {
        Object.defineProperty(this, "width", {
            value: width,
            writable: false,
            configurable: false,
            enumerable: true, // or false, doesn't matter
        });

        Object.defineProperty(this, "height", {
            value: height,
            writable: false,
            configurable: false,
            enumerable: true, // or false, doesn't matter
        });
    }
}

Rectangle.prototype.getArea = function () {
    var areaWidth = this.width;
    var areaHeight = this.height;
    return " Area of rectangle is: " + (areaWidth * areaHeight);
}

var sides1 = new Rectangle(6, 5);
sides1.height = 50;

console.log(sides1.getArea());