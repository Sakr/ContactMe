<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<script type="text/javascript">
     $(document).ready(function () {
     	$("#idLanguage").attr( "disabled", "disabled" );
     });
</script>
<form>
	<div class="readContact">
		<img class ="picto" src="resources/images/name.png" style="width:25px; height:25px;" />
		${contactFormBean.secondNameContact} ${contactFormBean.firstNameContact}
	</div>
	</br>

	<div class="readContact">
		<img class ="picto" src="resources/images/mail.png" style="width:25px; height:25px;" />
		${contactFormBean.mailContact}
	</div>
	</br>
	<div class="readContact">
		<img class ="picto" src="resources/images/birth.png" style="width:25px; height:25px;" />
		${contactFormBean.dateBirthContact}
	</div>
	</br>
</form>

</br>
	<a href="/popupAddAdress" class="lien iframe"><img src="resources/images/add-adress.png" style="width:30px; height: 30px; margin-bottom:10px; margin-left:20px;"></a>

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
			<th id="entete_7"></th>
			<th id="entete_8"></th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${adressList}" var="adress"  varStatus="status">
			<tr>
				<td headers="entete_1">${adress.numberAdress}</td>
				<td headers="entete_2">${adress.streetNameAdress}</td> 
				<td headers="entete_3">${adress.codeAdess}</td>
				<td headers="entete_4">${adress.cityAdress}</td>
				<td headers="entete_5">
					<c:if test="${adress.shippingAdress}">
						<img src="resources/images/check.png" style="width:17px; height:10px;">
					</c:if>
				</td>
				<td headers="entete_6">
					<c:if test="${adress.billingAdress}">
						<img src="resources/images/check.png" style="width:17px; height:10px;">
					</c:if>
				</td>
				<td headers="entete_7" style="text-align: center;"><a href="/deleteAdress?indexA=${status.index}" class="lien iframe"><img src="resources/images/delete.png" style="width:20px; height:20px;"><span title="Supprimer le contact"></span></a></td>
				<td headers="entete_8" style="text-align: center;"><a href="/changeAdress?indexA=${status.index}" class="lien iframe"><img src="resources/images/update.png" style="width:20px; height:20px;"><span title="Modifier le contact"></span></a></td>
			</tr>			
		</c:forEach>
	</tbody>
</table>