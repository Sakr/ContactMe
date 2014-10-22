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
<c:url value="/addContact" var="addURL" />
<c:url value="/resetAddContact" var="resetAddContactURL" />

<div class="block">

<!--  
	<form:form method="POST"  commandName="contactFormBean" class="cssform_colonnes_new_width" action="${addURL}">
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

		<div class="aligner_center">
			<input type="submit" class="submit" name="add" id="idAdd" value="<spring:message code="contact.add"/>"  /> 
			<input type="reset" name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetAddContactURL}')" />
				 
		</div>
	</form:form>
	-->
	
		<form:form method="POST"  commandName="contactFormBean" action="${addURL}" class="modifyContact" target="_parent">
			
			<spring:message code="contact.add.title" var="create"/>
			<div class="titleModify">${create}</div>	

			<div>
				<img class ="picto" src="resources/images/name.png" />
				<spring:message code="listContact.firstName" var="firstname"/>
				<form:input required="required" class = "inputmodify" type = "text" path="firstNameContact" id="idFirstNameContact" placeholder="${firstname}"/>
				
			</div>
			
			<div>
				<img class ="picto" src="resources/images/blank.png" />
				<spring:message code="listContact.secondName" var="secondname"/>
				<form:input required="required" class = "inputmodify" type = "text"  path="secondNameContact" id="idSecondNameContact" placeholder="${secondname}"/>
			</div>
			
			<div>
				<img class ="picto" src="resources/images/birth.png" />
				<spring:message code="listContact.dateBirth" var="dateBirth"/>
				<form:input required="required" class = "inputmodify" type = "text"  path="dateBirthContact" id="idDateBirthContact" placeholder="${dateBirth}"/>
			</div>	
					
			<div>
				<img class ="picto" src="resources/images/mail.png" />
				<spring:message code="listContact.mail" var="mail"/>
				<form:input required="required" class = "inputmodify" type = "email" path="mailContact" id="idMailContact" placeholder="${mail}"/>
			</div>
			
			<div>
				<label class="labelmodify" for="activeContact"><spring:message code="listContact.active"/> </label>
				<form:checkbox id="idActiveContactAdd" path="activeContact" />
			</div>

			<div style="margin-top:13px;">
				<input type="submit" class="buttonmodify" name="rechercher" id="rechercher" value="<spring:message code="contact.save" />" /> 
				<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
			</div>

	</form:form>
	
	
</div>
