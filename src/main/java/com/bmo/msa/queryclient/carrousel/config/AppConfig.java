package com.bmo.msa.queryclient.carrousel.config;

import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtil;
import com.pichincha.centrodigital.app.libcorelogger.service.LoggerUtilImp;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AppConfig {

    @Value("${SENSITIVE_DATA_LIST}")
    private String sensitiveDataList;
    private List<String> loadSensitiveDataList() {
        return  Stream.of(Optional.ofNullable(sensitiveDataList).orElse("").split(",")).distinct().collect(Collectors.toList()) ;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LoggerUtil logger(InjectionPoint injectionPoint) {
        return LoggerUtilImp.getInstance().sensitiveDataList(loadSensitiveDataList()).setLoggerClass(Optional.of(injectionPoint.getMember())
                .map(Member::getDeclaringClass).orElseThrow(IllegalArgumentException::new));
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
