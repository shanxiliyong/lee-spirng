package lee.springframework.beans.factory.annotation;


import java.lang.annotation.*;

/**
 * Marks a constructor, field, setter method or config method as to be
 * autowired by Spring's dependency injection facilities.
 * 标记属性被spirng依赖注入功能装配
 * <p>Only one constructor (at max) of any given bean class may carry this
 * annotation, indicating the constructor to autowire when used as a Spring
 * bean. Such a constructor does not have to be public.
 * 只有一个构造器持有这个注解，表明这个构造器会被装配。不需要公有
 * <p>Fields are injected right after construction of a bean, before any
 * config methods are invoked. Such a config field does not have to be public.
 * 字段在构造之后，配置之前，没必要是公有的
 * <p>Config methods may have an arbitrary name and any number of arguments;
 * each of those arguments will be autowired with a matching bean in the
 * Spring container. Bean property setter methods are effectively just
 * a special case of such a general config method. Such config methods
 * do not have to be public.
 * 配置方法可以是任意名称，有任意参数个数。set方法是一个特殊的配置方法
 * <p>In the case of multiple argument methods, the 'required' parameter is
 * applicable for all arguments.
 *
 * <p>In case of a {@link java.util.Collection} or {@link java.util.Map}
 * dependency type, the container will autowire all beans matching the
 * declared value type. In case of a Map, the keys must be declared as
 * type String and will be resolved to the corresponding bean names.
 * map的可以必须是String类型
 * <p>Note that actual injection is performed through a
 * {@link org.springframework.beans.factory.config.BeanPostProcessor
 * BeanPostProcessor} which in turn means that you <em>cannot</em>
 * use {@code @Autowired} to inject references into
 * {@link org.springframework.beans.factory.config.BeanPostProcessor
 * BeanPostProcessor} or
 * {@link org.springframework.beans.factory.config.BeanFactoryPostProcessor BeanFactoryPostProcessor}
 * types. Please consult the javadoc for the {@link AutowiredAnnotationBeanPostProcessor}
 * class (which, by default, checks for the presence of this annotation).
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @see AutowiredAnnotationBeanPostProcessor
 * @see Qualifier
 * @see Value
 * @since 2.5
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

  /**
   * Declares whether the annotated dependency is required.
   * <p>Defaults to {@code true}.
   */
  boolean required() default true;

}
