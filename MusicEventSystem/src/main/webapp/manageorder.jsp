<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Management</title>
    <!-- Updated Bootstrap and jQuery versions -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10">
            <!-- Search Section -->
            <div class="panel panel-default">
                <div class="panel-heading">Search Orders</div>
                <div class="panel-body">
                    <form class="form-inline" action="/manageorder?method=search" method="post">
                        <div class="form-group mr-3">
                            <label for="value">Search by Order ID: </label>
                            <input type="text" class="form-control" name="value" placeholder="Enter Order ID" maxlength="12">
                        </div>
                        <button type="submit" class="btn btn-info">
                            <i class="fas fa-search mr-1"></i>Search
                        </button>
                    </form>
                </div>
            </div>

            <!-- Order List Display -->
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Event Name</th>
                        <th>Quantity</th>
                        <th>Creation Time</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.eventName}</td>
                            <td>${order.num}</td>
                            <td>${order.time}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-danger" data-id="${order.id}" data-toggle="modal" data-target="#delUserModal">
                                        <i class="fas fa-trash-alt"></i> Delete
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Delete Confirmation Modal -->
<div class="modal fade" id="delUserModal" tabindex="-1" role="dialog" aria-labelledby="deleteOrderModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteOrderModalLabel">Delete Order</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="deleteConfirmationText">Are you sure you want to delete this order?</p>
                <form method="post" action="/order?method=delete" class="form-horizontal" role="form">
                    <input type="hidden" class="form-control" id="id" name="id">
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var orderId = button.data('id');
        var modal = $(this);
        modal.find('#deleteConfirmationText').text('Are you sure you want to delete the order with ID ' + orderId + '?');
        modal.find('#id').val(orderId);
    });
</script>
</body>
</html>
