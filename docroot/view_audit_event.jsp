<%@include file="/init.jsp"%>

<liferay-ui:search-container id="auditEvent"
    emptyResultsMessage="there-are-no-entries" delta="20"
    deltaConfigurable="true">

    <liferay-ui:search-container-results>
    <%
        total = AuditEventLocalServiceUtil.getAuditEventsCount();
        results = AuditEventLocalServiceUtil.getAuditEvents(searchContainer.getStart(), searchContainer.getEnd());
        
        searchContainer.setTotal(total);
        searchContainer.setResults(results);
    %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row className="com.liferay.portal.audit.model.AuditEvent"
        keyProperty="auditEventId" modelVar="line">
        <liferay-ui:search-container-column-text name="User ID" property="userId" />
        <liferay-ui:search-container-column-text name="User Name" property="userName" />
        <liferay-ui:search-container-column-text name="Event Type" property="eventType" />
        <liferay-ui:search-container-column-text name="Class Name" property="className" />
        <liferay-ui:search-container-column-text name="Client IP" property="clientIP" />
        <liferay-ui:search-container-column-text name="Create Date" property="createDate" />
        <liferay-ui:search-container-column-text name="Additional Info" property="additionalInfo" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>