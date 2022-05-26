import React, { useState ,useEffect} from 'react'
import { Link ,useParams,useNavigate} from 'react-router-dom'
import { EmployeeService } from '../../../Services/EmployeeService';
import Spinner from '../../Spinner/Spinner';


const EditGuest = () => {
  let navigate=useNavigate();
  let {guestId}=useParams();

  let [state,setState]=useState({
    loading:false,
    guest: {
           
      name: '',
      gender: '',
      age: 0,
      mobileNo: '',
      memberDetails: [
        {
          name: '',
          age: 0,
          gender:''
        }
      ],
      address: {
        country: '',
        state: '',
        city: '',
        street: '',
        zipcode: ''
      },
      currentStatus: '',
      roomDetails: {
        roomId:'',
        noOfNights: 0
      }
  },
    errorMessage:''
  });
    useEffect(()=>{
      (async function(){
      try {
          setState({...state,loading:true})
          let response=await EmployeeService.getGuestById(guestId)
          // let groupResponse=await EmployeeService.getGroups();
          setState({...state,
          loading:false,
          guest:response.data,
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
  
  },[guestId]);
  let AddressInput=(event)=>
  {
    setState({
      ...state,
      address:{
        ...state.guest.address,
        [event.target.name]:event.target.value
      }
    });
  };

  let updateInput=(event)=>
  {
    setState({
      ...state,
      guest:{
        ...state. guest,
        [event.target.name]:event.target.value
      }
    });
  };

  let submitForm= async(event)=>
{
   event.preventDefault();
   try {
     let response=await EmployeeService.updateGuest(state.guest);
     if(response)
     {
       console.log(response.data);
           navigate(`/receptionist/list`,{replace:true});
     }
   } catch (error) {
     setState({...state,errorMessage:error.message });
     navigate(`/receptionist/editGuest/${guest.id}`,{replace:false});
   }
};

  let{loading,guest,errorMessage}=state;
  return (
    <React.Fragment>
      
     
        {
          loading ? <Spinner/> :<React.Fragment>
             <section className='add-contact p-3'>
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-primary fw-bold">Edit Guest</p>
              <h5>Guest Id:{guestId}</h5>
              <p className='fst-italic'></p>

            </div>
          </div>
          <div className="row align-items-center">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
               <div className="mb-2">
                  <input
                    required={true}
                    name="name"
                    value={guest.name}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Guest Name"
                  />
                </div>
                
                <div className="mb-2">
                <input
                    required={true}
                    name="gender"
                    value={guest.gender}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Gender"
                  />
                  </div>

                  <div className="mb-2">
                  <input
                    required={true}
                    name="age"
                    value={guest.age}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Age"
                  />
                 </div>

                 <div className="mb-2">
                  <input
                    required={true}
                    name="mobileNo"
                    value={guest.mobileNo}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Mobile No"
                  />
                </div>

                {/* <div className="mb-2">
                  <input
                    required={true}
                    name="salary"
                    // value={employee.salary}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Salary"
                  />
                </div> */}

                <div className="mb-2">
                  <input
                    required={true}
                    
                    name="currentStatus"
                    value={guest.currentStatus}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Current Status"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="country"
                    value={state.guest.address.country}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="Country"
                  />
                </div>
               

                <div className="mb-2">
                  <input
                    required={true}
                    name="gstate"
                    value={guest.address.state}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="State"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="city"
                    value={guest.address.city}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="City"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="street"
                    value={guest.address.street}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Street"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="zipcode"
                    value={guest.address.zipcode}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="ZipCode"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="roomId"
                    value={guest.roomDetails.roomId}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Room Id"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="noOfNights"
                    value={guest.roomDetails.noOfNights}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="No Of Nights"
                  />
                </div>
                 
                <div className="mb-2">
                  <input type="submit" className='btn btn-primary' value="Update" />
                  <Link to={'/receptionist/list'} className="btn btn-dark ms-2">Cancle</Link>
                </div>
              </form>
            </div>
            <div className="col-md-6">
              <img src={guest.url} alt=""className='img-fluid employee-img' />
            </div>
          </div>
        </div>
    </section>

          </React.Fragment>
        }
   
  </React.Fragment>
  )
}

export default EditGuest
