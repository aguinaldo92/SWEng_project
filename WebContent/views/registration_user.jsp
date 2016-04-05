<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<head>

<script lang="JavaScript">

function enable_vatnumber(status)
{
	document.registration.vatNumber.disabled = !status;
	document.registration.vatNumber.value="";
}

</script>

</head>

<s:div class="container">
	<s:div class="account">
			<h2 class="account-in">Registrazione</h2>
			<s:form name="registration" action="AddUser">
				<s:textfield name="ssn" label="Codice Fiscale" size="60%" maxlength="16"/>
				<s:textfield name="username" label="Username" />
				<s:password name="password" label="Password" />
				<s:password name="confirm_password" label="Conferma password"/>
				<s:textfield name="name" label="Nome" />
				<s:textfield name="surname" label="Cognome"/>
				<sj:datepicker name="dateOfBirth" label="Data di nascita" yearRange="-120:-18" minDate="-120y" maxDate="-18y" 
				displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" readonly="true"/> 
				<s:select name="gender" label="Sesso" list="#{'M':'Maschio','F':'Femmina'}"/>
				<s:label value="Contatti:" cssStyle="font-size: 150%;"/>
				<s:textfield name="email" label="Email"/>
				<s:textfield name="telephone" label="Telefono"/>
				<s:textfield name="cellular" label="Cellulare"/>
				<s:checkbox name="seller" label="Venditore" value="0" onclick="enable_vatnumber(this.checked)"/>
				<s:textfield name="vatNumber" label="Partita IVA" disabled="true" value="" maxlength="11"/>
				<s:submit value="Invia"/>
				</s:form>
		</s:div>
	</s:div>