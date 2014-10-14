package fr.esiea.web.utils;

import java.util.List;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;

public class FillTableElementWithJSON {
	/**
	 * Generation de champ input pour l'alimentation du tableau via JSON
	 * 
	 * @param id
	 * @param name
	 * @param classes
	 * @param value
	 * @param javascript
	 * @param disabled
	 * @param readonly
	 * @param maxlength
	 * @param size
	 * @return
	 */
	public static  String generateInputText(String id, String name, String classes, String value, String title, String javascript, boolean disabled, boolean readonly, int maxlength, int size) {

		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"text\" id=\"");
		sb.append(id);
		sb.append("\" name=\"");
		sb.append(name);
		sb.append("\" class=\"");
		sb.append(classes);
		sb.append("\" value=\"");
		if(value == null) {
			sb.append("");
		} else {
			sb.append(value);
		}
		sb.append("\" title=\"");
		if(title == null) {
			sb.append("");
		} else {
			sb.append(title);
		}
		sb.append("\"");
		
		if(disabled) {
			sb.append(" disabled=\"disabled\"");
		}
		
		if(readonly) {
			sb.append(" readonly=\"readonly\"");
		}
		
		if(size != -1) {
			sb.append(" size=\"");
			sb.append(size);
			sb.append("\" ");
		}
		
		if(maxlength != -1) {
			sb.append(" maxlength=\"");
			sb.append(maxlength);
			sb.append("\" ");
		}
		
		if(javascript != null) {
			sb.append(" ");
			sb.append(javascript);
			sb.append(" ");
		}
		
		sb.append(" />");
		return sb.toString();
	}
	
	/**
	 * Generation de champ select "mode de delegation" pour l'alimentation du tableau via JSON
	 * 
	 * @param modeDelegationList
	 * @param idSousEnveloppe
	 * @param idModeDelegation
	 * @param id
	 * @param name
	 * @param classes
	 * @param disabled
	 * @param readonly
	 * @return
	 */
	public static String generateModeDelegationSelect(List<AdressBean> adressList, Long idSousEnveloppe, Long idModeDelegation, String id, String name, String classes, boolean disabled, boolean readonly, int mnIndex, int notifIndex) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<select id=\"");
		sb.append(id);
		sb.append("\" name=\"");
		sb.append(name);
		sb.append("\" class=\"");
		sb.append(classes);
		sb.append("\"");
		
		if(disabled) {
			sb.append(" disabled=\"disabled\"");
		}
		
		if(readonly) {
			sb.append(" readonly");
		}

		sb.append("onchange=\"javascript:setNewDelegationMode(this.options[this.selectedIndex].value, '");
		sb.append(mnIndex);
		sb.append("', '");
		sb.append(notifIndex);
		sb.append("');\"");
		sb.append(">");
		
		sb.append("<option value=\"-1\">--------</option>");
		for(AdressBean adressBean : adressList) {
			
				sb.append("<option value=\"");
				sb.append(adressBean.getIdAdress());
				sb.append("\" selected=\"selected\" >");
				sb.append(adressBean.getStreetNameAdress());
				sb.append("</option>");
		}
		sb.append("</select>");
		return sb.toString();
	}
	
	
	/**
	 * Generation de champ de type checkbox pour l'alimentation du tableau via JSON
	 * 
	 * @param id
	 * @param name
	 * @param classes
	 * @param javascript
	 * @param value
	 * @param disabled
	 * @param readonly
	 * @return
	 */
	public static String generateInputCheckbox(String id, String name, String classes, String javascript, boolean checked, boolean disabled, boolean readonly) {

		StringBuilder sb = new StringBuilder();
		
		if(disabled) {
		    	sb.append("<input type=\"checkbox\" id=\"");
        		sb.append(id);
        		sb.append("\" name=\"");
        		sb.append(name);
        		sb.append("\" class=\"");
        		sb.append(classes);
        		sb.append("\"");
        		
        		if(checked) {
        			sb.append(" checked=\"checked\"");
        		}
        		sb.append(" disabled=\"disabled\"");

        		if(javascript != null) {
        			sb.append(" ");
        			sb.append(javascript);
        			sb.append(" ");
        		}
        		
        		sb.append(" />");
		} else {
        		sb.append("<input type=\"checkbox\" id=\"");
        		sb.append(id);
        		sb.append("\" name=\"");
        		sb.append(name);
        		sb.append("\" class=\"");
        		sb.append(classes);
        		sb.append("\"");
        		
        		if(checked) {
        			sb.append(" checked=\"checked\"");
        		}
        		
        		if(javascript != null) {
        			sb.append(" ");
        			sb.append(javascript);
        			sb.append(" ");
        		}
        		sb.append(" />");
        		
        		sb.append("<input type=\"hidden\" value=\"on\" name=\"_");
        		sb.append(name);
        		sb.append("\" title=\"on\">");		
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param linkUrl
	 * @param linkButton
	 * @param title
	 * @param libelle
	 * @param classes
	 * @return
	 */
	public static String generatePopup(String linkUrl, String linkButton, String title, String libelle, String classes) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"");
		sb.append(linkUrl);
		sb.append("\" class=\"");
		sb.append(classes);
		sb.append("\" ><img src=\"");
		sb.append(linkButton);
		sb.append("\" /><span title=\"");
		sb.append(title);
		sb.append("\">");
		sb.append(libelle);
		sb.append("</span></a>");
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param linkUrl
	 * @param libelle
	 * @param title
	 * @param classes
	 * @return
	 */
	public static String generateLink(String linkUrl,String linkButton,  String libelle, String title) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<a href=\"");
		sb.append(linkUrl);
		sb.append("\" ><img src=\"");
		sb.append(linkButton);
		sb.append("\" /><span title=\"");
		sb.append(title);
		sb.append("\">");
		sb.append(libelle);
		sb.append("</span></a>");
		
		return sb.toString();
	}
	
	
	
	/**
	 * Generation de champ select "mesures" pour l'alimentation du tableau via JSON
	 * 
	 * @param modeDelegationList
	 * @param idSousEnveloppe
	 * @param idModeDelegation
	 * @param id
	 * @param name
	 * @param classes
	 * @param disabled
	 * @param readonly
	 * @return
	 */
	public static String generateContactSelect(List<ContactBean> contactList, Long idMesure, String id, String name, String classes, String javascript, boolean disabled, boolean readonly, int lineIndex, int index) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<select id=\"_");
		sb.append(id);
		sb.append("\" name=\"_");
		sb.append(name);
		sb.append("\" class=\"");
		sb.append(classes);
		sb.append("\"");
		
		if(disabled) {
			sb.append(" disabled=\"disabled\"");
		}
		
		
		
		if(javascript != null) {
			sb.append(" ");
			sb.append(javascript);
			sb.append(" ");
		}
	
		sb.append(">");
		
		for(ContactBean contactBean : contactList) {
			
				sb.append("<option value=\"");
				sb.append(contactBean.getIdContact());
				sb.append("\" selected=\"selected\" >");
				sb.append(contactBean.getFirstNameContact());
				sb.append("</option>");
		}
		sb.append("</select>");
		sb.append("<input id=\"");
		sb.append(id);
		sb.append("\" type=\"hidden\" value=\"");
		sb.append(idMesure);
		sb.append("\" name=\"");
		sb.append(name);
		sb.append("\" title=\"on\">");	
		
		return sb.toString();
	}
}
