import '../styles/navbar.css';
import Dropdown from '../assets/navbar.png';
import { useNavigate } from 'react-router-dom';

const NavBar = () => {

    const navigate = useNavigate();

    const Login = () => {
        navigate("/login");
    }

    const navHome = () => {
        navigate("/");
    }

    const navSchedule = () => {
        navigate("/schedule");
    }

    const toggleMenuOn = () => {
        const menu = document.getElementById('menu');
        menu.style.animation = "menuToggleOn .4s forwards";
    }

    const toggleMenuOff = () => {
        const menu = document.getElementById('menu');
        menu.style.animation = "menuToggleOff .4s forwards";
    }

    return(<>
        <div className='container'>
            <h2>Name</h2>
            <ul className='navbar-links'>
                <li><button className='navLinks' onClick={navHome}>Home</button></li>
                <li><button className='navLinks' onClick={navSchedule}>Schedule</button></li>
                <li><button className='navLinks'>Stats</button></li>
            </ul>
            <button id='login' onClick={Login} >Login</button>
            <button className='dropdown' onClick={toggleMenuOn} >
                <img src={Dropdown}></img>
            </button>
            <div className='menu' id='menu'>
                <button className='exit-dropdown' id='exit-dropdown' onClick={toggleMenuOff}></button>
                <ul>
                    <li><button className='dd-btn' onClick={navHome}>Home</button></li>
                    <li><button className='dd-btn' onClick={navSchedule}>Schedule</button></li>
                    <li><button className='dd-btn'>Stats</button></li>
                </ul>
                <button id='dd-login'>Login</button>
            </div>
        </div>
    </>)
};

export default NavBar;