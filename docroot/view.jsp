<%@ include file="/init.jsp" %>

<%
long auditEventId = ParamUtil.getLong(request, "auditEventId");
%>

<h3>Audit Reports</h3>
<portlet:renderURL var="viewURL" />

<c:set var="tabs1" value='<%= ParamUtil.getString(request, "tabs1", "report-events") %>' />

<%-- <liferay-ui:tabs names="report-events, report-page-views" url="${viewURL}" /> --%>

<%-- <c:choose> --%>
<%-- 	<c:when test="${tabs1 == 'report-events'}"> --%>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="<%= auditEventId > 0 %>"> --%>
<%-- 				<liferay-util:include page="/view_audit_event.jsp" servletContext="<%= application %>" /> --%>
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<%-- 				<liferay-util:include page="/search.jsp" servletContext="<%= application %>" /> --%>
<%-- 			</c:otherwise> --%>
<%-- 		</c:choose> --%>
<%-- 	</c:when> --%>
<%-- 	<c:when test="${tabs1 == 'report-page-views'}"> --%>
<%-- 		<liferay-util:include page="/report-page-view.jsp" servletContext="<%= application %>" /> --%>
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<%-- 		<liferay-ui:message key="report-report-not-found"/> --%>
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>

<liferay-util:include page="/view_audit_event.jsp" servletContext="<%= application %>" />