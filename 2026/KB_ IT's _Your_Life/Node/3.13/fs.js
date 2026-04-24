const fs = require('fs');
// fs.readFile('exampl.txt', (err,data)=>{..})
// let files = fs.readdirSync('./');
// console.log(files);
fs.readdir('./',(err,files)=>{

    if (err){
        console.error(err);
        
    }
    console.log(files);
    
})