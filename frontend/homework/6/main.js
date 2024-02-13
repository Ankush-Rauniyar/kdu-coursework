const express = require('express');
const uuid = require('uuid');
const posts = require('./data/postsData');

const app = express();
app.use(express.json());

app.get('/get/posts',(req,resp) =>{
    resp.status(201).send(posts);
    console.log('retrieved successfully all posts');
});

app.get('/get/:id', (req, resp) => {
    console.log('searching for data');
    let currentId = req.params.id; // Use req.params.id to get the value of the id parameter
    let answer = posts.filter((post) => post.id === currentId); // Add a return statement here
    if (answer.length !== 0) {
        resp.status(201).send(answer[0]);
        console.log(`post with ${currentId} found successfully`);
    } else {
        resp.status(404).send({ 'msg': 'post not found' });
        console.log(`post with ${currentId} not found`);
    }
});


app.post('/api/add',(req,resp)=>{
    let current = req.body;
    console.log(current.post);
    let id = uuid.v4();
    posts.push({id,post : current.post});
    console.log('added the user successfully');
    resp.send(`id : ${id}`);
});

const server = app.listen(6000,function(){
    console.log('listening to port 6000');
})