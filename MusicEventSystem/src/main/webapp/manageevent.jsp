<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- import Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- import font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>MusicEventSystem</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- top search section -->
            <div class="panel panel-default">
                <div class="panel-heading">search</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="/event?method=search" method="post">

                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">Search by name : </label>
                            <input type="text" class="form-control" name="value" placeholder="please enter" maxlength="12" style="width: 130px">
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
										<span style="margin-right: 5px"
                                              class="glyphicon glyphicon-search" aria-hidden="true">
										</span>Confirm
                            </button>
                        </div>
                        <div class="form-group " style="margin-left: 48px">
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">Creat Event</i>
											</span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- list display-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Event</th>
                        <th>Venue</th>
                        <th>Date</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="event">
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.name}</td>
                            <td>${event.venue}</td>
                            <td>${event.date}</td>
                            <td>${event.staP}</td>
                            <td>${event.mosP}</td>
                            <td>${event.seaP}</td>
                            <td>${event.vipP}</td>
                            <td>${event.othP}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-id="${event.id}"
                                            data-name="${event.name}"
                                            data-venue="${event.venue}"
                                            data-date="${event.date}"
                                            data-stap="${event.staP}"
                                            data-mosp="${event.mosP}"
                                            data-seap="${event.vipP}"
                                            data-vipp="${event.vipP}"
                                            data-othp="${event.othP}"
                                            data-version="${event.version}"
                                            data-toggle="modal"
                                            data-target="#updateUserModal">
                                        <i class="fa fa-user-o">edit</i>
                                    </button>

                                    <button type="button" class="btn btn-danger "
                                            data-id="${event.id}" data-toggle="modal"
                                            onclick="" data-target="#delUserModal">
                                        <i class="fa fa-user-times">delete</i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- add -->
                <form method="post" action="/event?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">Creat Event</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Event Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="enter event name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Select Planner</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="planner">
                                                    <c:forEach items="${plannerList}" var="planner">
                                                        <option value="${planner.id}">${planner.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Select Venue</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="venue">
                                                    <c:forEach items="${venueList}" var="venue">
                                                        <option value="${venue.id}">${venue.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">date</label>
                                            <div class="col-sm-9">
                                                <input type="date" required class="form-control" id="date"
                                                       name="date" value="" placeholder="please enter date">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Standing Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="stap"
                                                       name="stap" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Mosh Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="mosp"
                                                       name="mosp" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Seated Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="seap"
                                                       name="seap" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">VIP Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="vipp"
                                                       name="vipp" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Others Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="othp"
                                                       name="othp" value="">
                                            </div>
                                        </div>

                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                                    <button type="submit" class="btn btn-primary">submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- update -->
                <form method="post" action="/event?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="updateUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">Creat Event</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Event ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" required readonly class="form-control" id="id"
                                                       name="id" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Event Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Select Planner</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="planner">
                                                    <c:forEach items="${plannerList}" var="planner">
                                                        <option value="${planner.id}">${planner.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Select Venue</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="venue">
                                                    <c:forEach items="${venueList}" var="venue">
                                                        <option value="${venue.id}">${venue.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">date</label>
                                            <div class="col-sm-9">
                                                <input type="date" required class="form-control" id="date"
                                                       name="date" value="" placeholder="please enter date">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Standing Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="stap"
                                                       name="stap" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Mosh Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="mosp"
                                                       name="mosp" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Seated Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="seap"
                                                       name="seap" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">VIP Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="vipp"
                                                       name="vipp" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Others Price</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="othp"
                                                       name="othp" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label"></label>
                                            <div class="col-sm-9">
                                                <input type="hidden" required class="form-control" id="version"
                                                       name="version" value="">
                                            </div>
                                        </div>

                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                                    <button type="submit" class="btn btn-primary">submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- delete -->
                <form method="post" action="/event?method=delete"
                      class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="delUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">×</button>
                                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <h3 class="col-sm-18 control-label" id="deleteLabel">删除信息</h3>
                                                <input type="hidden" class="form-control" id="tab"
                                                       name="tab" placeholder="" value="dor_admin"> <input
                                                    type="hidden" class="form-control" id="id"
                                                    name="id" placeholder="">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                                    <button type="submit" class="btn btn-danger">delete</button>
                                    <span id="tip"> </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $('#updateUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var name = button.data('name')
        var venue = button.data('venue')
        var date = button.data('date')
        var stap = button.data('stap')
        var mosp = button.data('mosp')
        var seap = button.data('seap')
        var vipp = button.data('vipp')
        var othp = button.data('othp')
        var version = button.data('version')
        var modal = $(this)

        modal.find('.modal-title').text('Edit Event Details')
        modal.find('#id').val(id)
        modal.find('#name').val(name)
        modal.find('#venue').val(venue)
        modal.find('#date').val(date)
        modal.find('#stap').val(stap)
        modal.find('#mosp').val(mosp)
        modal.find('#seap').val(seap)
        modal.find('#vipp').val(vipp)
        modal.find('#othp').val(othp)
        modal.find('#version').val(version)
    })

    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var modal = $(this)
        modal.find('.modal-title').text('Delete Event')
        modal.find('#deleteLabel').text('The event with ID ' + id + '  will be removed!')
        modal.find('#id').val(id)
    })
</script>

</body>

</html>