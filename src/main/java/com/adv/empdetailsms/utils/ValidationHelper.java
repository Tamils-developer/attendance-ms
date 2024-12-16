package com.adv.empdetailsms.utils;

import java.util.List;

public final class ValidationHelper {

	public static final boolean isValid(String value) {
		return value != null && !value.isBlank();
	}

	public static final boolean isValidList(List<?> list) {
		return list != null && !list.isEmpty();
	}

	public static final boolean isValidModel(Object obj) {
		return obj != null;
	}

}
