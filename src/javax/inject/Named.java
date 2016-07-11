package javax.inject;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Named
{
  String value() default "";
}

/* Location:
 * Qualified Name:     javax.inject.Named
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */