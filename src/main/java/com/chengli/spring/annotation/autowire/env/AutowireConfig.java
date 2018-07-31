package com.chengli.spring.annotation.autowire.env;

import com.chengli.spring.annotation.autowire.service.AwareTest;
import com.chengli.spring.annotation.autowire.service.BookDao;
import com.chengli.spring.annotation.autowire.service.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.inject.Inject;

/**
 * @Author: chengli
 * @Date: 2018/7/29 18:18
 * <p>
 * 1.@Autowired自动装配
 * 首先去容器中查找有没有该类型的实例，如果找到多个，再根据属性名字进行匹配【可以使用@Qualifier来明确指定名字】，
 * 如果没找到，默认会报错，可以使用requried=false来控制是否必须。
 * 另外可以使用@Primary来标注哪个实例为首选的。
 * <p>
 * 2. @Resource (JSR250)和 @Inject (JSR330)
 * 1）@Resource 默认按照属性名称来进行装配，不支持@Primary
 * 2）@Inject 需要导入javax.inject的包，和Autowried的功能一样。
 * <p>
 * 3.@Autowired可以用在构造器，属性，方法上，参数位置
 * 当构造器，只有一个有参的构造器时，不用autowried也可以成功注入，也就是@Autowried可以省略
 *
 * 4. @Bean标注的方法，其参数默认从容器中寻找注入
 * @see com.chengli.spring.annotation.autowire.env.AutowireConfig#bookDao(Car)
 *
 * 5. 假如我们想使用Spring提供的一些组件，例如ApplicationContext，我们可以使用xxxAware来实现，例如ApplicationContextAware
 * @see com.chengli.spring.annotation.autowire.service.AwareTest
 * 类似这些功能都是由后置处理器来完成，例如装配ApplicationContext就是由ApplicationContextAwarePropercessor
 */
@Configuration
@ComponentScan(basePackages = {"com.chengli.spring.annotation.autowire"})
public class AutowireConfig {

    @Inject
    public BookDao bookDao3(ApplicationContext applicationContext){
        return bookDao();
    }


    @Primary
    @Bean(name = "bookDao1")
    public BookDao bookDao() {
        return new BookDao();
    }

    /**
     * 形参Car 默认会到spring容器中寻找，自动装配
     */
    @Bean(name = "bookDao2")
    public BookDao bookDao(Car car) {
        return new BookDao();
    }
}
