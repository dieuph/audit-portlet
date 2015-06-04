<%@include file="/init.jsp" %>

<%@taglib uri="http://www.liferay.com" prefix="s" %>

<c:set var="list" value="<%= AuditEventLocalServiceUtil.getReportList(-1, -1) %>" />
<c:set var="listSize" value="${list.size()}" />

<liferay-ui:search-container id="auditEvent" emptyResultsMessage="there-are-no-entries" 
    delta="20" deltaConfigurable="true">
    
    <liferay-ui:search-container-results results="${list}"
        total="${listSize}" />
    
    <liferay-ui:search-container-row className="java.lang.Object"
        escapedModel="true" modelVar="line">
        <liferay-ui:search-container-column-text name="userName">
            <c:choose>
                <c:when test="${line[0] eq null || line[0] eq ''}">
                    <liferay-ui:message key="user-gest" />
                </c:when>
                <c:otherwise>
                ${line[0]}
            </c:otherwise>
            </c:choose>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="assetTitle"
            value="${s:getNodeXml(line[1], 'Title')}" />
        <liferay-ui:search-container-column-text name="quantity"
            value="${line[2]}" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
