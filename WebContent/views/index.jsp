<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:form action="AddUser">
	<s:textfield name="name" label="Nome" />
	<s:textfield name="surname" label="Cognome"/>
	<s:textfield name="age" label="Età"/>
	<s:textfield name="email" label="Email"/>
	<s:radio name="gender" label="Sesso" list="#{'M':'Uomo','F':'Donna'}"/>
	<s:select name="province" label="Provincia" list="#{'LE': 'Lecce','BR':'Brindisi','TA':'Taranto'}" />
	<s:submit class="btn btn-primary" value="Invia"/>
</s:form>

<a href="views/login.jsp">gotologin</a>
Index.jsp

Body della pagina.