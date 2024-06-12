import NavBar from "../components/navbar"
import '../styles/createAcc.css'
import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'


const CreateAcc = () => {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [password2, setPassword2] = useState("");

    const [currTime, setCurrTime] = useState(new Date().toISOString());
    const timeInterval = setInterval(getTime, 1000)
    function getTime() {
        setCurrTime(new Date().toISOString());
    }

    const handleForm = () => {
        const errMsg = document.getElementById('error-msg')
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
            const reqBody = {"email": email, "password": password, "username": username, "createdAt": currTime};

            fetch("/api/users/addOne", {
                "method": "PUT",
                "mode": "cors",
                "headers": {
                    'Content-Type': 'application/json',
                    'x-api-key': 'BigTig',
                },
                "body": JSON.stringify(reqBody)
            }).then((res) => {
                return res.json()
            }).then((res) => {
                if (res.msg == "User has been added successfully") {
                    navigate('/')
                }
            }).catch((error) => {
                console.log(error)
            })
        }
    }

    return (<>
        <NavBar />
        <div id="container">
            <div id="login-box">
                <h2>Create Account</h2>
                <input onChange={(e) => setEmail(e.target.value)} placeholder="Enter email" type="email"></input>
                <input onChange={(e) => setUsername(e.target.value)} placeholder="Enter a username"></input>
                <input onChange={(e) => setPassword(e.target.value)} placeholder="Enter a password"></input>
                <input onChange={(e) => setPassword2(e.target.value)} placeholder="Re-enter a password"></input>
                <button id="sign-in" onClick={handleForm}>Create Account</button>
                <p id="error-msg"></p>
            </div>
        </div>
    </>)
}

export default CreateAcc;