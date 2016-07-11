package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;

public abstract interface JacksonAnnotationValue<A extends Annotation>
{
  public abstract Class<A> valueFor();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JacksonAnnotationValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */