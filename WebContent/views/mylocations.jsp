<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:div class="container">
	<s:div class="account">
			<s:a action="mylocations"><s:submit name="change_pw_button" value="Aggiungi un indirizzo di spedizione"/></s:a>
			<h2 class="account-in">Dati della residenza</h2>
			
			<s:form name="registration" action="AddLocation">			
				<s:textfield name="name" label="Nome indirizzo"/>
				<s:textfield name="address" label="Indirizzo" size="80%"/>
				<s:textfield name="number" label="Civico"/>
				<s:textfield name="cap" label="CAP"/>
				<s:textfield name="city" label="Città" />
				<s:textfield name="province" label="Provincia"/>
				<s:textfield name="state" label="Stato" value="Italia"/>
				<s:submit value="Aggiungi indirizzo"/>
			</s:form>
		</s:div>
	</s:div>