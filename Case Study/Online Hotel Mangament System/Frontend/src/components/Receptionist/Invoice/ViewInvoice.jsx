import React from 'react'
import { Link} from 'react-router-dom'
import Logo from '../../../assets/img/logo.png'
import moment from 'moment';
const ViewInvoice = (props) => {
    const {selectedInvoice}=props;
  return (
      
   <React.Fragment>
       

        {
            Object.keys(selectedInvoice).length  > 0 &&

            <div className="card shodow-lg sticky-top animated zoomIn delay-1s">
            {/* <img src={Logo} alt=""  className='img-fluid img-thumbnail'/> */}
           
            <div className="card-body">
                       <ul className='list-group'>
                           <li className='list-group-item'>
                                Guest Id:{selectedInvoice.invoice.guestId}
                           </li>
                           <li className='list-group-item'>
                                Name:{selectedInvoice.invoice.guestName}
                           </li>
                           <li className='list-group-item'>
                                Mobile No:{selectedInvoice.invoice.guestMobile}
                           </li>
                           <li className='list-group-item'>
                           Booked Room Type:{selectedInvoice.invoice.bookedRoomType}
                           </li>
                           <li className='list-group-item'>
                           Room Price PerNight:{selectedInvoice.invoice.roomPricePerNight}
                           </li>
                           <li className='list-group-item'>
                            No Of Nights:{selectedInvoice.invoice.nights}
                           </li>
                           <li className='list-group-item'>
                           Booking Date:{moment(selectedInvoice.invoice.bookingDate).format("dddd, MMMM Do YYYY, h:mm:ss a")}
                           </li>
                           <li className='list-group-item'>
                           Tax:{selectedInvoice.invoice.tax}
                           </li>
                           <li className='list-group-item'>
                           Total Bill:{selectedInvoice.invoice.totalBill}
                           </li>
                           <li className='list-group-item'>
                           Issued By:{selectedInvoice.invoice.issuedBy}
                           </li>

                           <li className='list-group-item'>
                           Status:{selectedInvoice.status}
                           </li>

                          
                           
                       </ul>
            </div>

        </div>
        }
      
   </React.Fragment>
  )
}

export default ViewInvoice
