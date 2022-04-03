/* Make a variable whose value is an object with firstName and lastName properties, but don’t define
a Person class first. Try looking up the first and last names. Try changing the last name. It seems
very odd to Java programmers to make an object without first defining a class, but JavaScript programmers do this sort of thing all the time. */

var person = {
    firstName: "Jagadeeh",
    lastName: "Gudipalli"
};
console.log("Full name: " + person.firstName + " " + person.lastName);

person.lastName = "Gopireddy";

console.log("Here I have changed last name " + person.lastName);

