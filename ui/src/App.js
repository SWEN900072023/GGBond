import React from "react";
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import HomePage from "./HomePage";
import LoginPage from "./LoginPage";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/home" element={<HomePage />} />
            </Routes>
        </BrowserRouter>
    );
}


export default App;











