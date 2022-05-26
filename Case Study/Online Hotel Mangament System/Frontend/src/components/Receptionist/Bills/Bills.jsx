import React, { useState ,useEffect} from 'react'
import { Link ,useParams,useNavigate} from 'react-router-dom'
import { EmployeeService } from "../../../Services/EmployeeService";
import Spinner from '../../Spinner/Spinner';

const Bills = () => {
  let navigate=useNavigate();
  let {guestId}=useParams();

  let [state,setState]=useState({
    loading:false,
    bill:{
      guestId:'',
      employeeName:'' 
    },
    errorMessage:''
  });
   
  let updateInput=(event)=>
  {
    setState({
      ...state,
      bill:{
        ...state.bill,
        [event.target.name]:event.target.value
      }
    });
  };
  let submitForm= async(event)=>
{
   event.preventDefault();
   try {
     let response=await EmployeeService.issueBill(state.bill);
     if(response)
     {
       console.log(response.data.message);
       alert(response.data.message)
           navigate(`/receptionist/getallinvoice`,{replace:true});
     }
   } catch (error) {
     setState({...state,errorMessage:error.message });
     
     navigate(`/receptionist/bills/${guestId}`,{replace:false});
   }
};

  let{loading,bill,errorMessage}=state;
  return (
    <React.Fragment>
       <pre>{JSON.stringify(state.bill)}</pre> 
        {
          loading ? <Spinner/> :<React.Fragment>
             <section className='add-contact p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-primary fw-bold">ISSUE Bill FOR :{guestId}</p>
              <p className='fst-italic'></p>

            </div>
          </div>
          <div className="row align-items-center">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input 
                  required={true}
                  name='guestId'
                  value={bill.guestId}
                  onChange={updateInput}
                  type="text" className='form-control' placeholder='Guest Id' />
                </div>
                <div className="mb-2">
                  <input 
                  required={true}
                  name='employeeName'
                  value={bill.employeeName}
                  onChange={updateInput}
                  type="text" className='form-control' placeholder='Employee Name' />
                </div>

                
                 
                <div className="mb-2">
                  <input type="submit" className='btn btn-primary' value="Generate Bill" />
                  <Link to={'/receptionist/list'} className="btn btn-dark ms-2">Cancle</Link>
                </div>
              </form>
            </div>
            {/* <div className="col-md-6">
              <img src={employee.url} alt=""className='img-fluid employee-img' />
            </div> */}
          </div>
        </div>
    </section>

          </React.Fragment>
        }
   
  </React.Fragment>
  )
}

export default Bills
