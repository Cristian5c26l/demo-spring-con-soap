package com.example.demospringwithsoap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration(proxyBeanMethods = false)
public class WebServiceConfig {

    // Expone el WSDL automáticamente en http://localhost:8080/services/bankAccounts.wsdl
    @Bean
    public DefaultWsdl11Definition bankAccounts(SimpleXsdSchema bankAccount) {// bean o instancia para XsdSchema, que en este caso el bean es SimpleXsdSChema, tiene el mismo nombre "bankAccount" que tiene el archivo .xsd ubicado en META-INF/schemas
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BankAccountPort");
        wsdl11Definition.setLocationUri("/services");
        wsdl11Definition.setTargetNamespace("http://example.com/demospringwithsoap");
        wsdl11Definition.setSchema(bankAccount);
        return wsdl11Definition;
    }

    // 3. Carga archivo XSD (reemplazado por spring.webservices.wsdl-locations=classpath:META-INF/schemas/ en application.properties. Este crea el bean SimpleXsdSchema para XsdSchema)
    /*@Bean
    public XsdSchema calculatorSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calculator.xsd"));
    }*/
}
