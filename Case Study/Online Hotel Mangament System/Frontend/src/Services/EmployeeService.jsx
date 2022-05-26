import axios from "axios"
export class EmployeeService{

    
     static serverURL = `http://localhost:8082`;
    //  Owner
     static adminServerURL=`http://localhost:8084/owner`;

     //Manager
     static managerServerURL=`http://localhost:8084/manager`;


     //Receptionit
     static receptionistServerURL=`http://localhost:8084/receptionist`;


     //Authenticate
     static authenticateServerURL=`http://localhost:8084/authenticate`;

     
    //  static getGroups()
    //  {
    //      let dataURL= `${this.serverURL}/groups`;
    //      return axios.get(dataURL);
    //  }
    //  static getGroup(employee)
    //  {
    //     let groupId=employee.groupId;
    //      let dataURL= `${this.serverURL}/groups/${groupId}`;
    //      return axios.get(dataURL);
         
    //  }

    //Authenticate
    static authenticateRole(authenticate)
     {
        console.log(authenticate);
         let dataURL= `${this.authenticateServerURL}`;
         console.log(dataURL);
         return axios.post(dataURL,authenticate);
     }

     
     //add employee
     static getAllEmployees()
     {
         let dataURL= `${this.serverURL}/getAllEmployees`;
         return axios.get(dataURL);
     }
     //get Employee
     static getEmployee(id)
     {
         let dataURL= `${this.serverURL}/getEmployeeById/${id}`;
         return axios.get(dataURL);
     }
     //Create Employee
     static createEmployee(addEmployee)
     {
        console.log(addEmployee);
         let dataURL= `${this.serverURL}/addEmployee`;
         return axios.post(dataURL,addEmployee);
     }
     //Update Employee
     static updateEmployee(employee)
     {
         let dataURL= `${this.serverURL}/updateEmployee`;
         return axios.put(dataURL,employee);
     }
      //Delate Employee
     static deleteEmployee(id)
     {
         let dataURL= `${this.serverURL}/deleteEmployee/${id}`;
         return axios.delete(dataURL);
     }

    //  Admin Controller

     //Create Admin Depatment
     static createEmployeeAdmin(addEmployee)
     {
         console.log(addEmployee);
         let dataURL= `${this.adminServerURL}/addEmployee`;
         console.log(dataURL);
         return axios.post(dataURL,addEmployee);
     }
     //Update  Admin Depatment
     static updateEmployeeAdmin(employee)
     {
         let dataURL= `${this.adminServerURL}/updateEmployee`;
         return axios.put(dataURL,employee);
     }
      //Delate  Admin Depatment
     static deleteEmployeeAdmin(id)
     {
        console.log(id);
         let dataURL= `${this.adminServerURL}/deleteEmployee/${id}`;
         console.log(dataURL);
         return axios.delete(dataURL);
     }

     //get Report
     static getReport()
     {
         
         let dataURL= `${this.adminServerURL}/getReports`;
         console.log(dataURL);
         console.log(dataURL);
         const report= axios.get(dataURL);
         console.log(report);
         return report;
     }



     //Manager
      
     //Add Room
     static addRoom(addRoom)
     {
         console.log(addRoom);
         let dataURL= `${this.managerServerURL}/addRoom`;
         console.log(dataURL)
         return axios.post(dataURL,addRoom);
     }
     //
     static addRoomType(addRoom)
     {
         console.log(addRoom);
         let dataURL= `${this.managerServerURL}/addRoomType`;
         return axios.post(dataURL,addRoom);
     }

     static getAllRoomType()
     {
         let dataURL= `${this.receptionistServerURL}/getAllRoomTypes`;
         console.log(dataURL);
         return axios.get(dataURL);
     }
     //update room type
     static updateRoomDetails(updateRoomType)
     {
         console.log(updateRoomType);
         let dataURL= `${this.managerServerURL}/updateRoomDetails`;
         console.log(dataURL);
         return axios.put(dataURL,updateRoomType);
     }

