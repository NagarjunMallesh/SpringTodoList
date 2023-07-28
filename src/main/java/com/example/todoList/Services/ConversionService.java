package com.example.todoList.Services;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.convert.Jsr310Converters.StringToLocalDateConverter;
//import org.springframework.format.support.DefaultFormattingConversionService;
//import org.springframework.format.support.FormattingConversionService;
//
//public class ConversionService {
//
//	@Bean 
//	public FormattingConversionService conversionService() {
//
//	  DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//
//	  // Java 8 date converter
//	  
//	  conversionService.addConverter(new StringToLocalDateConverter("yyyy-MM-dd"));
//
//	  // Java 8 datetime converter
//	  conversionService.addConverter(new StringToLocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss"));
//
//	  return conversionService;
//
//	}
//	
//}
