import React from 'react'

const ManagerNavBar = () => {
  return (
    <React.Fragment>
         {/* <!-- Main Navbar --> */}
    <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
        <div className="container">
            <a href="#" className="navbar-brand text-warning">
               <i className="fa fa-snowflake"></i> GMK HOTEL
            </a>
            <button className="navbar-toggler" data-toggle="collapse" data-target="#ui-navbar">
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="ui-navbar">
            
                <ul className="navbar-nav ml-auto">
                   
                    <li className="nav-item">
                        <a className="nav-link" href={'/'}>
                            <i className="fa fa-sign-out-alt text-muted"></i> LogOut</a>
                            
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </React.Fragment>
  )
}

export default ManagerNavBar
