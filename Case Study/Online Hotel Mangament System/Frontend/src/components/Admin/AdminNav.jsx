import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Footer from "../Footer/Footer";
import Logo from "../assets/imgs/gmk_hotel.jpeg"
import ManagerNavBar from '../Manager/ManagerNavBar/ManagerNavBar'
import { useAuth } from './Auth'

const AdmiNav = () => {
  const auth=useAuth()
  return (
    <React.Fragment>
      <section className="container-navNar">
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
                <li class="nav-item dropdown">
{/*                         
                            <Link to={`/adminProfile`} class="nav-link">
                                             <i className='fa fa-sign-in-alt text-muted m-1'/>{auth.user.employee.name}
                                         </Link>
                        */}
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href={'/'}>
                            <i className="fa fa-sign-out-alt text-muted"></i> LogOut</a>
                            
                    </li>
                </ul>
            </div>
        </div>
    </nav>
      </section>
    
      <section className='manager-list p-5'>
         <div className="container">
            
                          
                           <div className="card my-2">
                               <div className="card-body">
                                  <div className="row align-items-center d-flex justify-content-around">
                                  <div className="col-md-4">
                                  
                                     <img src={Logo} alt="" className='img-fluid '  />
                                   </div>
                                 
                                   <div className="col-md-7">
                                   <li className='list-group-item list-group-item-action'>
                                         Employees Details  <span className='fw-blod'></span>
                                         </li>
                                     <ul className='list-group'>
                                        <li className='list-group-item list-group-item-action'>
                                        Guset's Details  <span className='fw-blod'></span>
                                        </li>
     
                                        <li className='list-group-item list-group-item-action'>
                                         Rooms Details <span className='fw-blod'></span>
                                        </li>

                                        <li className='list-group-item list-group-item-action'>
                                         Hotel Report <span className='fw-blod'></span>
                                        </li>
                                     </ul>
                                   </div>
                                   <div className="col-md-1 d-flex flex-column align-items-center">
                                   <Link to={`/admin`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-circle-user'/>
                                          </Link>
                                         <Link to={`/adminGustList`}className="btn btn-primary my-1">
                                             <i className='fa-solid fa-user'/>
                                         </Link>
     
                                         <Link to={`/adminRoomList`}className="btn btn-primary my-1">
                                             <i className='fa-solid fa-hotel'/>
                                         </Link>

                                         <Link to={'/admin/report'} className="btn btn-primary ms-2">
                                          <i className='fa fa-file me-2'/>
                                          </Link>
                                   </div>
                                  </div>
                               </div>
                           </div>
                       </div>
             
         

     </section>
     <Footer/>
  </React.Fragment>
   
  )
}

export default AdmiNav
