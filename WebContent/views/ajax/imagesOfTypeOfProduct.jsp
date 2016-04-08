<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="rslides" id="slider1">
	<s:iterator value="photos">
		<li><img src="<s:property value="photoUri" />" /></li>
	</s:iterator>
</ul>
