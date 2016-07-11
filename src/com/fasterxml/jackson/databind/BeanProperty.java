package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.Named;
import java.lang.annotation.Annotation;

public abstract interface BeanProperty
  extends Named
{
  public abstract void depositSchemaProperty(JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    throws JsonMappingException;
  
  public abstract JsonFormat.Value findFormatOverrides(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public abstract <A extends Annotation> A getContextAnnotation(Class<A> paramClass);
  
  public abstract PropertyName getFullName();
  
  public abstract AnnotatedMember getMember();
  
  public abstract PropertyMetadata getMetadata();
  
  public abstract String getName();
  
  public abstract JavaType getType();
  
  public abstract PropertyName getWrapperName();
  
  public abstract boolean isRequired();
  
  public static class Std
    implements BeanProperty
  {
    protected final Annotations _contextAnnotations;
    protected final AnnotatedMember _member;
    protected final PropertyMetadata _metadata;
    protected final PropertyName _name;
    protected final JavaType _type;
    protected final PropertyName _wrapperName;
    
    public Std(Std paramStd, JavaType paramJavaType)
    {
      this(_name, paramJavaType, _wrapperName, _contextAnnotations, _member, _metadata);
    }
    
    public Std(PropertyName paramPropertyName1, JavaType paramJavaType, PropertyName paramPropertyName2, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember, PropertyMetadata paramPropertyMetadata)
    {
      _name = paramPropertyName1;
      _type = paramJavaType;
      _wrapperName = paramPropertyName2;
      _metadata = paramPropertyMetadata;
      _member = paramAnnotatedMember;
      _contextAnnotations = paramAnnotations;
    }
    
    @Deprecated
    public Std(String paramString, JavaType paramJavaType, PropertyName paramPropertyName, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember, boolean paramBoolean) {}
    
    public void depositSchemaProperty(JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    {
      throw new UnsupportedOperationException("Instances of " + getClass().getName() + " should not get visited");
    }
    
    public JsonFormat.Value findFormatOverrides(AnnotationIntrospector paramAnnotationIntrospector)
    {
      return null;
    }
    
    public <A extends Annotation> A getAnnotation(Class<A> paramClass)
    {
      if (_member == null) {
        return null;
      }
      return _member.getAnnotation(paramClass);
    }
    
    public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
    {
      if (_contextAnnotations == null) {
        return null;
      }
      return _contextAnnotations.get(paramClass);
    }
    
    public PropertyName getFullName()
    {
      return _name;
    }
    
    public AnnotatedMember getMember()
    {
      return _member;
    }
    
    public PropertyMetadata getMetadata()
    {
      return _metadata;
    }
    
    public String getName()
    {
      return _name.getSimpleName();
    }
    
    public JavaType getType()
    {
      return _type;
    }
    
    public PropertyName getWrapperName()
    {
      return _wrapperName;
    }
    
    public boolean isRequired()
    {
      return _metadata.isRequired();
    }
    
    public boolean isVirtual()
    {
      return false;
    }
    
    public Std withType(JavaType paramJavaType)
    {
      return new Std(this, paramJavaType);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.BeanProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */