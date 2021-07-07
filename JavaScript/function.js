// Function
// - fundamental building block in the program
// - subgrogram can be used multiple times
// - performs a task or calciates a value

// 1. Function declation
// function name(param1, param2) { body ... return; }
// one function === one thing (한 개의 함수는 한가지 동작만 실행)
// naming : doSometing , command, verb 
// e.g. createCardAnd Point -> createCard, createPoint
// function is object in JS

function printHello() {
    console.log('Hello');
}

printHello();

function log(message) {
    console.log(message);
}

log('Hello~~!');
log(1234);


// 2. Parameters
// premitice parameters : passed by value
// object parameters : passed by reference
function changeName(obj) {
    obj.name = 'coder';
}
const seungmin = { name: 'seungmin' };
console.log(seungmin)

changeName(seungmin);
console.log(seungmin)


// 3. Default parameters (added in ES6)
function showMessage(message, from = 'unkonwn') {
    console.log(`${message} by ${from}`);
}

showMessage('Hi!');



// 4. Rest parameters
function printAll(...args) {
    for (let i = 0; i < args.length; i++) {
        console.log(args[i]);
    }
}

printAll(123, 456, 789);