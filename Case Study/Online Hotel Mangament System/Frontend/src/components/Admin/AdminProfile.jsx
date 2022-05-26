import React from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from './Auth'

const AdminProfile = () => {
    const auth=useAuth()
    const navigate =useNavigate()

    const handleLogout=()=>

    {
        auth.logout()
        navigate("/")
}
  return (
    <div>
          <pre>{JSON.stringify(auth.user.employee.name)}</pre>
        
         <button onClick={handleLogout}>Logout</button>
    </div>
  )
}

export default AdminProfile
