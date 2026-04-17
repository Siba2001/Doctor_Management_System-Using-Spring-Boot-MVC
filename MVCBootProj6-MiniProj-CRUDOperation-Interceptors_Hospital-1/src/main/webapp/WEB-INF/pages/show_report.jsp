<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Report</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(to right, #e3f2fd, #ffffff);
        font-family: 'Segoe UI', sans-serif;
    }

    .navbar {
        background-color: #0d6efd;
    }

    .navbar-brand {
        color: white !important;
        font-weight: bold;
    }

    .table-container {
        margin-top: 40px;
    }

    .table th {
        background-color: #0d6efd;
        color: white;
        text-align: center;
    }

    .table td {
        text-align: center;
        vertical-align: middle;
    }

    .action-img {
        width: 40px;
        height: 40px;
        transition: 0.3s;
    }

    .action-img:hover {
        transform: scale(1.2);
    }

    .footer-links img {
        width: 40px;
        height: 40px;
    }

    .footer-links a {
        text-decoration: none;
        margin: 0 15px;
        font-size: 20px;
        color: #0d6efd;
        font-weight: bold;
    }

</style>

</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <span class="navbar-brand"> Hospital Management System</span>
    </div>
</nav>

<div class="container table-container">

    <h2 class="text-center text-primary mb-4">Doctor Report Page</h2>

    <c:choose>

        <c:when test="${!empty listvo}">

            <div class="table-responsive">
                <table class="table table-bordered table-hover shadow" >
                    
                    <thead>
                        <tr>
                            <th>Doctor ID</th>
                            <th>Doctor Name</th>
                            <th>Doctor Address</th>
                            <th>Doctor Fees</th>
                            <th>Discount</th>
                            <th>Final Fees</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="vo" items="${listvo}">
                            <tr>
                                <td>${vo.did}</td>
                                <td>${vo.name}</td>
                                <td>${vo.addr}</td>
                                <td>${vo.fees}</td>
                                <td>${vo.discount}</td>
                                <td>${vo.netfees}</td>

                                <td>
                                    <a href="edit?id=${vo.did}">
                                        <img src="images/Edit.png" class="action-img">
                                    </a>

                                    &nbsp;&nbsp;

                                    <a href="delete?id=${vo.did}" 
                                       onclick="return confirm('Are you sure that you want to Delete')">
                                        <img src="images/delete.png" class="action-img">
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <p style="text-align:center">

    <!-- Previous -->
    <c:if test="${doctorData.hasPrevious()}">
        <a href="report?page=${doctorData.number-1}">Previous</a> &nbsp;&nbsp;
    </c:if>

    <!-- First -->
    <c:if test="${!doctorData.first}">
        <a href="report?page=0">First</a> &nbsp;&nbsp;
    </c:if>

    <!-- Page Numbers -->
    <c:forEach var="i" begin="1" end="${doctorData.totalPages}" step="1">
        <a href="report?page=${i-1}">${i}</a> &nbsp;&nbsp;
    </c:forEach>

    <!-- Last -->
    <c:if test="${!doctorData.last}">
        <a href="report?page=${doctorData.totalPages-1}">Last</a> &nbsp;&nbsp;
    </c:if>

    <!-- Next -->
    <c:if test="${doctorData.hasNext()}">
        <a href="report?page=${doctorData.number+1}">Next</a>
    </c:if>

</p>
        </c:when>
        <c:otherwise>
            <h3 class="text-danger text-center">No Record Found</h3>
        </c:otherwise>
    </c:choose>
    <!-- Result Message -->
    <h4 class="text-success text-center mt-4">${resultMsg}</h4>
    <!-- Footer Links -->
    <div class="text-center footer-links mt-4">
        <a href="add">
            Add Doctor
            <img src="images/add.jpg" class="action-img"/>
        </a>
        <a href="./">
            Home
            <img src="images/home.png" class="action-img" />
        </a>
    </div>
</div>
</body>
</html>