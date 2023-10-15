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
    <title>Order Management</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- top search section -->
            <div class="panel panel-default">
                <div class="panel-heading">Search Orders</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="/manageorder?method=search" method="post">
                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">Search by Order ID : </label>
                            <input type="text" class="form-control" name="value" placeholder="Enter Order ID" maxlength="12" style="width: 130px">
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
                                <span style="margin-right: 5px" class="glyphicon glyphicon-search" aria-hidden="true"></span>Search
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- list display -->
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Event Name</th>
                        <th>Quantity</th>
                        <th>Creation Time</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="order">
                        <tr>
                            <td>${order.id}</td>
<%--                            <td>${order.customerId}</td>--%>
                            <td>${order.eventName}</td>
                            <td>${order.num}</td>
                            <td>${order.time}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-danger "
                                            data-id="${order.id}" data-toggle="modal"
                                            onclick="" data-target="#delUserModal">
                                        <i class="fa fa-user-times">delete</i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- delete -->
                <form method="post" action="/order?method=delete"
                      class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="delUserModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">×</button>
                                    <h4 class="modal-title" id="myModalLabel">order message</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <h3 class="col-sm-18 control-label" id="deleteLabel">delete</h3>
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
    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var id = button.data('id')
        var modal = $(this)
        modal.find('.modal-title').text('Delete Order')
        modal.find('#deleteLabel').text('The order with ID ' + id + '  will be removed!')
        modal.find('#id').val(id)
    })
</script>

</body>
</html>
