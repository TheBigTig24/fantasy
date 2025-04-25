import NavBar from "../components/navbar"
import '../styles/createAcc.css'
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'


const CreateAcc = () => {

    const navigate = useNavigate();

    const [email, setEmail] = useState<string>("");
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [password2, setPassword2] = useState<string>("");

    const handleForm = () => {
        try {
            const errMsg = document.getElementById('error-msg')
            if (errMsg) {
                if (email == "" || username == "" || password == "" || password2 == "") {
                    errMsg.innerHTML = "Empty Field"
                } else if (password.length < 8 ) {
                    errMsg.innerHTML = "Password must be at least 8 characters long"
                } else if (password != password2) {
                    errMsg.innerHTML = "Passwords do not match"
                } else if ( (password.search(/[1234567890]/)) < 0) {
                    errMsg.innerHTML = "Password does not contain a number"
                } else if ( (password.search(/[~!@#$%^&*()_+\-=`[\]{};':",.\/\<>?]/)) < 0) {
                    errMsg.innerHTML = "Password must contain special character"
                } else {
                    errMsg.innerHTML = "";
                    const reqBody = {"email": email, "password": password, "username": username};
                    const uri = "http://localhost:8080/api/v1/auth/signup";
                    fetch(uri, {
                        "method": "POST",
                        "mode": "cors",
                        "headers": {
                            'Content-Type': 'application/json',
                        },
                        "body": JSON.stringify(reqBody)
                    }).then((res) => {
                        if (res.status == 200) {
                            return res.json();
                        } else {
                            errMsg.innerHTML = "Unable to create account.";
                            console.error("Unable to create account.");
                        }
                    }).then((res) => {
                        if (res) {
                            navigate('/home');
                        } else {
                            alert()
                            errMsg.innerHTML = "Incorrect username or password.";
                        }
                    }).catch((error) => {
                        console.log(error)
                    })
                }
            }
        } catch (e) {
            console.error(e);
        }
    }

    return (<>
        <NavBar />
        <div id="container">
            <div id="create-box">
                <h2>Create Account</h2>
                <span>Email</span>
                <input onChange={(e) => setEmail(e.target.value)} placeholder="Enter email" type="email"></input>
                <span>Username</span>
                <input onChange={(e) => setUsername(e.target.value)} placeholder="Enter a username"></input>
                <span>Password</span>
                <input onChange={(e) => setPassword(e.target.value)} placeholder="Enter a password" type="password"></input>
                <span>Re-enter Password</span>
                <input onChange={(e) => setPassword2(e.target.value)} placeholder="Re-enter a password" type="password"></input>
                <button id="sign-in" onClick={handleForm}>Create Account</button>
                <p id="error-msg"></p>
            </div>
        </div>
    </>)
}

export default CreateAcc;