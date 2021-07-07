// JSON
// JavaScript Object Notation


// 1. Object to JSON
// stringfy(obj)
let json = JSON.stringify(true);
console.log(json)

json = JSON.stringify(['apple', 'banana']);
console.log(json);

const rabbit = {
    name: 'tori',
    color: 'white',
    size: null,
    birthDate: new Date(),
    jump: () => {
        console.log(`${name} can jump!`);
    },
}

json = JSON.stringify(rabbit);
console.log(json)


json = JSON.stringify(rabbit, ['name', 'color']);
console.log(json)

json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key : ${key}, value : ${value}`);
    return key === 'name' ? 'seungmin' : value;
});
console.log(json);

// 2. JSON to Object
// parse(json)

console.clear();

json = JSON.stringify(rabbit);
console.log(json);
const obj = JSON.parse(json, (key, value) => {
    console.log(`key : ${key}, value : ${value}`);
    return key === 'birthDate' ? new Date(value) : value;
});
console.log(obj);

rabbit.jump();

// obj.jump();
// 함수는 json으로 stringfy될 때 변환되지 않았기 때문에 object로 parse해서 출력이 불가능함.
// 위 사항 유의하여 작성

console.log(rabbit.birthDate.getDate());
console.log(obj.birthDate.getDate());

