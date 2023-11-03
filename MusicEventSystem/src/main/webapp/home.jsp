<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<<<<<<< Updated upstream
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MusicEventSystem</title>
    <!-- Bootstrap CSS (latest version from CDN) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome (latest version from CDN) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <!-- Custom Styles -->
    <style>
        .form-group {
            margin-bottom: 1rem;
        }
        .modal-body {
            max-height: calc(100vh - 210px);
            overflow-y: auto;
=======
    <meta charset="utf-8" />
    <title>Welcome</title>
    <!-- Import Bootstrap CSS from CDN for better performance -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Import Font Awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Styles can be moved to an external stylesheet if necessary -->
    <style>
        .container-margin-top {
            margin-top: 100px;
>>>>>>> Stashed changes
        }
    </style>
</head>
<body>
<<<<<<< Updated upstream
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- Top Search Section -->
            <div class="card mb-3">
                <div class="card-header">Edit Event</div>
                <div class="card-body">
                    <form class="form-inline">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModal">
                            <i class="fa fa-user-plus"></i> Cancel
                        </button>
                    </form>
                </div>
            </div>
            <!-- List Display -->
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Event</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Price</th>
                        <th>Price</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="event">
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.date}</td>
                            <td>${event.date}</td>
                            <td>${event.date}</td>
                            <td>${event.date}</td>
                            <td>${event.date}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary"
                                            data-id="${event.id}"
                                            data-username="${event.name}" data-toggle="modal" data-target="#updateUserModal">
                                        <i class="fa fa-user-o"></i> Edit
                                    </button>
                                    <button type="button" class="btn btn-danger"
                                            data-id="${event.id}" data-toggle="modal"
                                            data-target="#delUserModal">
                                        <i class="fa fa-user-times"></i> Delete
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

<!-- Add Event Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addUserModalLabel">Create Event</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Add Event Form -->
                <form method="post" action="/event?method=save" class="form-horizontal" id="addEventForm">
                    <!-- Form Fields -->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" form="addEventForm" class="btn btn-primary">Submit</button>
            </div>
        </div>
    </div>
</div>

<!-- Update Event Modal -->
<div class="modal fade" id="updateUserModal" tabindex="-1" role="dialog" aria-labelledby="updateUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateUserModalLabel">Edit Event</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Update Event Form -->
                <form method="post" action="/event?method=update" class="form-horizontal" id="updateEventForm">
                    <!-- Form Fields -->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" form="updateEventForm" class="btn btn-primary">Confirm</button>
            </div>
        </div>
    </div>
</div>

<!-- Delete Event Modal -->
<div class="modal fade" id="delUserModal" tabindex="-1" role="dialog" aria-labelledby="delUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="delUserModalLabel">Delete Event</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Delete Event Form -->
                <form method="post" action="/event?method=delete" class="form-horizontal" id="deleteEventForm">
                    <!-- Form Fields -->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="submit" form="deleteEventForm" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $('#updateUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var username = button.data('username');
        var modal = $(this);
        modal.find('.modal-title').text('Edit Event Details');
        modal.find('#id').val(id);
        modal.find('#username').val(username);
    });

    $('#delUserModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var modal = $(this);
        modal.find('.modal-title').text('Delete Event');
        modal.find('#id').val(id);
    });
</script>
=======
<div class="container text-center container-margin-top">
    <h1>Welcome</h1>
</div>

<!-- Import jQuery -->
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<!-- Then Bootstrap JS -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- If you need bootstrap-select, ensure you include it after jQuery and Bootstrap -->
<script src="./bootstrap/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
>>>>>>> Stashed changes
</body>
</html>
