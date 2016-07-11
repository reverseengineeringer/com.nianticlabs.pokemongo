package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$7
  implements POJOPropertyBuilder.WithMember<String>
{
  POJOPropertyBuilder$7(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public String withMember(AnnotatedMember paramAnnotatedMember)
  {
    return this$0._annotationIntrospector.findPropertyDefaultValue(paramAnnotatedMember);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */