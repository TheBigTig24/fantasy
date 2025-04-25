import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './styles/index.css'

import LandingPage from './pages/LandingPage';
import Home from './pages/Home'
import Login from './pages/Login'
import CreateAcc from './pages/CreateAcc'
import Schedule from './pages/Schedule'
import Verification from './pages/Verification';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={ <LandingPage/> } />
        <Route path='/home' element={ <Home/> } />
        <Route path='/login' element={ <Login/> } />
        <Route path='/createAcc' element={ <CreateAcc/> } />
        <Route path='/schedule' element={ <Schedule/> } />
        <Route path='/verification' element={ <Verification/> } />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
)
