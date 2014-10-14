<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<c:url value="/contacts" var="contactsURL" />
<div style="margin:10px;">
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	<form:form method="POST"  class="cssform_colonnes_new_width" action="${contactsURL}">
			
			<div class="aligner_centre">
				<input type="submit" class="submit" name="add" id="idAdd" value="<spring:message code="contact.modeTest"/>"  /> 
					 
			</div>
		</form:form>	
</div>