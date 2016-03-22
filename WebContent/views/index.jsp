<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>


<s:a action="registrationUser" cssClass="btn btn-primary" >Registrazione</s:a>
<a href="views/login.jsp">Login</a>