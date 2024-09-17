import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './styles/index.css'

import Home from './pages/Home'
import Login from './pages/Login'
import CreateAcc from './pages/CreateAcc'
import Schedule from './pages/Schedule'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={ <Home/> } />
        <Route path='/login' element={ <Login/> } />
        <Route path='/createAcc' element={ <CreateAcc/> } />
        <Route path='/schedule' element={ <Schedule/>} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
)
