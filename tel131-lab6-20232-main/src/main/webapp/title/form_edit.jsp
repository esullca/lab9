<%--
  Created by IntelliJ IDEA.
  User: ALLISON
  Date: 29/10/2023
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="title" type="com.example.clase10crud.beans.Title" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Editar un title</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Editar un title</h1>
    <form method="post" action="<%=request.getContextPath()%>/TitleServlet?action=e">
        <div class="mb-3">
            <input type="hidden" class="form-control" name="titleEmp_no" value="<%=title.getTitleEmp_no()%>">
        </div>
        <div class="mb-3">
            <label>Title</label>
            <input type="text" class="form-control" name="titleTitle" value="<%=title.getTitleTitle()%>">
        </div>
        <div class="mb-3">
            <label>From Date</label>
            <input type="text" class="form-control" name="titleFromDate" value="<%=title.getTitleFromDate()%>">
        </div>
        <div class="mb-3">
            <label>To Date</label>
            <input type="text" class="form-control" name="titleToDate" value="<%=title.getTitleToDate()%>">
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
