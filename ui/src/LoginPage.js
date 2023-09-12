import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // 使用 useNavigate 替代 useHistory
import { login } from './api'; // 你的 API 函数
import './LoginPage.css';

function LoginPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await login(username, password);
            if (response.ok) {
                navigate('/home');
            } else {
                console.log('登录失败，请检查用户名和密码');
            }
        } catch (error) {
            console.error('登录出错', error);
        }
    };

    return (
        <div>
            <h1>Login Page</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" value={username} onChange={(e) => setUsername(e.target.value)} />
                </div>
                <div>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div>
                    <button type="submit">Login</button>
                </div>
            </form>
        </div>
    );
}
export default LoginPage;



