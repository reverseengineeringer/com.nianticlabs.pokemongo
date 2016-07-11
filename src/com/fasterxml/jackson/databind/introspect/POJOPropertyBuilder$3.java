package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$3
  implements POJOPropertyBuilder.WithMember<Boolean>
{
  POJOPropertyBuilder$3(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public Boolean withMember(AnnotatedMember paramAnnotatedMember)
  {
    return this$0._annotationIntrospector.isTypeId(paramAnnotatedMember);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */