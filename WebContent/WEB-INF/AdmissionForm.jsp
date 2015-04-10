<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Form With Spring Mvc Example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/datepicker.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="form-wrap">
					<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h1>
					<spring:form class="form-horizontal" commandName="student1"
						action="/UniversityRegistration/submitAdmissionForm.html"
						method="post">

						</br>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentName">
								Name :</label>
							<div class="col-sm-3">
								<div class="controls">
									<input type="text" class="form-control" name="studentName" />
									<font color="red"><spring:errors path="studentName" /></font>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentHobby">
								Hobby :</label>
							<div class="col-sm-3">
								<div class="controls">
									<input type="text" class="form-control" name="studentHobby" />
									<spring:errors path="studentHobby" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentMobile">
								Mobile Number :</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="studentMobile"
									id="inputWarning"> <font color="red"><spring:errors
										path="studentMobile" /></font>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="studentDOB">
								Birthday :</label>
							<div class="col-sm-3">
								<div class="controls">
									<input id="studentDOB" type="text" class="form-control" name="studentDOB" />
								</div>

								<br />
								<div class="form-actions">
									<button type="submit" class="btn btn-success">Submit</button>
									<button type="button" class="btn"
										onclick="alert('Hello World!')">Cancel</button>
								</div>
							</div>
						</div>


					</spring:form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap.js">
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js">
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js">
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/bootstrap-datepicker.js">
		
	</script>
	
	 <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('#studentDOB').datepicker({
                    format: "dd/mm/yyyy"
                });  
            
            });
        </script>

</body>
</html>

