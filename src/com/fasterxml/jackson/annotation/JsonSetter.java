package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD})
public @interface JsonSetter
{
  String value() default "";
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonSetter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */