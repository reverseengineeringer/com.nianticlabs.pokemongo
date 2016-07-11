package com.google.gson.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Expose
{
  boolean deserialize() default true;
  
  boolean serialize() default true;
}

/* Location:
 * Qualified Name:     com.google.gson.annotations.Expose
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */