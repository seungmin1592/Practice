// 1. Use Strict
// added in ES5
// use this for Valina Javascript
// Javascript를 작성할 경우엔 맨 처음에 'use strict' 입력을 권장.

'use strict';


// 2. Variable
// let (added in ES6)

let globalName = 'global name';
{
    let name = 'seungmin';
    console.log(name);
    name = 'hello';
    console.log(name);
    console.log(globalName);
}

console.log(name);
console.log(globalName);


// var (don't ever use this)
// var hosting
// 어디에 선언해도 출력이 가능
// var는 사용 x
// { } 블록스콥이 없음
// IE에서는 ES6 지원 x
{
    age = 4;
    var age;
}
console.log(age);


// 3. Constants
// 한번 선언할 경우 변경 x
// immutable date type

const daysInweek = 7;
const maxNumber = 5;


// 4. Variable types
// primttive, single item : number, string, boolean, null, undefiedn, symbol
// object, box container
// function, first-class function


// Number
// Javascript에서는 숫자형타입을 number로 통일하여 사용한다.

const count = 17;
const size = 17.1;
console.log(`value: ${count}m `)

// bigInt
// 입력값 뒤에 n
const bigInt = 12312312312312312312313231n;



// String
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello' + brendan;
console.log(`value: ${greeting}, type : ${typeof greeting}`);

// template literals(String)
const helloBob = `hi ${brendan}!`;
console.log(`value: ${helloBob} , type : ${typeof helloBob}`);


// boolean
// true, false


// null
// 비어있는 값
let nothing = null;
console.log(`value: ${nothing} , type : ${typeof nothing}`);


// undefined
// 값이 지정되지 않음
let x;
console.log(`value: ${x} , type : ${typeof x}`);

// symbol
// 고유한 값
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2); // false
const gsymbol1 = Symbol.for('id');
const gsymbol2 = Symbol.for('id');
console.log(gsymbol1 === gsymbol2); // true

// object
const seungmin = { name: 'seungmin', age: 25 };
seungmin.age = 20;


// 5. Dynamic typing 
let text = 'hello';
console.log(`value : ${text}, type : ${typeof text}`); // string
text = 1;
console.log(`value : ${text}, type : ${typeof text}`); // number
text = '7' + 5;
console.log(`value : ${text}, type : ${typeof text}`); // string
text = '8' / '2';
console.log(`value : ${text}, type : ${typeof text}`); // number



