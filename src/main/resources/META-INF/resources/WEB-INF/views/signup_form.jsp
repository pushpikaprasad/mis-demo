<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container text-center">
        <div>
            <h1>User Registration - Sign Up</h1>
        </div>
        <!--  <form th:action="@{/register}" th:object="${user}" 
            method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
             
            <div class="form-group row">
                <label class="col-4 col-form-label">Username: </label>
                <div class="col-8">
                    <input type="text" th:field="*{username}" class="form-control"
                            required minlength="2" maxlength="20"/>
                 <p th:if="${userError}">  Username is already taken!!</p>
                
             </div>
                
                
            </div>
             
            <div class="form-group row">
                <label class="col-4 col-form-label">Password: </label>
                <div class="col-8">
                    <input type="password" th:field="*{password}" class="form-control"
                            required minlength="6" maxlength="10"/>
                </div>
            </div>
             
            <div class="form-group row">
                <label class="col-4 col-form-label">First Name: </label>
                <div class="col-8">
                    <input type="text" th:field="*{firstName}" class="form-control"
                            required minlength="2" maxlength="20"/>
                </div>
            </div>
             
            <div class="form-group row">
                <label class="col-4 col-form-label">Last Name: </label>
                <div class="col-8">
                    <input type="text" th:field="*{lastName}" class="form-control"
                            required minlength="2" maxlength="20" />
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-4 col-form-label">E-mail: </label>
                <div class="col-8">
                    <input type="email" th:field="*{email}" class="form-control" required />
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </div>
        </div>
        </form>-->
        
        <form action="/register" method="POST">
        	<table style="with: 50%">
        		<tr>
					<td>UserName</td>
					<td><input type="text" name="username" required minlength="2" maxlength="20" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" required minlength="6" maxlength="10"/></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" required minlength="2" maxlength="20"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" required minlength="2" maxlength="20"/></td>
				</tr>				
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required/></td>
				</tr></table>
			<input type="submit" value="Submit" />
        
        </form>
    </div>
</body>
</html>