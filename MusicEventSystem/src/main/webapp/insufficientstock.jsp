<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
<<<<<<< Updated upstream
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Access Denied</title>

    <!-- Bootstrap CSS (latest version from CDN) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome (latest version from CDN) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        .container {
=======
    <title>Insufficient Stock</title>
    <!-- Import Bootstrap CSS from CDN for better performance -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Import Font Awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        .container-top {
>>>>>>> Stashed changes
            margin-top: 100px;
        }
    </style>
</head>
<body>
<<<<<<< Updated upstream
<div class="container text-center">
    <h1>Access Denied</h1>
    <p>You do not have permission to access this page.</p>
    <button class="btn btn-primary" onclick="goBack()">Back</button>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
=======
<div class="container text-center container-top">
    <h1>Insufficient stock</h1>
    <p>Inventory is zero, or purchases exceed the limit.</p>
    <button class="btn btn-primary" onclick="goBack()">Back</button>
</div>
<!-- Import jQuery -->
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<!-- Then Bootstrap JS -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="application/javascript">
>>>>>>> Stashed changes
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
