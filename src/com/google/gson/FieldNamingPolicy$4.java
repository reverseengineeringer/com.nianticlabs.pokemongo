package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$4
{
  FieldNamingPolicy$4()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$200(paramField.getName(), "_").toLowerCase();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.FieldNamingPolicy.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */