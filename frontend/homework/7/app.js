const express = require('express');
const http = require('http');
const cors = require('cors');

const {Server} = require('socket.io');


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

    socket.on("sender",(payload)=>{
        io.except(socket.id).emit("received",payload);
    });
})

const PORT = process.env.PORT || 3000;

server.listen(PORT,()=>{
    console.log(`server started in ${PORT}`);
})