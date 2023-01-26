package com.example.spingboot.converter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/23 14:42
 */
public class StringFormatter implements Formatter<String> {

        @Override
        public String parse(String text, Locale locale) throws ParseException {
                text = text.replaceAll("\\s*", "");
                if (StringUtils.isEmpty(text)) {
                        return null;
                }
                return text;
        }

        @Override
        public String print(String object, Locale locale) {
                return object;
        }

}
