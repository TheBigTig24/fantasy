import '../styles/login.css'
import NavBar from '../components/navbar';
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Login = () => {

    const navigate = useNavigate();

    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const navCreate = () => {
        navigate('/createAcc')
    }

    return (<>
        <NavBar />
        <div id='container'>
            <div id='login-box'>
                <h2 id='sign-header'>Sign In</h2>
                <input onChange={(e) => setUsername(e.target.value)} placeholder="username" ></input>
                <input onChange={(e) => setPassword(e.target.value)} placeholder="password" ></input>
                <button id='sign-in'>Log In</button>
                <p>Don't have an account? Create one <a onClick={navCreate}>here</a></p>
            </div>
        </div>
    </>)
}

export default Login;