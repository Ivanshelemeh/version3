package org.itstep.msk.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;




@Configuration
public class MainConfiguration  {


    @Bean
    public SpringResourceTemplateResolver thymeleafresolev(){
       final SpringResourceTemplateResolver resolver= new SpringResourceTemplateResolver();
       resolver.setPrefix("classpath:/templates/");
       resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
   }







}
