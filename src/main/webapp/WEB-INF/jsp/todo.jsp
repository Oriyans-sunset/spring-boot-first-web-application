<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<body>
		<div class="container">
			<h1>ADD TODO PAGE for ${name }</h1>
			
			<form:form method="post" modelAttribute="todo">
			<form:hidden path="id"/>
				<div class="form-group">
					<form:label path="desc">Description</form:label>
					<form:input path="desc" type="text" class="form-control" required="required"/>
					<form:errors path="desc" cssClass="text-warning"></form:errors>
					<br/>
					<form:label path="targetDate">Target Date</form:label>
					<form:input path="targetDate" type="text" class="form-control" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"></form:errors>
				</div>
				
				<button class="btn btn-primary" type="submit">Add</button>
			</form:form>	
	    </div>

<%@ include file="common/footer.jspf" %>