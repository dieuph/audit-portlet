package com.liferay.portal.audit.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AuditEventFinderUtil {
    private static AuditEventFinder _finder;

    public static java.lang.Object getReportList(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getReportList(start, end);
    }

    public static AuditEventFinder getFinder() {
        if (_finder == null) {
            _finder = (AuditEventFinder) PortletBeanLocatorUtil.locate(com.liferay.portal.audit.service.ClpSerializer.getServletContextName(),
                    AuditEventFinder.class.getName());

            ReferenceRegistry.registerReference(AuditEventFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(AuditEventFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(AuditEventFinderUtil.class,
            "_finder");
    }
}
