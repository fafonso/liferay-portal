/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.util.comparator;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 * @author Alexander Chow
 */
public class FileEntryModifiedDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "modifiedDate ASC";

	public static String ORDER_BY_DESC = "modifiedDate DESC";

	public static String[] ORDER_BY_FIELDS = {"modifiedDate"};

	public FileEntryModifiedDateComparator() {
		this(false);
	}

	public FileEntryModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		Date modifiedDate1;
		Date modifiedDate2;

		if (obj1 instanceof DLFileEntry) {
			modifiedDate1 = ((DLFileEntry)obj1).getModifiedDate();
			modifiedDate2 = ((DLFileEntry)obj2).getModifiedDate();
		}
		else {
			modifiedDate1 = ((FileEntry)obj1).getModifiedDate();
			modifiedDate2 = ((FileEntry)obj2).getModifiedDate();
		}

		int value = DateUtil.compareTo(modifiedDate1, modifiedDate2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}