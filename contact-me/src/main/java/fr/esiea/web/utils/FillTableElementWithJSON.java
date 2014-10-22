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
	

}
