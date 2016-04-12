<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>


QUESTA è LA PAGINA DI INDEX
<br>
<s:url action="gotoAddProduct.action" var="addProd"></s:url>
<s:a href="%{addProd}">Aggiungi un prodotto </s:a>