<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>

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

    .form-container {
        max-width: 500px;
        margin: 60px auto;
        padding: 30px;
        border-radius: 15px;
        background: white;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    .form-title {
        text-align: center;
        color: #0d6efd;
        margin-bottom: 25px;
        font-weight: bold;
    }

    .btn-custom {
        width: 100%;
    }
    

</style>

</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <span class="navbar-brand">Hospital Management System</span>
    </div>
</nav>

<!-- Form Card -->
<div class="form-container">

    <h3 class="form-title">Doctor Registration</h3>

    <frm:form modelAttribute="dvo" action="add" method="post">

        <div class="mb-3">
            <label class="form-label">Doctor Name</label>
            <frm:input path="name" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Doctor Address</label>
            <frm:input path="addr" cssClass="form-control"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Doctor Fees</label>
            <frm:input path="fees" cssClass="form-control"/>
        </div>

        <div class="d-grid gap-2">
            <input type="submit" value="Register" class="btn btn-primary"/>
            <input type="reset" value="Cancel" class="btn btn-secondary"/>
        </div>
        <div class="text-center mt-3">
    <a href="./" class="btn btn-outline-primary">
         Back to Home
    </a>
</div>

    </frm:form>

</div>

</body>
</html>