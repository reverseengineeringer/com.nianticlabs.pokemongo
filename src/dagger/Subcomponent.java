package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Subcomponent
{
  Class<?>[] modules() default {};
}

/* Location:
 * Qualified Name:     dagger.Subcomponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */