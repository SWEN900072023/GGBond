import React from 'react';
import './App.css'; 

function App(props) {
  return (
    <div>
      <h1 className="title">Welcome to Register !</h1>
      <form action="/hello-servlet" method="post" className="form">
        <div>
          <label htmlFor="username">Username</label>
          <input type="text" id="username" name="username" />
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input type="password" id="password" name="password" />
        </div>
        <div>
          <input type="submit" value="Register" id="reg_btn" />
        </div>
      </form>
    </div>
  );
}

export default App;

