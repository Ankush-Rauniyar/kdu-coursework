const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
    if (req.method === 'GET' && req.url === '/result') {

        const fileName = 'jsonStorage.json';

        fs.readFile(fileName, 'utf8', (err, data) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end(`Error reading ${fileName}: ${err}`);
            } else {
                const message = `Hello, my name is Ankush!\nHere is my system information:\n${data}`;
                res.writeHead(200, { 'Content-Type': 'text/plain' });
                res.end(message);
            }
        });
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

const PORT = 3000;

server.listen(PORT, () => {
    console.log(`Server is running at http://localhost:${PORT}/result`);
});
