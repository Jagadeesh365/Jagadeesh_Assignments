import React from 'react'

const FooterHome = () => {
  return (
    <React.Fragment>
      <footer className="main-footer mt-4">
        <div className="footer-wrapper">
            <div className="container p-5">
                <div className="row">
                    <div classNames="col-md-3">
                        <h2>GMK HOTEL</h2>
                        <p className="lead"></p>
                    </div>
                    <div className="col-md-3">
                        <h2>Information</h2>
                        <p>Adventures</p>
                        <p>Tours</p>
                        <p>Hotels</p>
                        <p>Destinations</p>
                        <p>Enquires</p>
                        <p>Online Bookings</p>
                        <p>Spot Bookings</p>
                    </div>
                    <div className="col-md-3">
                        <h2>Experience</h2>
                        <p>Adventures</p>
                        <p>Tours</p>
                        <p>Hotels</p>
                        <p>Destinations</p>
                        <p>Enquires</p>
                        <p>Online Bookings</p>
                        <p>Spot Bookings</p>
                    </div>
                    <div className="col-md-3">
                        <h2>Address</h2>
                        <p>Flat : 1471 , Road No. 14</p>
                        <p>Jubilee Hills , Hyderabad</p>
                        <p>Telangana , India</p>
                        <div className="d-flex justify-content-between">
                            <i className="fab fa-facebook-square text-primary fa-2x"></i>
                            <i className="fab fa-twitter text-info fa-2x"></i>
                            <i className="fab fa-instagram text-danger fa-2x"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    </React.Fragment>
  )
}

export default FooterHome
