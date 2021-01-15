package io.github.mafrawise.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    //criar arquivo messages.properties
    //internacionalizar as msg de erro.
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // se tivesse em pasta colocar o caminho
        messageSource.setDefaultEncoding("ISO-8859-1");
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    @Bean //aplica a validação local
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return  bean;
    }
}
