<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>


<a href="views/registration_user.jsp">Registrazione</a>
<a href="views/login.jsp">Login</a>