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
                                            data-sectionVip="${venue.sectionVip}"
                                            data-sectionOth="${venue.sectionOth}"
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
                                            <label for="user_id" class="col-sm-3 control-label">Venue Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="venuename"
                                                       name="venuename" placeholder="please enter venuename">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Standing Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="stan"
                                                       name="stan" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Mosh Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="mosn"
                                                       name="mosn" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Seated Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="sean"
                                                       name="sean" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">VIP Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="vipn"
                                                       name="vipn" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Others Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="othn"
                                                       name="othn" value="">
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
                                            <label for="user_id" class="col-sm-3 control-label">Venue ID</label>
                                            <div class="col-sm-9">
                                                <input type="text" required readonly class="form-control" id="id"
                                                       name="id"  value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Venue Name</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="venuename"
                                                       name="venuename"  value="" placeholder="please enter venuename">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Standing Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="stan"
                                                       name="stan" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Mosh Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="mosn"
                                                       name="mosn" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Seated Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="sean"
                                                       name="sean" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">VIP Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="vipn"
                                                       name="vipn" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Others Amount</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="othn"
                                                       name="othn" value="">
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
                                    <h4 class="modal-title" id="myModalLabel"></h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <h3 class="col-sm-18 control-label" id="deleteLabel"></h3>
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
        var stan = button.data('sectionsta')
        var mosn = button.data('sectionmos')
        var sean = button.data('sectionsea')
        var vipn = button.data('sectionvip')
        var othn = button.data('sectionoth')
        var modal = $(this)

        modal.find('.modal-title').text('Edit Venue Details')
        modal.find('#id').val(id)
        modal.find('#venuename').val(name)
        modal.find('#stan').val(stan)
        modal.find('#mosn').val(mosn)
        modal.find('#sean').val(sean)
        modal.find('#vipn').val(vipn)
        modal.find('#othn').val(othn)
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