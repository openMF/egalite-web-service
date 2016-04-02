package com.bfsi.mfi.themes.model;

import java.io.Serializable;

public class UserPreferences implements Serializable {

	private static final long serialVersionUID = 20120527L;

	private String theme = "home";

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
