package cn.taeyeon.zyx.springutil;

/**
 * @author zyx
 * @date 2018/9/25 025 11:10
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanAwareFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringBeanAwareFactory() {
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        applicationContext = applicationContext;
    }

    public static ApplicationContext getBeanFactory() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        if (applicationContext == null) {
            throw new NullPointerException(SpringBeanAwareFactory.class.getName() + "exception:must asign value to the property beaFactory.");
        } else {
            return applicationContext.getBean(name);
        }
    }
}

