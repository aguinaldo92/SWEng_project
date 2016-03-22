<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:form action="Login">
	<s:textfield name="username" label="Username"/>
	<s:password name="password" label="Password"/> 
	<s:submit value="Invia"/>
</s:form>