<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MusicEventSystem</title>
    <!-- Import Bootstrap 4 and jQuery 3 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Import Font Awesome 5 -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10">
            <!-- Search Section -->
            <div class="panel panel-default">
                <div class="panel-heading">Search</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="/customer?method=search" method="post">
                        <div class="form-group">
                            <label for="name">Method: </label>
                            <select name="key" class="form-control">
                                <option value="username">Customer Username</option>
                                <option value="name">Customer Name</option>
                                <option value="telephone">Telephone</option>
                            </select>
                        </div>
                        <div class="form-group ml-3">
                            <label for="value">Value: </label>
                            <input type="text" class="form-control" name="value" placeholder="Please enter" maxlength="12">
                        </div>
                        <div class="form-group ml-3">
                            <button type="submit" class="btn btn-info">
                                <i class="fas fa-search mr-1"></i>Confirm
                            </button>
                        </div>
                        <div class="form-group ml-3">
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
                                <i class="fas fa-user-plus mr-1"></i>Create Customer
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <!-- List Display -->
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Name</th>
                        <th>Telephone</th>
                        <th>Operation</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="customer">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.username}</td>
                            <td>${customer.password}</td>
                            <td>${customer.name}</td>
                            <td>${customer.telephone}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" data-id="${customer.id}" data-username="${customer.username}" data-password="${customer.password}" data-name="${customer.name}" data-telephone="${customer.telephone}" data-toggle="modal" data-target="#updateUserModal">
                                        <i class="fas fa-user-edit"></i> Edit
                                    </button>
                                    <button type="button" class="btn btn-danger" data-id="${customer.id}" data-toggle="modal" data-target="#delUserModal">
                                        <i class="fas fa-user-times"></i> Delete
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

<!-- Add User Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addUserModalLabel">Create Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/customer?method=save" class="form-horizontal" role="form">
                    <!-- Form Fields Here -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Update User Modal -->
<!-- Similar structure as Add User Modal, just with different IDs and data binding -->

<!-- Delete User Modal -->
<!-- Similar structure as Add User Modal, just with different IDs and data binding -->

<script>
    $(document).ready(function() {
        $('#updateUserModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget)
            var id = button.data('id')
            var username = button.data('username')
            var password = button.data('password')
            var name = button.data('name')
            var telephone = button.data('telephone')
            var modal = $(this)

            modal.find('.modal-title').text('Edit Customer Details')
            modal.find('#id').val(id)
            modal.find('#username').val(username)
            modal.find('#password').val(password)
            modal.find('#name').val(name)
            modal.find('#telephone').val(telephone)
        });

        $('#delUserModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget)
            var id = button.data('id')
            var modal = $(this)
            modal.find('.modal-title').text('Delete Customer')
            modal.find('#deleteLabel').text('The customer with ID ' + id + '  will be removed!')
            modal.find('#id').val(id)
        });
    });
</script>

</body>
</html>
