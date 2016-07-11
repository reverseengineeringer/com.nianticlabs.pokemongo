package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$2
{
  FieldNamingPolicy$2()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$100(paramField.getName());
  }
}

/* Location:
 * Qualified Name:     com.google.gson.FieldNamingPolicy.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */