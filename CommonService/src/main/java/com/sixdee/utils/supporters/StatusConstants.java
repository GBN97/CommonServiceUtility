package com.sixdee.utils.supporters;

/**
 * @author balu.s
 **/

public class StatusConstants {

	public enum HttpConstants {

		SUCCESS(200, "Success"),

		CUSTOM_FIELD_VALIDATION(400, null),
		
		NOT_FOUND(404, null),
		
		UNAUTHORIZED_STATUS_CODE(401, null),
		
		FORBIDDEN_STATUS_CODE(403, null),

		INTERNAL_SERVER_ERROR(500, "System error! Unable to process the request");

		private Integer code;

		private String desc;

		private HttpConstants(Integer code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}

}
