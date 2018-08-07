package com.kncoast.common.exception;

/**
 * KnCoast Exception,Code is the internationalization code, the exception will be handled by {@link com.kncoast.common.bean.ErrorHandlerCompoent}, the prompt information will be automatically obtained from the properties file according to the code.
 * @author xiaopeng.liu
 */
public class KnCoastException extends RuntimeException {

	private static final long serialVersionUID = 514056212915598903L;

	private Enum<?> code;

	/**
	 * KnCoast common exception information.<br>
	 * The msg that the interface caller gets will be the internationalized message for code enum.<br>
	 * @param code		Error message code definition (typically the interface caller needs to be handled separately for the wrong business logic to set this parameter)
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Enum<?> code) {
		super(code.name());
		this.code = code;
	}

	/**
	 * KnCoast common exception information.<br>
	 * The msg that the interface caller gets will be the internationalized message for code enum.<br>
	 * @param code		Error message code definition (typically the interface caller needs to be handled separately for the wrong business logic to set this parameter)
	 * @param debugMessage	Interface returns debug information about the result, helping developers locate error messages
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Enum<?> code, String debugMessage) {
		super(debugMessage);
		this.code = code;
	}

	/**
	 * KnCoast common exception information.
	 * The code from the interface caller will be "BUSINESS_ERROR".<br>
	 * The msg that the interface caller gets will be the internationalized message for "BUSINESS_ERROR".<br>
	 * @param debugMessage	Interface returns debug information about the result, helping developers locate error messages
	 * @author xiaopeng.liu
	 */
	public KnCoastException(String debugMessage) {
		super(debugMessage);
		this.code = KnCoastCode.ERROR;
	}

	/**
	 * KnCoast common exception information.<br>
	 * The code from the interface caller will be "EXCEPTION_ERROR".<br>
	 * The msg that the interface caller gets will be the internationalized message for "EXCEPTION_ERROR".<br>
	 * The debugMessage from the interface caller will be the message of the exception.<br>
	 * @param throwable	exception
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Throwable throwable) {
		super(throwable);
		this.code = KnCoastCode.ERROR;
	}

	/**
	 * KnCoast common exception information.<br>
	 * The msg that the interface caller gets will be the internationalized message for code enum.<br>
	 * @param throwable		exception
	 * @param code			Error message code definition (typically the interface caller needs to be handled separately for the wrong business logic to set this parameter)
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Throwable throwable, Enum<?> code) {
		super(throwable);
		this.code = code;
	}

	/**
	 * KnCoast common exception information.<br>
	 * The code from the interface caller will be "ERROR".<br>
	 * The msg that the interface caller gets will be the internationalized message for "ERROR".<br>
	 * @param throwable		exception
	 * @param debugMessage	Interface returns debug information about the result, helping developers locate error messages
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Throwable throwable, String debugMessage) {
		super(debugMessage,throwable);
		this.code = KnCoastCode.ERROR;
	}

	/**
	 * KnCoast common exception information
	 * @param throwable		exception
	 * @param code			Error message code definition (typically the interface caller needs to be handled separately for the wrong business logic to set this parameter)
	 * @param debugMessage	Interface returns debug information about the result, helping developers locate error messages
	 * @author xiaopeng.liu
	 */
	public KnCoastException(Throwable throwable, Enum<?> code, String debugMessage) {
		super(debugMessage, throwable);
		this.code = code;
	}

	public Enum<?> getCode() {
		return code;
	}

	public void setCode(Enum<?> code) {
		this.code = code;
	}
}
