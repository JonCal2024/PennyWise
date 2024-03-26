import {React, useState} from 'react'
import { useNavigate } from 'react-router-dom'

const Home = () => {
    const[formData, setFromData] = useState({
        email: "",
        password: ""
    });

    const handleChange = (e) => {
        setFromData({...formData, [e.target.name]: e.target.value})
    }


    return(
        <div className="homeContainer">
            <div className="titleContainer">
                <h1>Welcome to Pennywise</h1>  
            </div>
            <h2>Login to get started</h2>
            <form>
                <div className="credentialContainer">
                    <label className="credentialLabel">
                        <span className="credentialTitle">E-Mail:</span>
                        <input
                            type="text"
                            className="credentialInput"
                            name="email"
                            id="email"
                            placeholder="E-Mail"
                            value={formData.email}
                            onChange = {handleChange}
                            required
                        />
                    </label>
                    <label className="credentialLabel">
                        <span className="credentialTitle">Password:</span>
                        <input
                            type="text"
                            className="credentialInput"
                            name="password"
                            id="password"
                            placeholder="Password"
                            value={formData.password}
                            onChange = {handleChange}
                            required
                        />
                    </label>
                </div>
            </form>
        </div>
    )
}

export default Home;