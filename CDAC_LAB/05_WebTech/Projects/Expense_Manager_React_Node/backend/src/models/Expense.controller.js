const ExpenseService=require('./Expense.service');

exports.CreateExpense=async(req , res)=>{
    try{

        const data=await ExpenseService.createExpense(req.body);
        res.status(201).json(body);
    }catch(err){
        res.status(500).json({message:"Server Unreachable"});
    }
}

exports.ViewExpense=async(req , res)=>{
    try{

        const data=await ExpenseService.viewExpense();
        res.status(200).json(body);
    }catch(err){
        res.status(500).json({message:"Server Unreachable"});
    }
}


exports.DeleteExpense=async(req , res)=>{
    try{

        const data=await ExpenseService.deleteExpense(req.params.id);
        res.status(200).json({message:"Deleted Successfully"});
    }catch(err){
        res.status(500).json({message:"Server Unreachable"});
    }
}


exports.UpdateExpense=async(req , res)=>{
    try{

        const data=await ExpenseService.updateExpense(req.params.id,req.body);
        res.status(200).json(body);
    }catch(err){
        res.status(500).json({message:"Server Unreachable"});
    }
}