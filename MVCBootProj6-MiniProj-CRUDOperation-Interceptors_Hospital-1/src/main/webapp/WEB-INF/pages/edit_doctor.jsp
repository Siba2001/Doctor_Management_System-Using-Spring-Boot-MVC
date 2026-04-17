<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Doctor</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(to right, #e3f2fd, #ffffff);
        font-family: 'Segoe UI', sans-serif;
    }
    body {
    background: linear-gradient(135deg, #89f7fe, #66a6ff);
}

    .form-container {
        max-width: 500px;
        margin: 60px auto;
        padding: 30px;
        border-radius: 15px;
        background: white;
        box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    }

    .title {
        text-align: center;
        color: #0d6efd;
        margin-bottom: 20px;
    }
</style>

</head>
<body>

<div class="form-container">

    <h3 class="title">Edit Doctor Details</h3>

    <frm:form modelAttribute="dvo">

        <div class="mb-3">
            <label class="form-label">Doctor Id</label>
            <frm:input path="did" cssClass="form-control" readonly="true"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Doctor Name</label>
            <frm:input path="name" cssClass="form-control"/>
            <frm:errors path="name" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Doctor Address</label>
            <frm:input path="addr" cssClass="form-control"/>
            <frm:errors path="addr" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Doctor Fees</label>
            <frm:input path="fees" cssClass="form-control"/>
            <frm:errors path="fees" cssClass="text-danger"/>
        </div>

        <div class="d-grid gap-2">
            <input type="submit" value="Update Doctor" class="btn btn-primary"/>
            <input type="reset" value="Cancel" class="btn btn-secondary"/>
        </div>

    </frm:form>

    <div class="text-center mt-3">
        <a href="./" class="btn btn-outline-primary">Back to Home</a>
    </div>

</div>

</body>
</html>