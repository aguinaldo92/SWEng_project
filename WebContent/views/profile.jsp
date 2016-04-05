<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<head>

<script lang="JavaScript">

function enable_text(status)
{
	document.registration.vatNumber.disabled = !status;
	document.registration.vatNumber.value="";
}

function change_password()
{
	document.account_management.old_password.hidden = false;
	document.account_management.password.hidden = false;
	document.account_management.confirm_password.hidden = false;
	
	document.account_management.change_pw_button.hidden = true;
}

</script>

</head>

<s:iterator value="#session.user" var="user">

<s:div class="container">
	<s:div class="account">
			<s:a action="UpdatePassword"><s:submit name="change_pw_button" value="Modifica la password"/></s:a>
			<s:a action="mylocations"><s:submit name="change_pw_button" value="Gestisci i tuoi indirizzi"/></s:a>
			
			
			<h2 class="account-in">Gestione account</h2>
			<s:form name="account_management" action="UpdateUser">
				<s:textfield name="ssn" label="Codice Fiscale" size="60%" maxlength="16"/>
				<s:textfield name="username" label="Username" />
				<s:password name="old_password" hidden="true" />
				<s:password name="password" hidden="true"/>
				<s:password name="confirm_password" hidden="true"/>
				<s:textfield name="name" label="Nome" value="%{#user.name}"/>
				<s:textfield name="surname" label="Cognome"/>
				<sj:datepicker name="dateOfBirth" label="Data di nascita" yearRange="-120:-18" minDate="-120y" maxDate="-18y" 
				displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" readonly="true"/> 
				<s:select name="gender" label="Sesso" list="#{'M':'Maschio','F':'Femmina'}"/>
				
				<s:label value="Contatti:" cssStyle="font-size: 150%;"/>
				<s:textfield name="email" label="Email"/>
				<s:textfield name="telephone" label="Telefono"/>
				<s:textfield name="cellular" label="Cellulare"/>
				
				<s:checkbox name="seller" label="Venditore" value="%{#user.seller}" onclick="enable_text(this.checked)"/>
				<s:textfield name="vatNumber" label="Partita IVA" disabled="%{!#user.seller}" maxlength="11"/>
				<s:submit value="Aggiorna profilo"/>
			</s:form>
		</s:div>
				
	</s:div>

</s:iterator>