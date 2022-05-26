import React, { useState,useEffect } from 'react'
import { Link ,useParams} from 'react-router-dom'
import { EmployeeService } from '../../../../hms_front/src/Services/EmployeeService';
import Spinner from '../../../src/components/Spinner/Spinner';

const AdminViewDepartment = () => {
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
        let response=await EmployeeService.getEmployee(contactId);
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
     
     <section className='view-Employee-intro p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h3 text warning fw-bold">View Employee</p>
              <h2>{contactId}</h2>
              <p className='fst-italic'></p>
              
            </div>
          </div>
        </div>
     </section>
     {
       loading ? <Spinner/> :<React.Fragment>
         {
           Object.keys(employee).length>0 && 

           <section className='view-contact mt-3'>
           <div className="container">
             <div className="row align-items-center">
               <div className="col-md-4">
               <img src={employee.url} alt="" className='img-fluid employee-img'  />
               </div>
               <div className="col-md-7">
               <ul className='list-group'>
                                       <li className='list-group-item list-group-item-action'>
                                       Name : <span className='fw-blod'>{employee.name}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                        Role <span className='fw-blod'>{employee.role}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                       Salary : <span className='fw-blod'>{employee.salary}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                       Email : <span className='fw-blod'>{employee.email}</span>
                                       </li>
    
                                       <li className='list-group-item list-group-item-action'>
                                        Mobile: <span className='fw-blod'>{employee.mobileNo}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Country : <span className='fw-blod'>{employee.country}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       State : <span className='fw-blod'>{employee.state}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       City : <span className='fw-blod'>{employee.city}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       Street : <span className='fw-blod'>{employee.street}</span>
                                       </li>
                                       <li className='list-group-item list-group-item-action'>
                                       ZipCode : <span className='fw-blod'>{employee.zipcode}</span>
                                       </li>
                                    </ul>
             </div>
             </div>
             <div className="row">
               <div className="col">
                      <Link to={'/admin'} className="btn btn-warning">Back</Link>
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

export default AdminViewDepartment
