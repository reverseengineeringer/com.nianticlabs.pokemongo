package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;

abstract class ManagedVariableModel<T>
{
  @UpsightStorableIdentifier
  String id;
  @JsonProperty("tag")
  String tag;
  @JsonProperty("value")
  T value;
  
  public String getTag()
  {
    return tag;
  }
  
  public T getValue()
  {
    return (T)value;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.ManagedVariableModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */