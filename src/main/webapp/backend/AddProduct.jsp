    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="static/backend/img/favicon.png" rel="icon">
  <link href="static/backend/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="../static/backend/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../static/backend/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="../static/backend/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="../static/backend/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="../static/backend/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="../static/backend/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="../static/backend/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
<link href="../static/backend/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Home Decor</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

   

    <nav class="header-nav ms-auto">
      
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="AdminDashboardServlet">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>Product</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="AddProductServlet">
              <i class="bi bi-circle"></i><span>Add</span>
            </a>
          </li>
          <li>
            <a href="ProductListServlet">
              <i class="bi bi-circle"></i><span>Products</span>
            </a>
          </li>
         
          
        </ul>
      </li><!-- End Components Nav -->


      <li class="nav-heading">Pages</li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="users-profile.html">
          <i class="bi bi-person"></i>
          <span>Profile</span>
        </a>
      </li><!-- End Profile Page Nav -->

     
      

     

    </ul>

  </aside><!-- End Sidebar-->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Add Product</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="AdminDashboardServlet">Dashboard</a></li>
          <li class="breadcrumb-item active">Add Product</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section dashboard">
      <div class="card">
            <div class="card-body">
              <h5 class="card-title">Add Product</h5>
<c:if test="${not empty error}">
	        <p style="color: red;">${success}</p>
	    </c:if>
              <!-- Floating Labels Form -->
               <form action="${pageContext.request.contextPath}/backend/AddProductServlet"  method="post"  class="row g-3" enctype="multipart/form-data">
                <div class="col-md-12">
                  <div class="form-floating">
                    <input type="text" class="form-control" id="floatingName" name="name" placeholder="Product Name" required>
                    <label for="floatingName">Product Name</label>
                  </div>
                </div>
               
                <div class="col-md-6">
                  <div class="form-floating">
                    <input type="number" class="form-control" name="price" id="price" placeholder="Price" required>
                    <label for="price">Price</label>
                  </div>
                </div>
               
                <div class="col-md-6">
                  <div class="col-md-12">
                    <div class="form-floating">
                      <input type="file" class="form-control" name ="image" id="floatingImage" placeholder="Image" required>
                      <label for="floatingImage">Image</label>
                    </div>
                  </div>
                </div>
                
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form><!-- End floating Labels Form -->

            </div>
          </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
    <div class="copyright">
      &copy; Copyright <strong><span></span></strong>. All Rights Reserved
    </div>
    <div class="credits">
    
<!--       Designed by <a href="https://bootstrapmade.com/"></a>
 -->    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="../static/backend/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="../static/backend/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="../static/backend/vendor/chart.js/chart.umd.js"></script>
  <script src="../static/backend/vendor/echarts/echarts.min.js"></script>
  <script src="../static/backend/vendor/quill/quill.js"></script>
  <script src="../static/backend/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="../static/backend/vendor/tinymce/tinymce.min.js"></script>
  <script src="../static/backend/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="../static/backend/js/main.js"></script>

</body>

</html>