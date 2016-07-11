package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public abstract interface VisibilityChecker<T extends VisibilityChecker<T>>
{
  public abstract boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember);
  
  public abstract boolean isCreatorVisible(Member paramMember);
  
  public abstract boolean isFieldVisible(AnnotatedField paramAnnotatedField);
  
  public abstract boolean isFieldVisible(Field paramField);
  
  public abstract boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isGetterVisible(Method paramMethod);
  
  public abstract boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isIsGetterVisible(Method paramMethod);
  
  public abstract boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract boolean isSetterVisible(Method paramMethod);
  
  public abstract T with(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T with(JsonAutoDetect paramJsonAutoDetect);
  
  public abstract T withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withFieldVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withSetterVisibility(JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withVisibility(PropertyAccessor paramPropertyAccessor, JsonAutoDetect.Visibility paramVisibility);
  
  @JsonAutoDetect(creatorVisibility=JsonAutoDetect.Visibility.ANY, fieldVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility=JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility=JsonAutoDetect.Visibility.ANY)
  public static class Std
    implements VisibilityChecker<Std>, Serializable
  {
    protected static final Std DEFAULT = new Std((JsonAutoDetect)Std.class.getAnnotation(JsonAutoDetect.class));
    private static final long serialVersionUID = 1L;
    protected final JsonAutoDetect.Visibility _creatorMinLevel;
    protected final JsonAutoDetect.Visibility _fieldMinLevel;
    protected final JsonAutoDetect.Visibility _getterMinLevel;
    protected final JsonAutoDetect.Visibility _isGetterMinLevel;
    protected final JsonAutoDetect.Visibility _setterMinLevel;
    
    public Std(JsonAutoDetect.Visibility paramVisibility)
    {
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT)
      {
        _getterMinLevel = DEFAULT_getterMinLevel;
        _isGetterMinLevel = DEFAULT_isGetterMinLevel;
        _setterMinLevel = DEFAULT_setterMinLevel;
        _creatorMinLevel = DEFAULT_creatorMinLevel;
        _fieldMinLevel = DEFAULT_fieldMinLevel;
        return;
      }
      _getterMinLevel = paramVisibility;
      _isGetterMinLevel = paramVisibility;
      _setterMinLevel = paramVisibility;
      _creatorMinLevel = paramVisibility;
      _fieldMinLevel = paramVisibility;
    }
    
    public Std(JsonAutoDetect.Visibility paramVisibility1, JsonAutoDetect.Visibility paramVisibility2, JsonAutoDetect.Visibility paramVisibility3, JsonAutoDetect.Visibility paramVisibility4, JsonAutoDetect.Visibility paramVisibility5)
    {
      _getterMinLevel = paramVisibility1;
      _isGetterMinLevel = paramVisibility2;
      _setterMinLevel = paramVisibility3;
      _creatorMinLevel = paramVisibility4;
      _fieldMinLevel = paramVisibility5;
    }
    
    public Std(JsonAutoDetect paramJsonAutoDetect)
    {
      _getterMinLevel = paramJsonAutoDetect.getterVisibility();
      _isGetterMinLevel = paramJsonAutoDetect.isGetterVisibility();
      _setterMinLevel = paramJsonAutoDetect.setterVisibility();
      _creatorMinLevel = paramJsonAutoDetect.creatorVisibility();
      _fieldMinLevel = paramJsonAutoDetect.fieldVisibility();
    }
    
    public static Std defaultInstance()
    {
      return DEFAULT;
    }
    
    public boolean isCreatorVisible(AnnotatedMember paramAnnotatedMember)
    {
      return isCreatorVisible(paramAnnotatedMember.getMember());
    }
    
    public boolean isCreatorVisible(Member paramMember)
    {
      return _creatorMinLevel.isVisible(paramMember);
    }
    
    public boolean isFieldVisible(AnnotatedField paramAnnotatedField)
    {
      return isFieldVisible(paramAnnotatedField.getAnnotated());
    }
    
    public boolean isFieldVisible(Field paramField)
    {
      return _fieldMinLevel.isVisible(paramField);
    }
    
    public boolean isGetterVisible(AnnotatedMethod paramAnnotatedMethod)
    {
      return isGetterVisible(paramAnnotatedMethod.getAnnotated());
    }
    
    public boolean isGetterVisible(Method paramMethod)
    {
      return _getterMinLevel.isVisible(paramMethod);
    }
    
    public boolean isIsGetterVisible(AnnotatedMethod paramAnnotatedMethod)
    {
      return isIsGetterVisible(paramAnnotatedMethod.getAnnotated());
    }
    
    public boolean isIsGetterVisible(Method paramMethod)
    {
      return _isGetterMinLevel.isVisible(paramMethod);
    }
    
    public boolean isSetterVisible(AnnotatedMethod paramAnnotatedMethod)
    {
      return isSetterVisible(paramAnnotatedMethod.getAnnotated());
    }
    
    public boolean isSetterVisible(Method paramMethod)
    {
      return _setterMinLevel.isVisible(paramMethod);
    }
    
    public String toString()
    {
      return "[Visibility:" + " getter: " + _getterMinLevel + ", isGetter: " + _isGetterMinLevel + ", setter: " + _setterMinLevel + ", creator: " + _creatorMinLevel + ", field: " + _fieldMinLevel + "]";
    }
    
    public Std with(JsonAutoDetect.Visibility paramVisibility)
    {
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        return DEFAULT;
      }
      return new Std(paramVisibility);
    }
    
    public Std with(JsonAutoDetect paramJsonAutoDetect)
    {
      Std localStd1 = this;
      Std localStd2 = localStd1;
      if (paramJsonAutoDetect != null) {
        localStd2 = localStd1.withGetterVisibility(paramJsonAutoDetect.getterVisibility()).withIsGetterVisibility(paramJsonAutoDetect.isGetterVisibility()).withSetterVisibility(paramJsonAutoDetect.setterVisibility()).withCreatorVisibility(paramJsonAutoDetect.creatorVisibility()).withFieldVisibility(paramJsonAutoDetect.fieldVisibility());
      }
      return localStd2;
    }
    
    public Std withCreatorVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT_creatorMinLevel;
      }
      if (_creatorMinLevel == localVisibility) {
        return this;
      }
      return new Std(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, localVisibility, _fieldMinLevel);
    }
    
    public Std withFieldVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT_fieldMinLevel;
      }
      if (_fieldMinLevel == localVisibility) {
        return this;
      }
      return new Std(_getterMinLevel, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, localVisibility);
    }
    
    public Std withGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT_getterMinLevel;
      }
      if (_getterMinLevel == localVisibility) {
        return this;
      }
      return new Std(localVisibility, _isGetterMinLevel, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
    }
    
    public Std withIsGetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT_isGetterMinLevel;
      }
      if (_isGetterMinLevel == localVisibility) {
        return this;
      }
      return new Std(_getterMinLevel, localVisibility, _setterMinLevel, _creatorMinLevel, _fieldMinLevel);
    }
    
    public Std withSetterVisibility(JsonAutoDetect.Visibility paramVisibility)
    {
      JsonAutoDetect.Visibility localVisibility = paramVisibility;
      if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
        localVisibility = DEFAULT_setterMinLevel;
      }
      if (_setterMinLevel == localVisibility) {
        return this;
      }
      return new Std(_getterMinLevel, _isGetterMinLevel, localVisibility, _creatorMinLevel, _fieldMinLevel);
    }
    
    public Std withVisibility(PropertyAccessor paramPropertyAccessor, JsonAutoDetect.Visibility paramVisibility)
    {
      switch (VisibilityChecker.1.$SwitchMap$com$fasterxml$jackson$annotation$PropertyAccessor[paramPropertyAccessor.ordinal()])
      {
      default: 
        return this;
      case 1: 
        return withGetterVisibility(paramVisibility);
      case 2: 
        return withSetterVisibility(paramVisibility);
      case 3: 
        return withCreatorVisibility(paramVisibility);
      case 4: 
        return withFieldVisibility(paramVisibility);
      case 5: 
        return withIsGetterVisibility(paramVisibility);
      }
      return with(paramVisibility);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.VisibilityChecker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */