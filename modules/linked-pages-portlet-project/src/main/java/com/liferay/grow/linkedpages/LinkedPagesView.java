package com.liferay.grow.linkedpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.liferay.grow.linkedpages.util.PageLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

public class LinkedPagesView {

	/*
	 * Finding a linked pages in a wiki page
	 * Based on Grow Navigation ADT
	 * https://grow.liferay.com/group/guest/people/-/wiki/Grow/Grow+navigation+ADT
	 */
	public LinkedPagesView(ThemeDisplay themeDisplay) {
		_linkedPages = new ArrayList<PageLink>();
		_themeDisplay = themeDisplay;

		long groupId = _themeDisplay.getScopeGroupId();
		String wikiPageTitle = getWikiPageTitle(_themeDisplay.getURLCurrent());

		fillLinkedPages(groupId, "Grow", wikiPageTitle);
	}

	public ArrayList<PageLink> getLinkedPages() {
		return _linkedPages;
	}

	public void fillLinkedPages(long groupId, String nodeTitle, String pageTitle) {
		try {
			long nodeId = WikiNodeLocalServiceUtil.getNode(
				groupId, nodeTitle).getNodeId();

			WikiPage wikiPage = WikiPageLocalServiceUtil.getPage(
				nodeId, pageTitle);
			String content = wikiPage.getContent();

			while(content.indexOf("]]") > 0) {
				String link = content.substring(
					content.indexOf("[[")+2, content.indexOf("]]"));

				if (link.contains(_GROW_URL)) {
					_linkedPages.add(
						new PageLink(link.split("\\|")[1], link.split("\\|")[0]));
				}

				content = content.substring(content.indexOf("]]")+2);
			}

		} catch (PortalException e) {
			_log.debug(e.getMessage());
		}
	}

	private String getWikiPageTitle(String url) {
		String[] explodedURL = url.split("/");
		String rawPageTitle = "";
		String wikiPageTitle = "";

		if(explodedURL.length == 4) {
			if(url.contains(
				"_com_liferay_wiki_web_portlet_WikiPortlet_parentTitle")) {

				rawPageTitle = getGETParameterValue(
					url,
					"_com_liferay_wiki_web_portlet_WikiPortlet_parentTitle");
				wikiPageTitle = rawPageTitle.replace(
					"%20", " ").replace("%3CQUESTION%3E", "?");
			}
			else if (
				url.contains("p_r_p__http%3A%2F%2Fwww.liferay.com%2Fpublic-render-parameters%2Fwiki_title")) {

				rawPageTitle = getGETParameterValue(
					url, "p_r_p__http%3A%2F%2Fwww.liferay.com%2Fpublic-render-parameters%2Fwiki_title");
				wikiPageTitle = rawPageTitle.replace(
					"%20", " ").replace("%3CQUESTION%3E", "?");
			}
			else {
				wikiPageTitle = _themeDisplay.getLayout().getFriendlyURL()
					.replace("/", "").replace("%3CQUESTION%3E", "?");
			}
		} else if (explodedURL.length > 1) {
			wikiPageTitle = 
				explodedURL[explodedURL.length-1].replace("+", " ");
			wikiPageTitle = 
				wikiPageTitle.split("\\?")[0].replace("%3CQUESTION%3E", "?");
		}

		return wikiPageTitle;
	}

	private String getGETParameterValue(String url, String parameterName) {
		String parameterValue = StringUtil.extractLast(url, parameterName + "=");
		parameterValue = StringUtil.extractFirst(parameterValue, "&");

		if (parameterValue != null) {
			return parameterValue;
		}
		else {
			return "";
		}
	}

	private static final String _GROW_URL = "grow.liferay.com";
	private ArrayList<PageLink> _linkedPages;
	private ThemeDisplay _themeDisplay;
	private Log _log = LogFactoryUtil.getLog(LinkedPagesView.class);
}
