import React, { useState } from 'react'
import { Link, useNavigate } from "react-router-dom";
import GetAllInvoice from './GetAllInvoice'
import ViewInvoice from './ViewInvoice'
import ManagerNavBar from "../../Manager/ManagerNavBar/ManagerNavBar";
import moment from 'moment';

const ReceptionistInvoice = () => {

    const [state,setState]=useState({
           
        selectedInvoice:{}
    });
    const {selectedInvoice}=state;
 
    const receiveInvoice=(invoice)=>{

        setState((state)=>({
            selectedInvoice:invoice

        }));
    };

  return (
    <React.Fragment>
          <ManagerNavBar/>
          {/* <pre>{JSON.stringify(selectedInvoice)}</pre> */}
        <div className="container-fluid  mt-3">
              <div className="row">
                  <div className="col">
                      <p className="h3 text-success animated flipInY ms-5"> <Link to={"/receptionist"} className="fa fa-arrow-left animated flipInY"/>Invoices List</p>
                  </div>
              </div>
        </div>
        <div className="container-fluid mt-3">
            <div className="row">
                <div className="col-md-9">
                    <GetAllInvoice sendInvoice={receiveInvoice}/>
                </div>
                <div className="col-md-3">
                    <ViewInvoice selectedInvoice={selectedInvoice}/>
                </div> 
            </div>
        </div>
    </React.Fragment>
  )
}

export default ReceptionistInvoice
