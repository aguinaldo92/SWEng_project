<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:div class="container">
	<s:div class="account">		
			<h2 class="account-in">Gestione account - Modifica password</h2>
			<s:form name="password_management" action="UpdatePassword">
				<s:password name="old_password" label="Vecchia password" size="60%" requiredLabel="true" labelSeparator=" "/>
				<s:password name="password" label="Nuova password" requiredLabel="true" labelSeparator=" "/>
				<s:password name="confirm_password" label="Conferma password" requiredLabel="true" labelSeparator=" "/>
				<s:submit value="Aggiorna password" name="submit_name"/>
			</s:form>
	</s:div>	
</s:div>