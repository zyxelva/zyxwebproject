/**
 * @author zyx
 * @date 2018/9/25 025 11:08
 */
package cn.taeyeon.zyx.springutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public ApplicationContextHolder() {
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getBeanFactory() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        if (applicationContext == null) {
            throw new NullPointerException(SpringBeanAwareFactory.class.getName() + "exception:must asign value to the ApplicationContextHolder.");
        } else {
            return applicationContext.getBean(name);
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            throw new NullPointerException(SpringBeanAwareFactory.class.getName() + "exception:must asign value to the ApplicationContextHolder.");
        } else {
            return applicationContext.getBean(clazz);
        }
    }
}

