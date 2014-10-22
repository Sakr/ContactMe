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
<c:url value="/saveChanges" var="saveURL" />
<c:url value="/resetChanges"  var="resetURL" />
<div class="modifyFrame">
	<!--	
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>

	<form:form method="POST" commandName="contactFormBean"
		class="cssform_colonnes_new_width" action="${saveURL}">
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
				<form:input path="dateBirthContact" id="idDateBirthContact" class="w16em dateformat-d-sl-m-sl-Y show-weeks no-animation opacity-99 disable-drag"
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
				value="<spring:message code="contact.save" />" /> 
				
			<input type="reset" name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
		</div>
	
	</form:form>
	-->
	
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
				<form:input required="required" class = "inputmodify" type = "text"  path="dateBirthContact" id="idDateBirthContact"/>
			</div>	
					
			<div>
				<img class ="picto" src="resources/images/mail.png" />
				<form:input required="required" class = "inputmodify" type = "email" path="mailContact" id="idMailContact"/>
			</div>

			<div>
				<input type="submit" class="buttonmodify" name="rechercher" id="rechercher" value="<spring:message code="contact.save" />" /> 
				<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
			</div>

	</form:form>
</div>