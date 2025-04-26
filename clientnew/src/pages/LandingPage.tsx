import "../styles/landingPage.css";
import NavBar from "../components/navbar";
import { useNavigate } from "react-router-dom";
import React from 'react';

function LandingPage() {

    const navigate = useNavigate();

    function navLogin() {
        navigate("/login");
    }

    function navCreateAcc() {
        navigate("/createAcc");
    }

    return(
        <>
            <NavBar />
            <div className="landing-page-container">
                <div className="landing-page-left">

                </div>
                <div className="landing-page-right">
                    <h1>Spring Gooners</h1>
                    <div>
                        <button onClick={() => navLogin()} >Login</button>
                        <button onClick={() => navCreateAcc()} >Sign Up</button>
                    </div>
                </div>
            </div>
        </>
    )
}

export default LandingPage;