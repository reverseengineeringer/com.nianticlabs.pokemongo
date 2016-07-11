package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface>
  implements Api.zzb, zzk.zza
{
  public static final String[] zzafI = { "service_esmobile", "service_googleme" };
  private final Context mContext;
  final Handler mHandler;
  private final Account zzQd;
  private final Set<Scope> zzTm;
  private final Looper zzaaO;
  private final GoogleApiAvailability zzaaP;
  private final zzf zzabI;
  private T zzafA;
  private final ArrayList<zzj<T>.zzc<?>> zzafB = new ArrayList();
  private zzj<T>.zze zzafC;
  private int zzafD = 1;
  private final GoogleApiClient.ConnectionCallbacks zzafE;
  private final GoogleApiClient.OnConnectionFailedListener zzafF;
  private final int zzafG;
  protected AtomicInteger zzafH = new AtomicInteger(0);
  private final zzl zzafx;
  private zzs zzafy;
  private GoogleApiClient.zza zzafz;
  private final Object zzpd = new Object();
  
  protected zzj(Context paramContext, Looper paramLooper, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzl.zzal(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzf, (GoogleApiClient.ConnectionCallbacks)zzx.zzw(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzx.zzw(paramOnConnectionFailedListener));
  }
  
  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mContext = ((Context)zzx.zzb(paramContext, "Context must not be null"));
    zzaaO = ((Looper)zzx.zzb(paramLooper, "Looper must not be null"));
    zzafx = ((zzl)zzx.zzb(paramzzl, "Supervisor must not be null"));
    zzaaP = ((GoogleApiAvailability)zzx.zzb(paramGoogleApiAvailability, "API availability must not be null"));
    mHandler = new zzb(paramLooper);
    zzafG = paramInt;
    zzabI = ((zzf)zzx.zzw(paramzzf));
    zzQd = paramzzf.getAccount();
    zzTm = zza(paramzzf.zzoL());
    zzafE = paramConnectionCallbacks;
    zzafF = paramOnConnectionFailedListener;
  }
  
  private Set<Scope> zza(Set<Scope> paramSet)
  {
    Set localSet = zzb(paramSet);
    if (localSet == null) {
      return localSet;
    }
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (zzpd)
    {
      if (zzafD != paramInt1) {
        return false;
      }
      zzb(paramInt2, paramT);
      return true;
    }
  }
  
  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label119;
      }
      j = 1;
      label17:
      if (i != j) {
        break label125;
      }
    }
    for (;;)
    {
      zzx.zzaa(bool);
      for (;;)
      {
        synchronized (zzpd)
        {
          zzafD = paramInt;
          zzafA = paramT;
          zzc(paramInt, paramT);
          switch (paramInt)
          {
          case 2: 
            return;
            zzoX();
          }
        }
        zzoW();
        continue;
        zzoY();
      }
      i = 0;
      break;
      label119:
      j = 0;
      break label17;
      label125:
      bool = false;
    }
  }
  
  private void zzoX()
  {
    if (zzafC != null)
    {
      Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzfK());
      zzafx.zzb(zzfK(), zzafC, zzoV());
      zzafH.incrementAndGet();
    }
    zzafC = new zze(zzafH.get());
    if (!zzafx.zza(zzfK(), zzafC, zzoV()))
    {
      Log.e("GmsClient", "unable to connect to service: " + zzfK());
      mHandler.sendMessage(mHandler.obtainMessage(3, zzafH.get(), 9));
    }
  }
  
  private void zzoY()
  {
    if (zzafC != null)
    {
      zzafx.zzb(zzfK(), zzafC, zzoV());
      zzafC = null;
    }
  }
  
  public void disconnect()
  {
    zzafH.incrementAndGet();
    synchronized (zzafB)
    {
      int j = zzafB.size();
      int i = 0;
      while (i < j)
      {
        ((zzc)zzafB.get(i)).zzpi();
        i += 1;
      }
      zzafB.clear();
      zzb(1, null);
      return;
    }
  }
  
  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        int i = zzafD;
        paramArrayOfString = zzafA;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null) {
            break label137;
          }
          paramPrintWriter.println("null");
          return;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
    }
    label137:
    paramPrintWriter.append(zzfL()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final Looper getLooper()
  {
    return zzaaO;
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzafD == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzafD == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult) {}
  
  protected void onConnectionSuspended(int paramInt) {}
  
  protected abstract T zzW(IBinder paramIBinder);
  
  protected void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(5, paramInt2, -1, new zzi(paramInt1, paramBundle)));
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    mHandler.sendMessage(mHandler.obtainMessage(1, paramInt2, -1, new zzg(paramInt1, paramIBinder, paramBundle)));
  }
  
  public void zza(GoogleApiClient.zza paramzza)
  {
    zzafz = ((GoogleApiClient.zza)zzx.zzb(paramzza, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }
  
  public void zza(zzp paramzzp)
  {
    Bundle localBundle = zzpd();
    paramzzp = new ValidateAccountRequest(paramzzp, (Scope[])zzTm.toArray(new Scope[zzTm.size()]), mContext.getPackageName(), localBundle);
    try
    {
      zzafy.zza(new zzd(this, zzafH.get()), paramzzp);
      return;
    }
    catch (DeadObjectException paramzzp)
    {
      Log.w("GmsClient", "service died");
      zzbE(1);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("GmsClient", "Remote exception occurred", paramzzp);
    }
  }
  
  public void zza(zzp paramzzp, Set<Scope> paramSet)
  {
    try
    {
      Object localObject = zzly();
      localObject = new GetServiceRequest(zzafG).zzcl(mContext.getPackageName()).zzg((Bundle)localObject);
      if (paramSet != null) {
        ((GetServiceRequest)localObject).zzd(paramSet);
      }
      if (zzlN()) {
        ((GetServiceRequest)localObject).zzc(zzoI()).zzc(paramzzp);
      }
      for (;;)
      {
        zzafy.zza(new zzd(this, zzafH.get()), (GetServiceRequest)localObject);
        return;
        if (zzpe()) {
          ((GetServiceRequest)localObject).zzc(zzQd);
        }
      }
      return;
    }
    catch (DeadObjectException paramzzp)
    {
      Log.w("GmsClient", "service died");
      zzbE(1);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("GmsClient", "Remote exception occurred", paramzzp);
    }
  }
  
  protected Set<Scope> zzb(Set<Scope> paramSet)
  {
    return paramSet;
  }
  
  public void zzbE(int paramInt)
  {
    mHandler.sendMessage(mHandler.obtainMessage(4, zzafH.get(), paramInt));
  }
  
  protected void zzbF(int paramInt)
  {
    mHandler.sendMessage(mHandler.obtainMessage(6, paramInt, -1, new zzh()));
  }
  
  protected void zzc(int paramInt, T paramT) {}
  
  protected abstract String zzfK();
  
  protected abstract String zzfL();
  
  public boolean zzlN()
  {
    return false;
  }
  
  protected Bundle zzly()
  {
    return new Bundle();
  }
  
  public Bundle zzmS()
  {
    return null;
  }
  
  public IBinder zznz()
  {
    if (zzafy == null) {
      return null;
    }
    return zzafy.asBinder();
  }
  
  public final Account zzoI()
  {
    if (zzQd != null) {
      return zzQd;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  protected final String zzoV()
  {
    return zzabI.zzoO();
  }
  
  protected void zzoW() {}
  
  public void zzoZ()
  {
    int i = zzaaP.isGooglePlayServicesAvailable(mContext);
    if (i != 0)
    {
      zzb(1, null);
      zzafz = new zzf();
      mHandler.sendMessage(mHandler.obtainMessage(3, zzafH.get(), i));
      return;
    }
    zza(new zzf());
  }
  
  protected final zzf zzpa()
  {
    return zzabI;
  }
  
  protected final void zzpb()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzpc()
    throws DeadObjectException
  {
    synchronized (zzpd)
    {
      if (zzafD == 4) {
        throw new DeadObjectException();
      }
    }
    zzpb();
    if (zzafA != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = zzafA;
      return localIInterface;
    }
  }
  
  protected Bundle zzpd()
  {
    return null;
  }
  
  public boolean zzpe()
  {
    return false;
  }
  
  private abstract class zza
    extends zzj<T>.zzc<Boolean>
  {
    public final int statusCode;
    public final Bundle zzafJ;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      statusCode = paramInt;
      zzafJ = paramBundle;
    }
    
    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        zzj.zza(zzj.this, 1, null);
      }
      do
      {
        return;
        switch (statusCode)
        {
        default: 
          zzj.zza(zzj.this, 1, null);
          paramBoolean = (Boolean)localObject;
          if (zzafJ != null) {
            paramBoolean = (PendingIntent)zzafJ.getParcelable("pendingIntent");
          }
          zzh(new ConnectionResult(statusCode, paramBoolean));
          return;
        }
      } while (zzpf());
      zzj.zza(zzj.this, 1, null);
      zzh(new ConnectionResult(8, null));
      return;
      zzj.zza(zzj.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void zzh(ConnectionResult paramConnectionResult);
    
    protected abstract boolean zzpf();
    
    protected void zzpg() {}
  }
  
  final class zzb
    extends Handler
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private void zza(Message paramMessage)
    {
      paramMessage = (zzj.zzc)obj;
      paramMessage.zzpg();
      paramMessage.unregister();
    }
    
    private boolean zzb(Message paramMessage)
    {
      return (what == 2) || (what == 1) || (what == 5) || (what == 6);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (zzafH.get() != arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((what == 1) || (what == 5) || (what == 6)) && (!isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (what == 3)
      {
        paramMessage = new ConnectionResult(arg2, null);
        zzj.zza(zzj.this).zza(paramMessage);
        onConnectionFailed(paramMessage);
        return;
      }
      if (what == 4)
      {
        zzj.zza(zzj.this, 4, null);
        if (zzj.zzb(zzj.this) != null) {
          zzj.zzb(zzj.this).onConnectionSuspended(arg2);
        }
        onConnectionSuspended(arg2);
        zzj.zza(zzj.this, 4, 1, null);
        return;
      }
      if ((what == 2) && (!isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zzj.zzc)obj).zzph();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle message: " + what, new Exception());
    }
  }
  
  protected abstract class zzc<TListener>
  {
    private TListener mListener;
    private boolean zzafL;
    
    public zzc()
    {
      Object localObject;
      mListener = localObject;
      zzafL = false;
    }
    
    public void unregister()
    {
      zzpi();
      synchronized (zzj.zzc(zzj.this))
      {
        zzj.zzc(zzj.this).remove(this);
        return;
      }
    }
    
    protected abstract void zzpg();
    
    /* Error */
    public void zzph()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/zzj$zzc:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/zzj$zzc:zzafL	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 48
      //   16: new 50	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   23: ldc 53
      //   25: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 62
      //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 76	com/google/android/gms/common/internal/zzj$zzc:zzt	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/common/internal/zzj$zzc:zzafL	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 78	com/google/android/gms/common/internal/zzj$zzc:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzpg	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 80	com/google/android/gms/common/internal/zzj$zzc:zzpg	()V
      //   85: goto -30 -> 55
      //   88: astore_1
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_1
      //   92: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	zzc
      //   6	46	1	localObject1	Object
      //   69	4	1	localObject2	Object
      //   74	6	1	localRuntimeException	RuntimeException
      //   88	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	88	finally
      //   89	91	88	finally
    }
    
    public void zzpi()
    {
      try
      {
        mListener = null;
        return;
      }
      finally {}
    }
    
    protected abstract void zzt(TListener paramTListener);
  }
  
  public static final class zzd
    extends zzr.zza
  {
    private zzj zzafM;
    private final int zzafN;
    
    public zzd(zzj paramzzj, int paramInt)
    {
      zzafM = paramzzj;
      zzafN = paramInt;
    }
    
    private void zzpj()
    {
      zzafM = null;
    }
    
    public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      zzx.zzb(zzafM, "onPostInitComplete can be called only once per call to getRemoteService");
      zzafM.zza(paramInt, paramIBinder, paramBundle, zzafN);
      zzpj();
    }
    
    public void zzb(int paramInt, Bundle paramBundle)
    {
      zzx.zzb(zzafM, "onAccountValidationComplete can be called only once per call to validateAccount");
      zzafM.zza(paramInt, paramBundle, zzafN);
      zzpj();
    }
  }
  
  public final class zze
    implements ServiceConnection
  {
    private final int zzafN;
    
    public zze(int paramInt)
    {
      zzafN = paramInt;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      zzx.zzb(paramIBinder, "Expecting a valid IBinder");
      zzj.zza(zzj.this, zzs.zza.zzaK(paramIBinder));
      zzbF(zzafN);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      mHandler.sendMessage(mHandler.obtainMessage(4, zzafN, 1));
    }
  }
  
  protected class zzf
    implements GoogleApiClient.zza
  {
    public zzf() {}
    
    public void zza(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zza(null, zzj.zzd(zzj.this));
      }
      while (zzj.zze(zzj.this) == null) {
        return;
      }
      zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
    }
    
    public void zzb(ConnectionResult paramConnectionResult)
    {
      throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
  }
  
  protected final class zzg
    extends zzj<T>.zza
  {
    public final IBinder zzafO;
    
    public zzg(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      zzafO = paramIBinder;
    }
    
    protected void zzh(ConnectionResult paramConnectionResult)
    {
      if (zzj.zze(zzj.this) != null) {
        zzj.zze(zzj.this).onConnectionFailed(paramConnectionResult);
      }
      onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzpf()
    {
      do
      {
        try
        {
          String str = zzafO.getInterfaceDescriptor();
          if (!zzfL().equals(str))
          {
            Log.e("GmsClient", "service descriptor mismatch: " + zzfL() + " vs. " + str);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zzW(zzafO);
      } while ((localObject == null) || (!zzj.zza(zzj.this, 2, 3, (IInterface)localObject)));
      Object localObject = zzmS();
      if (zzj.zzb(zzj.this) != null) {
        zzj.zzb(zzj.this).onConnected((Bundle)localObject);
      }
      return true;
    }
  }
  
  protected final class zzh
    extends zzj<T>.zza
  {
    public zzh()
    {
      super(0, null);
    }
    
    protected void zzh(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).zza(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzpf()
    {
      zzj.zza(zzj.this).zza(ConnectionResult.zzZY);
      return true;
    }
  }
  
  protected final class zzi
    extends zzj<T>.zza
  {
    public zzi(int paramInt, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected void zzh(ConnectionResult paramConnectionResult)
    {
      zzj.zza(zzj.this).zzb(paramConnectionResult);
      onConnectionFailed(paramConnectionResult);
    }
    
    protected boolean zzpf()
    {
      zzj.zza(zzj.this).zzb(ConnectionResult.zzZY);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */