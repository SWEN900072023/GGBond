<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Music Event System Dashboard</title>

    <!-- Bootstrap CSS (latest version from CDN) -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome (latest version from CDN) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        .navbar-brand {
            font-size: 26px;
        }
        .navbar-text {
            color: #CCCCCC;
            font-size: 26px;
        }
        .list-group-item {
            cursor: pointer;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">Music Event System -- Dashboard</span>
        <span class="navbar-text"></span>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <span class="navbar-text">Welcome! ${username}</span>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/account?method=logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <c:choose>
                    <c:when test="${roleType eq 'admin'}">
                        <a href="#" class="list-group-item active" onclick="change('/venue?method=list',0)">
                            <i class="fa fa-home fa-fw"></i> Venue
                        </a>
                        <!-- Other admin links go here -->
                    </c:when>
                    <c:when test="${roleType eq 'planner'}">
                        <a href="#" class="list-group-item active" onclick="change('/event?method=list',0)">
                            <i class="fa fa-bookmark fa-fw"></i> Event
                        </a>
                        <!-- Other planner links go here -->
                    </c:when>
                    <c:when test="${roleType eq 'customer'}">
                        <a href="#" class="list-group-item active" onclick="change('/purchase?method=list',0)">
                            <i class="fa fa-bookmark-o fa-fw"></i> Purchase
                        </a>
                        <!-- Other customer links go here -->
                    </c:when>
                </c:choose>
            </div>
        </div>
        <div class="col-md-10">
            <iframe style="width: 100%; height: 800px; border: 0;" src="/home.jsp"></iframe>
        </div>
    </div>
</div>
<div class="footer">
    <!-- Footer content goes here -->
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="application/javascript">
    function change(url, index) {
        $(".list-group-item").removeClass("active");
        $(".list-group-item").eq(index).addClass("active");
        $("iframe").attr("src", url);
    }
</script>
</body>
</html>
