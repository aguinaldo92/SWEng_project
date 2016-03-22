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
			<div>
				<span class="name-in">Username</span>
				<s:textfield name="username" />
			</div>
			<s:password cssClass="word" name="password" label="Password" />
			<s:submit value="Invia" />
		</s:form>
	</div>
</div>