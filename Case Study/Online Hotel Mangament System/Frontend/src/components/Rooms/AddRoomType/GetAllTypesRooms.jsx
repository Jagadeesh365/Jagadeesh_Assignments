import React, { useState,useEffect } from 'react'
import { Link ,useParams} from 'react-router-dom'
import { EmployeeService } from '../../../Services/EmployeeService';
import Spinner from '../../Spinner/Spinner';

const GetAllTypesRooms = () => {
  let {contactId}=useParams();
  let [state,setState]=useState({
  
    loading:false,
    employee:{},
    errorMessage:"",
    // group:{}


  });
  useEffect(()=>{
    (async function(){
    try {
        setState({...state,loading:true});
        let response=await EmployeeService.getAllRoomType();
        // let groupResponse=await EmployeeService.getGroup(response.data);
        setState({...state,
        loading:false,
        employee:response.data,
        // group:groupResponse.data
    });
        console.log(response.data)
        console.log(employee)
        
    } catch (error) {
        setState({
            ...state,
            loading:false,
            errorMessage:error.message
        });
    }
})();

},[contactId]);
let{loading,employee,errorMessage,}=state;
  return (
   <React.Fragment>
    
     {
       loading ? <Spinner/> :<React.Fragment>
         {
           Object.keys(employee).length>0 && 

           <section className='manager-list p-5'>
         <div className="container">
            
                          <h1>ALL ROOOMS TYPES</h1>
                           <div className="card my-2">
                               <div className="card-body">
                                  <div className="row align-items-center d-flex justify-content-around">
                                  {/* <div className="col-md-4">
                                     <img src={Logo} alt="" className='img-fluid '  />
                                   </div> */}
                                 
                                   <div className="col-md-7">
                                      
                                     <ul className='list-group'>
                                        <li className='list-group-item list-group-item-action'>
                                        SINGLE   :{employee.roomType.SINGLE}  <span className='fw-blod'></span>
                                        </li>
     
                                        <li className='list-group-item list-group-item-action'>
                                         DOUBLE   :{employee.roomType.DOUBLE} <span className='fw-blod'></span>
                                        </li>

                                        <li className='list-group-item list-group-item-action'>
                                         TRIPLE    :{employee.roomType.TRIPLE}<span className='fw-blod'></span>
                                        </li>

                                        <li className='list-group-item list-group-item-action'>
                                         FOUR       :{employee.roomType.FOUR}<span className='fw-blod'></span>
                                        </li>
                                       
                                     </ul>
                                   </div>
                                   <div className="col-md-1 d-flex flex-column align-items-center">
                                         <Link to={`/receptionist/list`}className=" btn btn-danger my-1">
                                             <i className='fa fa-trash'/>
                                         </Link>
     
                                         <Link to={`/rooms/nav`}className="btn btn-primary btn-danger my-1">
                                             <i className='fa fa-trash'/>
                                         </Link>

                                         <Link to={`/bills`}className="btn btn-danger my-1">
                                             <i className='fa fa-trash'/>
                                         </Link>
                                         <Link to={`/bills`}className="btn  btn-danger my-1">
                                             <i className='fa fa-trash'/>
                                         </Link>
                                   </div>
                                  </div>
                               </div>
                           </div>
                       </div>
                       <div className="row">
                      
             </div>
             
             <Link to={"/rooms/nav"} className="btn btn-dark ms-2 mt-2">
                    Back
                  </Link>

     </section>
         }

       </React.Fragment>
     }
    
   </React.Fragment>
  )
}

export default GetAllTypesRooms
