// 在 Routes.js 或 AppRoutes.js 中定义路由
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage'; // 导入你的组件

function Routes() {
    return (
        <Router>
            <Routes>
            <Route path="/home" component={HomePage} />
            </Routes>
        </Router>
    );
}

export default Routes;
