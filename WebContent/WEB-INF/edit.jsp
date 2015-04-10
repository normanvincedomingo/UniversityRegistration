<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Form With Spring Mvc Example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<h1>${headerMessage}</h1>
					<legend>Edit Account</legend>
					<form class="form-horizontal"
						action="/UniversityRegistration/update.html"
						method="post">
						<div class="control-group">
							<label class="control-label">Student's Name :</label>
							<div class="controls">
								<input type="text" name="studentName" value="${studentObject.studentName}" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Student's Hobby :</label>
							<div class="controls">
								<input type="text" name="studentHobby" value="${studentObject.studentHobby}"/>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label">Student's Mobile Number :</label>
							<div class="controls">
								<input type="text" name="studentMobile" value="${studentObject.studentMobile}"  />
							</div>
						</div>
						
						
						<div class="control-group">
							<label class="control-label">Student's DOB :</label>
							<div class="controls">
							<fmt:formatDate value="${studentObject.studentDOB}" type="both" 
      							pattern="dd/mm/yyyy" var="formattedBirthday" />
								<input type="text" name="studentDOB" value="${formattedBirthday}" />
							</div>
						</div>
						
						
						
					<input type="hidden" name="id" value="${studentObject.id}"  />
							

						<br />
						<div class="form-actions">
							<button type="submit" class="btn btn-success">Update</button>
							<button type="button" class="btn" onclick="alert('Hello World!')">Cancel</button>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</div>

</body>
</html>