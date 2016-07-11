package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;

public @interface JsonSubTypes$Type
{
  String name() default "";
  
  Class<?> value();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonSubTypes.Type
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */