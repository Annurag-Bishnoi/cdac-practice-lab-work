const Expense =require('./Expense.model');

exports.createExpense=(data)=>Expense.create(data);
exports.viewExpense=()=>Expense.find();
exports.deleteExpense=(id)=>Expense.findByIdAndDelete(id);
exports.updateExpense=(id,data)=>Expense.findByIdAndDelete(id,data,{new:true});


