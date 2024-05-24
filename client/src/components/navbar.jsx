import '../styles/navbar.css'
import Dropdown from '../assets/navbar.png'

const NavBar = () => {

    const Login = () => {
        alert("your mom")
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
                <li>Home</li>
                <li>Schedule</li>
                <li>Stats</li>
            </ul>
            <button id='login' onClick={Login} >Login</button>
            <button className='dropdown' onClick={toggleMenuOn} >
                <img src={Dropdown}></img>
            </button>
            <div className='menu' id='menu'>
                <button className='exit-dropdown' id='exit-dropdown' onClick={toggleMenuOff}></button>
                <ul>
                    <li><button className='dd-btn'>Home</button></li>
                    <li><button className='dd-btn'>Schedule</button></li>
                    <li><button className='dd-btn'>Stats</button></li>
                </ul>
                <button id='dd-login'>Login</button>
            </div>
        </div>
    </>)
}

export default NavBar;