package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlr<T>
{
  private static zza zzadc = null;
  private static int zzadd = 0;
  private static String zzade = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzpy = new Object();
  private T zzOX = null;
  protected final String zzue;
  protected final T zzuf;
  
  protected zzlr(String paramString, T paramT)
  {
    zzue = paramString;
    zzuf = paramT;
  }
  
  public static boolean isInitialized()
  {
    return zzadc != null;
  }
  
  public static zzlr<Float> zza(String paramString, Float paramFloat)
  {
    new zzlr(paramString, paramFloat)
    {
      protected Float zzcc(String paramAnonymousString)
      {
        return zzlr.zzoq().zzb(zzue, (Float)zzuf);
      }
    };
  }
  
  public static zzlr<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzlr(paramString, paramInteger)
    {
      protected Integer zzcb(String paramAnonymousString)
      {
        return zzlr.zzoq().zzb(zzue, (Integer)zzuf);
      }
    };
  }
  
  public static zzlr<Long> zza(String paramString, Long paramLong)
  {
    new zzlr(paramString, paramLong)
    {
      protected Long zzca(String paramAnonymousString)
      {
        return zzlr.zzoq().getLong(zzue, (Long)zzuf);
      }
    };
  }
  
  public static zzlr<Boolean> zzg(String paramString, boolean paramBoolean)
  {
    new zzlr(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzbZ(String paramAnonymousString)
      {
        return zzlr.zzoq().zzb(zzue, (Boolean)zzuf);
      }
    };
  }
  
  public static int zzoo()
  {
    return zzadd;
  }
  
  public static zzlr<String> zzu(String paramString1, String paramString2)
  {
    new zzlr(paramString1, paramString2)
    {
      protected String zzcd(String paramAnonymousString)
      {
        return zzlr.zzoq().getString(zzue, (String)zzuf);
      }
    };
  }
  
  public final T get()
  {
    if (zzOX != null) {
      return (T)zzOX;
    }
    return (T)zzbY(zzue);
  }
  
  protected abstract T zzbY(String paramString);
  
  public final T zzop()
  {
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = get();
      return (T)localObject1;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zzb(String paramString, Boolean paramBoolean);
    
    public abstract Float zzb(String paramString, Float paramFloat);
    
    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */