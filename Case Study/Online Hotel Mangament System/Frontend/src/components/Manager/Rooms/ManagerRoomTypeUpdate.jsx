import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";
const ManagerRoomTypeUpdate = () => {
  let navigate = useNavigate();

  let [state, setState] = useState({
    loading: false,
    updateRoomDetails: {
      type: "",
      price: ""
      
    },
    errorMessage: "",
   
  });
  

  let updateInput=(event)=>
  {
    setState({
      ...state,
      updateRoomDetails:{
        ...state.updateRoomDetails,
        [event.target.name]:event.target.value
      }
    });
  };

  let submitForm = async (event) => {
    event.preventDefault();
    try {
      let response = await EmployeeService.updateRoomDetails(state.updateRoomDetails);
      console.log(response.data)
      if (response) {
        navigate("/manager/getroomstpyes", { replace: true });
      }
    } catch (error) {
      setState({ ...state, errorMessage: error.message });
      navigate("/manager/updateroomtype", { replace: false });
    }
  };
  let { updateRoomDetails } = state;
  
  return (
    <React.Fragment>
      <pre>{JSON.stringify(state.updateRoomDetails)}</pre>
      <section className="add-contact p-3">
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-success fw-bold">Update Room Details</p>
              <p className="fst-italic">
               
              </p>
            </div>
          </div>
          <div className="row">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input
                    required={true}
                    name="type"
                    value={updateRoomDetails.type}
                    onChange={updateInput}
                    type="text"
                    className="form-control"
                    placeholder="Type"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="price"
                    value={updateRoomDetails.price}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Price"
                  />
               </div>

                <div className="mb-2">
                  <input
                    type="submit"
                    className="btn btn-success"
                    value="Craete"
                  />
                  <Link to={"manager/getroomstpyes"} className="btn btn-dark ms-2"> Close</Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  );
};

export default ManagerRoomTypeUpdate;
