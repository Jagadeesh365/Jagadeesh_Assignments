import React from 'react'
import Logo from '../assets/imgs/gmk_hotel.jpeg'

import { Link } from 'react-router-dom'
import Footer from '../Footer/Footer'
import ManagerNavBar from './ManagerNavBar/ManagerNavBar'


const Manager = () => {
  return (
   <React.Fragment>
     <ManagerNavBar/>
       <section className='manager-list p-5'>
          <div className="container">
             
                           
                            <div className="card my-2">
                                <div className="card-body">
                                   <div className="row align-items-center d-flex justify-content-around">
                                   <div className="col-md-4">
                                      <img src={Logo} alt="" className='img-fluid '  />
                                    </div>
                                  
                                    <div className="col-md-7">
                                       
                                      <ul className='list-group'>
                                         <li className='list-group-item list-group-item-action'>
                                         Employees Details  <span className='fw-blod'></span>
                                         </li>
      
                                         <li className='list-group-item list-group-item-action'>
                                          Rooms Details <span className='fw-blod'></span>
                                         </li>
                                      </ul>
                                    </div>
                                    <div className="col-md-1 d-flex flex-column align-items-center">
                                          <Link to={`/contact/list`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-circle-user'/>
                                          </Link>
      
                                          <Link to={`/manager/roomsNav`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-hotel'/>
                                          </Link>
                                    </div>
                                   </div>
                                </div>
                            </div>
                        </div>
              
          

      </section>
      <Footer  />
   </React.Fragment>
  )
}

export default Manager
