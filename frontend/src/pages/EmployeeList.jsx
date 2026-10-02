
import { useEffect, useState } from "react";
import axios from "axios";


function EmployeeList() {
	
	useEffect(() => {
	    axios.get("http://localhost:8080/api/employee")
	        .then(response => {
	            setEmployees(response.data);
	        })
	        .catch(error => {
	            console.log(error);
	        });
	}, []);
	
	
		const [employees, setEmployees] = useState([]);

    return (
        <div>
            <h1>Employee List</h1>
						<button>Add Employee</button>
						<p>{employees.length}</p>
						<table>
						    <thead>
						        <tr>
						            <th>ID</th>
						            <th>Name</th>
						            <th>Email</th>
						            <th>Department</th>
						            <th>City</th>
									<th>Actions</th>
						        </tr>
						    </thead>

						    <tbody>
						        {employees.map(employee => (
						            <tr key={employee.id}>
						                <td>{employee.id}</td>
						                <td>{employee.name}</td>
						                <td>{employee.email}</td>
						                <td>{employee.department}</td>
						                <td>{employee.city}</td>
										
										<td>
										    <button>View</button>
										    <button>Edit</button>
										    <button>Delete</button>
										</td>
										
						            </tr>
						        ))}
						    </tbody>
						</table>						
        </div>
    );
}

export default EmployeeList;