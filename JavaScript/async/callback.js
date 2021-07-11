'use strick';

// JavaScript is synchronous.
// Execute the code block by order after hoisting.
// hoisting: var, function declaration

console.log('1');
setTimeout(() => console.log('2'), 1000);
console.log('3');


// Synchronous callback
function printImmediately(print) {
    print();
}
printImmediately(() => console.log('hello'));



// Asynchronous callback
function printWiteDelay(print, timeout) {
    setTimeout(print, timeout);
}
printWiteDelay(() => console.log('async callback'),2000);



// callback Hell example
// 콜백 체인의 문제점 확인해보기

class UserStorage {
    loginUser(id, password, onSuccess, onError){
        setTimeout(()=> {
            if(
                (id === 'seungm' && password === '1234') ||
                (id === 'coder' && password === 'qwe')
            ) {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    };

    getRoles(user, onSuccess, onError){
        setTimeout(() => {
            if(user === 'seungm'){
                onSuccess({ name : 'seungm', role : 'admin'});
            } else { 
                onerror(new Error('no access'));
            }
        }, 1000)
    };
};


const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(
    id, 
    password, 
    (user) => {
        userStorage.getRoles(
            user, 
            (userWithRole) => {
                alert(`hello ${userWithRole.name}, you have a ${userWithRole.role} role`)
            },
            error => {
                console.log(error);
            }
        );
    }, 
    error => { console.log(error)}
    );