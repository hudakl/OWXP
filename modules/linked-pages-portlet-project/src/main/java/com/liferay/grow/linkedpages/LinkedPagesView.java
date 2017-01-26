package com.liferay.grow.linkedpages;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.liferay.grow.linkedpages.util.PageLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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
		_linkedPages = new ArrayList<PageLink>();
		HttpServletRequest request = themeDisplay.getRequest();

		String wikiNode = ParamUtil.getString(request, "p_r_p__http://www.liferay.com/public-render-parameters/wiki_nodeName");
		String wikiTitle = ParamUtil.getString(request, "p_r_p__http://www.liferay.com/public-render-parameters/wiki_title");
		
		long groupId = themeDisplay.getScopeGroupId();

		fillLinkedPages(groupId, wikiNode, wikiTitle);
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

	private static final String _GROW_URL = "grow.liferay.com";
	private ArrayList<PageLink> _linkedPages;
	private Log _log = LogFactoryUtil.getLog(LinkedPagesView.class);
}
