<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="hasActionErrors()">
	<div style="color: red">
		<s:actionerror />
	</div>
</s:if>

<s:div class="container">
	<s:div class="account">
			<h2 class="account-in">Account</h2>
			<s:form action="Login">
			<s:textfield name="username" label="Username"/>
			<s:password name="password" label="Password"/>
			<s:submit value="Invia" />
			</s:form>
	</s:div>
</s:div>