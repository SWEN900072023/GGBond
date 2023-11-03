<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<<<<<<< Updated upstream
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Server Busy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function change(url, index) {
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src", url);
        }

        function goBack() {
            window.history.back();
=======
    <meta charset="utf-8" />
    <title>Server Busy</title>
    <!-- Import Bootstrap CSS from CDN for better performance -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Import Font Awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        .container-top {
            margin-top: 100px;
>>>>>>> Stashed changes
        }
    </style>
</head>
<body>
<div class="container text-center container-top">
    <h1>Server Busy</h1>
    <p>Please try again later.</p>
    <button class="btn btn-primary" onclick="goBack()" aria-label="Go back to previous page">Back</button>
</div>
<<<<<<< Updated upstream
=======
<!-- Import jQuery -->
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<!-- Then Bootstrap JS -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function goBack() {
        window.history.back();
    }
</script>
>>>>>>> Stashed changes
</body>
</html>
