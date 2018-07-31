package com.chengli.spring.annotation.bean.env;

import com.chengli.spring.annotation.bean.custom.condition.ConditionOs;
import com.chengli.spring.annotation.bean.custom.factorybean.ColorFactoryBean;
import com.chengli.spring.annotation.bean.custom.importselector.MyImportSelector;
import com.chengli.spring.annotation.bean.custom.registrar.MyImportBeanDefinitionRegistrar;
import com.chengli.spring.annotation.bean.po.Dog;
import com.chengli.spring.annotation.bean.po.Person;
import com.chengli.spring.annotation.bean.custom.typefilter.CustomFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Author: chengli
 * @Date: 2018/7/29 14:41
 */

/**
 * <p>
 *
 * @Configuration 表示这个类是一个spring的配置类，等同于spring的xml配置文件
 *
 * <p>
 * @Import 1.等同于@Bean，给容器中快速注册一个Bean，可以spring容器中快速注册一个第三方包中类实例
 * 2.此外还可以通过自定义ImportSelector来定义要注册的Bean
 * 3.ImportBeanDefinitionRegistrar导入自定义注册的类到容器
 * <p>
 * @ComponentScan自动扫描指定包下面类，默认扫描@Controller，@Service，@Component，@Repostiry注解的类， <br/>
 * 可以通过添加Filter来定义其他扫描规则 当使用includeFilters的时候，应当将useDefaultFilters的值，置为false
 */
@Import({Dog.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan(basePackages = {"com.chengli.spring.annotation.bean.po"},
        excludeFilters = {
                /**这里配置filter表示排除Dog类，当然还可以通过指定FtiletType为Annotation来过滤指定注解的类，includeFilter同理*/
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {Dog.class}),
                /**排除所有的controller注解的方法*/
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
                /**自定义过滤规则，所有类名字包含ok的都会被排除掉，自定义规则没有注解的类，也同样生效*/
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = {CustomFilter.class})
        })
@Configuration
public class Config {

    /**
     * <pre>
     * @Bean 等同于spring配置文件中的<bean                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               name                                                                                                                                                                                                                                                               =                                                                                                                                                                                                                                                               "                                                                                                                                                                                                                                                               person                                                                                                                                                                                                                                                               "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               class                                                                                                                                                                                                                                                               =                                                                                                                                                                                                                                                               "                                                                                                                                                                                                                                                               *                                                                                                                                                                                                                                                               *                                                                                                                                                                                                                                                               *                                                                                                                                                                                                                                                               "></bean>
     * </pre>
     */
    @Bean
    public Person person() {
        return new Person();
    }

    /**
     * 当ConditionOs条件满足是，才会注册这个Bean
     * 当Conditional标注在类上时，所有的方法都会使用此条件判定
     */
    @Conditional(ConditionOs.class)
    @Bean(name = "Bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    /**
     * 这里返回的实例类型是Color而不是ColorFactoryBean
     * <p>在这里spring会同时注册ColorFactoryBean和Color的实例</p>
     * 如果想获取工厂bean本身，我们需要给Id前加一个&符号，例如applicationContext.getBean("& olorFactoryBean")
     */
    @Bean(name = "color")
    public ColorFactoryBean createColor() {
        return new ColorFactoryBean();
    }
}
