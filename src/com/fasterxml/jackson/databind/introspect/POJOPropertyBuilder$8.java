package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

class POJOPropertyBuilder$8
  implements POJOPropertyBuilder.WithMember<ObjectIdInfo>
{
  POJOPropertyBuilder$8(POJOPropertyBuilder paramPOJOPropertyBuilder) {}
  
  public ObjectIdInfo withMember(AnnotatedMember paramAnnotatedMember)
  {
    ObjectIdInfo localObjectIdInfo2 = this$0._annotationIntrospector.findObjectIdInfo(paramAnnotatedMember);
    ObjectIdInfo localObjectIdInfo1 = localObjectIdInfo2;
    if (localObjectIdInfo2 != null) {
      localObjectIdInfo1 = this$0._annotationIntrospector.findObjectReferenceInfo(paramAnnotatedMember, localObjectIdInfo2);
    }
    return localObjectIdInfo1;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */