<%--
  Created by IntelliJ IDEA.
  User: ALLISON
  Date: 29/10/2023
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Crear un nuevo Title</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Crear un nuevo title</h1>
    <form method="POST" action="<%=request.getContextPath()%>/TitleServlet">
        <div class="mb-3">
            <label>Title emp_no</label>
            <input type="text" class="form-control" name="titleEmp_no">
        </div>
        <div class="mb-3">
            <label>Title</label>
            <input type="text" class="form-control" name="titleTitle">
        </div>
        <div class="mb-3">
            <label>From Date</label>
            <input type="text" class="form-control" name="titleFromDate">
        </div>
        <div class="mb-3">
            <label>To Date</label>
            <input type="text" class="form-control" name="titleToDate">
        </div>
        <a href="<%=request.getContextPath()%>/TitleServlet" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>

