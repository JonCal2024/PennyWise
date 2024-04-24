import React, { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom'
import axios from 'axios'

const SignUp = () => {

    const [email, setEmail] = useState("");
    const [userName, setUserName] = useState(""); 
    const [password, setPassword] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        const userInfo = {
            email : email,
            username : userName,
            password : password
        }
    
        axios.post('http://localhost:8080/users/register', userInfo)
        .then(function (response) {
          console.log(response.data); 
        })
        .catch(function (error) {
          console.error('Error:', error);
        });       
    };

    return(
        <div className="sign-up-container">
            <div className="title-container">
                <h1 className="sign-up-title">Create your account</h1>
            </div>
            <form className="credential-form" onSubmit={handleSubmit}>
                <div className="credential-container">
                    <label className="credential-label">
                        <input
                            type="email"
                            className="credential-input"
                            placeholder="Email"
                            value ={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </label>
                    <label className="credential-label">
                        <input
                            type="username"
                            className="credential-input"
                            placeholder="Username"
                            value ={userName}
                            onChange={(e) => setUserName(e.target.value)}
                        />
                    </label>
                    <label className="credential-label">
                        <input
                            type="password"
                            className="credential-input"
                            placeholder="Password"
                            value ={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </label>
                    <button type="submit" className="submit-button b">Sign Up</button>
                    <p>
                        Have an account? 
                        <Link className="account-link" to="/">Log In</Link>
                    </p>
                </div>
            </form>
        </div>
    )
};

    
export default SignUp;