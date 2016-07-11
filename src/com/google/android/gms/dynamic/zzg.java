package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public abstract class zzg<T>
{
  private final String zzapA;
  private T zzapB;
  
  protected zzg(String paramString)
  {
    zzapA = paramString;
  }
  
  protected final T zzas(Context paramContext)
    throws zzg.zza
  {
    if (zzapB == null)
    {
      zzx.zzw(paramContext);
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      zzapB = zzd((IBinder)paramContext.loadClass(zzapA).newInstance());
      return (T)zzapB;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  protected abstract T zzd(IBinder paramIBinder);
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */