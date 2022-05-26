import React, { useState } from 'react'
import Header from '../../Header'
import {Link, useNavigate } from 'react-router-dom'
import axios from 'axios'

function Register() {

    const [fullName, setName] = useState("")
    const [image, setImage] = useState("")
    const [email, setEmail] = useState("")
    const [mobileNumber, setMobileNumber] = useState("")
    const [about, setAbout] = useState("")
    const [dob, setDob] = useState("")
    const [gender, setGender] = useState("")
    const [password, setPassword] = useState("")
    const [address, setAddress] = useState([])
    const navigate = useNavigate()

  

    const onChangeGender = (e) => {
        setGender(e.target.value)
    }

    const onChangeAddress = (e) => {
        setAddress({ ...address, [e.target.name]: e.target.value });
    }


    const SignUp = async(e) => {
        e.preventDefault();

        let data = {fullName, image, email, mobileNumber, about, dob, gender, password, address }
        console.warn(data)
        await axios.post("http://localhost:8999/profile/add-customer",data)
        
        alert("Welcome Customer You are registered successfully !! we are redirecting you to login page")
        navigate("/login")

    }

    return (
        <>
            <Header />
            
            <form className='registerpage'>
            <h5>Customer Register</h5>
                <input 
                    type="text" 
                    value={fullName} 
                    onChange={(e) => setName(e.target.value)} 
                    className='form-control' 
                    placeholder='full name' 
                /><br />
                <input 
                    type="text" 
                    value={image} 
                    onChange={(e) => setImage(e.target.value)} 
                    className='form-control' 
                    placeholder='Image Url'  
                /><br />
                <input 
                    type="email" 
                    value={email} 
                    onChange={(e) => setEmail(e.target.value)} 
                    className='form-control' 
                    placeholder='email' 
                /><br />
                <input 
                    type="text"
                    value={mobileNumber} 
                    onChange={(e) => setMobileNumber(e.target.value)} 
                    className='form-control' 
                    placeholder='mobile number' 
                /><br />
                <textarea 
                    value={about} 
                    onChange={(e) => setAbout(e.target.value)} 
                    className='form-control' 
                    placeholder='About yourself....' 
                /><br />
                <input 
                    type="text" 
                    value={dob} 
                    onChange={(e) => setDob(e.target.value)} 
                    className='form-control' 
                    placeholder='Date of Birth' 
                /><br />
                <label>Gender</label>
                <div onChange={onChangeGender} >
                    <input 
                        type="radio" 
                        value="Male" 
                        name="gender" 
                    /> Male 
                    <input 
                        type="radio" 
                        value="Female" 
                        name="gender"
                    /> Female
                    <input 
                        type="radio" 
                        value="Other" 
                        name="gender" 
                    /> Other
                </div><br />
                <input 
                    type="password" 
                    value={password} 
                    onChange={(e) => setPassword(e.target.value)} 
                    className='form-control' 
                    placeholder='password' 
                /><br />
                <input 
                    type="text" 
                    value={address.houseNumber} 
                    name='houseNumber' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='house number' 
                /><br />
                <input 
                    type="text" 
                    value={address.streetName} 
                    name='streetName' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='street name' 
                /><br />
                <input 
                    type="text" 
                    value={address.colonyName} 
                    name='colonyName' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='colony name' 
                /><br />
                <input 
                    type="text" 
                    value={address.city} 
                    name='city' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='city' 
                /><br />
                <input 
                    type="text" 
                    value={address.state} 
                    name='state' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='state' 
                /><br />
                <input 
                    type="text" 
                    value={address.pincode} 
                    name='pincode' 
                    onChange={onChangeAddress} 
                    className='form-control' 
                    placeholder='pincode' 
                /><br />
                <button 
                    onClick={SignUp} 
                    className='sign-btn'
                >Sign up</button><br/>
                <small>Already have account? </small><Link to='/login'>Sign in</Link>
            </form>
        </>
    )
}

export default Register