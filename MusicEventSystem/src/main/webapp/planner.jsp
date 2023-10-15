<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <!-- import Bootstrap -->
  <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <!-- import font-awesome -->
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="application/javascript">
    function change(url,index){
      $(".list-group-item").removeClass("active");
      $(".list-group-item").eq(index).addClass("active");
      $("iframe").attr("src",url);
    }
  </script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
  <div class="container-fluid">
    <ul class="nav navbar-nav navbar-left">
      <li>
        <a style="font-size: 26px;">Music Event System -- Planner</a>
      </li>
    </ul>
    <span style="color: #CCCCCC;font-size: 26px;position: relative;top: 5px;"></span>
    <ul class="nav navbar-nav navbar-right">
      <li>
        <a>Welcome,${admin.name}</a>
      </li>
      <li>
        <a href="/account?method=logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-2">
        <a href="javascript:void(0)" class="list-group-item" onclick="change('/venue?method=list',0)">
						<span class="" aria-hidden="true">
							<i class="fa fa-home fa-fw"></i>
						</span>Venue
        </a>
        <a href="javascript:void(0)" class="list-group-item" onclick="change('/dormitory?method=list',1)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bookmark fa-fw"></i>
						</span>Event
        </a>

    </div>
    <!--right content-->
    <iframe style="width: 81%; height: 600px; border: 0px;" src="/venue?method=list"></iframe>
  </div>
</div>
<div class="footer">
  <p class="text-center">
    Unimelb SWEN90007 GGBond
  </p>
</div>
</body>
</html>
