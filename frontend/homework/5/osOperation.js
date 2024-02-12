const os = require('os');
const fs = require('fs');
class Details{
    constructor(hostname,operatingSystem,architecture,release,uptime,numberOfCPUCores,totalMemory,freeMemory,currentDirectory){
        this.hostname = hostname;
        this.operatingSystem = operatingSystem;
        this.architecture = architecture;
        this.release = release;
        this.uptime = uptime;
        this.numberOfCPUCores = numberOfCPUCores;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.currentDirectory = currentDirectory;
    }
}

// console.log(os.hostname());
let current = new Details(os.hostname(),os.platform(),os.arch(),os.release(),os.uptime(),os.cpus.length,os.totalmem(),os.freemem(),process.cwd());
let jsonFormat = JSON.stringify(current);
console.log(jsonFormat);


const storeInFile = 'jsonStorage.json';

fs.writeFile(storeInFile,jsonFormat,'utf8',(err) =>{
    if(err){
        console.log('error while creating file and appending json');
    }else{
        console.log('json object written in the file successfully');
    }
});

