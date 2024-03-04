const http = require('http');
const express = require('express');
const {Server} = require('socket.io');
const cors = require('cors');
const { getRandomValues } = require('crypto');


const app = express();
app.use(express.json());

app.use(cors());

const server = http.createServer();
const io = new Server(server,{
    cors:{
        origin:'*'
    }
});

io.on("connection",(socket)=>{
    console.log(`connected successfully id ${socket.id}`);
    const first ={
        price:generateRandomValue().toString(),
        name:'Zomato'
    }
    console.log(first);
    io.emit('initial',first);
        setInterval(()=>{
            
                const current={
                    value : generateRandomValue().toString()
                }
                console.log(current);
                io.emit('data',current);
        },5000);
})

const PORT = process.env.PORT || 4000;

server.listen(PORT,()=>{
    console.log(`server listening in http://localhost:${PORT}`);
});

const history = [];

function generateRandomValue(){
    return Math.floor(Math.random()*605) + 1;
}

