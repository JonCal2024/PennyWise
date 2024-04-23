import React from 'react';
import "./App.css";
import ReactDOM from "react-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from './pages/Layout';
import Home from './pages/Home';
import BudgetManager from './pages/BudgetManager';
import SignUp from './pages/SignUp';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="manage" element={<BudgetManager />} />
          <Route path="signup" element={<SignUp/>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
