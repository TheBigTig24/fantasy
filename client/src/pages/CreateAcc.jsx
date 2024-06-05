import NavBar from "../components/navbar"
import '../styles/createAcc.css'
import { useState } from 'react'


const CreateAcc = () => {

    const [email, setEmail] = useState();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [password2, setPassword2] = useState();


    return (<>
        <NavBar />
        <div id="container">
            <div id="login-box">
                <h2>Create Account</h2>
                <input onChange={(e) => setEmail(e.target.value)} placeholder="Enter email"></input>
                <input onChange={(e) => setUsername(e.target.value)} placeholder="Enter a username"></input>
                <input onChange={(e) => setPassword(e.target.value)} placeholder="Enter a password"></input>
                <input onChange={(e) => setPassword2(e.target.value)} placeholder="Re-enter a password"></input>
                <button id="sign-in">Create Account</button>
            </div>
        </div>
    </>)
}

export default CreateAcc;