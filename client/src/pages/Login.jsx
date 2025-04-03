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
                
                <div className='da_inputs'>
                    <p>Username</p>
                    <input onChange={(e) => setUsername(e.target.value)} placeholder="username" ></input>
                    <p id='password'>Password</p>
                    <input onChange={(e) => setPassword(e.target.value)} placeholder="password" type='password'></input>
                </div>
                
                <button id='sign-in'>Log In</button>
                <p id='before-here'>Don't have an account? Create one <a onClick={navCreate} id='here'>here</a></p>
            </div>
        </div>
    </>)
}

export default Login;