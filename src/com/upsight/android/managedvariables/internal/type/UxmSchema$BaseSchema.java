package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UxmSchema$BaseSchema<T>
{
  @JsonProperty("default")
  public T defaultValue;
  @JsonProperty("description")
  public String description;
  @JsonProperty("tag")
  public String tag;
  @JsonProperty("type")
  public String type;
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmSchema.BaseSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */