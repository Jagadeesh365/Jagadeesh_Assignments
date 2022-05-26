import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { EmployeeService } from "../../../../Services/EmployeeService";
import Footer from "../../../Footer/Footer";


import Spinner from "../../../Spinner/Spinner";

let EmployeeList = () => {
  let [query, setQurey] = useState({
    text: "",
  });

  let [state, setState] = useState({
    loading: false,
    employees: [],
    filterEmployees: [],
    errorMessage: "",
  });
  useEffect(() => {
    (async function () {
      try {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllEmployees();
        console.log(response.data)
        setState({
          ...state,
          loading: false,
          employees: response.data,
          filterEmployees: response.data,
        });
        console.log(response.data);
      } catch (error) {
        setState({
          ...state,
          loading: false,
          errorMessage: error.message,
        });
      }
    })();
  }, []);

  let clickDelete = async (contactId) => {
    try {
      let response = await EmployeeService.deleteEmployee(contactId);
      if (response) {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllEmployees();
        setState({
          ...state,
          loading: false,
          employees: response.data,
          filterEmployees: response.data,
        });
      }
    } catch (error) {
      setState({
        ...state,
        loading: false,
        errorMessage: error.message,
      });
    }
  };

  ///serach employee
  let searchEmployee = (event) => {
    setQurey({ ...query, text: event.target.value });
    let theEmployees = state.employees.filter((employee) => {
      return employee.name
        .toLowerCase()
        .includes(event.target.value.toLowerCase());
    });
    setState({
      ...state,
      filterEmployees: theEmployees,
    });
  };
  let { loading, employees, errorMessage, filterEmployees } = state;
  return (
    <React.Fragment>
      <pre>{query.text}</pre>
      <section className="employee-serach p-3">
        <div className="container">
          <div className="grid">
            <div className="row">
              <div className="col">
                <p className="h3 fw-bold">
                  Manager
                  <Link to={"/contact/add"} className="btn btn-primary ms-2">
                    <i className="fa fa-plus-circle me-2" />
                    New
                  </Link>
                  <Link to={"/"} className="btn btn-danger ms-2">
                    <i className="fa fa-sign-out-alt text-muted me-2" />
                    LogOut
                  </Link>
                  
                </p>
                <p className="fst-italic">
                  Manager can Add,View,Upadte and Search Staff Here
                </p>
              </div>
            </div>
            <div className="row">
              <div className="col-md-6">
                <form className="row">
                  <div className="col">
                    <div className="mb-2">
                      <input
                        name="text"
                        value={query.text}
                        onChange={searchEmployee}
                        type="text"
                        className="form-control"
                        placeholder="Search Names"
                      />
                    </div>
                  </div>
                  <div className="col">
                    <div className="mb-2">
                      {/* <input
                        type="submit"
                        className="btn btn-outline-dark"
                        value="Search"
                      /> */}
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>

      {loading ? (<Spinner />) : (
        <React.Fragment>
         
               
                {filterEmployees.length > 0 && 
                  filterEmployees.map((employee) => {
                    return (
                      employee.role!=="ADMIN"
                      &&
                      <section className="contact-list">
                      <div className="container">
                        <div className="row">
                      <div className="col-md-11" key={employee.id}>
                        <div className="card my-2">
                          
                          <div className="card-body">
                            <div className="row align-items-center d-flex justify-content-around">
                              <div className="col-md-2">
                                <img
                                  src={employee.url}
                                  alt=""
                                  className=" employee-img"
                                />
                              </div>
                              <div className="col-md-8">
                                <ul className="list-group">
                                  <li className="list-group-item list-group-item-action">
                                    Name :{" "}
                                    <span className="fw-blod">
                                      {employee.name}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                    Role:{" "}
                                    <span className="fw-blod">
                                      {employee.role}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                    Salary :{" "}
                                    <span className="fw-blod">
                                      {employee.salary}
                                    </span>
                                  </li>
                                </ul>
                              </div>
                              <div className="col-md-2 d-flex flex-column align-items-center">
                                <Link
                                  to={`/contact/view/${employee.id}`}
                                  className="btn btn-warning my-1"
                                >
                                  <i className="fa fa-eye" />
                                </Link>

                                <Link
                                  to={`/contact/edit/${employee.id}`}
                                  className="btn btn-primary my-1"
                                >
                                  <i className="fa fa-pen" />
                                </Link>

                                <button
                                  className="btn btn-danger my-1"
                                  onClick={() => clickDelete(employee.id)}
                                >
                                  <i className="fa fa-trash" />
                                </button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      </div>
            </div>
          </section>
                    );
                  })}
                <div className="row">
                  <div className="col">
                    <Link to={"/manager"} className="btn btn-secondary my-1">
                      <i className="fa fa-arrow-left me-2" />
                      Back
                    </Link>
                  </div>
                </div>
              
        </React.Fragment>
      )}
    <Footer/>
    </React.Fragment>
  );
};

export default EmployeeList;
