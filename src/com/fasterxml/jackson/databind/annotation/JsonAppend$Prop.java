package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import java.lang.annotation.Annotation;

public @interface JsonAppend$Prop
{
  JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
  
  String name() default "";
  
  String namespace() default "";
  
  boolean required() default false;
  
  Class<?> type() default Object.class;
  
  Class<? extends VirtualBeanPropertyWriter> value();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.annotation.JsonAppend.Prop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */