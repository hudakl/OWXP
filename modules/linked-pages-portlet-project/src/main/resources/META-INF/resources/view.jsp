<%@ include file="/init.jsp" %>

<%
String portletNamespace = PortalUtil.getPortletNamespace(LinkedPagesPortletKeys.LINKED_PAGES);

LinkedPagesView linkedPagesView = new LinkedPagesView(themeDisplay);
%>

<div id="#wrapper">
	<div class="closed lfr-admin-panel lfr-product-menu-panel lfr-simulation-panel sidenav-fixed sidenav-menu-slider sidenav-right" id="<%= portletNamespace %>linkedPagesPanelId">
		<div class="product-menu sidebar sidebar-inverse sidenav-menu">

			<h4 class="sidebar-header">
				<span><liferay-ui:message key="linked_pages_portlet_project_LinkedPagesPortlet.caption"/></span>

				<aui:icon cssClass="icon-monospaced sidenav-close" image="times" markupView="lexicon" url="javascript:;" />
			</h4>

			<c:choose>
				<c:when test="<%= linkedPagesView.getLinkedPages().isEmpty() %>">
					<div>
						No Wiki page is available
					</div>
				</c:when>
				<c:otherwise>
					<div>
						Linked Pages:
					</div>
	
					<div class="list-group-item">
						<ul class="nav nav-equal-height">
							<%
							for (String pageTitle : linkedPagesView.getPageTitles()) {
							%>
								<li>
									<a href="<%= linkedPagesView.getLink(pageTitle) %>">
										<%= pageTitle %>
									</a>
								</li>
							<%
							}
							%>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>