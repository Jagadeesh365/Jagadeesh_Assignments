import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";
import { toast, ToastContainer } from "react-toastify";

const AddRoom = () => {
  let navigate = useNavigate();
  //Guest
  const [roomType, setRoomType] = useState("");
  const [status, setStatus] = useState("");
  const [bookingDetails, setBookingDetails] = useState({});

  const setroomDetailsInput = (e) => {
    setBookingDetails({
      ...bookingDetails,
      [e.target.name]: e.target.value,
    });
  };

  //Address
  
  
  let submitForm = async (event) => {
    event.preventDefault();
    const data={roomType,status,bookingDetails}
    console.log(data)
    try {
      let response = await EmployeeService.addRoom(data)
      console.log(response.data)

      if (response.data.message ==="Added") {
     
        toast.success(response.data.refId,"Added", {
          position: "top-right",
          autoClose: 10000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          });
       navigate("/rooms/list", { replace: true });
      } else {
        toast.error(response.data.message, {
          position: "top-right",
          autoClose: 5000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
        navigate("/rooms/add", { replace: false });
      }
    } catch (error) {
      navigate("/rooms/add", { replace: false });
    }
  };
  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(state. guest)}</pre>
      <pre>{JSON.stringify(addressSate.address)}</pre> */}
      <section className="add-contact p-3">
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-success fw-bold">Add Room</p>
              <p className="fst-italic"></p>
            </div>
          </div>
          <div className="row">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input
                    required={true}
                    name="room Type"
                    value={roomType}
                    onChange={(e) => setRoomType(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Room Type In Capital Letter"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="gender"
                    value={status}
                    onChange={(e) => setStatus(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Status Type In Capital Letter"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="bookingDate"
                    value={bookingDetails.bookingDate}
                    onChange={setroomDetailsInput}
                    type="Date"
                    className="form-control"
                    placeholder="Room Id"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="noOfNight"
                    value={bookingDetails.noOfNight}
                    onChange={setroomDetailsInput}
                    type="number"
                    className="form-control"
                    placeholder="No Of Night"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="guestId"
                    value={bookingDetails.guestId}
                    onChange={setroomDetailsInput}
                    type="text"
                    className="form-control"
                    placeholder="Guest Id"
                  />
                </div>

                <div className="mb-2">
                  <input
                    type="submit"
                    className="btn btn-success"
                    value="Craete"
                  />
                  <Link to={"/rooms/list"} className="btn btn-dark ms-2">
                    {" "}
                    Close
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
      <ToastContainer />
    </React.Fragment>
  );
};

export default AddRoom;
