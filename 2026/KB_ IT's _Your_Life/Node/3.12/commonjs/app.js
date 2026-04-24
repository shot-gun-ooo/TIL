const users = require('./user-1.js'); 
const helloFunc = require('hello.js')
console.log(users)

helloFunc(users.user1)
helloFunc(users.user2)

const{user1, user2} = require('./user-1.js')
console.log(user1)
console.log(user2)

