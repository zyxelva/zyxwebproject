package cn.taeyeon.zyx;

import cn.taeyeon.zyx.filter.ResourceBaseUrlFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@ImportResource("classpath:/spring/applicationContext.xml")
public class Main extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Main.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

    @Bean
    public FilterRegistrationBean resourceBaseUrlFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ResourceBaseUrlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("resourceBaseUrlFilter");
        registration.setOrder(2);
        return registration;
    }

//    @Bean
//    public FilterRegistrationBean distributedSessionFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new SessionFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("distributedSessionFilter");
//        registration.setOrder(2);
//        return registration;
//    }
}
