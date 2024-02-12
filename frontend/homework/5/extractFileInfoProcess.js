const { dir } = require('console');
const path = require('path');

class Details{
    constructor(extension,baseName,directory){
        this.extension = extension;
        this.baseName = baseName;
        this.directory = directory;
    }
    getDirectory(){
        return this.directory;
    }
}

function extractFileInfo(currentPath){
    const extension = path.extname(currentPath);
    const baseName = path.basename(currentPath);
    const directory = path.dirname(currentPath);
    return new Details(extension,baseName,directory);
}

module.exports = extractFileInfo;