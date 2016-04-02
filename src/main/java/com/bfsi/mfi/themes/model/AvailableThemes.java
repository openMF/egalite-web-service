package com.bfsi.mfi.themes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AvailableThemes implements Serializable {

	private static final long serialVersionUID = 20120517L;

	private static AvailableThemes INSTANCE = null;

	public static AvailableThemes instance() {
		if (INSTANCE == null) {
			INSTANCE = new AvailableThemes();
		}

		return INSTANCE;
	}

	private final HashMap<String, Theme> themesAsMap;
	private final List<Theme> themes;

	private AvailableThemes() {
		List<String> themeNames = new ArrayList<String>();
		themeNames.add("home");
		themeNames.add("ui-lightness");
		themeNames.add("afterdark");
		themeNames.add("dot-luv");
		themeNames.add("glass-x");
		themeNames.add("hot-sneaks");
		themeNames.add("aristo");
		
		

		themesAsMap = new HashMap<String, Theme>();
		themes = new ArrayList<Theme>();

		for (String themeName : themeNames) {
			Theme theme = new Theme(themeName, "/resources/img/themeswitcher/" + themeName + ".png");

			themes.add(theme);
			themesAsMap.put(theme.getName(), theme);
		}
	}

	public final List<Theme> getThemes() {
		return themes;
	}

	public Theme getTheme(String name) {
		return themesAsMap.get(name);
	}
}
