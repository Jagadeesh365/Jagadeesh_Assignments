import React from 'react';
import './App.css';
import NavBar from './components/NavBar/NavBar';
import {Route,Routes,Navigate} from 'react-router-dom'

import EmployeeList from './components/Employees/EmployeeList/EmployeeList/EmployeeList';
import AddEmployee from './components/Employees/EmployeeList/AddEmployee/AddEmployee';
import EditEmployee from './components/Employees/EmployeeList/EditEmployee/EditEmployee';
import ViewEmployee from './components/Employees/EmployeeList/ViewEmployee/ViewEmployee';
import Home from './components/Head/Home';
import Receptionist from './components/Receptionist/Receptionist';
import Login from './components/Login/Login';
import Register from './components/Register/Register';
import Admin from './components/Admin/Admin';
import Manager from './components/Manager/Manager';
import Spinner from './components/Spinner/Spinner';
import RoomList from './components/Rooms/RoomList/RoomList';
import AddRoom from './components/Rooms/AddRoom/AddRoom';
import ViewRoom from './components/Rooms/ViewRoom/ViewRoom';
import RoomNav from './components/Rooms/RoomNav/RoomNav';
import AddDepartment from './components/Admin/AddDepartment';
import Report from './components/Admin/Report';
import AddRoomsTypes from './components/Rooms/AddRoomType/AddRoomsTypes';
import ReceptionnistLogin from './components/Receptionist/RceptionnistLogin/ReceptionnistLogin';
import ManagerLogin from './components/Manager/ManagerLogin/ManagerLogin';
import AddGuest from './components/Receptionist/AddGuest/AddGuest';
import EditGuest from './components/Receptionist/EditGuest/EditGuest';
import ViewGuest from './components/Receptionist/ViewGuest/ViewGuest';
import Bills from './components/Receptionist/Bills/Bills';
import GuestList from './components/Receptionist/GuestList/GuestList';
import GetAllTypesRooms from './components/Rooms/AddRoomType/GetAllTypesRooms';
import BookingRoom from './components/Receptionist/BookingRoom/BookingRoom';
import GetBooked from './components/Rooms/GetBooked/GetBooked';
import Reservation from './components/Receptionist/Reservation/Reservation';
import GetAVAILABLE from './components/Rooms/GetAVAILABLE/GetAVAILABLE';
import AdmiNav from './components/Admin/AdminNav';
import AdminLogin from './components/Admin/AdminLogin';
import AdminGuestList from './components/Admin/AdminGuestList';
import AdminEditDepartment from './components/Admin/AdminEditDepartment';
import AdminViewDepartment from './components/Admin/AdminViewDepartment';
import AdminProfile from './components/Admin/AdminProfile';
import { AuthProvider } from './components/Admin/Auth';
import AdminGuestView from './components/Admin/AdminGuestView';
import AdminEditGuest from './components/Admin/AdminEditGuest';
import UpdateRoom from './components/Manager/Rooms/UpdateRoom';
import MangerRoomsNav from './components/Manager/Rooms/MangerRoomsNav';
import ManagerRoomsList from './components/Manager/Rooms/ManagerRoomsList';
import ManagerAddRoom from './components/Manager/Rooms/ManagerAddRoom';
import ManagerGetBookedRooms from './components/Manager/Rooms/ManagerGetBookedRooms';
import ManagerGetAvailableRooms from './components/Manager/Rooms/ManagerGetAvailableRooms';
import ManagerAddRoomType from './components/Manager/Rooms/ManagerAddRoomType';
import ManagerGetRoomsTypes from './components/Manager/Rooms/ManagerGetRoomsTypes';
import ManagerRoomTypeUpdate from './components/Manager/Rooms/ManagerRoomTypeUpdate';
import ManagerUpdateRoom from './components/Manager/Rooms/ManagerUpdateRoom';
import ReseptionistUpdateRoom from './components/Rooms/ReseptionistUpdateRoom';
import AdminRoomList from './components/Admin/RoomsManagementSystem/AdminRoomList';
import AdminViewRoom from './components/Admin/RoomsManagementSystem/AdminViewRoom';

import EditRoom from './components/Rooms/EditRoom/EditRoom';
import AdminEditRoom from './components/Admin/RoomsManagementSystem/AdminEditRoom';
import GetAllInvoice from './components/Receptionist/Invoice/GetAllInvoice';
import ReceptionistInvoice from './components/Receptionist/Invoice/ReceptionistInvoice';


