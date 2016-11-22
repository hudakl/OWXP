package com.liferay.grow.linkedpages.util;

public class PageLink {

	public PageLink(String pageTitle, String pageLink) {
		this._pageLink = pageLink;
		this._pageTitle = pageTitle;
	}

	public String getPageTitle() {
		return _pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this._pageTitle = pageTitle;
	}

	public String getPageLink() {
		return _pageLink;
	}

	public void setPageLink(String pageLink) {
		this._pageLink = pageLink;
	}

	private String _pageTitle;
	private String _pageLink;
}
