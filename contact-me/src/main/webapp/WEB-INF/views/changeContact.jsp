<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<c:url value="/saveChanges" var="saveURL" />
<c:url value="/resetChanges"  var="resetURL" />
<div class="modifyFrame">
	
	<form:form method="POST" commandName="contactFormBean" action="${saveURL}" class="modifyContact" target="_parent">
			
			<spring:message code="listContact.change" var="change"/>
			<div class="titleModify">${change}</div>	

			<div>
				<img class ="picto" src="resources/images/name.png" />
				<form:input required="required" class = "inputmodify" type = "text" path="firstNameContact" id="idFirstNameContact"/>
			</div>
			
			<div>
				<img class ="picto" src="resources/images/blank.png" />
				<form:input  required="required" class = "inputmodify" type = "text"  path="secondNameContact" id="idSecondNameContact"/>
			</div>
			
			<div>
				<img class ="picto" src="resources/images/birth.png" />
				<form:input required="required" class = "inputmodify w16em dateformat-d-sl-m-sl-Y show-weeks no-animation opacity-99 disable-drag"
							maxlength="10" onchange="javascript:isDate(this.value)" type = "text"  path="dateBirthContact" id="idDateBirthContact"/>
			</div>	
					
			<div>
				<img class ="picto" src="resources/images/mail.png" />
				<form:input required="required" class = "inputmodify" type = "email" path="mailContact" id="idMailContact"/>
			</div>
			
			<div>
				<label class="labelmodify" for="activeContact"><spring:message code="listContact.active"/> </label>
				<form:checkbox id="idActiveContactAdd" path="activeContact" />
			</div>
			
			<div>
				<input type="submit" class="buttonmodify" name="rechercher" id="rechercher" value="<spring:message code="contact.save" />" /> 
				<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
			</div>

	</form:form>
</div>