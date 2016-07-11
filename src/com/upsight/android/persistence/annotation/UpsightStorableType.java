package com.upsight.android.persistence.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
public @interface UpsightStorableType
{
  String value() default "";
}

/* Location:
 * Qualified Name:     com.upsight.android.persistence.annotation.UpsightStorableType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */