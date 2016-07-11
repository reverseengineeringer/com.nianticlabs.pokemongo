package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final zzc<?> zzZM;
  private final zza<?, O> zzaav;
  private final zze<?, O> zzaaw;
  private final zzf<?> zzaax;
  
  public <C extends zzb> Api(String paramString, zza<C, O> paramzza, zzc<C> paramzzc)
  {
    zzx.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzx.zzb(paramzzc, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    zzaav = paramzza;
    zzaaw = null;
    zzZM = paramzzc;
    zzaax = null;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public zza<?, O> zznv()
  {
    if (zzaav != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return zzaav;
    }
  }
  
  public zze<?, O> zznw()
  {
    if (zzaaw != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
      return zzaaw;
    }
  }
  
  public zzc<?> zznx()
  {
    if (zzZM != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return zzZM;
    }
  }
  
  public boolean zzny()
  {
    return zzaax != null;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class zza<T extends Api.zzb, O>
  {
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public abstract T zza(Context paramContext, Looper paramLooper, zzf paramzzf, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public List<Scope> zzm(O paramO)
    {
      return Collections.emptyList();
    }
  }
  
  public static abstract interface zzb
  {
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract boolean isConnected();
    
    public abstract void zza(GoogleApiClient.zza paramzza);
    
    public abstract void zza(zzp paramzzp);
    
    public abstract void zza(zzp paramzzp, Set<Scope> paramSet);
    
    public abstract boolean zzlN();
    
    public abstract IBinder zznz();
  }
  
  public static final class zzc<C extends Api.zzb> {}
  
  public static abstract interface zzd<T extends IInterface>
  {
    public abstract T zzW(IBinder paramIBinder);
    
    public abstract void zza(int paramInt, T paramT);
    
    public abstract String zzfK();
    
    public abstract String zzfL();
  }
  
  public static abstract interface zze<T extends Api.zzd, O>
  {
    public abstract T zzn(O paramO);
    
    public abstract int zznA();
  }
  
  public static final class zzf<C extends Api.zzd> {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */