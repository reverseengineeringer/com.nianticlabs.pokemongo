package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Module
{
  Class<?>[] includes() default {};
}

/* Location:
 * Qualified Name:     dagger.Module
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */