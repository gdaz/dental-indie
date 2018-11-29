<!DOCTYPE html >
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <script src="lib/jquery-3.3.1.min.js"></script>
    <script src="lib/datatables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="lib/datatables.min.css"
    "></link>
</head>
<body>
<%--<h2>Message: ${message}</h2>--%>
<h2 id="h2Ajax">Data from server via ajax:</h2>
<table id="patientTable">
    <thead>
    <tr>
        <th>First Name</th>
        <th>First Name</th>
        <th>Age</th>
    </tr>
    </thead>
</table>
<button value="callAllPatient" onclick="callAllPatientCri()">Call All Patient</button>

</body>
<script src="js/index.js"></script>
<%--<script>--%>
<%--var msg = "<%= request.getAttribute("message") %>";--%>
<%--console.log(msg);--%>
<%--</script>--%>
</html>