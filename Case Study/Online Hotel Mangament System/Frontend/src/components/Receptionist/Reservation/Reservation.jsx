import React, { useState, useEffect } from "react";
import { Link, useNavigate,useParams } from "react-router-dom";
import { EmployeeService } from "../../../Services/EmployeeService";

const Reservation = () => {
  let {roomId}=useParams();
  let navigate = useNavigate();
  //Guest
  const [name, setName] = useState("");
  const [gender, setGender] = useState("");
  const [age, setAge] = useState("");
  const [mobileNo, setMobileNo] = useState("");
  const [currentStatus, SetcurrentStatus] = useState("");
  const [roomDetails, setroomDetails] = useState({});

  const setroomDetailsInput = (e) => {
  
    setroomDetails({
      ...roomDetails,
      [e.target.name]: e.target.value,
    });
  };

  //Address
  const [addressSate, setAddress] = useState({
    address: {
      country: "",
      state: "",
      city: "",
      street: "",
      zipcode: "",
    },
  });
  const AddressInput = (event) => {
    setAddress({
      ...addressSate,
      address: {
        ...addressSate.address,
        [event.target.name]: event.target.value,
      },
    });
  };
  let submitForm = async (event) => {
    event.preventDefault();
    const data = {
      name,
      gender,
      age,
      mobileNo,
      address,
      currentStatus,
      roomDetails,
    };
    console.log(data);

    try {
      let response = await EmployeeService.createGuest(data);

      if (response.data.message === "Success!, Guest Added") {
        console.log(response.data.messag);
        navigate("/receptionist/list", { replace: true });
      } else {
        alert(response.data.message);
        navigate(`/reservation/${roomId}`, { replace: false });
      }
    } catch (error) {
      navigate(`/reservation/${roomId}`, { replace: false });
    }
  };

  let { address } = addressSate;

  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(state. guest)}</pre> */}
      {/* <pre>{JSON.stringify(addressSate.address)}</pre>  */}
      <section className="add-contact p-3">
        <div className="container">
          <div className="row">
            <div className="col">
              <p className="h4 text-success fw-bold">BOOK ROOM:{roomId}</p>
              <p className="fst-italic"></p>
            </div>
          </div>
          <div className="row">
            <div className="col-md-4">
              <form onSubmit={submitForm}>
                <div className="mb-2">
                  <input
                    required={true}
                    name="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Name"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="gender"
                    value={gender}
                    onChange={(e) => setGender(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Gender"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="age"
                    value={age}
                    onChange={(e) => setAge(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Age"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="mobileNo"
                    value={mobileNo}
                    onChange={(e) => setMobileNo(e.target.value)}
                    className="form-control"
                    placeholder=" Mobile number"
                  />
                </div>

                {/* <div className="mb-2">
                  <input
                    required={true}
                    name="salary"
                    value={employee.salary}
                    onChange={updateInput}
                    type="number"
                    className="form-control"
                    placeholder="Salary"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="email"
                    value={employee.email}
                    onChange={updateInput}
                    type="email"
                    className="form-control"
                    placeholder="Email"
                  />
                </div> */}

                <div className="mb-2">
                  <input
                    required={true}
                    name="country"
                    value={address.country}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="Country"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="state"
                    value={address.state}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="State"
                  />
                </div>
                <div className="mb-2">
                  <input
                    required={true}
                    name="city"
                    value={address.city}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="City"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="street"
                    value={address.street}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="Street"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="zipcode"
                    value={address.zipcode}
                    onChange={AddressInput}
                    type="text"
                    className="form-control"
                    placeholder="ZipCode"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="currentStatus"
                    value={currentStatus}
                    onChange={(e) => SetcurrentStatus(e.target.value)}
                    type="text"
                    className="form-control"
                    placeholder="Current Status"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="roomId"
                    value={roomDetails.roomId}
                    onChange={setroomDetailsInput}
                    type="text"
                    className="form-control"
                    placeholder="Room Id"
                  />
                </div>

                <div className="mb-2">
                  <input
                    required={true}
                    name="noOfNights"
                    value={roomDetails.noOfNights}
                    onChange={setroomDetailsInput}
                    type="number"
                    className="form-control"
                    placeholder="No Of Night"
                  />
                </div>

                <div className="mb-2">
                  <input
                    type="submit"
                    className="btn btn-success"
                    value="Craete"
                  />
                  <Link to={"/receptionist/list"} className="btn btn-dark ms-2">
                    {" "}
                    Close
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </section>
    </React.Fragment>
  );
};

export default Reservation