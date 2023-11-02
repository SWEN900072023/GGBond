<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Operation Failure</title>
    <!-- Updated Bootstrap version -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container text-center" style="margin-top: 100px;">
    <h1>Operation Failure</h1>
    <p>The data has been changed, please try again.</p>
    <button class="btn btn-primary" onclick="goBack()">Back</button>
</div>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
