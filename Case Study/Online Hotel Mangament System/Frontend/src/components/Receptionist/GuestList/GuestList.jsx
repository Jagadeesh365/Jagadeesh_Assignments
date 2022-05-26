import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";
import Footer from "../../Footer/Footer";
import ManagerNavBar from "../../Manager/ManagerNavBar/ManagerNavBar";
import Spinner from "../../Spinner/Spinner";


let GuestList = () => {
  let [query, setQurey] = useState({
    text: "",
  });

  let [state, setState] = useState({
    loading: false,
    guests: [],
    filterEmployees: [],
    errorMessage: "",
  });


  useEffect(() => {
    (async function () {
      try {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllGuest();
        console.log(response.data)
       
        if(response)
        {
          setState({
            ...state,
            loading: false,
            guests: response.data,
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
    })();
  }, []);

  

  let clickDelete = async (guestId) => {
    try {
      let response = await EmployeeService.deleteGuestById(guestId);
      if (response) {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllGuest();
        setState({
          ...state,
          loading: false,
          guests: response.data,
          filterEmployees: response.data,
        });
      }
      console.log(filterEmployees)
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
    let theGuets = state.guests.filter((guest) => {
      return guest.name
        .toLowerCase()
        .includes(event.target.value.toLowerCase());
    });
    setState({
      ...state,
      filterEmployees: theGuets,
    });
  };
  let { loading, employees, errorMessage, filterEmployees } = state;
  return (
    <React.Fragment>
         <ManagerNavBar/>
      <pre>{query.text}</pre>
      <section className="employee-serach p-3">
        <div className="container">
          <div className="grid">
            <div className="row">
              <div className="col">
                <p className="h3 fw-bold">
                  Receptionist
                  <Link to={"/receptionist/addGuest"} className="btn btn-primary ms-2">
                    <i className="fa fa-plus-circle me-2" />
                    New Guest
                  </Link>

                  <Link to={"/receptionist/updatetroom"} className="btn btn-primary ms-2">
                    <i className="fa fa-pen me-2" />
                    UPDATE ROOM
                  </Link>

                  <Link to={"/receptionist/getallinvoice"} className="btn btn-primary ms-2">
                    <i className="fa fa-money-bill me-2" />
                    Invoices
                  </Link>
                  
                  
                </p>
                <p className="fst-italic">
                  Receptionist can Add,View,Upadte and Search guest Here
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
                    {/* <div className="mb-2">
                      <input
                        type="submit"
                        className="btn btn-outline-dark"
                        value="Search"
                      />
                    </div> */}
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>

      {loading ? (<Spinner />) : 
      (
        <React.Fragment>
          <section className="contact-list">
            <div className="container">
              <div className="row">
               
                {filterEmployees.length > 0 && 
                  filterEmployees.map((guest) => {
                    return (
                      <div className="col-md-6" key={guest.id}>
                        <div className="card my-2">
                          <div className="card-body">
                            <div className="row align-items-center d-flex justify-content-around">
                             
                              <div className="col-md-9">
                                <ul className="list-group">
                                  <li className="list-group-item list-group-item-action">
                                    Name :{" "}
                                    <span className="fw-blod">
                                      {guest.name}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                    Gender:{" "}
                                    <span className="fw-blod">
                                      {guest.gender}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                    Age :{" "}
                                    <span className="fw-blod">
                                      {guest.age}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                    Mobile Number :{" "}
                                    <span className="fw-blod">
                                      {guest.mobileNo}
                                    </span>
                                  </li>

                                  <li className="list-group-item list-group-item-action">
                                  Current Status :{" "}
                                    <span className="fw-blod">
                                      {guest.currentStatus}
                                    </span>
                                  </li> 

                                  {/* <li className="list-group-item list-group-item-action">
                                    Room Id :{" "}
                                    <span className="fw-blod">
                                      {guest.roomDetails.roomId}
                                    </span>
                                  </li> */}

                                  {/* <li className="list-group-item list-group-item-action">
                                    Address :{" "}
                                    <span className="fw-blod">
                                      {guest.address.state}
                                    </span>
                                  </li> */}

                                </ul>
                              </div>
                              <div className="col-md-1 d-flex flex-column align-items-center">
                                <Link
                                  to={`/receptionist/viewGuest/${guest.id}`}
                                  className="btn btn-warning my-1"
                                >
                                  <i className="fa fa-eye" />
                                </Link>

                                <Link
                                  to={`/receptionist/editGuest/${guest.id}`}
                                  className="btn btn-primary my-1"
                                >
                                  <i className="fa fa-pen" />
                                </Link>

                                <Link
                                  to={`/receptionist/bookingRoom/${guest.id}`}
                                  className="btn btn-primary my-1"
                                >
                                  <i className="fas fa-bed" />
                                </Link>
                                <Link
                                  to={`/receptionist/bills/${guest.id}`}
                                  className="btn btn-success my-1"
                                >
                                  <i className="fa-solid fa-money-bill" />
                                </Link>

                                <button
                                  className="btn btn-danger my-1"
                                  onClick={() => clickDelete(guest.id)}
                                >
                                  <i className="fa fa-trash" />
                                </button>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    );
                  })}
                <div className="row">
                  <div className="col">
                    <Link to={"/receptionist"} className="btn btn-secondary my-1">
                      <i className="fa fa-arrow-left me-2" />
                      Back
                    </Link>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </React.Fragment>
      )}
       <Footer/>
    </React.Fragment>
  );
};

export default GuestList;
