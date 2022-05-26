import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { EmployeeService } from '../../Services/EmployeeService'
import moment from 'moment';
import Spinner from "../Spinner/Spinner";

const Report = () => {

    let [state, setState] = useState({
        loading: false,
        report: {},
        bookingDetails:[],

        errorMessage: "",
      });
      useEffect(() => {
        (async function () {
          try {
            setState({ ...state, loading: true });
            let response = await EmployeeService.getReport();
            console.log(response.data)
            console.log(response.data.bookedRoomsDetails)
            
            setState({
              ...state,
              loading: false,
              report: response.data,
              bookingDetails:response.data.bookedRoomsDetails
             
            });
          } catch (error) {
            setState({
              ...state,
              loading: false,
              errorMessage: error.message,
            });
          }
        })();
      }, []);
   
   
    let {loading,report,bookingDetails}=state;
    

    
  return (
    
    <React.Fragment>
          {/* <pre>{JSON.stringify(state.report)}</pre> */}
         <div className="container mt-3">
             <div className="row">
                 <div className="col">
                     <p className='h3 text-success'>Hotel Report</p>
                     <p>{state.bookingDetails.id}</p>
                     <p></p>
                 </div>
             </div>

         </div>
         <div className="container mt-3">
             <div className="row">
                 <div className="col-md-9">
                     <div className="table table-hover text-center table table-striped">
                         <thead className='bg-dark text-white'>
                             <tr>
                                 <th>Room Id</th>
                                 <th>Status</th>
                                 <th>Booked on</th>
                                 <th>Nights</th>
                                 <th>Amount</th>
                                 
                             </tr>
                         </thead>
                          <tbody>
                             {
                                 loading ? (<Spinner/>):(
                                  bookingDetails.length > 0 && bookingDetails.map(rep=>{
                                    return(
                                        <tr key={rep.id}>
                                            <td>{rep.id}</td>
                                            <td>{rep.status}</td>
                                           
                                            <td>{moment(rep.dateOfBooking).format("dddd, MMMM Do YYYY, h:mm:ss a")}</td>
                                            <td>{rep.nights}</td>
                                            <td>&#8377;{rep.amount.toFixed(2)}</td>
                                           

                                        </tr>
       
                                    )
                                })
                                 )
                             }
                         </tbody> 

                     </div>
                 </div>
                 {
                   loading ?(<Spinner/>):(
                    <div className="col-md-3">
                    Total Rooms     :<h1>{report.totalRooms}</h1>
                    Available Rooms :<h1>{report.availableRooms}</h1>
                    Booked Rooms    :<h1>{report.bookedRooms}</h1> 
                    Total Earnings  : <h1>&#8377;{report.totalEarnings}</h1>
                  </div>
                   )
                 }

             </div>
             <div className="row">
                  <div className="col">
                    <Link to={"/adminNav"} className="btn btn-secondary my-1">
                      <i className="fa fa-arrow-left me-2" />
                      Back
                    </Link>
                  </div>
                </div>
         </div>
        
    </React.Fragment>
    
    
  )
}

export default Report
