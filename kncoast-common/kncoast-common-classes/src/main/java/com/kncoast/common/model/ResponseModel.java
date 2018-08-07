package com.kncoast.common.model;


import com.kncoast.common.exception.KnCoastCode;

import java.io.Serializable;

public class ResponseModel implements Serializable {

	private static final long serialVersionUID = 535281142961018368L;
	// result code
	private Enum<?> code = KnCoastCode.SUCCESS;
	// prompt message
	private String message;
	// debug message
	private String debugMessage;
	// data conent
	private Object data;

	public ResponseModel() {
	}

	public ResponseModel(Enum<?> code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseModel(Object data) {
		this.data = data;
	}

	/**
	 * Get result code
	 * @return the code
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public Enum<?> getCode() {
		return code;
	}

	/**
	 * Set result code
	 * @param code the code to set
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public void setCode(Enum<?> code) {
		this.code = code;
	}

	/**
	 * Get debug message
	 * @return the debugMessage
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public String getDebugMessage() {
		return debugMessage;
	}

	/**
	 * Set debug message
	 * @param debugMessage the debugMessage to set
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	/**
	 * Get prompt message
	 * @return the message
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Set prompt message
	 * @param message the message to set
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Get data content
	 * @return the data
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Set data content
	 * @param data the data to set
	 * @author xiaopeng.liu
	 * @version 1.0.0
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
