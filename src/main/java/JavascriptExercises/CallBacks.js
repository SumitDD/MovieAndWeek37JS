






var msgPrinter = function (msg, delay) {
    setTimeout(function () {
        console.log(msg);
    }, delay);
};
console.log("aaaaaaaaaa");//1
msgPrinter("bbbbbbbbbb", 2000);//5
console.log("dddddddddd");//2
msgPrinter("eeeeeeeeee", 1000);//4
console.log("ffffffffff");//3
