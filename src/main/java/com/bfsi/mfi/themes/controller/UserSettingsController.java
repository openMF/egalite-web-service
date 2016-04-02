package com.bfsi.mfi.themes.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

import com.bfsi.mfi.themes.model.AvailableThemes;
import com.bfsi.mfi.themes.model.Theme;
import com.bfsi.mfi.themes.model.UserPreferences;

@Controller
@SessionScoped
public class UserSettingsController implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, String> themes;
	private String theme;
	private UserPreferences userPreferences = new UserPreferences();

	public Map<String, String> getThemes() {
		return themes;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
		currentTheme = AvailableThemes.instance().getTheme(theme);
	}

	public void saveTheme() {
		userPreferences.setTheme(theme);
	}

	@PostConstruct
	public void init() {
		theme = userPreferences.getTheme();
		
		if (theme == null) {
			theme = "ui-lightness";
		}
		themes = new TreeMap<String, String>();
		themes.put("UI-Lightness","ui-lightness");
		themes.put("Afterdark", "afterdark");
		themes.put("Home", "home");
		themes.put("Dot-Luv", "dot-luv");
		themes.put("Glass-X", "glass-x");
		themes.put("Hot-Sneaks", "hot-sneaks");
		themes.put("Aristo", "aristo");
		
	}

	// Stateful Switcher (Full page refresh)

	private List<Theme> availableThemes;
	private Theme currentTheme;

	public UserSettingsController() {
		currentTheme = AvailableThemes.instance().getTheme("ui-lightness");
		availableThemes = AvailableThemes.instance().getThemes();
	}

	public List<Theme> getAvailableThemes() {
		return availableThemes;
	}

	public void setAvailableThemes(List<Theme> availableThemes) {
		this.availableThemes = availableThemes;
	}

	public Theme getCurrentTheme() {
		return currentTheme;
	}

	public void setCurrentTheme(Theme currentTheme) {
		this.currentTheme = currentTheme;
	}
}
