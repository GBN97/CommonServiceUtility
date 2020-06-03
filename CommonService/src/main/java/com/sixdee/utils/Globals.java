package com.sixdee.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Basil Jose
 * @version 1.0.0.0
 * @since Dec 12, 2017 : 11:57:08 AM
 */

public class Globals {

	@SuppressWarnings("unchecked")
	public static Map<String, String> jsonToMap(final String json) {
		try {

			Map<String, String> map = new HashMap<String, String>();

			ObjectMapper mapper = new ObjectMapper();

			map = mapper.readValue(json, HashMap.class);

			return map;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Object jsonToObject(final String json, Object t) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, (Class<T>) t);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> jsonStringToList(final String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<T>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> String listTojson(List<T> list) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(list);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> boolean isNull(T reference) {
		if (reference == null || reference.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isInteger(String input) {
		try {
			Integer.valueOf(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isLong(String input) {
		try {
			Long.valueOf(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static double calculatePercentage(double obtained, double total) {
		return obtained * 100 / total;
	}

	public static int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static int getWeekOfMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.WEEK_OF_MONTH);
	}

	public static String setName(String firstName, String lastName) {
		return firstName.concat(" ").concat(lastName != null ? lastName : "");
	}

	public static byte[] serialize(Object obj) {
		if (obj == null)
			return null;
		return asJsonString(obj).getBytes();
	}
	
	public static String deserialize(byte[] data) {
		return new String(data);
	}
	
	public static byte[] serializeObj1(Object obj) {
		ByteArrayOutputStream out = null;
		ObjectOutputStream os = null;
		
		try {
			out = new ByteArrayOutputStream();
			os = new ObjectOutputStream(out);
			os.writeObject(obj);
			return out.toByteArray();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Object deserializeObj(byte[] data) {
		ByteArrayInputStream in = null;
		ObjectInputStream is = null;
		try {
			in = new ByteArrayInputStream(data);
			is = new ObjectInputStream(in);
			return is.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
