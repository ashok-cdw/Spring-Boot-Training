<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/api/moneytransfer" method="POST" modelAttribute="transaction">
	Amount Transfer<br><br>
	Credit ID:<form:input path="crid"/><br>
	Debit ID:<form:input path="drid"/><br>
	Amount:<form:input path="amount"/><br>
	<input type="submit" value="Submit">
</form:form>