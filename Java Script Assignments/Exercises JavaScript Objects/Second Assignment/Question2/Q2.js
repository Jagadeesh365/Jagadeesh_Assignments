function person(fname, lname, age, skills, dateofbirth, address, married, profession) {
    this.fname = fname;
    this.lname = lname;
    this.age = age;
    this.skills = skills;
    this.dateofbirth = dateofbirth;
    this.address = address;
    this.married = married;
    this.profession = profession;
}
lokesh = new person("lokesh", "THAATHAA", 22, ["c"], "24/10/2007", { city: "hyderabad", pincode: "524201" }, "false", "sranalyst")
apavan = new person("pvan", 21, "HTML", "08/06/2009", "false", "jr analyst")
var pavan = Object.create(lokesh);
print = function () {
    console.log(lokesh);
    console.log(pavan.lname);
    console.log(pavan.fname);

    console.log(pavan.address);
}();