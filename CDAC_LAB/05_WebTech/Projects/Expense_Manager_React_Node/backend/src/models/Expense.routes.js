const express=require("express");
const controller=require("./Expense.controller");

const router=express.Router();

router.post('/expenses',controller.CreateExpense);
router.get('/expenses',controller.ViewExpense);
router.put('/expenses/:id',controller.UpdateExpense);
router.delete('/expenses/:id',controller.DeleteExpense)

module.exports=router;