let App=()=> {
  return (
    
    <React.Fragment>
     
      <AuthProvider>
       <Routes>
         
            {/* <Route path={'/'} element={<Navigate to={'/contact/list'}/>}/> */}
            <Route path={'/'} element={<Home/>}/>
            <Route path={'/receptionnistLogin'} element={<ReceptionnistLogin/>}/>
            <Route path={'/managerLogin'} element={<ManagerLogin/>}/>
            <Route path={'/register'} element={<Register/>}/>
            <Route path={'/admin'} element={<Admin/>}/>
            <Route path={'/manager'} element={<Manager/>}/>
           

            {/* Employee  */}
            <Route path={'/contact/list'} element={<EmployeeList/>}/>
            <Route path={'/contact/add'} element={<AddEmployee/>}/>
            <Route path={'/contact/view/:contactId'} element={<ViewEmployee/>}/>
            <Route path={'/contact/edit/:contactId'} element={<EditEmployee/>}/>

            {/* Rooms */}
            <Route path={'/rooms/list'} element={<RoomList/>}/>
            <Route path={'/rooms/add'} element={<AddRoom/>}/>
            <Route path={'/rooms/view/:roomId'} element={<ViewRoom/>}/>
            <Route path={'/rooms/nav'} element={<RoomNav/>}/>
            <Route path={'/rooms/type'} element={<AddRoomsTypes/>}/>
            <Route path={'/rooms/getAllTypes'} element={<GetAllTypesRooms/>}/>
            <Route path={'/getbooked'} element={<GetBooked/>}/>
            <Route path={'/reservation/:roomId'} element={<Reservation/>}/>
            <Route path={'/getavailable'} element={<GetAVAILABLE/>}/>

            {/* Admin */}
            <Route path={'/admin/add'} element={<AddDepartment/>}/>
            <Route path={'/admin/report'} element={<Report/>}/>
            <Route path={'/adminNav'} element={<AdmiNav/>}/>
             <Route path={'/adminLogin'} element={<AdminLogin/>}/>
             <Route path={'/adminGustList'} element={<AdminGuestList/>}/>
             <Route path={'/Admin/editDepartment/:contactId'} element={<AdminEditDepartment/>}/>
             <Route path={'/Admin/ViewDepartment/:contactId'} element={<AdminViewDepartment/>}/>
             <Route path={'/adminRoomList'} element={<AdminRoomList/>}/>
             <Route path={'/adminProfile'} element={<AdminProfile/>}/>
             <Route path={'/adminGuestView/:guestId'} element={<AdminGuestView/>}/>
             <Route path={'/adminGuestEdit/:guestId'} element={<AdminEditGuest/>}/>
             <Route path={'/Admin/roomview/:roomId'} element={<AdminViewRoom/>}/>
             <Route path={'/Admin/editroom/:roomId'} element={<AdminEditRoom/>}/>
            
            {/* Receptionist */}
            <Route path={'/receptionist'} element={<Receptionist/>}/>
            <Route path={'/receptionist/list'} element={<GuestList/>}/>
            <Route path={'/receptionist/addGuest'} element={<AddGuest/>}/>
            <Route path={'/receptionist/editGuest/:guestId'} element={<EditGuest/>}/>
            <Route path={'/receptionist/viewGuest/:guestId'} element={<ViewGuest/>}/>
            <Route path={'/receptionist/bills/:guestId'} element={<Bills/>}/>
            <Route path={'/receptionist/bookingRoom/:guestId'} element={<BookingRoom/>}/>
            <Route path={'/receptionist/updatetroom/:roomId'} element={<ReseptionistUpdateRoom/>}/>
            <Route path={'/receptionist/editroom/:roomId'} element={<EditRoom/>}/>
            <Route path={'/receptionist/updatetroom'} element={<ReseptionistUpdateRoom/>}/>
            <Route path={'/receptionist/getallinvoice'} element={<ReceptionistInvoice/>}/>

            {/* Manager */}
            <Route path={'/manager/update/room/:roomId'} element={<UpdateRoom/>}/>
            <Route path={'/manager/roomsNav'} element={<MangerRoomsNav/>}/>
            <Route path={'/manager/rooms/list'} element={<ManagerRoomsList/>}/>
            <Route path={'/manager/add/room'} element={<ManagerAddRoom/>}/>
            <Route path={'/manager/getbookedrooms'} element={<ManagerGetBookedRooms/>}/>
            <Route path={'/manager/getavailablerooms'} element={<ManagerGetAvailableRooms/>}/>
            <Route path={'/manager/addroomtype'} element={<ManagerAddRoomType/>}/>
            <Route path={'/manager/getroomstpyes'} element={<ManagerGetRoomsTypes/>}/>
            <Route path={'/manager/updateroomtype'} element={<ManagerRoomTypeUpdate/>}/>
            <Route path={'/manager/updatetroom/:roomId'} element={<ManagerUpdateRoom/>}/>

       </Routes>
       </AuthProvider>
    </React.Fragment>
  );
}

export default App;
