package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$1
{
  FieldNamingPolicy$1()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return paramField.getName();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.FieldNamingPolicy.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */