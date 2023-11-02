<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MusicEventSystem</title>
    <!-- Updated Bootstrap and jQuery versions -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10">
            <!-- Search Section -->
            <div class="panel panel-default">
                <div class="panel-heading">Search</div>
                <div class="panel-body">
                    <form class="form-inline" action="/event?method=search" method="post">
                        <div class="form-group mr-3">
                            <label for="value">Search by name: </label>
                            <input type="text" class="form-control" name="value" placeholder="Please enter" maxlength="12">
                        </div>
                        <button type="submit" class="btn btn-info mr-3">
                            <i class="fas fa-search mr-1"></i>Confirm
                        </button>
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addUserModal">
                            <i class="fas fa-user-plus mr-1"></i>Create Event
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
                        <th>Venue</th>
                        <th>Date</th>
                        <th>Price</th>
                        <th>Operation</th>
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
                                    <button type="button" class="btn btn-default" data-id="${event.id}" data-name="${event.name}" data-venue="${event.venue}" data-date="${event.date}" data-stap="${event.staP}" data-mosp="${event.mosP}" data-seap="${event.vipP}" data-vipp="${event.vipP}" data-othp="${event.othP}" data-version="${event.version}" data-toggle="modal" data-target="#updateUserModal">
                                        <i class="fas fa-user-edit"></i> Edit
                                    </button>
                                    <button type="button" class="btn btn-danger" data-id="${event.id}" data-toggle="modal" data-target="#delUserModal">
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

<!-- Modals (Add, Update, Delete) -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        $('#updateUserModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget)
            var modal = $(this)
            modal.find('.modal-title').text('Edit Event Details')
            modal.find('#id').val(button.data('id'))
            modal.find('#name').val(button.data('name'))
            // ... Set other form fields
        });

        $('#delUserModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget)
            var modal = $(this)
            modal.find('.modal-title').text('Delete Event')
            modal.find('#deleteLabel').text('Are you sure you want to delete the event with ID ' + button.data('id') + '?')
            modal.find('#id').val(button.data('id'))
        });
    });
</script>
</body>
</html>
