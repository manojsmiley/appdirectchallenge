package com.appdirect.subscription.utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

import com.appdirect.response.AppdirectResponse;
import com.appdirect.subscription.constants.Constants;

public class AppdirectUtils {

	public static int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {

			return 0;
		}
	}
	public static double parseDouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return 0;
		}
	}
	public static double parseLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return 0;
		}
	}

	public static String nextUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getCurrentDateTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	}
	public static String getCurrentDateTime(String format) {
		return new SimpleDateFormat(format).format(new java.util.Date());
	}

	public static AppdirectResponse<?> getAppdirectResponse() {
		return null;
	}
	public static String getStatusMessage(boolean status) {
		if (status)
			return Constants.SUCCESS;
		else
			return Constants.FAIL;
	}
	public static int getStatusCode(boolean status) {
		if (status)
			return Constants.SUCCESS_CODE;
		else
			return Constants.FAIL_CODE;
	}

	public static Date mysqlDateToUtilDate(Timestamp date) {
		// TODO Auto-generated method stub
		return new Date(date.getTime());
	}

}
