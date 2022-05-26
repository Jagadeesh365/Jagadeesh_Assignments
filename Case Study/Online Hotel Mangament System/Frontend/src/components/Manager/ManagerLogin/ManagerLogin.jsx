import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";
import Footer from '../../Footer/Footer'

const ManagerLogin = () => {
    let navigate = useNavigate();

    let [state, setState] = useState({
        loading: false,
        login: {
          username:'',
          password:''
         
        },
        errorMessage: "",
       
      });
      
    
      let updateInput=(event)=>
      {
        setState({
          ...state,
          login:{
            ...state.login,
            [event.target.name]:event.target.value
          }
        });
      };
    
      let submitForm = async (event) => {
        event.preventDefault();
        try {
          let response = await EmployeeService.authenticateRole(state.login);
          if (response.data.message==="Success!" && response.data.employee.role==="MANAGER") {
              console.log(response.data);
              console.log(response.data.message)
              console.log(response.data.employee.role)
              navigate("/manager", { replace: true });
          }
          else
          {
              alert('Login With Valid Inputs and This Login Only For Manager!')
            navigate("/managerLogin", { replace: false });
          }
        } catch (error) {
            console.log(error);
          setState({ ...state, errorMessage: error.message });
          navigate("/managerLogin", { replace: false });
        }
  };
  return (
    <React.Fragment>
    {/* <!-- Dashboard Section --> */}
    <section className="p-2 bg-teal text-white">
    <div className="container">
        <div className="row animated flipInY">
            <h1><Link to={"/"} className="fa fa-arrow-left "> </Link>
                <i className="fa fa-snowflake  ms-5"></i>MANAGER</h1>
        </div>
    </div>
    </section>

            {/* <!-- Login Section --> */}
            <section className="p-5">
            <div className="container">
                <div className="row">
                    <div className="col-md-4 m-auto">
                        <div className="card animated zoomIn delay-1s">
                            <div className="card-header bg-teal text-white text-center">
                                <h3>Login Here</h3>
                            </div>
                            <div className="card-body bg-light">
                                <form onSubmit={submitForm}>
                                    <div className="form-group">
                                        <input 
                                         required={true}
                                         name="username"
                                         value={state.login.username}
                                         onChange={updateInput}
                                         type="text"
                                        
                                        className="form-control" placeholder="User ID"/>
                                    </div>
                                    
                                    <div className="form-group">
                                        <input 
                                        required={true}
                                        name="password"
                                        value={state.login.password}
                                        onChange={updateInput}
                                        type="password" 
                                        className="form-control" placeholder="Password"/>
                                    </div>
                                   

                                    <div className="card-footer bg-light">
                                    {/* <Link to={'/receptionist'} className="dropdown-item">
                                    <i className="fa-solid fa-circle-arrow-right me-2" />Login
                                    </Link> */}
                                    <i className="fa-solid fa-circle-arrow-right me-2" />
                                    <input type="submit" className="btn btn-dark" value="Login"/>
                                    </div>
                                </form>
                           
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </section>
           
    </React.Fragment>
   
  )
}

export default ManagerLogin
