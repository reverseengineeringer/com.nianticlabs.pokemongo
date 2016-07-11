package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$6
  implements POJOPropertyBuilder.WithMember<Integer>
{
  POJOPropertyBuilder$6(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Integer withMember(AnnotatedMember paramAnnotatedMember)
  {
    return this$0._annotationIntrospector.findPropertyIndex(paramAnnotatedMember);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */