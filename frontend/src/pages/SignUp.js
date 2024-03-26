import React, { useState } from 'react'


const SignUp = () => {

    const [email, setEmail] = useState("");
    const [userName, setUserName] = useState(""); 
    const [password, setPassword] = useState("");

    const handleSubmit = (event) => {
        
    
        // TODO: Submit the form data to your backend here
      };

    return(
        <form onSubmit={handleSubmit}>
            <div className="credentialContainer">
                <label className="credentialLabel">
                    <span className="credentialTitle">E-Mail:</span>
                    <input
                        type="email"
                        className="credentialInput"
                        placeHolder="Email"
                        value ={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </label>
                <label className="credentialLabel">
                    <span className="credentialTitle">Username:</span> 
                    <input
                        type="username"
                        className="credentialInput"
                        placeHolder="Username"
                        value ={userName}
                        onChange={(e) => setUserName(e.target.value)}
                    />
                </label>
                <label className="credentialLabel">
                    <span className="credentialTitle">Password:</span> 
                    <input
                        type="password"
                        className="credentialInput"
                        placeHolder="Password"
                        value ={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </label>
                <button type="submit" className="submitButton" style={{ marginTop: '8px' }}>Sign Up</button>
            </div>
            
        </form>
    )
};

    
export default SignUp;