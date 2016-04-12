<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:div class="container">
	
	<s:div class="account">
			<h2 class="account-in">Gestione account - Dati della residenza</h2>
			
			<s:form name="manageresidence" action="UpdateResidence">
				<s:textfield name="address" value="%{#session.user.residenceAddress}" label="Indirizzo" size="80%" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="number" value="%{#session.user.residenceNumber}" label="Civico" labelSeparator=" "/>
				<s:textfield name="cap" value="%{#session.user.residenceCap}" label="CAP" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="city" value="%{#session.user.residenceCity}" label="Città" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="province" value="%{#session.user.residenceProvince}" label="Provincia" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="state" value="%{#session.user.residenceState}" label="Stato" labelSeparator=" " requiredLabel="true"/>
				<s:submit value="Aggiorna residenza"/>
			</s:form>
		</s:div>
</s:div>