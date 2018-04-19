package com.yikeo.mypress.common.service;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


public interface MessageService {

    String getMessage(String code);

    String getMessage(String code, String defaultMessage);

    String getMessage(String code, Object[] args);

    String getMessage(String code, Object[] args, String defaultMessage);

    String getMessage(String code, Object[] args, String defaultMessage, Locale locale);

    String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException;

    String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException;

    Locale getLocale();

    Locale getLocale(HttpServletRequest request);

}
