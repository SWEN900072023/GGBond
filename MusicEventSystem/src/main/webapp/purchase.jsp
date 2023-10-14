<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- import Bootstrap -->
    <link rel="stylesheet" href="./bootstrap/bootstrap-select/dist/css/bootstrap-select.min.css">
    <script src="./assets/js/vendor/vendor.min.js"></script>
    <script src="./bootstrap/bootstrap-select/dist/js/bootstrap-select.min.js"></script>

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
                        <th>Standing Left</th>
                        <th>Mosh Left</th>
                        <th>Seated Left</th>
                        <th>VIP Left</th>
                        <th>Other Left</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="ticket">
                        <tr>
                            <td>${ticket.id}</td>
                            <td>${ticket.eventName}</td>
                            <td>${ticket.venueName}</td>
                            <td>${ticket.staN}</td>
                            <td>${ticket.mosN}</td>
                            <td>${ticket.seaN}</td>
                            <td>${ticket.vipN}</td>
                            <td>${ticket.othN}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default "
                                            data-customerid="${id}"
                                            data-ticketid="${ticket.id}"
                                            data-eventid="${ticket.eventId}"
                                            data-eventname="${ticket.eventName}"
                                            data-staP="${ticket.staP}"
                                            data-mosP="${ticket.mosP}"
                                            data-seaP="${ticket.seaP}"
                                            data-vipP="${ticket.vipP}"
                                            data-othP="${ticket.othP}"
                                            data-staN="${ticket.staN}"
                                            data-mosN="${ticket.mosN}"
                                            data-seaN="${ticket.seaN}"
                                            data-vipN="${ticket.vipN}"
                                            data-othN="${ticket.othN}"
                                            data-toggle="modal"
                                            data-target="#ticketDetailModal">
                                        BUY
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- update -->
                <form method="post" action="/purchase?method=save" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="ticketDetailModal" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">Ticket Details</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">

                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="customerid"
                                                       name="customerid" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="ticketid"
                                                       name="ticketid" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="eventid"
                                                       name="eventid" value="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="eventname"
                                                       name="eventname">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="price"
                                                       name="price">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Select Section</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="section">
                                                    <option id="sta" value="sta">Standing</option>
                                                    <option id="mos" value="mos">Mosh</option>
                                                    <option id="sea" value="sea">Seated</option>
                                                    <option id="vip" value="vip">VIP</option>
                                                    <option id="oth" value="oth">Other</option>
                                                </select>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label for="user_id" class="col-sm-3 control-label">Number</label>
                                            <div class="col-sm-9">
                                                <input type="number" required class="form-control" id="number"
                                                       name="number" placeholder="please enter number">
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
            </div>
        </div>
    </div>
</div>

<script>
    $('#ticketDetailModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var customerid = button.data('customerid')
        var ticketid = button.data('ticketid')
        var eventid = button.data('eventid')
        var eventname = button.data('eventname')
        var price = '888'
        var stap = button.data('stap')
        var mosp = button.data('mosp')
        var seap = button.data('seap')
        var vipp = button.data('vipp')
        var othp = button.data('othp')
        var modal = $(this)

        modal.find('.modal-title').text('Event Details')
        modal.find('#customerid').val(customerid)
        modal.find('#ticketid').val(ticketid)
        modal.find('#eventid').val(eventid)
        modal.find('#eventname').val(eventname)
        modal.find('#price').val(price)

        modal.find('#section').val(stap,mosp,seap)
    })
</script>

</body>

</html>