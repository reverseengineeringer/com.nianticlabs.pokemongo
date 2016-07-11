package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Collections;

public abstract class AnnotatedMember
  extends Annotated
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final transient AnnotationMap _annotations;
  protected final transient AnnotatedClass _context;
  
  protected AnnotatedMember(AnnotatedClass paramAnnotatedClass, AnnotationMap paramAnnotationMap)
  {
    _context = paramAnnotatedClass;
    _annotations = paramAnnotationMap;
  }
  
  protected AnnotatedMember(AnnotatedMember paramAnnotatedMember)
  {
    _context = _context;
    _annotations = _annotations;
  }
  
  public final boolean addIfNotPresent(Annotation paramAnnotation)
  {
    return _annotations.addIfNotPresent(paramAnnotation);
  }
  
  public final boolean addOrOverride(Annotation paramAnnotation)
  {
    return _annotations.add(paramAnnotation);
  }
  
  public Iterable<Annotation> annotations()
  {
    if (_annotations == null) {
      return Collections.emptyList();
    }
    return _annotations.annotations();
  }
  
  public final void fixAccess()
  {
    ClassUtil.checkAndFixAccess(getMember());
  }
  
  protected AnnotationMap getAllAnnotations()
  {
    return _annotations;
  }
  
  public AnnotatedClass getContextClass()
  {
    return _context;
  }
  
  public abstract Class<?> getDeclaringClass();
  
  public abstract Member getMember();
  
  public abstract Object getValue(Object paramObject)
    throws UnsupportedOperationException, IllegalArgumentException;
  
  public abstract void setValue(Object paramObject1, Object paramObject2)
    throws UnsupportedOperationException, IllegalArgumentException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */