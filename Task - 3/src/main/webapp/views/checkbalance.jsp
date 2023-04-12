<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/api/checkbalance" method="POST" modelAttribute="user">
	Check Balance<br><br>
	User ID <br><form:input path="id"/><br>
	<input type="submit" value="Submit">
</form:form>