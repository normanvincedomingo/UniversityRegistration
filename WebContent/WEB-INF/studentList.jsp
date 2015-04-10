<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Form With Spring Mvc Example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/univReg.js"></script>
    
</head>
<body>
	<center>
		<h2>List of students enrolled</h2>
	</center>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Hobby</th>
				<th>Mobile</th>
				<th>Birthday</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td><c:out value="${student.studentName}" /></td>
					<td><c:out value="${student.studentHobby}" /></td>
					<td><c:out value="${student.studentMobile}" /></td>
					<td><fmt:formatDate value="${student.studentDOB}" type="both"
							pattern="dd/mm/yyyy" /></td>
					<td><a class="viewDialog" href='#' value="<c:out value="${student.studentName}"/>"
													   hobby="<c:out value="${student.studentHobby}"/>
													   ">Edit</a></td>
					<td><a href="delete?id=${student.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="position: absolute; left: 1200px; top: 500px;">
		<a href="/UniversityRegistration/admissionForm.html"> <img
			border="0" alt="Add"
			src="<%=request.getContextPath()%>/resources/images/add.jpg"
			width="70" height="70">
		</a>
	</div>
	
	<div id="myDialog" style="display: none" title="Basic dialog">
    	<span id="responsecode"></span> 
	</div>
	
	<div id="innerDialog" style="display: none" title="Inner dialog">
    	<span id="innerResponsecode"></span> 
	</div>
	
	
</body>
</html>