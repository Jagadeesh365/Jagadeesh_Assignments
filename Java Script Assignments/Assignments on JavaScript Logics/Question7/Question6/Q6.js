let printRectangularFrame =function (arr){
  const longest = arr.reduce((a, b) => a.length <= b.length ? b : a);
  const box_width = longest.length + 2;
  
  console.log("*".repeat(box_width));

  arr.map(str => console.log("*" + str + " ".repeat(box_width - (str.length + 2)) + "*"));

  console.log("*".repeat(box_width));
}
printRectangularFrame(frame=["Hello", "World", "in", "a", "frame"]);





