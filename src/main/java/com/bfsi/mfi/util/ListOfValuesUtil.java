package com.bfsi.mfi.util;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.vo.ListValueVO;

/**
 * Utility class to work with list of values
 * 
 * @author arun
 * 
 */
public class ListOfValuesUtil {
	private static final String LOV_BUNDLE = "i18n.lov";
	private static final String DELIMITER = "~";

	public static void addLocaleDescription(List<ListValueVO> listValues) {
		for (ListValueVO vo : listValues) {
			String listName = vo.getListName().trim();
			String listValue = vo.getListValue().trim();

			ResourceBundle bundle = ResourceBundle
					.getBundle(LOV_BUNDLE, FacesContext.getCurrentInstance()
							.getViewRoot().getLocale());
			String value = bundle.getString(listName + DELIMITER + listValue);

			vo.setDesn(value);
		}
	}

	public static String getLocaleValue(String listName, String listValue) {
		ResourceBundle bundle = ResourceBundle.getBundle(LOV_BUNDLE,
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(listName.trim() + DELIMITER + listValue.trim());
	}

}
