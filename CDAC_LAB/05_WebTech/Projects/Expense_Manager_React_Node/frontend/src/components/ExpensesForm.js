



function ExpenseForm(form,handleSubmit ,handleChange){
    return (
        <form onSubmit={handleSubmit}>
            <lable>Description</lable>
            <input name="description" value={form.description} onChange={handleChange} placeholder="Description" /> <hr/>
            <lable>Date</lable>
            <input type="date" name="date" value={form.date} onChange={handleChange} placeholder="Date" /> <hr/>
            <lable>Amount</lable>
            <input  name="amount" value={form.amount} onChange={handleChange} placeholder="Amount" /> <hr/>
            
            <button>Submit</button>
        </form>
    )
}


export default ExpenseForm;


