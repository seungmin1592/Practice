'use strict';


// Q1. make a string out of array
// 배열을 문자형으로 변환

// join()
// 배열 안의 값을 문자형으로 출력
// ()안에 구분자를 입력하면 배열 사이에 구분자가 입력된다.
{
    const fruits = ['apple', 'banana', 'orange'];
    const result = fruits.join('/');
    console.log(result);
}
console.clear();


// Q2. make an array out of a string
// 문자형을 배열로 변환

// split()
// 구분자를 기준으로 해당 값을 index 1개로 나눠서 배열로 출력한다.
{
    const fruits = '🍈,🍋,🍒,🍓';
    console.log(fruits)
    const result = fruits.split(',');
    console.log(result)
}
console.clear();


// 03. make this array look like this : [5, 4, 3, 2, 1]
// 배열의 순서를 거꾸로 변경

// reverse()
// 배열의 순서를 바꿈
// 배열 자체를 바꾸기 때문에 array를 출력해도 거꾸로 출력된다.
{
    const array = [1, 2, 3, 4, 5];
    const result = array.reverse();
    console.log(result);
}
console.clear();


// Q4. make new array without the first two elements
// 배열의 index 1번, 2번을 제외하고 출력

// slice()
// (2 , 5) => 2번 index부터 4번 index까지 출력
{
    const array = [1, 2, 3, 4, 5];
    const result = array.slice(2, 5);
    console.log(result)

}
console.clear();


// ============================

class Student {
    constructor(name, age, enrolled, score) {
        this.name = name;
        this.age = age;
        this.enrolled = enrolled;
        this.score = score;
    }
};

const students = [
    new Student('A', 29, true, 45),
    new Student('B', 28, false, 80),
    new Student('C', 30, true, 90),
    new Student('D', 40, false, 66),
    new Student('E', 18, true, 88)
];


// Q5. find a student with the score 90
// 점수가 90점 이상인 학생을 찾기

// find()
// 콜백 함수를 사용하여 원하는 값을 출력한다
// return이 true가 되면 멈춘다
{
    const result = students.find(function (student) {
        return student.score === 90;
    });
    console.log(result)
}
console.clear();


// Q6. make an array of enrolled students
// enrolled가 true인 학생만 출력

// filter()
// 콜백 함수를 사용하여 원하는 값을 출력
{
    const result = students.filter((student) => student.enrolled);
    console.log(result);
}
console.clear();


// Q7. make an array containing only the student's scores
// result should be : [45, 80, 90, 66, 88]
// 학생들의 점수만 출력하는 배열 생성

// map()
// 콜백함수를 이용하여 모든 index를 돌고 해당하는 index를 mapping하여 변환
{
    const result = students.map((student) => student.score);
    console.log(result);
}
console.clear();


// Q8. check if there is a student with the score lower than 50
// 50점보다 낮은 점수를 가진 학생이 있는지 체크

// some()
// 콜백함수를 이용
// 배열중에 score가 50이하가 있으면 true
{
    const result = students.some((student) => student.score < 50);
    console.log(result);
}

// every()
// 배열의 모든 요소들이 콜백함수의 조건을 true이면 true 하나라도 false 일 경우 false
{
    const result = students.every((student) => student.score < 50);
    console.log(result);
}
console.clear();

// Q9. compute student's average score

// reduce()
// prev => 이전에 콜백함수에서 리턴된 값이 전달
// curr => 배열의 아이템을 순차적으로 전달
{
    const result = students.reduce((prev, curr) => prev + curr.score, 0);
    console.log(result / students.length);
}
console.clear();


// Q10. make a string containing all the scores
// result should be : '45, 80, 90, 66, 88'

// API를 여러개 섞어서 사용 가능
{
    const result = students.
        map((student) => student.score) // student의 score만 출력
        .join(); // score를 문자형으로 변경
    console.log(result);
}
console.clear();


// Bonus! do Q10 sorted in ascending order
// result should be : '45, 66, 80, 88, 90';

// sort()
// 정렬
{
    const result = students
        .map((student) => student.score) // 배열의 객체에서 score만 뽑아냄
        .sort((a, b) => a - b) // a - b이면 작은 수를 먼저 출력 // b - a이면 큰 수를 먼저 출력
        .join(); // 배열을 문자형으로 변경
    console.log(result);
}