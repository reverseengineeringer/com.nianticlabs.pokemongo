package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.lang.annotation.Annotation;

public @interface JsonAppend$Attr
{
  JsonInclude.Include include() default JsonInclude.Include.NON_NULL;
  
  String propName() default "";
  
  String propNamespace() default "";
  
  boolean required() default false;
  
  String value();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.annotation.JsonAppend.Attr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */