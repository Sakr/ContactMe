<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<a href="<c:url value="/start"/>">
	<img alt="<spring:message code="contact.title" />" src="<c:url value="resources/images/contact-me.png"/>" width="500" height="76" style="padding-top:10px;" />
</a>

<ul class="informations">
	<li class="langue">
		<label><spring:message code="home.langue"/> </label>
		<select id="idLanguage" onchange="changeLanguage(this)" >
			<option value="lang" label="" selected="selected" />
			<option value="fr" label="Français"  />
			<option value="en" label="English" />
				
		</select>
	</li>		
</ul>
