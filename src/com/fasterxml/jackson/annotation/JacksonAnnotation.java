package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface JacksonAnnotation {}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JacksonAnnotation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */