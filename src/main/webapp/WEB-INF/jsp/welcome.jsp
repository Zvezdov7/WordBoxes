<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="semantic/semantic.min.css">
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
    <script src="semantic/semantic.min.js"></script>
    <style type="text/css">
        body {
            background-color: #DADADA;
        }
    </style>

</head>
<body>
<div class="ui raised very padded container segment">
    <h1 class="ui center aligned header">Список представителей</h1>
    <div class="customersList"></div>
</div>






<script src="http://cdn.jsdelivr.net/npm/sortablejs@1.6.1/Sortable.min.js"></script>
<script type="text/javascript">
    $('.menu .item').tab();
</script>
<script src="customer.js"></script>
<script>

    $(document).ready(function() {
        $.getJSON("http://localhost:8080/customers", function(data) {
            for (var i = 0, len = data.length; i < len; i++) {
                $(".customersList").append("<p>" + data[i].id + data[i].firstName +  " " + data[i].lastName + "</p>" +
                        "<button class='ui secondary small button delete' value='" + data[i].id + "'>Delete</button>");

            }
        });

    });
    $(document).on('click', '.delete', function(event) {
        event.preventDefault();
        /* Act on the event */
        $.ajax({
            url: 'http://localhost:8080/customers/' + $(this).attr('value'),
            type: 'DELETE',
            success: function(result) {
                alert("Yeah");
            }
        });
    });

</script>
</body>
</html>