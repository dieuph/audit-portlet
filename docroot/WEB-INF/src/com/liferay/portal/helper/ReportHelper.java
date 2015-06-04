package com.liferay.portal.helper;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;


public final class ReportHelper {

	private ReportHelper() {
		super();
	}

	public static String getNodeXml(final String xml, final String nodeName) {

		String value = StringPool.BLANK;
		
		try {
			final Document document = com.liferay.portal.kernel.xml.SAXReaderUtil.read(xml);
			final Node node = document.selectSingleNode(String.format(TAG, nodeName));
			if (Validator.isNotNull(node) && Validator.isNotNull(node.getText())) {
				return node.getText();
			}
		} catch (DocumentException e) {
			
		}
		
		return value;

	}

	protected static final String TAG = "/root/%s";

}