     //update room 
     static updateRoom(updateRoom)
     {
         console.log(updateRoom);
         let dataURL= `${this.managerServerURL}/updateRoom`;
         console.log(dataURL);
         return axios.put(dataURL,updateRoom);
     }
     //Get ALL Rooms
     static getAllRooms()
     {
         let dataURL= `${this.receptionistServerURL}/getAllRooms`;
         console.log(dataURL);
         return axios.get(dataURL);
     }


      //Delete room by id
     static deleteRoomById(id)
    {
       console.log(id);
        let dataURL= `${this.managerServerURL}/deleteRoom/${id}`;
        console.log(dataURL)
        console.log(dataURL);
        return axios.delete(dataURL);
    }

     //Receptionist

     //get All Guest
     static getAllGuest()
     {
         let dataURL= `${this.receptionistServerURL}/getAllGuests`;
         console.log(dataURL);
         return axios.get(dataURL);
     }

     //get Guest By Id
     static getGuestById(id)
     {
         let dataURL= `${this.receptionistServerURL}/getGuestById/${id}`;
         console.log(dataURL)
         const guestid=axios.get(dataURL);
         console.log(guestid)
         return  guestid
     }

     //Delete Guest By Id

     static deleteGuestById(id)
     {
        console.log(id);
         let dataURL= `${this.receptionistServerURL}/deleteGuest/${id}`;
         console.log(dataURL)
         console.log(dataURL);
         return axios.delete(dataURL);
     }


     //Create Guest
     static createGuest(addGuest)
     {
        console.log(addGuest);
         let dataURL= `${this.receptionistServerURL}/addGuest`;
         return axios.post(dataURL,addGuest);
     }



     //Update guest
     static updateGuest(guest)
     {

        console.log(guest)
         let dataURL= `${this.receptionistServerURL}/updateGuest`;
         return axios.put(dataURL,guest);
     }

      //Get Booked Room
     static getBookedRooms()
     {
        
         let dataURL= `${this.receptionistServerURL}/getAllRoomsByStatus/BOOKED`;
         console.log(dataURL)
         const data= axios.get(dataURL);
         console.log(data);
         return data;

     }

     //Get Booked Room
     static getAvailableRooms()
     {
        
         let dataURL= `${this.receptionistServerURL}/getAllRoomsByStatus/AVAILABLE`;
         console.log(dataURL)
         const data= axios.get(dataURL);
         console.log(data);
         return data;

     }


     static getRoomById(id)
     {
         let dataURL= `${this.receptionistServerURL}/getRoom/${id}`;
         console.log(dataURL)
         const guestid=axios.get(dataURL);
         console.log(guestid)
         return  guestid
     }

      //Update Employee
      static makeReservation(reservation)
      {
           console.log(reservation)
          let dataURL= `${this.receptionistServerURL}/makeReservation`;
          console.log(dataURL)
          return axios.put(dataURL,reservation);
      }

       //issue bill
      static issueBill(bill)
      {
         console.log(bill);
          let dataURL= `${this.receptionistServerURL}/issueBill`;
          return axios.post(dataURL,bill);
      }



      //Invoice Receptionist
      static getAllInvoices()
     {
         let dataURL= `${this.receptionistServerURL}/getAllInvoices`;
         console.log(dataURL);
         return axios.get(dataURL);
     }


     static deleteInvoiceById(id)
     {
        console.log(id);
         let dataURL= `${this.receptionistServerURL}/deleteInvoiceById/${id}`;
         console.log(dataURL)
         console.log(dataURL);
         return axios.delete(dataURL);
     }


     
     
     static createOrder(amount)
    {
        return axios.post("http://localhost:8085/create_order/" + amount );
    }
     
    static updateInvoiceStatusById(id)
    {
         console.log(id)
       
        return axios.put("http://localhost:8085/updateInvoiceStatusById/"+id);
        
    }



}