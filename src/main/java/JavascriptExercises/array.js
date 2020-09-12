





var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

var all = boys.concat(girls)

let SringGenders1 = all.join(',');
let StringGenders2 = all.join('-');


all.push('Lone')
all.push('Gitte')

all.unshift('Hans')
all.unshift('Kurt')


all.shift('Hans');
all.pop('Gitte');


all.splice(3,2)

function UpperCase(){
    return n.toUpperCase()
}

all.reverse(girls);
let allUpperCase = all.map(n => n.toUpperCase());

console.log(allUpperCase)
function filterName(arrayOfNames, index, letter) {
    var filteredNames = arrayOfNames.filter(function(word) {
     return word[index] === letter;
    });
    return filteredNames; 
}

let il = all.filter((n) => n.startsWith("L"));
console.log(il);