package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zzb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm
  extends zzl
  implements Handler.Callback
{
  private final Handler mHandler;
  private final HashMap<zza, zzb> zzafY = new HashMap();
  private final zzb zzafZ;
  private final long zzaga;
  private final Context zzqZ;
  
  zzm(Context paramContext)
  {
    zzqZ = paramContext.getApplicationContext();
    mHandler = new Handler(paramContext.getMainLooper(), this);
    zzafZ = zzb.zzqh();
    zzaga = 5000L;
  }
  
  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localzzb;
      synchronized (zzafY)
      {
        localzzb = (zzb)zzafY.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new zzb(paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzcm(paramString);
          zzafY.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = paramzza.isBound();
          return bool;
        }
        mHandler.removeMessages(0, localzzb);
        if (localzzb.zza(paramServiceConnection)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2: 
        localzzb.zzcm(paramString);
        paramzza = localzzb;
        break;
      default: 
        paramzza = localzzb;
      }
    }
  }
  
  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzx.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (zzafY)
    {
      localzzb = (zzb)zzafY.get(paramzza);
      if (localzzb == null) {
        throw new IllegalStateException("Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzzb.zza(paramServiceConnection)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzpn())
    {
      paramzza = mHandler.obtainMessage(0, localzzb);
      mHandler.sendMessageDelayed(paramzza, zzaga);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    zzb localzzb = (zzb)obj;
    synchronized (zzafY)
    {
      if (localzzb.zzpn())
      {
        if (localzzb.isBound()) {
          localzzb.zzcn("GmsClientSupervisor");
        }
        zzafY.remove(zzb.zza(localzzb));
      }
      return true;
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public boolean zza(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return zza(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public void zzb(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    zzb(new zza(paramString1), paramServiceConnection, paramString2);
  }
  
  private static final class zza
  {
    private final String zzPp;
    private final ComponentName zzagb;
    
    public zza(ComponentName paramComponentName)
    {
      zzPp = null;
      zzagb = ((ComponentName)zzx.zzw(paramComponentName));
    }
    
    public zza(String paramString)
    {
      zzPp = zzx.zzcr(paramString);
      zzagb = null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
      } while ((zzw.equal(zzPp, zzPp)) && (zzw.equal(zzagb, zzagb)));
      return false;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { zzPp, zzagb });
    }
    
    public String toString()
    {
      if (zzPp == null) {
        return zzagb.flattenToString();
      }
      return zzPp;
    }
    
    public Intent zzpm()
    {
      if (zzPp != null) {
        return new Intent(zzPp).setPackage("com.google.android.gms");
      }
      return new Intent().setComponent(zzagb);
    }
  }
  
  private final class zzb
  {
    private int mState;
    private IBinder zzaeJ;
    private ComponentName zzagb;
    private final zza zzagc;
    private final Set<ServiceConnection> zzagd;
    private boolean zzage;
    private final zzm.zza zzagf;
    
    public zzb(zzm.zza paramzza)
    {
      zzagf = paramzza;
      zzagc = new zza();
      zzagd = new HashSet();
      mState = 2;
    }
    
    public IBinder getBinder()
    {
      return zzaeJ;
    }
    
    public ComponentName getComponentName()
    {
      return zzagb;
    }
    
    public int getState()
    {
      return mState;
    }
    
    public boolean isBound()
    {
      return zzage;
    }
    
    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramServiceConnection, paramString, zzagf.zzpm());
      zzagd.add(paramServiceConnection);
    }
    
    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return zzagd.contains(paramServiceConnection);
    }
    
    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zzb(zzm.zzb(zzm.this), paramServiceConnection);
      zzagd.remove(paramServiceConnection);
    }
    
    public void zzcm(String paramString)
    {
      mState = 3;
      zzage = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, zzagf.zzpm(), zzagc, 129);
      if (!zzage) {
        mState = 2;
      }
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), zzagc);
        return;
      }
      catch (IllegalArgumentException paramString) {}
    }
    
    public void zzcn(String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), zzagc);
      zzage = false;
      mState = 2;
    }
    
    public boolean zzpn()
    {
      return zzagd.isEmpty();
    }
    
    public class zza
      implements ServiceConnection
    {
      public zza() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, paramIBinder);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, null);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zzb(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 2);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */