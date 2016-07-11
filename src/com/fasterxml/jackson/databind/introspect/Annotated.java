package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class Annotated
{
  public abstract Iterable<Annotation> annotations();
  
  public abstract boolean equals(Object paramObject);
  
  protected abstract AnnotationMap getAllAnnotations();
  
  public abstract AnnotatedElement getAnnotated();
  
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public abstract Type getGenericType();
  
  protected abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract Class<?> getRawType();
  
  public JavaType getType(TypeBindings paramTypeBindings)
  {
    return paramTypeBindings.resolveType(getGenericType());
  }
  
  public final <A extends Annotation> boolean hasAnnotation(Class<A> paramClass)
  {
    return getAnnotation(paramClass) != null;
  }
  
  public abstract int hashCode();
  
  public final boolean isPublic()
  {
    return Modifier.isPublic(getModifiers());
  }
  
  public abstract String toString();
  
  public abstract Annotated withAnnotations(AnnotationMap paramAnnotationMap);
  
  public final Annotated withFallBackAnnotationsFrom(Annotated paramAnnotated)
  {
    return withAnnotations(AnnotationMap.merge(getAllAnnotations(), paramAnnotated.getAllAnnotations()));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.Annotated
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */