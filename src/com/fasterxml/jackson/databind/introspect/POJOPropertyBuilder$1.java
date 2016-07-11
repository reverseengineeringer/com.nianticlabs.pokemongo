package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$1
  implements POJOPropertyBuilder.WithMember<Class<?>[]>
{
  POJOPropertyBuilder$1(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Class<?>[] withMember(AnnotatedMember paramAnnotatedMember)
  {
    return this$0._annotationIntrospector.findViews(paramAnnotatedMember);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */