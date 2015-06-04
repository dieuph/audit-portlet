package com.liferay.portal.audit.service.persistence;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class AuditEventFinderImpl 
	extends BasePersistenceImpl<AuditEvent> implements AuditEventFinder {

	public Object getReportList(final int start, final int end) throws SystemException {

		Object result = null;
		final Session session = openSession();

		try{

			result =
				QueryUtil.list(getSQLQuery(session), getDialect(), start, end);

		}catch (final Exception e){
			throw new SystemException(e);
		}finally {
			closeSession(session);
		}

		return result;

	}

	protected SQLQuery getSQLQuery(final Session session) {

		final StringBundler sql = new StringBundler(9);

		sql.append(" select ");
		sql.append(" 	Audit_AuditEvent.userName, ");
		sql.append(" 	AssetEntry.title, ");
		sql.append(" 	count(Audit_AuditEvent.className) as qtd ");
		sql.append(" from Audit_AuditEvent, AssetEntry ");
		sql.append(" where Audit_AuditEvent.eventType = ? ");
		sql.append(" and Audit_AuditEvent.classPK = AssetEntry.classPK ");
		sql.append(" group by Audit_AuditEvent.userName, AssetEntry.title, Audit_AuditEvent.className");
		sql.append(" order by Audit_AuditEvent.userName asc, qtd desc");

		final SQLQuery query = session.createSQLQuery(sql.toString());

		final QueryPos queryPosition = QueryPos.getInstance(query);
		queryPosition.add("VIEW");

		return query;

	}
}
