<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>LoginPage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Import Bootstrap 4 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Import Font Awesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <div class="row">
        <form class="form-horizontal col-md-6 offset-md-3" id="login_form" action="<%= request.getContextPath()%>/account?method=login" method="post">
            <h3 class="form-title text-center">Login</h3>
            <div class="form-group">
                <i class="fa fa-user fa-lg"></i>
                <span class="text-danger" style="font-size: 13px;">${usernameError}</span>
                <input class="form-control" required placeholder="Input username." type="text" name="username"/>
            </div>
            <div class="form-group">
                <i class="fa fa-lock fa-lg"></i>
                <span class="text-danger" style="font-size: 13px;">${passwordError}</span>
                <input class="form-control" required placeholder="Input password." type="password" name="password"/>
            </div>
            <div class="form-group">
                <label class="radio-inline">
                    <input type="radio" name="loginType" checked value="admin"> admin
                </label>
                <label class="radio-inline">
                    <input type="radio" name="loginType" value="planner"> planner
                </label>
                <label class="radio-inline">
                    <input type="radio" name="loginType" value="customer"> customer
                </label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success" name="submit">submit</button>
                <button type="reset" class="btn btn-success" name="submit">reset</button>
            </div>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('input[type=radio][name=loginType]').change(function() {
            $('#loginType').val(this.value);
        });
    });
</script>
</body>
</html>
