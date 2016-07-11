package crittercism.android;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class j
{
  public static Object a(Field paramField, Object paramObject)
  {
    if (paramField == null) {}
    while (paramField == null) {
      return null;
    }
    paramField.setAccessible(true);
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (ThreadDeath paramField)
    {
      throw paramField;
    }
    catch (Throwable paramField)
    {
      throw new cl("Unable to get value of field", paramField);
    }
  }
  
  public static Field a(Class paramClass1, Class paramClass2)
  {
    Field[] arrayOfField = paramClass1.getDeclaredFields();
    paramClass1 = null;
    int i = 0;
    while (i < arrayOfField.length)
    {
      Object localObject = paramClass1;
      if (paramClass2.isAssignableFrom(arrayOfField[i].getType()))
      {
        if (paramClass1 != null) {
          throw new cl("Field is ambiguous: " + paramClass1.getName() + ", " + arrayOfField[i].getName());
        }
        localObject = arrayOfField[i];
      }
      i += 1;
      paramClass1 = (Class)localObject;
    }
    if (paramClass1 == null) {
      throw new cl("Could not find field matching type: " + paramClass2.getName());
    }
    paramClass1.setAccessible(true);
    return paramClass1;
  }
  
  public static void a(AccessibleObject[] paramArrayOfAccessibleObject)
  {
    int i = 0;
    while (i < paramArrayOfAccessibleObject.length)
    {
      AccessibleObject localAccessibleObject = paramArrayOfAccessibleObject[i];
      if (localAccessibleObject != null) {
        localAccessibleObject.setAccessible(true);
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */