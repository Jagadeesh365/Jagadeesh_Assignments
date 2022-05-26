import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService"
import Spinner from "../../Spinner/Spinner";


let  ManagerGetAvailableRooms = () => {
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
        let response = await EmployeeService.getAvailableRooms()
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
  let { loding, employees, errorMessage, filterEmployees } = state;
  return (
    <React.Fragment>
      <pre>{query.text}</pre>
      <section className="employee-serach p-3">
        <div className="container">
          <div className="grid">
            <div className="row">
              
            </div>
            <div className="row">
              <div className="col-md-6">
                <form className="row">
                  <div className="col">
                   
                  </div>
                  <div className="col">
                    
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </section>

      {loding ? (
        <Spinner/>
      ) : (
        <React.Fragment>
         <section className="p-3">
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <div className="card animated zoomIn delay-2s">
                        <div className="card-header bg-primary text-white">
                            <h3>AVAILABE Rooms Details</h3>
                        </div>
                        <div className="card-body bg-light">
                            <table className="table table-hover text-center">
                                <thead className="bg-dark text-white">
                                    <tr>
                                        <th>Id</th>
                                        <th>Room Type</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                {
                                 filterEmployees.length > 0 && filterEmployees.map(rep=>{
                                     return(
                                         <tr key={rep.id}>
                                             <td>{rep.id}</td>
                                             <td>{rep.roomType}</td>
                                             <td>{rep.status}</td>
                                             {/* <td>{rep.bookingDetails.bookingDate}</td>
                                             <td>{rep.bookingDetails.nights}</td>
                                             <td>{rep.bookingDetails.guestId}</td> */}
                                              <td>
                                              
                                                        
                                        </td>
                                         </tr>
        
                                     )
                                 })
                             }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
               </div>
               <Link to={"/manager/roomsNav"} className="btn btn-dark ms-2 mt-2">
                    Back
                  </Link>
        </div>
        
    </section>
        </React.Fragment>
      )}
      
    </React.Fragment>
  );
};

export default ManagerGetAvailableRooms;
