<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<html>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<head>
<sj:head/>

<script language="JavaScript">

function enable_text(status)
{
	document.registration.VAT_number.disabled = !status;
}

</script>

</head>

<body>

<s:form name="registration" action="AddUser">
	<s:textfield name="ssn" label="Codice Fiscale" />
	<s:textfield name="username" label="Username" />
	<s:password name="password" label="Password" />
	<s:password name="password2" label="Conferma password"/>
	<s:textfield name="name" label="Nome" />
	<s:textfield name="surname" label="Cognome"/>
	<sj:datepicker name="dateOfBirth" label="Data di nascita" yearRange="-120:-18" zindex="1986"  displayFormat="dd-mm-yy" changeMonth="true" changeYear="true" disabled="true"/> 
	<s:radio name="gender" label="Sesso" list="#{'M':'Uomo','F':'Donna'}"/>
	<s:textfield name="email" label="Email"/>
	<s:textfield name="tel" label="Telefono"/>
	<s:textfield name="cell" label="Cellulare"/>
	<s:textfield name="cap" label="CAP"/>
	<s:textfield name="address" label="Indirizzo"/>
	<s:textfield name="number" label="Civico"/>
	<s:textfield name="city" label="Città" />
	<s:textfield name="province" label="Provincia"/>
	<s:textfield name="state" label="Stato" value="Italia"/>
	<s:checkbox name="seller" label="Venditore" value="aBoolean" onclick="enable_text(this.checked)"/>
	<s:textfield name="VAT_number" label="Partita IVA" disabled="true"/>
	<s:submit value="Invia"/>
</s:form>

</body>

</html>