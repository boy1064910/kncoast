package com.kncoast.common.i18n;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * locale language definition
 *
 * @author xiaopeng.liu
 */
public enum LocaleLanguage {

    zh_CN, // Chinese Simplified
    en_US, // English
    ja_JP;// Japanese
	
	public final static String HEADER_LOCALE = "Accept-Language"; 

    private static final Logger logger = LoggerFactory.getLogger(LocaleLanguage.class);

    /**
     * According to the parameters to get the internationalization type, the default is English if it can't match or it's null
     *
     * @param locale locale language,see {@link com.kncoast.common.i18n.LocaleLanguage}
     * @return the string value of locale language,see {@link com.kncoast.common.i18n.LocaleLanguage}
     * @author xiaopeng.liu
     */
    public static String getLocale(String locale) {
        if (StringUtils.isEmpty(locale)) {
            return LocaleLanguage.en_US.toString();// default english
        }
        try {
            return LocaleLanguage.valueOf(locale).toString();
        } catch (IllegalArgumentException e) {
            logger.info("LOCALE is unmatch,set default locale:" + locale);
            return LocaleLanguage.en_US.toString();// default english
        }
    }
}
