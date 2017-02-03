package com.liferay.grow.linkedpages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.liferay.grow.linkedpages.util.PageLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
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
		_linkedPages = new TreeSet<PageLink>();
		HttpServletRequest request = themeDisplay.getRequest();

		String wikiNode = ParamUtil.getString(request, "p_r_p__http://www.liferay.com/public-render-parameters/wiki_nodeName");
		String wikiTitle = ParamUtil.getString(request, "p_r_p__http://www.liferay.com/public-render-parameters/wiki_title");
		
		long groupId = themeDisplay.getScopeGroupId();

		fillLinkedPages(groupId, wikiNode, wikiTitle);
	}

	public ArrayList<PageLink> getLinkedPages() {
		ArrayList<PageLink> linkedPages = new ArrayList<PageLink>();

		linkedPages.addAll(_linkedPages);

		return linkedPages;
	}

	public void fillLinkedPages(long groupId, String nodeTitle, String pageTitle) {
		try {
			long nodeId = WikiNodeLocalServiceUtil.getNode(
				groupId, nodeTitle).getNodeId();

			WikiPage wikiPage = WikiPageLocalServiceUtil.getPage(
				nodeId, pageTitle);
			String content = wikiPage.getContent();

			if (wikiPage.getFormat().equals("creole")) {
				addLinksCreole(content);
			}
			else if (wikiPage.getFormat().equals("html")) {
				addLinksHTML(content);
			}
			else if (wikiPage.getFormat().equals("markdown")) {
				addLinksCreole(content);
			}

		} catch (PortalException e) {
			_log.debug(e.getMessage());
		}
	}

	private void addLinksCreole(String content) {
		while(content.indexOf("]]") > 0) {
			String link = content.substring(
				content.indexOf("[[")+2, content.indexOf("|"));

			addLink(link);

			content = content.substring(content.indexOf("]]")+2);
		}
	}

	private void addLinksHTML(String content) {
		while(content.indexOf("</a>") > 0) {
			String link = content.substring(content.indexOf("href=\"")+6); 
			link = link.substring(0, link.indexOf("\">"));

			addLink(link);

			content = content.substring(content.indexOf("</a>")+4);
		}
	}

	private void addLinksMarkdown(String content) {
	}

	private void addLink(String link) {
		if (link.contains(_GROW_URL)) {
			String title = link.substring(link.lastIndexOf('/')+1);

			title = title.replace('+', CharPool.SPACE);

			_linkedPages.add(
				new PageLink(title, link));
		}
	}

	private static final String _GROW_URL = "grow.liferay.com";
	private TreeSet<PageLink> _linkedPages;
	private Log _log = LogFactoryUtil.getLog(LinkedPagesView.class);
}
