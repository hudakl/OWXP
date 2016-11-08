<%@ include file="/init.jsp" %>

<%
String portletNamespace = PortalUtil.getPortletNamespace(LinkedPagesPortletKeys.LINKED_PAGES);

PortletURL linkedPagesPanelURL = PortletURLFactoryUtil.create(request, LinkedPagesPortletKeys.LINKED_PAGES, PortletRequest.RENDER_PHASE);

linkedPagesPanelURL.setWindowState(LiferayWindowState.EXCLUSIVE);
%>

<li class="control-menu-nav-item">
		<a class="control-menu-icon lfr-portal-tooltip product-menu-toggle sidenav-toggler" 
			data-qa-id="Linked Pages" data-content="body" data-title="Linked Pages" data-toggle="sidenav" 
			data-url="<%= linkedPagesPanelURL.toString() %>"
			href="#<%= portletNamespace %>linkedPagesPanelId" id="<%= portletNamespace %>linkedPagesToggleId">

			<aui:icon image="link" markupView="lexicon" />

		</a>
</li>