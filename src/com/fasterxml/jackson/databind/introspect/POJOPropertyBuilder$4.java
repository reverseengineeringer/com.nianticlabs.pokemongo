package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$4
  implements POJOPropertyBuilder.WithMember<Boolean>
{
  POJOPropertyBuilder$4(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Boolean withMember(AnnotatedMember paramAnnotatedMember)
  {
    return this$0._annotationIntrospector.hasRequiredMarker(paramAnnotatedMember);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */