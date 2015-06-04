package com.liferay.portal.audit.service.persistence;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.audit.service.AuditEventLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AuditEventActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AuditEventActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AuditEventLocalServiceUtil.getService());
        setClass(AuditEvent.class);

        setClassLoader(com.liferay.portal.audit.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("auditEventId");
    }
}
