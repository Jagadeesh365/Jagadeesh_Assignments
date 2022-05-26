import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { EmployeeService } from "../../../../src/Services/EmployeeService";
import Spinner from "../../../components/Spinner/Spinner";
import Logo from '../../../assets/img/logo.png'
let GetAllInvoice = (props) => {
  let [query, setQurey] = useState({
    text: "",
  });

  let [state, setState] = useState({
    loading: false,
    invoices: [],
    filterinvoices: [],
    errorMessage: "",
  });
  useEffect(() => {
    (async function () {
      try {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllInvoices();
        console.log(response.data)
        setState({
          ...state,
          loading: false,
          invoices: response.data,
          filterinvoices: response.data,
        });
        console.log(response.data);
      } catch (error) {
        setState({
          ...state,
          loading: false,
          errorMessage: error.message,
        });
      }
    })();
  }, []);

  const changeStatus = (id) => {
    
     EmployeeService.updateInvoiceStatusById(id);
   
  }

  let clickDelete = async (invoceId) => {
    try {
      let response = await EmployeeService.deleteInvoiceById(invoceId);
      if (response) {
        setState({ ...state, loading: true });
        let response = await EmployeeService.getAllInvoices();
        setState({
          ...state,
          loading: false,
          invoices: response.data,
          filterinvoices: response.data,
        });
      }
    } catch (error) {
      setState({
        ...state,
        loading: false,
        errorMessage: error.message,
      });
    }
  };

  const paymentStart=(amount,invoiceId)=>
  {
    console.log(amount);
    console.log(invoiceId);

    EmployeeService.createOrder(amount).then((response)=> {
      console.log(response.data);
      if(response.data.status == "created"){
          
          let options={
              key:'rzp_test_88Fw6jzdPSitWF',
              amount:response.data.amount,
              currency:'INR',
              name: "GMK HOTEL",
              description: "Online Payment",
              image: {Logo},
              order_id:response.data.id,
              handler: function(response){
                  console.log(response);
                  console.log("payment successful");

                  
                changeStatus(invoiceId);
                  
              },
              prefill: {
                  name: "",
                  email: "",
                  contact: "",
              },

              notes: {
                  address: "Case Study With Jagadeesh",
              },

              theme: {
                  color: "#3399cc",
              },

          };


          let rzp=new window.Razorpay(options);

          rzp.on('payment.failed', function (response){
              console.log(response);
             
              alert("Oops payment failed");
          });

          rzp.open();
      }
      // console.log(response.data.status);
  }).catch((err) => {
      
      console.log(err);
      alert("something went wrong");
  });

  }
  //serach employee
  let searchEmployee = (event) => {
    setQurey({ ...query, text: event.target.value });
    let theinvoices = state.invoices.filter((invoice) => {
      return invoice.name
        .toLowerCase()
        .includes(event.target.value.toLowerCase());
    });
    setState({
      ...state,
      filterinvoices: theinvoices,
    });
  };
  let clickInvoice=(rinvoice)=>{
      props.sendInvoice(rinvoice);
  };

  let { loading, invoices, errorMessage, filterinvoices } = state;
  return (
    <React.Fragment>
      {/* <pre>{JSON.stringify(state.invoices)}</pre> */}
       <table className="table table-hover text-center table-striped animated zoomIn delay-2s">
              <thead className="bg-dark text-white">
                     <tr>
                         <th>InvoiceId</th>
                         <th>GuestId</th>
                         <th>Guest Mobile</th>
                         <th>Booked Room Type</th>
                         <th>Room Price</th>
                         <th>No Of Nights</th>
                         <th>Total Bill</th>
                         <th>Status</th>
                         <th>Update</th>
                         <th>Delete</th>
                         <th>Payment</th>
                     </tr>
              </thead>
              <tbody>
                                
                {loading ? (<Spinner /> ) : (
                        <React.Fragment>
                            {
                                filterinvoices.length > 0 &&
                                filterinvoices.map(Rinvoice=>{
                                    return(
                                        <tr key={Rinvoice.id} onClick={()=>clickInvoice(Rinvoice)}>
                                             <td>{Rinvoice.id}</td>
                                            <td>{Rinvoice.invoice.guestId}</td>
                                            <td>{Rinvoice.invoice.guestMobile}</td>
                                            <td>{Rinvoice.invoice.bookedRoomType}</td>
                                            <td>{Rinvoice.invoice.roomPricePerNight}</td>
                                            <td>{Rinvoice.invoice.nights}</td>
                                            <td>{Rinvoice.invoice.totalBill}</td>
                                            <td>{Rinvoice.status}</td>
                                            <td><Link to={`/contact/view/${Rinvoice.id}`}>
                                                  <i className="fa fa-pen" />
                                                 </Link>
                                            </td>
                                            <td><button className="fa fa-trash"onClick={() => clickDelete(Rinvoice.id)}/>
                                            </td>

                                            <td><button className="fa fa-money-bill"onClick={() => paymentStart(Rinvoice.invoice.totalBill,Rinvoice.id)}/>
                                            </td>

                                           

                                        </tr>
                                    )
                                })
                            }
                        </React.Fragment>       
                    )}
                        
                  
              </tbody>
       </table>
    </React.Fragment>
  );
};

export default GetAllInvoice
