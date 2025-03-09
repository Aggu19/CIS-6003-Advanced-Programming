<!DOCTYPE html>
<html>
<head>
    <title>View Bookings</title>
</head>
<body>
    <h1>Your Bookings</h1>
    <table border="1">
        <tr>
            <th>Booking ID</th>
            <th>Destination</th>
            <th>Fare</th>
        </tr>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>${booking.bookingID}</td>
                <td>${booking.destination}</td>
                <td>${booking.fare}</td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>