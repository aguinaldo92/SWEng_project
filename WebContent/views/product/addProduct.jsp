<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>



<s:div class="container">
	<s:div class="account">
			<h2 class="account-in">Inserisci nuovo prodotto</h2>
			<s:form name="addProduct" action="AddProduct">
				<s:textfield name="barcode" label="Bar code" size="60%" maxlength="16"/>
				<s:textfield name="title" label="Title" />
				<s:textfield name="description" label="Description" />
				<s:textfield name="sizes" label="Size"/>
				<s:textfield name="weight" label="Weight" />
				<s:textfield name="brand" label="Brand"/>
				<s:textfield name="model" label="Model"/>
				<s:textfield name="category" label="Category"/>
				<s:textfield name="sellingPrice" label="SellingPrice"/>
				<s:textfield name="sellingDiscount" label="SellingDiscount"/>
				<s:submit value="Invia"/>
				</s:form>
		</s:div>
	</s:div>