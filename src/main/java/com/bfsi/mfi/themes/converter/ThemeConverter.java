package com.bfsi.mfi.themes.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bfsi.mfi.themes.model.AvailableThemes;
import com.bfsi.mfi.themes.model.Theme;

@FacesConverter("com.bfsi.mfi.themes.converter.ThemeConverter")
public class ThemeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return AvailableThemes.instance().getTheme(value);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return ((Theme) value).getName();
	}
}
