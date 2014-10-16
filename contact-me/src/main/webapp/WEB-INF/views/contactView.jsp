<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- URL For search Block -->
<c:url value="/search" var="searchURL" />
<c:url value="/reset" var="resetURL" />

<!-- URL For add Block -->
<c:url value="/addContact" var="addURL" />

<!-- URL For contact action -->
<c:url value="/remove" var="removeURL" />
<c:url value="/change" var="changeURL" />
<c:url value="/consult" var="consultURL" />

<form:form method="POST" commandName="contactFormBean"
	class="cssform_colonnes_new_width" action="${searchURL}">

	<div class="colonne_gauche">
		<p>
			<label for=firstNameContact><spring:message code="listContact.firstName"/></label>
			<form:input path="firstNameContact" id="idFirstNameContact"></form:input>
		</p>
		<p>
			<label for="secondNameContact"><spring:message code="listContact.secondName"/> </label>
			<form:input path="secondNameContact" id="idSecondNameContact" />
		</p>
		<p>
			<label for="dateBirthContact"><spring:message code="listContact.dateBirth"/> </label>
			<form:input path="dateBirthContact" id="idDateBirthContactAdd" class="w16em dateformat-d-sl-m-sl-Y show-weeks no-animation opacity-99 disable-drag"
						maxlength="10" onchange="javascript:isDate(this.value)"/>
		</p>
		<p>
			<label for="mailContact"><spring:message code="listContact.mail"/> </label>
			<form:input path="mailContact" id="idMailContact" />
		</p>
		<p>
			<label for="activeContact"><spring:message code="listContact.active"/> </label>
			<form:checkbox id="idActiveContact" path="activeContact" />
		</p>
	</div>

	<div class="clear"></div>

	<div class="center">
		<input type="submit" class="submit" name="rechercher" id="rechercher"
			value="<spring:message code="listContact.rechercher" />" /> 
		<a href="${resetURL}" class="lien"
			title="<spring:message code="listContact.cancelSearch.title" />"
			class="lien"> <spring:message code="listContact.cancelSearch" />
		</a>
	</div>

</form:form>

<h2 class="acc_trigger acc_trigger_0">
	<a href="#"><spring:message code="contact.add.title" /></a>
</h2>
<div class="acc_container">
	<div class="block">
		<form:form method="POST" commandName="contactFormBean" class="cssform_colonnes_new_width" action="${addURL}">
			<div class="colonne_gauche">
				<p>
					<label for=firstNameContact><spring:message code="listContact.firstName"/></label>
					<form:input path="firstNameContact" id="idFirstNameContactAdd"></form:input>
				</p>
				<p>
					<label for="secondNameContact"><spring:message code="listContact.secondName"/> </label>
					<form:input path="secondNameContact" id="idSecondNameContactAdd" />
				</p>
				<p>
					<label for="dateBirthContact"><spring:message code="listContact.dateBirth"/> </label>
					<form:input path="dateBirthContact" id="idDateBirthContactAdd" class="w16em dateformat-d-sl-m-sl-Y show-weeks no-animation opacity-99 disable-drag"
						maxlength="10" onchange="javascript:isDate(this.value)"/>
				</p>
			</div>

			<div class="colonne_droite">
				<p>
					<label for="mailContact"><spring:message code="listContact.mail"/> </label>
					<form:input path="mailContact" id="idMailContactAdd" />
				</p>
				<p>
					<label for="activeContact"><spring:message code="listContact.active"/> </label>
					<form:checkbox id="idActiveContactAdd" path="activeContact" />
				</p>
			</div>

			<div class="clear"></div>

			<div class="right">
				<input type="submit" class="submit" name="add" id="idAdd" value="<spring:message code="contact.add"/>"  /> 
				<input type="reset" name="cancelAdd" id="idCancelAdd" class="reset" value="<spring:message code="contact.cancel"/>"/>
					 
			</div>
		</form:form>
	</div>
</div>

<div class="clear"></div>

<table id="suivi0" class="display dataTable" summary="<spring:message code="listContact.nameTable"/>">
	<thead>
		<tr>
			<th id="entete_1"><spring:message code="listContact.firstName"/></th>
			<th id="entete_2"><spring:message code="listContact.secondName"/></th> 
			<th id="entete_3"><spring:message code="listContact.dateBirth"/></th>
			<th id="entete_4"><spring:message code="listContact.mail"/></th>
			<th id="entete_5"><spring:message code="listContact.active"/></th>
			<th id="entete_6"><spring:message code="listContact.remove"/></th>
			<th id="entete_7"><spring:message code="listContact.change"/></th>
			<th id="entete_8"><spring:message code="listContact.consult"/></th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th id="entete_1"><spring:message code="listContact.firstName"/></th>
			<th id="entete_2"><spring:message code="listContact.secondName"/></th> 
			<th id="entete_3"><spring:message code="listContact.dateBirth"/></th>
			<th id="entete_4"><spring:message code="listContact.mail"/></th>
			<th id="entete_5"><spring:message code="listContact.active"/></th>
			<th id="entete_6"><spring:message code="listContact.remove"/></th>
			<th id="entete_7"><spring:message code="listContact.change"/></th>
			<th id="entete_8"><spring:message code="listContact.consult"/></th>
		</tr>
	</tfoot>
	<tbody>
		<c:forEach items="${contactList}" var="contact"  varStatus="status">
			<tr>
				<td headers="entete_1">${contact.firstNameContact}</td>
				<td headers="entete_2">${contact.secondNameContact}</td> 
				<td headers="entete_3">${contact.dateBirthContact}</td>
				<td headers="entete_4">${contact.mailContact}</td>
				<td headers="entete_5">${contact.activeContact}</td>
				<td headers="entete_6" style="text-align: center;"><a href="/delete?index=${status.index}" class="lien iframe"><img src="resources/images/trash-icon.png"><span title="Supprimer le contact"></span></a></td>
				<td headers="entete_7" style="text-align: center;"><a href="/change?index=${status.index}" class="lien iframe"><img src="resources/images/picture-settings-icon.png"><span title="Modifier le contact"></span></a></td>
				<td headers="entete_8" style="text-align: center;"><a href="/consult?index=${status.index}" ><img src="resources/images/Search-icon.png"><span title="Consulter le contact"></span></a></td>
			</tr>			
		</c:forEach>
		
	</tbody>
</table>