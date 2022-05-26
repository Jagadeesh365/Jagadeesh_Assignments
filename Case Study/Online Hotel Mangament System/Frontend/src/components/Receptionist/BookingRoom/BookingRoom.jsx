import React, { useState,useEffect } from 'react'
import { Link ,useParams} from 'react-router-dom'
import { EmployeeService } from '../../../Services/EmployeeService';
import Spinner from '../../Spinner/Spinner';
import Logo from '../../../assets/img/logo.png'


const BookingRoom = () => {
  let {guestId}=useParams();
  let [state,setState]=useState({
  
    loading:false,
    guest:{},
    errorMessage:"",
    // group:{}


  });
  useEffect(()=>{
    (async function(){
    try {
        setState({...state,loading:true});
        let response=await EmployeeService.getGuestById(guestId);
        console.log(response.data.memberDetails)
        // let groupResponse=await EmployeeService.getGroup(response.data);
        setState({...state,
        loading:false,
        guest:response.data,
        // group:groupResponse.data
    });
        console.log(response.data)
        
    } catch (error) {
        setState({
            ...state,
            loading:false,
            errorMessage:error.message
        });
    }
})();

},[guestId]);
let{loading,guest,errorMessage,}=state;
  return (
   <React.Fragment>
     
     <section className='view-Employee-intro p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h3 text warning fw-bold">Booking Status</p>
             
            </div>
          </div>
        </div>
     </section>
     {
       loading ? <Spinner/> :<React.Fragment>
         {
           Object.keys(guest).length>0 && 

           <section className='view-BookingRooms mt-3'>
           <div className="container">
             <div className="row align-items-center">
               <div className="col-md-4">
               <img src={Logo} alt="" className='img-fluid '  /> 
               </div>
               <div className="col-md-7">
               <ul className='list-group'>
                                       <li className='list-group-item list-group-item-action'>
                                       Name : <span className='fw-blod'>{guest.name}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Mobile No : <span className='fw-blod'>{guest.mobileNo}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Address : <span className='fw-blod'>{guest.address.street} ,{guest.address.city} ,{guest.address.state} ,{guest.address.country}</span>
                                       </li>
                                      
                                        <li className='list-group-item list-group-item-action'>
                                       Room Booked : <span className='fw-blod'>{guest.roomDetails.roomId}</span>
                                       </li> 
                                        <li className='list-group-item list-group-item-action'>
                                       No of Nights : <span className='fw-blod'>{guest.roomDetails.noOfNights}</span>
                                       </li> 
    
                                      
                                    </ul>
             </div>
             </div>
             <div className="row">
               <div className="col">
                      <Link to={'/receptionist'} className="btn btn-warning">Back</Link>
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

export default BookingRoom
