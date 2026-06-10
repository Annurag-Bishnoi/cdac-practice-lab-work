import axios from 'axios';

const API="http://localhost:5000/api/expenses";

export const createExpense=(data)=> axios.post(API,data);
export const viewExpense=()=>axios.get(API);
export const deleteExpense=(id)=>axios.delete(`${API}/${id}`);




