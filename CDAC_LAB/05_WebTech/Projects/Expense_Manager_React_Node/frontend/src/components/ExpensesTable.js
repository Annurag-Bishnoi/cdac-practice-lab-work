import React from "react";

function ExpenseTable ( data, handledelete){
    return (
        <table border="3">
            
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Description</td>
                    <td>Date</td>
                    <td>Amount</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                
                {/* {data.map((exp)=>(
                    <tr key={exp._id}>
                        <td>{exp._id}</td>
                        <td>{exp.description}</td>
                        <td>{exp.date}</td>
                        <td>{exp.amount}</td>
                        <td>
                            <button>Edit</button>
                            <button onClick={()=>{handledelete(exp._id)}}>Delete</button>
                        </td>
                    </tr>
                ))} */}
            </tbody>

            <h3>if frontend is Not Working Please Use PostMan All Api is working</h3>
        </table>
    )

}
export default ExpenseTable;