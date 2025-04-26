import '../styles/login.css'
import NavBar from '../components/navbar';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const Login = () => {

    const navigate = useNavigate();

    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const navCreate = () => {
        navigate('/createAcc');
    };

    const handleSubmit = () => {
        try {
            const uri: string = "http://localhost:8080/api/v1/auth/login";
            if (username === "" || password === "") {
                const errMsg: HTMLElement | null = document.querySelector('#err-msg');
                if (errMsg) {
                    errMsg.innerHTML = "Missing username or password";
                }
            } else {
                const errMsg: HTMLElement | null = document.querySelector('#err-msg');
                if (errMsg) {
                    errMsg.innerHTML = "";
                }
                const reqJson = { "email": username, "password": password };
                fetch(uri, {
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(reqJson)
                }).then((res) => {
                    if (res.status == 200) {
                        return res.json();
                    } else {
                        const errMsg: HTMLElement | null = document.querySelector('#err-msg');
                        if (errMsg) {
                            errMsg.innerHTML = "Unable to log in."
                        }
                    }
                }).then((res) => {
                    localStorage.setItem('token', res.token);
                    alert('Successful Login!');
                    navigate('/home');
                }).catch((e) => {
                    console.error(e);
                })
            }
        } catch (e) {
            console.error(e);
        }
    };

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
                <p id='err-msg'>asdf</p>
                <button id='sign-in' onClick={handleSubmit}>Log In</button>
                <p id='before-here'>Don't have an account? Create one <a onClick={navCreate} id='here'>here</a></p>
            </div>
        </div>
    </>)
}

export default Login;