const x = new Promise<number>((resolve, reject) => {
    setTimeout(resolve, 100, 15);
  });
  
  const y = new Promise<number>((resolve, reject) => {
    setTimeout(resolve, 100, 45);
  });
  
  Promise.all([x, y]).then((values) => {
    console.log("Addition of x and y: "+ (values[0] + values[1]));
  });