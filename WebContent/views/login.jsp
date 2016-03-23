<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="hasActionErrors()">
	<div style="color: red">
		<s:actionerror />
	</div>
</s:if>
<div class="container">
	<div class="account">
		<s:form action="Login">
			<h2 class="account-in">Account</h2>
			<s:textfield cssClass="word" name="username" label="Username" />
			<s:password cssClass="word" name="password" label="Password" />
			<s:submit value="Invia" />
		</s:form>
	</div>
</div>