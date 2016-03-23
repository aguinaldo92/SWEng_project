<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>


<s:a action="registrationUser" cssClass="btn btn-primary" type="tiles" >Registrazione</s:a>
<a href="login" type="tiles">Login</a>