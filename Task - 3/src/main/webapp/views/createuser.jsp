<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/api/createuser" method="POST" modelAttribute="user">
	User ID:<form:input path="id"/><br>
	Name:<form:input path="name"/><br>
	Amount:<form:input path="amount"/><br>
	<input type="submit" value="Submit">
</form:form>