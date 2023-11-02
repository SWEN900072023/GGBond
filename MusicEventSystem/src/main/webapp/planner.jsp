<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Planner Dashboard</title>
  <!-- Updated Bootstrap version -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <!-- Updated font-awesome version -->
  <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- External JS file -->
  <script src="path/to/your/javascript/file.js"></script>
  <style>
    .footer {
      position: fixed;
      bottom: 0;
      width: 100%;
      text-align: center;
      padding: 10px;
      background-color: #f8f9fa;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Music Event System -- Planner</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Welcome, ${admin.name}</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/account?method=logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-2">
      <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action" data-url="/venue?method=list">Venue <i class="fa fa-home fa-fw"></i></a>
        <a href="#" class="list-group-item list-group-item-action" data-url="/dormitory?method=list">Event <i class="fa fa-bookmark fa-fw"></i></a>
      </div>
    </div>
    <iframe id="mainContent" style="width: 81%; height: 600px; border: none;" src="/venue?method=list"></iframe>
  </div>
</div>
<div class="footer">
  <p>Unimelb SWEN90007 GGBond</p>
</div>
<script>
  document.addEventListener("DOMContentLoaded", function() {
    $('.list-group-item').on('click', function() {
      var url = $(this).data('url');
      $('#mainContent').attr('src', url);
      $('.list-group-item').removeClass('active');
      $(this).addClass('active');
    });
  });
</script>
</body>
</html>
