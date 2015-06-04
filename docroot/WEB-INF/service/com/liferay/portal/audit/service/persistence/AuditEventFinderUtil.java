/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.audit.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class AuditEventFinderUtil {
	public static java.lang.Object getReportList(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getReportList(start, end);
	}

	public static AuditEventFinder getFinder() {
		if (_finder == null) {
			_finder = (AuditEventFinder)PortletBeanLocatorUtil.locate(com.liferay.portal.audit.service.ClpSerializer.getServletContextName(),
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

	private static AuditEventFinder _finder;
}