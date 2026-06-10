const mongoose=require('mongoose');

const dbconnect=async ()=>{
    try{
        await mongoose.connect(process.env.MONGO_URL);
        console.log("Connected To Database");
    }catch(err){
        console.log("Failed To Connect To Database",err);
    }
}

module.exports=dbconnect;