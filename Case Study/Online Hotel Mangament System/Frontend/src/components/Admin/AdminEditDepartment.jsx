import React, { useState ,useEffect} from 'react'
import { Link ,useParams,useNavigate} from 'react-router-dom'
import { EmployeeService } from '../../../../hms_front/src/Services/EmployeeService';
import Spinner from '../../../src/components/Spinner/Spinner';

const AdminEditDepartment = () => {
  let navigate=useNavigate();
  let {contactId}=useParams();

  let [state,setState]=useState({
    loading:false,
    employee:{
      name:'',
      url:'',
      password:'',
      role:'',
      salary:'',
        email:'',
        country:'',
        state:'',
        city:'',
        street:'',
        zipcode:'',
        mobileNo:''

      
    },
    errorMessage:''
  });
    useEffect(()=>{
      (async function(){
      try {
          setState({...state,loading:true})
          let response=await EmployeeService.getEmployee(contactId);
          // let groupResponse=await EmployeeService.getGroups();
          setState({...state,
          loading:false,
          employee:response.data,
          // groups:groupResponse.data
          
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
  
  },[contactId]);
  let updateInput=(event)=>
  {
    setState({
      ...state,
      employee:{
        ...state.employee,
        [event.target.name]:event.target.value
      }
    });
  };
  let submitForm= async(event)=>
{
   event.preventDefault();
   try {
     let response=await EmployeeService.updateEmployee(state.employee);
     if(response)
     {
       console.log(response.data);
           navigate(`/admin`,{replace:true});
     }
   } catch (error) {
     setState({...state,errorMessage:error.message });
     navigate(`/Admin/editDepartment/${contactId}`,{replace:false});
   }
};

  let{loading,employee,errorMessage}=state;
  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(state.employee)}</pre> */}
        {
          loading ? <Spinner/> :<React.Fragment>
             <section className='add-contact p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-primary fw-bold">Edit Employee</p>
              <p className='fst-italic'></p>

            </div>
          </div>
          <div className="row align-items-center">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input 
                  required={true}
                  name='name'
                  value={employee.name}
                  onChange={updateInput}
                  type="text" className='form-control' placeholder='Name' />
                </div>
                <div className="mb-2">
                  <input 
                  required={true}
                  name='url'
                  value={employee.url}
                  onChange={updateInput}
                  type="text" className='form-control' placeholder='Photo Url' />
                </div>

                <div className="mb-2">
                  <input 
                  required={true}
                  name='password'
                  value={employee.password}
                  onChange={updateInput}type="password" className='form-control' placeholder='Password' />
                </div>

                <div className="mb-2">
                  <input 
                  required={true}
                  name='role'
                  value={employee.role}
                  onChange={updateInput}
                  type="texr" className='form-control' placeholder='Role' />
                </div>

                <div className="mb-2">
                  <input 
                  required={true}
                  name='salary'
                  value={employee.salary}
                  onChange={updateInput}
                  type="number" className='form-control' placeholder='Salary' />
                </div>

                <div className="mb-2">
                  <input 
                 required={true}
                  name='email'
                  value={employee.email}
                  onChange={updateInput}
                  type="email" className='form-control' placeholder='Email' />
                </div>

                <div className="mb-2">
                 <input
                   required={true}
                   name='country'
                   value={employee.country}
                   onChange={updateInput}
                    type="text" className='form-control' placeholder='Country' />
                 </div>

                 <div className="mb-2">
                 <input
                   required={true}
                   name='state'
                   value={employee.state}
                   onChange={updateInput}
                    type="text" className='form-control' placeholder='State' />
                 </div>

                 <div className="mb-2">
                 <input
                   required={true}
                   name='city'
                   value={employee.city}
                   onChange={updateInput}
                    type="text" className='form-control' placeholder='City' />
                 </div>

                 <div className="mb-2">
                 <input
                   required={true}
                   name='street'
                   value={employee.street}
                   onChange={updateInput}
                    type="text" className='form-control' placeholder='Street' />
                 </div>

                 <div className="mb-2">
                 <input
                   required={true}
                   name='zipcode'
                   value={employee.zipcode}
                   onChange={updateInput}
                    type="text" className='form-control' placeholder='ZipCode' />
                 </div>

                 <div className="mb-2">
                 <input
                   required={true}
                   name='mobileNo'
                   value={employee.mobileNo}
                   onChange={updateInput}
                    type="number" className='form-control' placeholder='MobileNo' />
                 </div>
                 
                <div className="mb-2">
                  <input type="submit" className='btn btn-primary' value="Update" />
                  <Link to={'/admin'} className="btn btn-dark ms-2">Cancle</Link>
                </div>
              </form>
            </div>
            <div className="col-md-6">
              <img src={employee.url} alt=""className='img-fluid employee-img' />
            </div>
          </div>
        </div>
    </section>

          </React.Fragment>
        }
   
  </React.Fragment>
  )
}

export default AdminEditDepartment
