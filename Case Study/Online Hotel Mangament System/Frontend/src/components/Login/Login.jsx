import React from 'react'
import Footer from '../Footer/Footer'

const Login = () => {
  return (
    
      <React.Fragment>
      {/* <!-- Main Navbar --> */}
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container">
        <a href="index.html" class="navbar-brand text-warning">
            <i class="fa fa-snowflake"></i> Ui Brains
        </a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#ui-navbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="ui-navbar">

        </div>
    </div>
</nav>

{/* <!-- Dashboard Section --> */}
<section class="p-2 bg-teal text-white">
    <div class="container">
        <div class="row animated flipInY">
            <h1>
                <i class="fa fa-snowflake"></i> UiBrains Dashboard</h1>
        </div>
    </div>
</section>

{/* <!-- Login Section --> */}
<section class="p-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 m-auto">
                <div class="card animated zoomIn delay-1s">
                    <div class="card-header bg-teal text-white text-center">
                        <h3>Login Here</h3>
                    </div>
                    <div class="card-body bg-light">
                        <form>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="User Name"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password"/>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer bg-light">
                        <a href="index.html" class="btn btn-teal btn-block">Login</a>
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

export default Login
