package com.company.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DataHelper {

	/**
	 * LOG
	 */
	final static Logger logger = Logger.getLogger(DataHelper.class);

	public static synchronized ArrayList<String> getDataList(List<Map<String, String>> data) {
		ArrayList<String> list = new ArrayList<String>();

		for (Map<String, String> i : data) {
			list.addAll(i.values());
		}
		return list;
	}

	/**
	 * Método criado para tratamento de massa nula
	 * 
	 * @author caio.ribeiro
	 * @param data
	 * @return
	 */
	public static synchronized <T> T getData(List<T> data) {
		try {
			return data.get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.error("Massa de dados não foi informada");
			throw new IllegalArgumentException();
		}
	}

}
