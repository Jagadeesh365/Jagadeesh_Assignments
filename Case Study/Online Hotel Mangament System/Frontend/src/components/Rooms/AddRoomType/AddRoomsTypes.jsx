
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";
import GetAllTypesRooms from "./GetAllTypesRooms";



const AddRoomsTypes = () => {
  let navigate = useNavigate();

  let [roomType, setRoomType] = useState({
    loading: false,
    room:{
          type:'',
          price: 0,    
    },
    errorMessage: "",
   
  });


  let updateInput=(event)=>
  {
    setRoomType({
      ...roomType,
      room:{
        ...roomType.room,
        [event.target.name]:event.target.value
      }
    });
  };

  let submitForm = async (event) => {
    event.preventDefault();
    try {
      let response = await EmployeeService.addRoomType(roomType.room)
      if (response) {
        console.log(response.data);
        navigate("/rooms/type", { replace: true });
      }
    } catch (error) {
      setRoomType({ ...roomType, errorMessage: error.message });
      navigate("/rooms/type", { replace: false });
    }
  };
  return (
    <React.Fragment>
       {/* <pre>{JSON.stringify(roomList.listOfRoom)}</pre> */}
      
        {/* <pre>{JSON.stringify(roomType.room)}</pre> */}
        <section className="add-contact p-3">
          <GetAllTypesRooms/>
        <div className="container mt-5">
          <div className="row">
            <div className="col">
              <p className="h4 text-success fw-bold">Add Rooms Type</p>
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
                     value={roomType.room.type}
                     onChange={updateInput}
                     type="text"
                    className="form-control"
                    placeholder="Add Room Type in Captical Letters"
                  />
                </div>
               
                <div className="mb-2">
                  <input
                     required={true}
                     name="price"
                     value={roomType.room.price}
                     onChange={updateInput}
                     type="text"
                    className="form-control"
                    placeholder="price"
                  />
                </div>
                <div className="mb-2">
                  <input
                    type="submit"
                    className="btn btn-success"
                    value="Craete"
                  />
                  <Link to={"/rooms/nav"} className="btn btn-dark ms-2">
                    Close
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  )
}

export default AddRoomsTypes
