
import {Link} from	"react-router-dom";

function Sidebar() {
    return (
        <div className="sidebar">

            <h2>EmployeeHub</h2>

            <div className="menu">
                <Link to ="/deshboard">
				🏠 Dashboard
				</Link>
                <Link to ="/employees">
				👨‍💼 Employees
				</Link>
                <Link to ="/add-employee">
				➕ Add Employee
				</Link>
            </div>

        </div>
    );
}

export default Sidebar;