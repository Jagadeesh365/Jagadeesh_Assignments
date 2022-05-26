import React, { useState,useEffect } from 'react'
import { Link ,useParams} from 'react-router-dom'
import { EmployeeService } from '../../../Services/EmployeeService';
import Footer from "../../Footer/Footer";
import Spinner from "../../Spinner/Spinner";
import moment from 'moment';

const ViewRoom = () => {
  let {roomId}=useParams();
  let [state,setState]=useState({
  
    loading:false,
    room:{},
    errorMessage:"",
    // group:{}


  });
  useEffect(()=>{
    (async function(){
    try {
        setState({...state,loading:true});
        let response=await EmployeeService.getRoomById(roomId);
        // let groupResponse=await EmployeeService.getGroup(response.data);
        setState({...state,
        loading:false,
        room:response.data,
        // group:groupResponse.data
    });
        console.log(response.data)
        console.log(room)
        
    } catch (error) {
        setState({
            ...state,
            loading:false,
            errorMessage:error.message
        });
    }
})();

},[roomId]);
let{loading,room,errorMessage,}=state;
  return (
   <React.Fragment>
     
     <section className='view-Employee-intro p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h3 text warning fw-bold">VIEW ROOM DEATAILS:{roomId}</p>
              
              <p className='fst-italic'></p>
              
            </div>
          </div>
        </div>
     </section>
     {
       loading ? <Spinner/> :<React.Fragment>
         {
           Object.keys(room).length>0 && 

           <section className='view-contact mt-3'>
           <div className="container">
             <div className="row align-items-center">
               {/* <div className="col-md-4">
               <img src={employee.url} alt="" className='img-fluid employee-img'  />
               </div> */}
               <div className="col-md-7">
               <ul className='list-group'>
                                       <li className='list-group-item list-group-item-action'>
                                       Id : <span className='fw-blod'>{room.id}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                        Room Type : <span className='fw-blod'>{room.roomType}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                       Status : <span className='fw-blod'>{room.status}</span>
                                       </li>
    
                                        <li className='list-group-item list-group-item-action'>
                                       Booking Date : <span className='fw-blod'>{moment(room.bookingDetails.bookingDate).format("dddd, MMMM Do YYYY, h:mm:ss a")}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                       Nights: <span className='fw-blod'>{room.bookingDetails.nights}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Guest Id : <span className='fw-blod'>{room.bookingDetails.guestId}</span>
                                       </li> 
                                      
                                    </ul>
             </div>
             </div>
             <div className="row">
               <div className="col">
                      <Link to={'/rooms/list'} className="btn btn-warning">Back</Link>
               </div>
             </div>
           </div>
    
         </section>
         }

       </React.Fragment>
     }
    
   </React.Fragment>
  )
}

export default ViewRoom
