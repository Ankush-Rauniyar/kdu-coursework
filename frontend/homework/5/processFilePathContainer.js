const extractFileInfo = require('./extractFileInfoProcess');

const filePaths = [
    'dir1/dir2/file1.txt',
    'dir1/dir3/file2.txt',
    'dir1/dir3/file3.md',
    'dir4/file4.jpg',
    'dir4/file5.pdf',
];

let answer = [];

function processFilePaths(allPaths) {
    return Promise.all(allPaths.map(current => extractFileInfo(current)));
}

processFilePaths(filePaths)
    .then(result => {
        answer = result;
        console.log(answer);
    })
    .catch(error => console.error(error));
