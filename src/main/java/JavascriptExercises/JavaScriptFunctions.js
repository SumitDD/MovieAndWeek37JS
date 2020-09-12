

//Observe: no return type, no type on parameters


function add(n1, n2) {
    return n1 + n2;
}


var sub = function (n1, n2) {
    return n1 - n2
}
var div = function (n1, n2) {
    return n1 / n2
}
var mul = function (n1, n2) {
    return n1 * n2
}

var cb = function (n1, n2, callback) {

    if (typeof n1 === "number" && typeof n2 === "number" && typeof callback === "function") {

        return "Result from the two numbers: " + n1 + "+" + n2 + "=" + callback(n1, n2)

    } else {
        throw new exception('Idiot');

    }
}



//1
console.log(add(1, 2))
//2
console.log(add)
//3
console.log(add(1, 2, 3))
//4
console.log(add(1));
//5
console.log(cb(3, 3, add))
//6
console.log(cb(4, 3, sub))
//7
//console.log(cb(3, 3, add()))
//8
console.log(cb(4, 3, mul))


try {
    console.log(cb(3, "hh", add));
} catch (e) {
    console.log('Idiot')
}

let names = ['Lars', 'Jan', 'Peter', 'Bo', 'Frederik', 'Sumit']
let length3 = names.filter(n => n.length <= 3)

console.log(names)
console.log(length3)

let namesUpperCase = names.map(n => n.toUpperCase())
let length3UpperCase = length3.map(n => n.toUpperCase())

console.log(length3UpperCase)
console.log(namesUpperCase)

//console.log(names[1])


let htmlArray = names.map(function (n) {

    return "<li>" + n + "</li>"


})

htmlArray.unshift("<ul>")
htmlArray.push("</ul>")

let stringArray = htmlArray.join(" ")
//console.log(stringArray)

var cars = [
    {id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000},
    {id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900},
    {id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000},
    {id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799},
    {id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799}
];

var filteredCarsYear = cars.filter(function (car) {
    return car.year > 1999;
})
var filteredCarsVolvos = cars.filter(function (car) {
    return car.make === 'Volvo';
})
var filteredCarsPrice = cars.filter(function (car) {
    return car.price < 5000;
})

console.log(filteredCarsPrice);




var sqlCars = cars.filter(x=> x.year > 1999).map(x=> 'INSERT INTO cars (id,year,make,model,price) VALUES(' + x.id + ", " + x.year + ", " + x.make + ", " + x.model + ", " + x.price + ") ") 

console.log(sqlCars.join(""))


