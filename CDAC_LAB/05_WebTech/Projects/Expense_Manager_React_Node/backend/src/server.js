require('dotenv').config();
const app=require('./app')
const dbconnect=require('./config/db');
const port=process.env.PORT||5000;

dbconnect();

app.listen(port,()=>{
    console.log("Server is Running On Port 5000");
})


