import react ,{useState,useEffect} from "react";
import ExpenseForm from "../components/ExpensesForm";
import ExpenseTable from "../components/ExpensesTable";
import { createExpense,viewExpense,deleteExpense } from "../services/api";


function Home(){

    const [form,setForm] =useState({description:"",date:"",amount:""});
    const [data,setData] =useState([]);

    const fetchExpenses = async()=>{
        try{
            const res=await viewExpense();
            setData(res.data);

        }catch(err){
            console.log(err);
        }
    }

    useEffect(()=>{fetchExpenses();},[]);


const handleChange=(e)=>{
    setForm({
        ...form,[e.target.name]:e.target.value
    });

}

const handleSubmit=async(e)=>{
            e.preventDefault();
            try{
                await createExpense(form);
                fetchExpenses();
                setForm({description:"",date:"",amount:""});
            }catch(err)
            {
                console.log(err)}
           
}

const handledelete= async()=>{
    try{
        await deleteExpense();
        fetchExpenses();
    }catch(err){
        console.log(err);
    }
}


    return(
        <div>
        <h1>Welcome To Expense Management</h1>

        <ExpenseForm form={form} handleSubmit={handleSubmit} handleChange={handleChange}/>
        <hr/>
        <ExpenseTable data={data} handledelete={handledelete}/>

        </div>
    )
}

export default Home;