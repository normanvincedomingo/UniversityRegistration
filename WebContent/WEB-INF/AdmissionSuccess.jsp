<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Success</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
	
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>

					<legend>${headerMessage}</legend>


					<h1>Congratulations!! the Engineering college has processed
						your Application form successfully</h1>

					<h2>Details submitted by you:</h2>

					<table class="table table-striped">
						<tr>
							<td>Student Name :</td>
							<td>${student1.studentName}</td>
						</tr>
						<tr>
							<td>Student Hobby :</td>
							<td>${student1.studentHobby}</td>
						</tr>
						<tr>
							<td>Student Mobile Number :</td>
							<td>${student1.studentMobile}</td>
						</tr>
						<tr>
							<td>Student DOB :</td>
							<td><fmt:formatDate value="${student1.studentDOB}" type="both" 
      							pattern="dd/mm/yyyy"/></td>
						</tr>
						
					</table>
				</fieldset>
			</div>
		</div>
	</div>

<a href="studentList">Click Here to see Student List</a>  

</body>
</html>