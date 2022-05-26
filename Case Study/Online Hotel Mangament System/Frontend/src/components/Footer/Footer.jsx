import React from 'react'

const Footer = () => {
  return (
   <React.Fragment>
        {/* <!-- Main Footer --> */}
    <footer className="p-2 bg-dark text-white text-center">
        <div className="container">
            <div className="row">
                <div className="col">
                    <h3>Copyright &copy; 2020 , GMK HOTEL.com</h3>
                    <h6>All Rights Reserved</h6>
                    <h6>Developed & Maintained by
                        <a className="text-warning" href="#" target="_blank">GUDIPALLI JAGADEESH</a>
                    </h6>
                </div>
            </div>
        </div>
    </footer>
   </React.Fragment>
  )
}

export default Footer
