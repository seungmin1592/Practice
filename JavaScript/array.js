'use strict';

// Array 


// 1. Declaration
// 배열 선언
const arr1 = new Array();
const arr2 = [1, 2];


// 2. Index position
const fruits = ['Apple', 'Banana'];
console.log(fruits)
console.log(fruits.length);
console.log(fruits[0]);

console.clear();


// 3. Looping over an array
// print all fruits

// a. for
for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i])
}

// b. for of
for (let fruit of fruits) {
    console.log(fruit);
}

// c. fotEach
fruits.forEach((fruit) => console.log(fruit));

console.clear();

// 4. Addition, deletion, copy
// push : add an item to the end
// 배열에 index 입력
fruits.push('peach', 'melon')
console.log(fruits)

// pop : remove an item from the end 
// 배열의 마지막 index 삭제
fruits.pop();
fruits.pop();
console.log(fruits)

// unshift : add an item to the beningging
// 배열의 첫번째 index 추가
fruits.unshift('remon');
console.log(fruits)

// shift : remove an item from the benigging
// 배열의 첫번째 index 삭제
fruits.shift();
console.log(fruits)

// note!! shift, unshift are slower than pop, push
// shift와 unshift는 pop와 push보다 느림
// 맨 앞에 값을 입력해야 하기 때문에 기존에 값을 뒤로 넘겨야하기 때문

// splice : remove an item by index position
// splice( 0번 index부터, 0개)
fruits.push('🥝', '🍇', '🍒');
console.log(fruits);
fruits.splice(1, 2); // index 1번부터 2개 삭제
console.log(fruits);
fruits.splice(1, 1, '🍉', '🍏'); // index 1번부터 1개 삭제 후 🍉,🍏를 해당 자리에 입력
console.log(fruits);


// combine two arrays
// 배열과 배열을 연결(합친다)
const fruits2 = ['🥞', '🍕'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits)


// 5. Searching
// find the index 
console.clear();
console.log(fruits);

// indexOf
console.log(fruits.indexOf('Apple')); // fruits 배열에 Apple이 몇번째 index에 있는지?

// includes
console.log(fruits.includes('Apple')); // fruits 배열에 Apple이 있는지? // 있으면 -> true 

// lastIndexOf
// 중복된 값이 있을 경우 마지막 index값
console.clear();
console.log(fruits);
fruits.push('Apple');
console.log(fruits);
console.log(fruits.lastIndexOf('Apple'));