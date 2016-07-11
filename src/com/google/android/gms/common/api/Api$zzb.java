package com.google.android.gms.common.api;

import android.os.IBinder;
import com.google.android.gms.common.internal.zzp;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public abstract interface Api$zzb
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

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */