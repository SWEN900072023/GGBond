function App(props) {
  return (
    <div>
        <head>
            <title>register</title>
        </head>
        <body>
            <h1>Welcome to register!</h1>
            <br/>
            <form action="/hello-servlet" method="post"> {/* 注意 action 和 method 属性 */}
                <table>
                    <tbody>
                        <tr>
                            <td>username</td>
                            <td>
                                <input name="username" type="text" id="username" />
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td>password</td>
                            <td>
                                <input name="password" type="password" id="password" />
                                <br />
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input value="register" type="submit" id="reg_btn" /><br />
            </form>
        </body>
    </div>
  );
}

export default App;
