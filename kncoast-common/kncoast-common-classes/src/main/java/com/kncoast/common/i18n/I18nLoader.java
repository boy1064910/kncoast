package com.kncoast.common.i18n;

import com.kncoast.common.exception.KnCoastCode;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Internationalized resource loading component
 * @author xiaopeng.liu
 */
public class I18nLoader {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private Map<String, Properties> localePropertyMap;// Internationalized resource program cache map

	public I18nLoader() {
		//init to load all properties
		this.init();
	}
	
	private void init() {
		this.localePropertyMap = new HashMap<String, Properties>();

		for(LocaleLanguage localeLanguage:LocaleLanguage.values()){
			try {
				PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
				Resource[] resources = resolver.getResources("classpath*:i18n/resource_*_" + localeLanguage.name() + ".properties");
				Properties properties = new Properties();
				if (!ArrayUtils.isEmpty(resources)) {
					for (Resource resource : resources) {
						logger.info("Load i18n resource file:" + resource.getFilename());
						PropertiesLoaderUtils.fillProperties(properties, resource);
					}
				}
				localePropertyMap.put(localeLanguage.name(), properties);
			} catch (Exception e) {
				logger.error("load resource error,please check your properties!", e);
				System.exit(0);
			}
		}
	}

	/**
	 * Add international resources
	 * @param locale			locale language,see {@link com.kncoast.common.i18n.LocaleLanguage}
	 * @param propertiesMap		Upcoming international resources
	 * @author xiaopeng.liu
	 */
	public void addProperties(String locale, Map<String, String> propertiesMap) {
		if (localePropertyMap.containsKey(locale)) {
			for (Entry<String, String> entry : propertiesMap.entrySet()) {
				localePropertyMap.get(locale).setProperty(entry.getKey(), entry.getValue());
			}
		}
	}

	public void reload() {
		this.init();
	}
	
	/**
	 * Get properties in locale language
	 * @param locale	locale language
	 * @return	properties in locale language
	 */
	public Properties getPropertiesByLocale(String locale) {
		String localeLanguage = LocaleLanguage.getLocale(locale);
		return localePropertyMap.get(localeLanguage);
	}

	/**
	 * Get promotion message.
	 * @param locale	locale language
	 * @param code		promotion code
	 * @return	promotion message
	 */
	public String getMessage(String locale,Enum<?> code){
		return getMessage(locale,code.name());
	}

	/**
	 * Get promotion message.
	 * @param locale	locale language
	 * @param code		promotion code
	 * @return	promotion message
	 * @author xiaopeng.liu
	 */
	public String getMessage(String locale,String code){
		Properties properties = this.getPropertiesByLocale(locale);
		String errorMsg = properties.getProperty(code);
		if(StringUtils.isEmpty(errorMsg)) {
			return properties.getProperty(KnCoastCode.ERROR.name());
		}
		return properties.getProperty(code);
	}
}
