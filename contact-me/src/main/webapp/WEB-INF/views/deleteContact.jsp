<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url value="/resetDelete"  var="resetURL" />
<c:url value="/deleteContact" var="deleteContactURL" />
<div style="margin:10px;">
	<form:form method="POST"  class="modifyContact" action="${deleteContactURL}" target="_parent">
			</br>
			</br>
			</br>
			</br>
			</br>
			<p class ="deleteText"><spring:message code="contact.delete"/> ?</p>
			</br>
			</br>
			</br>
			<div id="bottomButton">
				<input type="submit" class="deleteButton" name="delete" id="idDelete" value="<spring:message code="contact.delete"/>"  /> 
				<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="contact.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />	 
			</div>
		
	</form:form>	
</div>