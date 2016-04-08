<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:iterator value="#session.user" var="user">

<s:div class="container">
	<s:div class="account">
			<s:a action="UpdatePassword"><s:submit name="change_pw_button" value="Modifica la password"/></s:a>
			<s:a action="MyLocations"><s:submit name="change_pw_button" value="Gestisci i tuoi indirizzi"/></s:a>
			
			
			<h2 class="account-in">Gestione account</h2>
			<s:form name="account_management" action="UpdateUser">
				<s:textfield name="ssn" label="Codice Fiscale" size="60%" maxlength="16"/>
				<s:textfield name="username" label="Username" />
				<s:textfield name="name" label="Nome"/>
				<s:textfield name="surname" label="Cognome"/>
				<sj:datepicker name="dateOfBirth" label="Data di nascita" yearRange="-120:-18" minDate="-120y" maxDate="-18y" 
				displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" readonly="true"/> 
				<s:select name="gender" label="Sesso" list="#{'M':'Maschio','F':'Femmina'}"/>
				
				<s:label value="Contatti:" cssStyle="font-size: 150%;"/>
				<s:textfield name="email" label="Email"/>
				<s:textfield name="telephone" label="Telefono"/>
				<s:textfield name="cellular" label="Cellulare"/>
				<s:submit value="Aggiorna profilo"/>
			</s:form>
		</s:div>
				
	</s:div>

</s:iterator>