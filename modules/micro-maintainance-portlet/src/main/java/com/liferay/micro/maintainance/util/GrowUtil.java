package com.liferay.micro.maintainance.util;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

public class GrowUtil {

	public static User getGladosUser() {
		if (_glados == null) {
			_glados = UserLocalServiceUtil.fetchUserByScreenName(
				PortalUtil.getDefaultCompanyId(), GLADOS_NAME);
		}

		return _glados;
	}

	public static WikiNode getGrowNode() {
		if (_grow == null) {
			List<WikiNode> allNodes = WikiNodeLocalServiceUtil
				.getWikiNodes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for(WikiNode node : allNodes) {
				if (node.getName().toLowerCase().equals(GROW_NAME)) {
					_grow = node;

					break;
				}
			}
		}

		return _grow;
	}

	public static final String GLADOS_NAME = "glados";
	public static final String GROW_NAME = "grow";

	private static User _glados = null;
	private static WikiNode _grow = null;
}
