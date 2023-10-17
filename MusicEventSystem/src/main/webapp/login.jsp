<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>LoginPage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Import Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Import font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        if (window.top !== window.self) { 
            window.top.location = window.self.location;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="form row" style="height: 300px;">
        <form class="form-horizontal col-md-offset-3" id="login_form" action="<%= request.getContextPath()%>/account?method=login" method="post">
            <h3 class="form-title">Login</h3>
            <div class="col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <span style="color: red; font-size: 13px; margin-left: -17px;">${usernameError}</span>
                    <input class="form-control required" required placeholder="Input username." type="text" name="username"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <span style="color: red; font-size: 13px; margin-left: -17px;">${passwordError}</span>
                    <input class="form-control required" required placeholder="Input password." type="password" name="password"/>
                </div>
                <div class="form-group">
                    <label class="radio-inline">
                        <input type="radio" name="loginType" checked value="admin" class="radio-inline"> admin
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="loginType" value="planner" class="radio-inline"> planner
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="loginType" value="customer" class="radio-inline"> customer
                    </label>
                </div>
                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-success pull-left" name="submit">submit</button>
                    <button type="reset" class="btn btn-success pull-right" name="submit">reset</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('input[type=radio][name=loginType]').change(function() {
            $('#loginType').val(this.value);
        });
    });
</script>
</body>
</html>
