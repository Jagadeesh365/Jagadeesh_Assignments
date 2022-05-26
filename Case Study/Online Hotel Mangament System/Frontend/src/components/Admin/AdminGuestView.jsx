import React, { useState,useEffect } from 'react'
import { Link ,useParams} from 'react-router-dom'
import { EmployeeService } from "../../../src/Services/EmployeeService";
import Spinner from "../../components/Spinner/Spinner";
import Logo from '../../../src/assets/img/logo.png'


const AdminGuestView = () => {
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
     {/* <h2>{<h2>{guestId}</h2>}</h2> */}
     <section className='view-Employee-intro p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h3 text warning fw-bold">View Guest</p>
              <p>Guest Id: {guestId} </p>
              
            </div>
          </div>
        </div>
     </section>
     {
       loading ? <Spinner/> :<React.Fragment>
         {
           Object.keys(guest).length>0 && 

           <section className='view-contact mt-3'>
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
                                       Gender : <span className='fw-blod'>{guest.gender}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Age : <span className='fw-blod'>{guest.age}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Mobile No : <span className='fw-blod'>{guest.mobileNo}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Address : <span className='fw-blod'>{guest.address.street} ,{guest.address.city} ,{guest.address.state} ,{guest.address.country}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Current Status : <span className='fw-blod'>{guest.currentStatus}</span>
                                       </li>
                                       {
                                          guest.memberDetails==="null"  &&(
                                          <li className='list-group-item list-group-item-action'>
                                          Members : <span className='fw-blod'>{guest.memberDetails.length}</span>
                                          </li>

                                         )
                                       }
                                       
                                       <li className='list-group-item list-group-item-action'>
                                       Name : <span className='fw-blod'>{guest.name}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Room Id : <span className='fw-blod'>{guest.roomDetails.roomId}</span>
                                       </li> 
                                        <li className='list-group-item list-group-item-action'>
                                       No of Nights : <span className='fw-blod'>{guest.roomDetails.noOfNights}</span>
                                       </li> 
    
                                      
                                    </ul>
             </div>
             </div>
             <div className="row">
               <div className="col">
                      <Link to={'/adminGustList'} className="btn btn-warning">Back</Link>
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

export default AdminGuestView
