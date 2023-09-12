import React from "react";
import {Route, BrowserRouter, Routes} from 'react-router-dom';
import HomePage from "./HomePage";
import LoginPage from "./LoginPage";


function App() {
    return (
        <BrowserRouter>
            <Routes>
            <Route path="/" component={LoginPage} />
            <Route path="/home" component={HomePage} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;











