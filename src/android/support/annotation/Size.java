package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
public @interface Size
{
  long max() default Long.MAX_VALUE;
  
  long min() default Long.MIN_VALUE;
  
  long multiple() default 1L;
  
  long value() default -1L;
}

/* Location:
 * Qualified Name:     android.support.annotation.Size
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */