
import React from "react";
import Romm1 from './img/image_1.jpg'
import Romm2 from './img/image_2.jpg'
import Romm3 from './img/image_3.jpg'
import Romm4 from './img/image_4.jpg'
import Romm5 from './img/image_5.jpg'
import Romm6 from './img/image_6.jpg'


const Rooms = () => {
   
  return (
      
   <React.Fragment>
     
        <section className="p-4">
        <div className="container">
            <div className="row">
                <div className="col text-center">
                    <h1>Our Rooms</h1>
                    <p className="lead"></p>
                </div>
            </div>
            <div className="row mt-3">
                <div className="col-md-4">
                    <div className="card location-card">
                        <img src={Romm1} className="img-fluid location-img" alt=""/>
                        <h4 className="location-price">&#8377;{6000}</h4>
                        <div className="card-body">
                            <h3 className="card-title">SINGLE</h3>
                            <p className="card-text">A room to one  May have one or more beds The room Size or area of single Rooms are generally between 37 m to 45 m</p>
                            <button className="btn btn-danger btn-sm">Book Now</button>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card location-card">
                        <img src={Romm2} className="img-fluid location-img" alt=""/>
                        <h4 className="location-price">&#8377;{8000}</h4>
                        <div className="card-body">
                            <h3 className="card-title">DOUBLE</h3>
                            <p className="card-text">A double room contain for two people the bed will either be A Double .Queen King sized this room is for couple there will be only one bed</p>
                            <button className="btn btn-danger btn-sm">Book Now</button>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card location-card">
                        <img src={Romm3} className="img-fluid location-img" alt=""/>
                        <h4 className="location-price">&#8377;{(10000).toFixed(2)}</h4>
                        <div className="card-body">
                            <h3 className="card-title">Triple</h3>
                            <p className="card-text">A room sutable for up to 3 gets . the room contain two regular beds and one extra bed in a superior  twin room</p>
                            <button className="btn btn-danger btn-sm">Book Now</button>
                        </div>
                    </div>
                </div>
            </div>
           
                
                </div>
    </section>
     
   </React.Fragment>
     
  
  )
}

export default Rooms
