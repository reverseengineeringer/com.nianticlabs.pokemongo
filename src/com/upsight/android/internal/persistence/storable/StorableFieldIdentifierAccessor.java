package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;
import java.lang.reflect.Field;

class StorableFieldIdentifierAccessor
  implements StorableIdentifierAccessor
{
  private final Field mField;
  
  StorableFieldIdentifierAccessor(Field paramField)
  {
    if (paramField == null) {
      throw new IllegalArgumentException("Specified Field can not be null.");
    }
    mField = paramField;
  }
  
  public String getId(Object paramObject)
    throws UpsightException
  {
    try
    {
      mField.setAccessible(true);
      paramObject = (String)mField.get(paramObject);
      return (String)paramObject;
    }
    catch (Exception paramObject)
    {
      throw new UpsightException("Error accessing field: " + mField, new Object[] { paramObject });
    }
    finally
    {
      mField.setAccessible(false);
    }
  }
  
  public void setId(Object paramObject, String paramString)
    throws UpsightException
  {
    try
    {
      mField.setAccessible(true);
      mField.set(paramObject, paramString);
      return;
    }
    catch (Exception paramObject)
    {
      throw new UpsightException("Error accessing field: " + mField, new Object[] { paramObject });
    }
    finally
    {
      mField.setAccessible(false);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableFieldIdentifierAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */