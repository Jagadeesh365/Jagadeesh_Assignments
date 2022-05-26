import React from 'react'
import { Link ,useParams} from 'react-router-dom'
import Logo from '../assets/imgs/gmk_hotel.jpeg'

const RoomNav = () => {
  return (
    <React.Fragment>
        <section className="p-2 bg-teal text-white">
        <div className="container">
            <div className="row">
                <h1 className="animated flipInY">
                   <i className="fa fa-chart-bar"></i> Dashboard</h1>
                  
            </div>
        </div>
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
                                       
                                      <ul className='list-group'>
                                         <li className='list-group-item list-group-item-action'>
                                         Room List ,View Room ,Delete Room <span className='fw-blod'></span>
                                         </li>
      

                                         <li className='list-group-item list-group-item-action'>
                                           Get Rooms Type<span className='fw-blod'></span>
                                         </li>
                                         <li className='list-group-item list-group-item-action'>
                                           Get All Booked Rooms<span className='fw-blod'></span>
                                         </li>
                                         <li className='list-group-item list-group-item-action'>
                                           Get All Available Rooms<span className='fw-blod'></span>
                                         </li>
                                      </ul>
                                    </div>
                                    <div className="col-md-1 d-flex flex-column align-items-center">
                                          <Link to={`/rooms/list`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-circle-user'/>
                                          </Link>
      
                                         

                                          <Link to={`/rooms/getAllTypes`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-hotel'/>
                                          </Link>
                                          <Link to={`/getbooked`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-hotel'/>
                                          </Link>
                                          <Link to={`/getavailable`}className="btn btn-primary my-1">
                                              <i className='fa-solid fa-hotel'/>
                                          </Link>
                                    </div>
                                   </div>
                                </div>
                            </div>
                            
                        
                  <Link
                                  to={`/receptionist`}
                                  className="btn btn-warning my-1"
                                >
                                  <i className="fa fa-arrow-left" />
                                </Link>
                        </div>
              

      </section>
   </React.Fragment>
  )
}

export default RoomNav
