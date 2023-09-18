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
                    <form role="form" class="form-inline" action="/venue?method=search" method="post">
                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">Search by venue name : </label>
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
											<i class="fa fa-user-plus">Creat Venue</i>
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
                        <th>Venue Name</th>
                        <th>Standing</th>
                        <th>Mosh</th>
                        <th>Seated</th>
                        <th>Vip</th>
                        <th>OtherSection</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="venue">
                        <tr>
                            <td>${venue.id}</td>
                            <td>${venue.name}</td>
                            <td>${venue.sectionSta}</td>
                            <td>${venue.sectionMos}</td>
                            <td>${venue.sectionSea}</td>
                            <td>${venue.sectionVip}</td>
                            <td>${venue.sectionOth}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-id="${venue.id}"
                                            data-name="${venue.name}"
                                            data-sectionSta="${venue.sectionSta}"
                                            data-sectionMos="${venue.sectionMos}"
                                            data-sectionSea="${venue.sectionSea}"
                                            data-sectionSea="${venue.sectionVip}"
                                            data-sectionSea="${venue.sectionOth}"
                                            data-toggle="modal"
                                            data-target="#updateUserModal">
                                        <i class="fa fa-user-o">edit</i>
                                    </button>

                                    <button type="button" class="btn btn-danger "
                                            data-id="${venue.id}" data-toggle="modal"
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
                <form method="post" action="/venue?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">Creat Venue</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">username</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="username"
                                                       name="username" placeholder="please enter username">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">password</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="password"
                                                       name="password" value="" placeholder="please enter password">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="please enter name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">telephone</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="please enter telephone">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                                    <button type="submit" class="btn btn-primary">confirm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- update -->
                <form method="post" action="/venue?method=update" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="updateUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">Venue Details</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" readonly required class="form-control" id="id"
                                                       name="id">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">username</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="username"
                                                       name="username" placeholder="please enter username">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">password</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="password"
                                                       name="password" value="" placeholder="please enter password">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="name" value="" placeholder="please enter name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">telephone</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="telephone"
                                                       name="telephone" value="" placeholder="please enter telephone">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">cancel</button>
                                    <button type="submit" class="btn btn-primary">confirm</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- delete -->
                <form method="post" action="/venue?method=delete"
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
        var username = button.data('username')
        var password = button.data('password')
        var name = button.data('name')
        var telephone = button.data('telephone')
        var modal = $(this)

        modal.find('.modal-title').text('Edit Venue Details')
        modal.find('#id').val(id)
        modal.find('#username').val(username)
        modal.find('#password').val(password)
        modal.find('#name').val(name)
        modal.find('#telephone').val(telephone)
    })

    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var modal = $(this)
        modal.find('.modal-title').text('Delete Venue')
        modal.find('#deleteLabel').text('The venue with ID ' + id + '  will be removed!')
        modal.find('#id').val(id)
    })
</script>

</body>

</html>