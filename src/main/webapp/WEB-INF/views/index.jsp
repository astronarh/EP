<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>EP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css" />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="col-xs-2">
    <form id="start" action="<c:url value='/start' />" method='POST'>
        <label for="postValue">Post Value</label>
        <input type="text" class="form-control" id="postValue" placeholder="Post Value" name="postValue" >
        <button type="button" class="btn btn-primary" onclick="start()">Start</button>
    </form>
    <table>
        <tr>
            <td valign="top">
                <table id="tasks" class="table table-striped table-bordered" >
                    <caption>Tasks</caption>
                    <thead>
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td></td>
                    </tr>
                    </thead>
                </table>
            </td>
            <td>
                <hr style="height: 200px;/*высота*/ width: 1px;/*толщина*/">
            </td>
            <td valign="top">
                <table id="result" class="table table-striped table-bordered" >
                    <caption>Result</caption>
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>complete</td>
                            <td>postValue</td>
                            <td>randomData</td>
                            <td>sum</td>
                            <td>taskCharacteristic</td>
                        </tr>
                    </thead>
                </table>
            </td>
        </tr>
    </table>
</div>
<script>
    var tasks;
    var result;
    /*function start() {
        $.ajax({
            url: "/start?postValue=" + $( "#postValue" ).val(),
            type: "POST",
            dataType: "json",
            success : function(list) {
            }
        });
        setTimeout( function () {
            tasks.api().ajax.reload();
        }, 500);
    }*/

    function start() {
        if ($( "#postValue" ).val() === "") return;
        var postValue = {
            postValue : $( "#postValue" ).val()
        };
        $.ajax({
            url: "/start",
            type: "POST",
            dataType: "json",
            contentType: 'application/json',
            data: JSON.stringify(postValue)
        });
        setTimeout( function () {
            tasks.api().ajax.reload();
        }, 500);
    }

    function completetask(id) {
        $.ajax({
            url: "/completetask?id=" + id,
            type: "POST",
            dataType: "json",
            success : function(list) {
            }
        });
        setTimeout( function () {
            tasks.api().ajax.reload();
            result.api().ajax.reload();
        }, 500);
    }

    $(document).ready(function() {
        tasks = $( '#tasks' ).dataTable( {
            "dom": '<"top"i>rt<"bottom"flp><"clear">',
            "sAjaxDataProp": "",
            "sAjaxSource": "/tasks",
            "order": [[ 0, "asc" ]],
            "bFilter": false,
            "lengthChange": false,
            "columns": [
                { "data": "id"},
                { "data": "taskCharacteristic" },
                {
                    "targets": 0,
                    "data": "id",
                    "render": function (data) {
                        return  '<div height=5><button type="button" class="btn btn-primary btn-sm" onclick="completetask(' + data + ')">Completetask</button></div>';
                    }
                }
            ]
        } );

        result = $( '#result' ).dataTable( {
            "dom": '<"top"i>rt<"bottom"flp><"clear">',
            "sAjaxDataProp": "",
            "sAjaxSource": "/result",
            "order": [[ 0, "asc" ]],
            "bFilter": false,
            "lengthChange": false,
            "columns": [
                { "data": "id"},
                { "data": "complete" },
                { "data": "postValue"},
                { "data": "randomData" },
                { "data": "sum"},
                { "data": "taskCharacteristic" }
            ]
        } );
    });

</script>
</body>
</html>