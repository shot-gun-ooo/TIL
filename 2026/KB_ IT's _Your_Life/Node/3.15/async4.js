const fs = require('fs');

let files = fs.readdir('./', (err, files)=>{
    if(err){
        console.error(err);
    }
    console.log(files)
})

console.log('code is done')