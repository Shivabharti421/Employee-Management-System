import axios from "axios";
import { useState } from "react";

function AddEmployee() {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [department, setDepartment] = useState("");
    const [city, setCity] = useState("");
    const [phone, setPhone] = useState("");
    const [salary, setSalary] = useState("");

    const handleSubmit = (e) => {

        e.preventDefault();

        console.log("Button clicked");

        const employee = {
            name: name,
            email: email,
            department: department,
            city: city,
            phone: phone,
            salary: salary
        };

        console.log(employee);

        axios.post("http://localhost:8080/api/employee", employee)
            .then(response => {
                console.log("Employee saved:", response.data);
            })
            .catch(error => {
                console.log("Error:", error);
            });
    };

    return (
        <div>

            <h1>Add Employee</h1>

            <form onSubmit={handleSubmit}>

                <label>Employee Name</label>

                <input
                    type="text"
                    placeholder="Enter employee Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />

                <label>Email</label>

                <input
                    type="email"
                    placeholder="Enter employee Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <label>Department</label>

                <input
                    type="text"
                    placeholder="Enter employee Department"
                    value={department}
                    onChange={(e) => setDepartment(e.target.value)}
                />

                <label>City</label>

                <input
                    type="text"
                    placeholder="Enter city"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                />

                <label>Phone</label>

                <input
                    type="tel"
                    placeholder="Enter phone number"
                    value={phone}
                    onChange={(e) => setPhone(e.target.value)}
                />

                <label>Salary</label>

                <input
                    type="number"
                    placeholder="Enter salary"
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                />

                <button type="submit">
                    Add Employee
                </button>

            </form>

        </div>
    );
}

export default AddEmployee;