package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JsonSerializableSchema
{
  public static final String NO_VALUE = "##irrelevant";
  
  String id() default "";
  
  @Deprecated
  String schemaItemDefinition() default "##irrelevant";
  
  @Deprecated
  String schemaObjectPropertiesDefinition() default "##irrelevant";
  
  String schemaType() default "any";
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */