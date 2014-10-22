<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
     $(document).ready(function () {
     	$("#idLanguage").removeAttr( "disabled", "disabled" );
     });
</script>
<!-- URL For search -->
<c:url value="/search" var="searchURL" />
<c:url value="/reset" var="resetURL" />

<!-- Gestion des doublons -->
<c:if test="${not empty doublon }">
	<div ><spring:message code="contact.doublon" /></div>
</c:if>


<form:form method="POST" commandName="contactFormBean" class="searchContact" action="${searchURL}">

			<label for=firstNameContact></label>
			<spring:message code="listContact.firstName" var="firstname"/>
			<form:input class ="inputSearch" type = "text" path="firstNameContact" id="nom" placeholder="${firstname}"/>

			<spring:message code="listContact.secondName" var="secondname"/>
			<label for="secondNameContact"></label>
			<form:input class ="inputSearch" path="secondNameContact" id="idSecondNameContact" placeholder="${secondname}"/>
			
<%-- 			<spring:message code="listContact.mail" var="mail"/> --%>
<!-- 			<label for="mailContact"></label> -->
<%-- 			<form:input class ="inputSearch" path="mailContact" type="email" id="mail" placeholder="${mail}"/> --%>

		<input type="submit" class="buttonSearch" name="rechercher" id="rechercher" value="" />
		<a href="${resetURL}" class="cancelSearch"
			title="<spring:message code="listContact.cancelSearch.title" />"
			class="lien"> <spring:message code="listContact.cancelSearch" />
		</a>

</form:form>

<!--  <h2 class="acc_trigger acc_trigger_0">
	<a href="#"><spring:message code="contact.add.title" /></a>
</h2>
<div class="acc_container">
</div>-->

<a href="/popupAddContact" class="lien iframe" id="pictoAddContact"><img src="resources/images/add-contact.png" style="width:30px; height: 27px; margin-bottom:10px; margin-left:20px;"></a>


<div class="clear"></div>

<table id="suivi0" class="display dataTable" summary="<spring:message code="listContact.nameTable"/>">
	<thead>
		<tr>
			<th id="entete_1"><spring:message code="listContact.firstName"/></th>
			<th id="entete_2"><spring:message code="listContact.secondName"/></th> 
			<th id="entete_3"><spring:message code="listContact.dateBirth"/></th>
			<th id="entete_4"><spring:message code="listContact.mail"/></th>
			<th id="entete_5"><spring:message code="listContact.active"/></th>
			<th id="entete_6"><!--spring:message code="listContact.remove"/--></th>
			<th id="entete_7"><!--spring:message code="listContact.change"/--></th>
			<th id="entete_8"><!--spring:message code="listContact.consult"/--></th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${contactList}" var="contact"  varStatus="status">
			<tr>
				<td headers="entete_1">${contact.firstNameContact}</td>
				<td headers="entete_2">${contact.secondNameContact}</td> 
				<td headers="entete_3">${contact.dateBirthContact}</td>
				<td headers="entete_4">${contact.mailContact}</td>
				<td headers="entete_5">
				
					<c:choose>
						<c:when test="${contact.activeContact }">
							<img src="resources/images/true.png" style="width:15px; height:15px;">
						</c:when>
						<c:otherwise>
							<img src="resources/images/false.png" style="width:15px; height:15px;">
						</c:otherwise>
					</c:choose>
				</td>
				<td headers="entete_6"><a href="/delete?index=${status.index}" class="lien iframe"><img src="resources/images/delete.png" style="width:20px; height:20px;"></a></td>
				<td headers="entete_7"><a href="/change?index=${status.index}" class="lien iframe"><img src="resources/images/update.png" style="width:20px; height:20px;"></a></td>
				<td headers="entete_8"><a href="/consult?index=${status.index}" ><img src="resources/images/read.png" style="width:20px; height:20px;" title="<spring:message code="listContact.consult"/>"></a></td>
			</tr>			
		</c:forEach>
		
	</tbody>
</table>
