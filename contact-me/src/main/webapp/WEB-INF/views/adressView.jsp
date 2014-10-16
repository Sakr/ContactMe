<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!-- URL For add Block -->
<c:url value="/addAdress" var="addURL" />

<form:form 	class="cssform_colonnes_new_width" >

	<div class="colonne_gauche">
	
		<p>
			<label for=firstNameContact><spring:message code="listContact.firstName"/></label>
			${contactFormBean.firstNameContact}
		</p>
		<p>
			<label for="secondNameContact"><spring:message code="listContact.secondName"/> </label>
			${contactFormBean.secondNameContact}
		</p>
		<p>
			<label for="dateBirthContact"><spring:message code="listContact.dateBirth"/> </label>
			${contactFormBean.dateBirthContact}
		</p>
		<p>
			<label for="mailContact"><spring:message code="listContact.mail"/> </label>
			${contactFormBean.mailContact}
		</p>
		<p>
			<label for="activeContact"><spring:message code="listContact.active"/> </label>
			${contactFormBean.activeContact}
		</p>
	</div>

	<div class="clear"></div>

</form:form>

<h2 class="acc_trigger acc_trigger_0">
	<a href="#"><spring:message code="adress.add.title" /></a>
</h2>
<div class="acc_container">
	<div class="block">
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

			<div class="right">
				<input type="submit" class="submit" name="add" id="idAdd" value="<spring:message code="adress.add"/>"  /> 
				<input type="reset" name="cancelAdd" id="idCancelAdd" class="reset" value="<spring:message code="contact.cancel"/>"/>
					 
			</div>
		</form:form>
	</div>
</div>

<div class="clear"></div>

<table id="suivi0" class="display dataTable" summary="<spring:message code="listContact.nameTable"/>">
	<thead>
		<tr>
		
			<th id="entete_1"><spring:message code="adress.number"/></th>
			<th id="entete_2"><spring:message code="adress.streetName"/></th> 
			<th id="entete_3"><spring:message code="adress.codeAdess"/></th>
			<th id="entete_4"><spring:message code="adress.cityAdress"/></th>
			
			<th id="entete_5"><spring:message code="adress.shipping"/></th>
			<th id="entete_6"><spring:message code="adress.billing"/></th>
			<th id="entete_7"><spring:message code="listContact.remove"/></th>
			<th id="entete_8"><spring:message code="listContact.change"/></th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th id="entete_1"><spring:message code="adress.number"/></th>
			<th id="entete_2"><spring:message code="adress.streetName"/></th> 
			<th id="entete_3"><spring:message code="adress.codeAdess"/></th>
			<th id="entete_4"><spring:message code="adress.cityAdress"/></th>
			
			<th id="entete_5"><spring:message code="adress.shipping"/></th>
			<th id="entete_6"><spring:message code="adress.billing"/></th>
			<th id="entete_7"><spring:message code="listContact.remove"/></th>
			<th id="entete_8"><spring:message code="listContact.change"/></th>
		</tr>
	</tfoot>
	<tbody>
		<c:forEach items="${adressList}" var="adress"  varStatus="status">
			<tr>
				<td headers="entete_1">${adress.numberAdress}</td>
				<td headers="entete_2">${adress.streetNameAdress}</td> 
				<td headers="entete_3">${adress.codeAdess}</td>
				<td headers="entete_4">${adress.cityAdress}</td>
				<td headers="entete_5">${adress.shippingAdress}</td>
				<td headers="entete_6">${adress.billingAdress}</td>
				<td headers="entete_7" style="text-align: center;"><a href="/deleteAdress?indexA=${status.index}" class="lien iframe"><img src="resources/images/trash-icon.png"><span title="Supprimer le contact"></span></a></td>
				<td headers="entete_8" style="text-align: center;"><a href="/changeAdress?indexA=${status.index}" class="lien iframe"><img src="resources/images/picture-settings-icon.png"><span title="Modifier le contact"></span></a></td>
			</tr>			
		</c:forEach>
	</tbody>
</table>