<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script language="JavaScript">
	function doGet(url) {
		parent.$.fancybox.close();
		window.location.href = url;
	}
	
</script>
<!-- URL For add -->
<c:url value="/addAdress" var="addURL" />
<c:url value="/resetAddAdress" var="resetAddAdressURL" />
<div class="block">
<!-- 
		<form:form method="POST" commandName="adressFormBean" class="cssform_colonnes_new_width" action="${addURL}">
			<div class="colonne_gauche">
				<p>
					<label for=numberAdress><spring:message code="adress.number"/></label>
					<form:input path="numberAdress" id="idAdressNumber"></form:input>
				</p>
				<p>
					<label for="streetNameAdress"><spring:message code="adress.streetName"/> </label>
					<form:input path="streetNameAdress" id="idAdressStreetName" />
				</p>
				<p>
					<label for="adressShipping"><spring:message code="adress.shipping"/> </label>
					<form:checkbox id="idAdressShipping" path="adressShipping" />
				</p>
			</div>
			<div class="colonne_droite">
				<p>
					<label for="codeAdess"><spring:message code="adress.codeAdess"/> </label>
					<form:input path="codeAdess" id="idCodeAdess" />
				</p>
				<p>
					<label for="cityAdress"><spring:message code="adress.cityAdress"/> </label>
					<form:input path="cityAdress" id="idCityAdress" />
				</p>
				<p>
					<label for="adressBilling"><spring:message code="adress.billing"/> </label>
					<form:checkbox id="idAdressBilling" path="adressBilling" />
				</p>
			</div>

			<div class="clear"></div>

			<div class="aligner_center">
				<input type="submit" class="submit" name="add" id="idAdd" value="<spring:message code="adress.add"/>"  /> 
				<input type="reset" name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetAddAdressURL}')" />
			</div>
		</form:form>
		-->
		
		<form:form method="POST" commandName="adressFormBean" action="${addURL}" class="modifyContact">
			
			<spring:message code="adress.add.title" var="create"/>
			<div class="titleModify">${create}</div>	

			<div>
				<img class ="picto" src="resources/images/name.png" />
				<spring:message code="adress.number" var="number"/>
				<form:input required="required" class = "inputmodify" type = "text" path="numberAdress" id="idAdressNumber" placeholder="${number}" value=""/>	
			</div>
			
			<div>
				<img class ="picto" src="resources/images/blank.png" />
				<spring:message code="adress.streetName" var="streetName"/>
				<form:input required="required" class = "inputmodify" type = "text"  path="streetNameAdress" id="idAdressStreetName" placeholder="${streetName}"/>			
			</div>	
					
			<div>
				<img class ="picto" src="resources/images/blank.png" />
				<spring:message code="adress.codeAdess" var="zipCode"/>
				<form:input required="required" class = "inputmodify" type = "text" path="codeAdess" id="idCodeAdess" placeholder="${zipCode}" value=""/>
			</div>
			
			<div>
				<img class ="picto" src="resources/images/blank.png" />
				<spring:message code="adress.cityAdress" var="city"/>
				<form:input required="required" class = "inputmodify" type = "text" path="cityAdress" id="idCityAdress" placeholder="${city}"/>
			</div>
				
			<div>
				<label class="labelmodify" for="adressBilling"><spring:message code="adress.billing"/> </label>
				<form:checkbox id="idAdressBilling" path="adressBilling" />
			</div>
			
			<div>
				<label class="labelmodify" for="adressShipping"><spring:message code="adress.shipping"/> </label>
				<form:checkbox id="idAdressShipping" path="adressShipping" />
			</div>

			<div style="margin-top:13px;">
				<input type="submit" class="buttonmodify" name="rechercher" id="rechercher" value="<spring:message code="contact.save" />" /> 
				<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
			</div>
			
			

	</form:form>
</div>