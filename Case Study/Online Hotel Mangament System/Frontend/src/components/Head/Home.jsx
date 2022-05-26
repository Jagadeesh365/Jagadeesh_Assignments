import React from 'react'
import FooterHome from './FooterHome'
import Rooms from './Rooms'
import Silder1 from './img/bg_1.jpg'
import Silder2 from './img/slider-2.jpg'
import Silder3 from './img/slider-3.jpg'
import NavBar from '../NavBar/NavBar'
import { EmployeeService } from '../../Services/EmployeeService'

const Home = () => {
  
  return (
    
      <React.Fragment>
          
           <NavBar/>
           
      {/* <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="carousel">
        <div className="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div className="carousel-inner">
            <div className="carousel-item active">
                <img src={Silder1} className="d-block w-100 " alt="..."/>
            </div>
            <div className="carousel-item">
                <img src={Silder2} className="d-block w-100" alt="..."/>
            </div>
            <div className="carousel-item">
                <img src={Silder3} className="d-block w-100" alt="..."/>
            </div>
        </div>
        <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span className="carousel-control-prev-icon" aria-hidden="true"></span>
            <span className="visually-hidden">Previous</span>
        </button>
        <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span className="carousel-control-next-icon" aria-hidden="true"></span>
            <span className="visually-hidden">Next</span>
        </button>
    </div> */}
     
     
      <Rooms/>
      <FooterHome/>
      
      </React.Fragment>
     
    
  )
}

export default Home
