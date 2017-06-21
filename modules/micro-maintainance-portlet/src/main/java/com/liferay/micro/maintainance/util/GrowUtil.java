package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

import java.util.List;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class GrowUtil {

	public static final String GLADOS_NAME = "glados";

	public static final String GROW_NAME = "grow";

	public static User getGladosUser() {
		if (_glados == null) {
			_glados = UserLocalServiceUtil.fetchUserByScreenName(
				PortalUtil.getDefaultCompanyId(), GLADOS_NAME);
		}

		return _glados;
	}

	public static WikiNode getGrowNode() {
		if (_grow == null) {
			List<WikiNode> allNodes = WikiNodeLocalServiceUtil.getWikiNodes(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (WikiNode node : allNodes) {
				if (StringUtil.toLowerCase(node.getName()).equals(GROW_NAME)) {
					_grow = node;

					break;
				}
			}
		}

		return _grow;
	}

	private static User _glados = null;
	private static WikiNode _grow = null;

}