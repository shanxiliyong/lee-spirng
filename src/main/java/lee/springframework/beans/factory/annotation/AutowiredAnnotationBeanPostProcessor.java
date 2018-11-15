/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: AutowiredAnnotationBeanPostProcessor.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/8/28
 */

package lee.springframework.beans.factory.annotation;

/**
 * {@link org.springframework.beans.factory.config.BeanPostProcessor} implementation
 * that autowires annotated fields, setter methods and arbitrary config methods.
 * Such members to be injected are detected through a Java 5 annotation: by default,
 * Spring's {@link Autowired @Autowired} and {@link Value @Value} annotations.
 *  BeanPostProcessor 的实现类。成员通过注解发现然后注入
 * <p>Also supports JSR-330's {@link javax.inject.Inject @Inject} annotation,
 * if available, as a direct alternative to Spring's own {@code @Autowired}.
 *
 * <p>Only one constructor (at max) of any given bean class may carry this
 * annotation with the 'required' parameter set to {@code true},
 *  只有一个构造器持主键属性required==true
 * indicating <i>the</i> constructor to autowire when used as a Spring bean.
 * If multiple <i>non-required</i> constructors carry the annotation, they
 * will be considered as candidates for autowiring.
 * 如果有多个就是候选
 * The constructor with
 * the greatest number of dependencies that can be satisfied by matching
 * beans in the Spring container will be chosen.
 * 匹配最多依赖的构造器被选择
 * If none of the candidates
 * can be satisfied, then a default constructor (if present) will be used.
 * 如果没有一个满足，默认的构造器被使用
 * An annotated constructor does not have to be public.
 * 构造器不需要是公有的
 *
 * <p>Fields are injected right after construction of a bean, before any
 * config methods are invoked. Such a config field does not have to be public.
 *
 * <p>Config methods may have an arbitrary name and any number of arguments; each of
 * those arguments will be autowired with a matching bean in the Spring container.
 * Bean property setter methods are effectively just a special case of such a
 * general config method. Config methods do not have to be public.
 *
 * <p>Note: A default AutowiredAnnotationBeanPostProcessor will be registered
 * by the "context:annotation-config" and "context:component-scan" XML tags.
 * AutowiredAnnotationBeanPostProcessor 被context:annotation-config标签注册
 * Remove or turn off the default annotation configuration there if you intend
 * to specify a custom AutowiredAnnotationBeanPostProcessor bean definition.
 *  如果指定自定义的AutowiredAnnotationBeanPostProcessor，移除默认的
 * <p><b>NOTE:</b> Annotation injection will be performed <i>before</i> XML injection;
 * thus the latter configuration will override the former for properties wired through
 * both approaches.
 *  注解注入先于xml注入，因此后者配置的会覆盖前者
 * <p>In addition to regular injection points as discussed above, this post-processor
 * also handles Spring's {@link Lookup @Lookup} annotation which identifies lookup
 * methods to be replaced by the container at runtime. This is essentially a type-safe
 * version of {@code getBean(Class, args)} and {@code getBean(String, args)},
 * See {@link Lookup @Lookup's javadoc} for details.
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Stephane Nicoll
 * @since 2.5
 * @see #setAutowiredAnnotationType
 * @see Autowired
 * @see Value
 */
public class AutowiredAnnotationBeanPostProcessor {
}
