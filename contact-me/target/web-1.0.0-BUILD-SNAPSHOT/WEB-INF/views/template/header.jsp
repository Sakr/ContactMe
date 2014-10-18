<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<a href="<c:url value="/start" />" class = "logo">
</a>
<div class="langueSelection">
	<p class="langue">
		<label><spring:message code="home.langue"/></label>
		<select id="idLanguage" onchange="changeLanguage(this)" >
			<option value="lang" label="" selected="selected" />
			<option value="fr" label="Français"  />
			<option value="en" label="English" />	
		</select>
	</p>		
</div>
