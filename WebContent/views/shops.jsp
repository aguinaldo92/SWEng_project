<%@ taglib prefix="s" uri="/struts-tags" %>

<s:action name="Shops"/>

<div class="top-products">

<s:iterator value="shops">
	<s:url var="shopURL" action="ShopDetails">
		<s:param name="idshop"><s:property value="id"/></s:param>
	</s:url>
	<div class="col-md-3 md-col">
		<div class="col-md">
			<a href="${shopURL}" class="compare-in" ><img  src="images/shop.png" /></a>
			<div class="top-content">
				<h5> <a href="${shopURL}"> <s:property value="name"/> <br> <s:property value="address"/> - <s:property value="city"/> </a></h5>
				</div>
			</div>							
		</div>
</s:iterator>

	<div class="col-md-3 md-col">
		<div class="col-md">
			<div style="opacity:0.3;">
			<div class="compare-in"><img  src="images/shop.png" alt="" /></div>
			</div>
			<div class="top-content">
				<div class="white">
					<s:a action="registrationShop" type="tiles" cssClass="hvr-shutter-in-vertical hvr-shutter-in-vertical2">AGGIUNGI UNO SHOP</s:a>
					<div class="clearfix"></div>
				</div>
			</div>							
		</div>
	</div>

</div>
<div class="clearfix"></div>