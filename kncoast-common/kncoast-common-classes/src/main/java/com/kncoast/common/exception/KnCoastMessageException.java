package com.kncoast.common.exception;

public class KnCoastMessageException extends RuntimeException {

	private static final long serialVersionUID = 2470472317034530423L;

	private Enum<?> code = KnCoastCode.ERROR;
	private String message;
	private String debugMessage;

	/**
	 * KnCoast common exception information.
	 * The code from the interface caller will be "ERROR".<br>
	 * @param message	message will be shown to user directly.
	 */
	public KnCoastMessageException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * KnCoast common exception information.
	 * The code from the interface caller will be "ERROR".<br>
	 * @param message	message will be shown to user directly.
	 * @param debugMessage	debugMessage will be shown in response.
	 */
	public KnCoastMessageException(String message, String debugMessage) {
		super(message);
		this.message = message;
		this.debugMessage = debugMessage;
	}

	public KnCoastMessageException(String message, Throwable throwable) {
		super(message, throwable);
		this.message = message;
	}

	public KnCoastMessageException(String message, String debugMessage, Throwable throwable) {
		super(message + debugMessage, throwable);
		this.message = message;
		this.debugMessage = debugMessage;
	}

	public Enum<?> getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

}
