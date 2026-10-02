import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import EmployeeList from"./pages/EmployeeList";
import SideBar from "./Component/SideBar";
import NavBar from "./Component/NavBar";
import AddEmployee from"./pages/AddEmployee";

import "./App.css";

function App() {
    return (
        <BrowserRouter>
		
		<NavBar />
		
		<dir className = "layout">
		<SideBar />
              <main className="content">
            <Routes>

                <Route path="/dashboard" element={<Dashboard />} />
				<Route path = "/employees" element={ <EmployeeList />} />
				<Route path ="/add-employee" element={ <AddEmployee />} />

            </Routes>
	    	</main>
		</dir>

        </BrowserRouter>
    );
}

export default App;