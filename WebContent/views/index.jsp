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
</head>

<body>

<s:form action="AddUser">
	<s:textfield name="ssn" label="Codice Fiscale" />
	<s:textfield name="username" label="Username" />
	<s:password name="password" label="Password" />
	<s:textfield name="name" label="Nome" />
	<s:textfield name="surname" label="Cognome"/>
	<sj:datepicker name="dateOfBirth" label="Data di nascita" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true"/>
	<s:radio name="gender" label="Sesso" list="#{'M':'Uomo','F':'Donna'}"/>
	<s:textfield name="email" label="Email"/>
	<s:textfield name="tel" label="Telefono"/>
	<s:textfield name="cell" label="Cellulare"/>
	<s:textfield name="cap" label="CAP"/>
	<s:textfield name="address" label="Indirizzo"/>
	<s:textfield name="number" label="Civico"/>
	<s:textfield name="city" label="Citt�"/>
	<s:textfield name="province" label="Provincia"/>
	<s:textfield name="state" label="Stato" value="Italia"/>
	<s:checkbox name="seller" label="Venditore" value="aBoolean"/>
	<s:textfield name="VAT_number" label="Partita IVA"/>
	<s:submit value="Invia"/>
</s:form>

</body>

</html>