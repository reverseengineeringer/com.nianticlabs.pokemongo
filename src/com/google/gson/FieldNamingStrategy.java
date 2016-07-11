package com.google.gson;

import java.lang.reflect.Field;

public abstract interface FieldNamingStrategy
{
  public abstract String translateName(Field paramField);
}

/* Location:
 * Qualified Name:     com.google.gson.FieldNamingStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */