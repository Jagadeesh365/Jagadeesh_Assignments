import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../assets/imgs/gmk_hotel.jpeg';

const NavBar = () => {
  return (
   <React.Fragment>
       {/* <nav className='navbar navbar-dark bg-dark navbar-expand-sm sticky-top'>
       <img src={logo} alt="" className={'d-block m-auto '} style={{width:"40px"}}/>
           <div className='container'>
           <Link to={'/'} className="navbar-brand  ">GMK HOTEL
               </Link>   

               <Link to={'/register'} className="navbar-brand  ">SigUp
               </Link> 
          <div className="nav-item dropdown navbar-brand">
              
          <a className="nav-link dropdown-toggle text-success"  id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <i className='fas fa-sign-in-alt text-primary me-2'/> Login
          </a>
          <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li> <Link to={'/receptionnistLogin'} className="dropdown-item">
                   <i className='fa-solid fa-bell-concierge text-success me-2'/>Receptionist
               </Link></li>
            <li><Link to={'/admin'} className="dropdown-item">
                   <i className='fa-solid fa-user text-primary me-2'/>Admin
               </Link></li>
            <li> <Link to={'/managerLogin'} className="dropdown-item">
                   <i className='fa fa-users text-warning me-2'/>Manager 
               </Link></li>
          </ul>
        </div>
           </div>
       </nav> */}
        <header class="main-header">

{/* <!-- Navbar --> */}
<nav className="navbar navbar-expand-sm scrolling-navbar navbar-dark fixed-top">
    <div className="container">
        <a href="index.html" className="navbar-brand">
            <i > <img src={logo} alt="" className={'d-block m-auto '} style={{width:"40px"}}/></i> GMK HOTEL</a>
        <button className="navbar-toggler" data-toggle="collpase" data-target="#ui-navbar">
            <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="ui-navbar">
            <ul className="navbar-nav ml-auto">
                <li className="nav-item px-2">
                    <a className="nav-link" href="/">Home</a>
                </li>
                <li className="nav-item px-2">
                    <a className="nav-link" href="#">About</a>
                </li>
                <li className="nav-item px-2">

                <a className="nav-link" href="/register">SigUp</a>
                {/* <Link to={'/register'} className="navbar-brand  ">SigUp
               </Link>  */}
                </li>
                <li className="nav-item px-2">
                <div className="nav-item dropdown navbar-brand">
              
              <a className="nav-link dropdown-toggle"id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              <i className='fas fa-sign-in-alt text-primary me-2'/> Login
              </a>
              <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <li> <Link to={'/receptionnistLogin'} className="dropdown-item">
                       <i className='fa-solid fa-bell-concierge text-success me-2'/>Receptionist
                   </Link></li>
                <li><Link to={'/adminLogin'} className="dropdown-item">
                       <i className='fa-solid fa-user text-primary me-2'/>Admin
                   </Link></li>
                <li> <Link to={'/managerLogin'} className="dropdown-item">
                       <i className='fa fa-users text-warning me-2'/>Manager 
                   </Link></li>
              </ul>
            </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

{/* <!-- Landing Page --> */}
<div className="landing-div">
    <div className="landing-wrapper d-flex flex-column h-100 align-items-center justify-content-center text-center">
        <div className="carousel slide carousel-fade" data-ride="carousel">
            <div className="carousel-inner">
                <div className="carousel-item active">
                    <h1 className="display-4 animated slideInLeft delay-1s">Enjoy Ultimate Vacations <br/> with Us</h1>
                </div>
                <div className="carousel-item">
                    <h1 className="display-4 animated slideInRight delay-1s">Make Tours Amazing <br/> with Us</h1>
                </div>
                <div className="carousel-item">
                    <h1 className="display-4 animated slideInDown delay-1s">Feel Relaxed in Holidays <br/> with Us</h1>
                </div>
            </div>
        </div>
    </div>
</div>

</header>
   </React.Fragment>
  )
}

export default NavBar
