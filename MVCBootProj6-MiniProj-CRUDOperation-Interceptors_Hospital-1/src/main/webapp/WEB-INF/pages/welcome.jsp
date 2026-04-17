<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor App</title>

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
        font-size: 22px;
    }

    .hero {
        text-align: center;
        padding: 60px 20px;
    }

    .hero h1 {
        font-size: 40px;
        font-weight: bold;
        color: #0d6efd;
    }

    .card-custom {
        border-radius: 15px;
        transition: 0.3s;
    }

    .card-custom:hover {
        transform: translateY(-8px);
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
    }

    .card-custom img {
        width: 120px;
        height: 120px;
        object-fit: cover;
        margin-top: 20px;
    }

    .footer {
        background-color: #0d6efd;
        color: white;
        text-align: center;
        padding: 15px;
        margin-top: 60px;
    }
</style>

</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <span class="navbar-brand">Doctor Management System</span>
    </div>
</nav>

<!-- Hero Section -->
<div class="hero">
    <h1>Spring Boot MVC Mini Project</h1>
    <p class="text-muted">Manage Doctors Efficiently</p>
</div>

<!-- Card Section -->
<div class="container text-center">
    <div class="row justify-content-center">
        
        <div class="col-md-4">
            <a href="report" style="text-decoration:none;">
                <div class="card card-custom shadow p-3">
                    <img src="images/report.jpg" alt="Report" class="mx-auto">
                    <div class="card-body">
                        <h5 class="card-title">Show Doctor Report</h5>
                    </div>
                </div>
            </a>
        </div>

    </div>
</div>

<!-- Footer -->
<div class="footer">
    @2026 Doctor Management System<br>
    Developed By siba Sethy
</div>

</body>
</html>