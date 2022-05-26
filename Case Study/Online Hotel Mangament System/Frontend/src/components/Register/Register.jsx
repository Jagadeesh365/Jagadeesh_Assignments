import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeService } from "../../Services/EmployeeService";
// Import toastify css file



const Register = () => {
  let navigate = useNavigate();

  let [state, setState] = useState({
    loading: false,
    employee: {
      name: "",
      url: "",
      password: "",
      role: "",
      salary: "",
      email: "",
      country: "",
      state: "",
      city: "",
      street: "",
      zipcode: "",
      mobileNo: ""
     
    },
    errorMessage: "",
   
  });
  

  let updateInput=(event)=>
  {
    setState({
      ...state,
      employee:{
        ...state.employee,
        [event.target.name]:event.target.value
      }
    });
  };

  let submitForm = async (event) => {
    event.preventDefault();
    try {
      let response = await EmployeeService.createEmployee(state.employee)
      if (response) {
        // toast('Register Successfully');
        alert(response.data.message)
        navigate("/", { replace: true });
      }
    } catch (error) {
      setState({ ...state, errorMessage: error.message });
      navigate("/register", { replace: false });
    }
  };
  let { employee } = state;
  
  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(state.employee)}</pre> */}
      <section className="add-contact p-3">
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-success fw-bold">Register</p>
              <p className="fst-italic">
               
              </p>
            </div>
          </div>
          <div className="row">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input
                    required={true}
                    name="name"
                    value={employee.name}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Name"
                    maxLength={25}
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="url"
                    value={employee.url}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Photo Url"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="password"
                    value={employee.password}
                    onChange={updateInput}
                    type="password"
                    className="form-control"
                    placeholder="Password"
                  />
                </div>

                <div className="mb-2">
                 <select  name="role" 
                 value={employee.role} 
                 onChange={updateInput}
                 className="form-control">
                  <option>Select a Role</option>
                  <option value="ADMIN">ADMIN</option>
                  <option value="MANAGER">MANAGER</option>
                  <option value="RECEPTIONIST">RECEPTIONIST</option>
                 </select>
                </div>

                {/* <div className="mb-2">
                  <input
                    required={true}
                    name="salary"
                    value={employee.salary}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Salary"
                  />
                </div> */}

                <div className="mb-2">
                  <input
                    required={true}
                    name="email"
                    value={employee.email}
                    onChange={updateInput}
                    type="email"
                    className="form-control"
                    placeholder="Email"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="country"
                    value={employee.country}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Country"
                  />
                </div>
               

                <div className="mb-2">
                  <input
                    required={true}
                    name="state"
                    value={employee.state}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="State"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="city"
                    value={employee.city}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="City"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="street"
                    value={employee.street}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Street"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="zipcode"
                    value={employee.zipcode}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="ZipCode"
                    maxLength={6}
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="mobileNo"
                    value={employee.mobileNo}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="MobileNo"
                    maxLength={10}
                    minLength={0}
                  />
                </div>

                <div className="mb-2">
                  <input
                    type="submit"
                    className="btn btn-success"
                    value="Craete"
                  />
                  <Link to={"/"} className="btn btn-dark ms-2"> Close</Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  );
};

export default Register;
