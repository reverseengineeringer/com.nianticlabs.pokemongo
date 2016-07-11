package com.google.gson.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface SerializedName
{
  String value();
}

/* Location:
 * Qualified Name:     com.google.gson.annotations.SerializedName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */