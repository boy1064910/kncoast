package com.kncoast.common.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kncoast.common.exception.KnCoastCode;
import com.kncoast.common.exception.KnCoastException;
import com.kncoast.common.exception.KnCoastMessageException;
import com.kncoast.common.i18n.I18nLoader;
import com.kncoast.common.i18n.LocaleLanguage;
import com.kncoast.common.model.ResponseModel;

public class ErrorHandlerCompoent {

	private Logger logger = LoggerFactory.getLogger(getClass());

	I18nLoader il8nLoader;

	public ErrorHandlerCompoent(I18nLoader il8nLoader){
		//init i18nLoader
		this.il8nLoader = il8nLoader;
	}

	public ResponseModel handleError(HttpServletRequest req, Exception e) {
		// get locale language
		String locale = req.getHeader(LocaleLanguage.HEADER_LOCALE);
		if (StringUtils.isEmpty(locale)) {
			locale = LocaleLanguage.en_US.name();
		}
		ResponseModel responseModel = new ResponseModel();

		Enum<?> code = null;
		String message = null;
		String debugMessage = null;

		if (e instanceof KnCoastException) {// DataDeck exception
			code = ((KnCoastException) e).getCode();
			message = il8nLoader.getMessage(locale, code);
			debugMessage = e.getLocalizedMessage();
			// 设置exception的信息，打印错误code
		} else if (e instanceof KnCoastMessageException) {
			code = ((KnCoastMessageException) e).getCode();
			message = ((KnCoastMessageException) e).getMessage();

		} else {// Uncaught exception handler
			code = KnCoastCode.ERROR;
			message = il8nLoader.getMessage(locale, code);
		}
		// write exception message into error log
		logger.error("====Occured exception=====", e);

		// build response result
		responseModel.setCode(code);
		responseModel.setMessage(message);
		responseModel.setDebugMessage(debugMessage);
		return responseModel;
	}
}
