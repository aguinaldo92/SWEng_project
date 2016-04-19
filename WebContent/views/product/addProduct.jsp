<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<s:if test="hasActionErrors()">
	<div style="color: red">
		<s:actionerror />
	</div>
</s:if>
<script>
$(document).ready(function() {
	 
});
</script>
<script>
	function showDiv(sel) {
		alert(sel.options[sel.selectedIndex].text);
		if(sel.options[sel.selectedIndex].text === "Aggiungi Categoria") {
			// document.addProduct.idcategoryName.options[0] = "Aggiungi Categoria";
			alert("if");
			$('#idNewCategory').show();
		} else {
			$('#idNewCategory').hide();
			alert("else");
		}
	};
	function showAlert(){
		alert("ok");
	}
</script>

<s:div class="container">
	<s:div class="product">
		<h2 class="product-in">Inserisci nuovo prodotto</h2>

		<s:form name="addProduct">
			<s:url action="AddCategory" var="aCategory" />
			<sj:select name="categoryName" id="idCategoryName" href="%{aCategory}"
				list="categoryNames" label="Category*" headerKey="-1"
				headerValue="Aggiungi Categoria" onChange="showDiv(this)" cssClass="" />


			<%-- 				<s:textfield name="newCategory" label="Inserisci nuova categoria" /> --%>
			<%-- 			<s:url id="idaBrand" var="aBrand" action="AddBrand.action"> --%>
			<!-- 		 controllare questi if per vedere se dal punto di vista logico compriamo tutte le possibilità -->
			<%-- 				<s:param name="categoryName"> --%>
			<%-- 					<s:if test="categoryName == Other" > --%>
			<%-- 						<s:property value="%{newCategory}"/> --%>
			<%-- 					</s:if> --%>
			<%-- 					<s:else> --%>
			<%-- 						<s:property value="%{categoryName}"/> --%>
			<%-- 					</s:else> --%>
			<%-- 				</s:param> --%>
			<%-- 			</s:url> --%>
			<%-- 			<sj:select name="brand" href="aBrand" list="brands" label="Brand*" --%>
			<%-- 				onChangeTopics="brandsState" /> --%>
			<%--  			<sj:submit value="Inserisci Model" action="AddModel" /> --%>
		</s:form>
		
			<s:textfield name="newCategory" id="idNewCategory"  />
		



		<%-- 		<s:form name="addProduct" action="AddProdcut"> --%>
		<%-- 			<s:textfield name="model" label="Model*" /> --%>
		<%-- 			<s:submit value="Invia" /> --%>
		<%-- 		</s:form> --%>

		<%-- 		<s:form name="addProduct" action="AddProdcut"> --%>
		<%-- 			<s:textfield name="barcode" label="Bar code" size="60%" --%>
		<%-- 				maxlength="16" /> --%>
		<%-- 			<s:textfield name="title" label="Title*" /> --%>
		<%-- 			<s:textfield name="description" label="Description" /> --%>
		<%-- 			<s:textfield name="sizes" label="Size" /> --%>
		<%-- 			<s:textfield name="weight" label="Weight" /> --%>
		<%-- 			<s:textfield name="sellingPrice" label="SellingPrice*" /> --%>
		<%-- 			<s:textfield name="sellingDiscount" label="SellingDiscount" /> --%>
		<%-- 			<s:submit value="Invia" /> --%>
		<%-- 		</s:form> --%>

	</s:div>
</s:div>