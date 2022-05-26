import React, { useEffect, useState } from "react";
import { Link } from 'react-router-dom'
import { EmployeeService } from "../../../src/Services/EmployeeService";

import Spinner from "../../components/Spinner/Spinner";
import Footer from "../Footer/Footer";
import { toast, ToastContainer } from "react-toastify";
let AdminRoomList = () => {
    let [query, setQurey] = useState({
      text: "",
    });
  
    let [state, setState] = useState({
      loading: false,
      rooms: [],
      filterRooms: [],
      errorMessage: "",
    });
    useEffect(() => {
      (async function () {
        try {
          setState({ ...state, loading: true });
          let response = await EmployeeService.getAllRooms();
          console.log(response.data)
          setState({
            ...state,
            loading: false,
            rooms: response.data,
            filterRooms: response.data,
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
        let response = await EmployeeService.deleteRoomById(contactId)
        console.log(response.data)
        if (response) {
          toast.error("Deleted Succesfully!", {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
          });
          setState({ ...state, loading: true });
          let response = await EmployeeService.getAllRooms();
          setState({
            ...state,
            loading: false,
            rooms: response.data,
            filterRooms: response.data,
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
      let theEmployees = state.rooms.filter((room) => {
        return room.name
          .toLowerCase()
          .includes(event.target.value.toLowerCase());
      });
      setState({
        ...state,
        filterRooms: theEmployees,
      });
    };
      let { loading, rooms, errorMessage, filterRooms } = state;
  return (
    <React.Fragment>
        <section class="p-2 bg-secondary text-white">
    <div class="container">
        <div class="row animated slideInLeft">
            <h1>
                <i class="fa fa-usersfas fa-bed  me-2"></i>Room List</h1>
        </div>
    </div>
</section>
      

    {/* <!-- Buttons Section --> */}
    <section className="p-3 bg-light">
        <div className="container">
            <div className="row animated flipInX delay-1s">
               
                <div className="col-md-4">
                <Link to={"/"} className="btn btn-danger ms-2">
                    <i className="fa fa-sign-out-alt text-muted me-2" />
                    LogOut
                  </Link>
                </div>
            </div>
        </div>
    </section>

    {/* <!-- Main Content Section --> */}
    {loading ? (
        <Spinner/>
      ) : (
        <React.Fragment>
         <section className="p-3">
        <div className="container">
            <div className="row">
                <div className="col-md-10">
                    <div className="card animated zoomIn delay-2s">
                        <div className="card-header bg-secondary text-white">
                            <h3>Rooms Details</h3>
                        </div>
                        <div className="card-body bg-light">
                            <table className="table table-hover text-center">
                                <thead className="bg-dark text-white">
                                    <tr>
                                        <th>Id</th>
                                        <th>Room Type</th>
                                        <th>Status</th>
                                       
                                       
                                    </tr>
                                </thead>
                                <tbody>
                                {
                                filterRooms.length > 0 && filterRooms.map(room=>{
                                     return(
                                         <tr key={room.id}>
                                             <td>{room.id}</td>
                                             <td>{room.roomType}</td>
                                             <td>{room.status}</td>
                                             
                                            
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
               
               <Link to={"/adminNav"} className="btn btn-dark ms-2 mt-2">
                    Back
                  </Link>
        </div>
        
    </section>
        </React.Fragment>
      )}
      <Footer/><ToastContainer/>
    </React.Fragment>
  )
}

export default AdminRoomList
