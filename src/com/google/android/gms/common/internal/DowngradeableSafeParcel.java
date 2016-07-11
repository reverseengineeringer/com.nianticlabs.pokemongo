package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel
  implements SafeParcelable
{
  private static final Object zzafm = new Object();
  private static ClassLoader zzafn = null;
  private static Integer zzafo = null;
  private boolean zzafp = false;
  
  private static boolean zza(Class<?> paramClass)
  {
    try
    {
      boolean bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool;
    }
    catch (IllegalAccessException paramClass)
    {
      return false;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  protected static boolean zzck(String paramString)
  {
    ClassLoader localClassLoader = zzoS();
    if (localClassLoader == null) {
      return true;
    }
    try
    {
      boolean bool = zza(localClassLoader.loadClass(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  protected static ClassLoader zzoS()
  {
    synchronized (zzafm)
    {
      ClassLoader localClassLoader = zzafn;
      return localClassLoader;
    }
  }
  
  protected static Integer zzoT()
  {
    synchronized (zzafm)
    {
      Integer localInteger = zzafo;
      return localInteger;
    }
  }
  
  protected boolean zzoU()
  {
    return zzafp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.DowngradeableSafeParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */