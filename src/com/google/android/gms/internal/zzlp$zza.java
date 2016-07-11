package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class zzlp$zza
  implements GoogleApiClient.OnConnectionFailedListener
{
  public final int zzacQ;
  public final GoogleApiClient zzacR;
  public final GoogleApiClient.OnConnectionFailedListener zzacS;
  
  public zzlp$zza(zzlp paramzzlp, int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzacQ = paramInt;
    zzacR = paramGoogleApiClient;
    zzacS = paramOnConnectionFailedListener;
    paramGoogleApiClient.registerConnectionFailedListener(this);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zzacQ);
    paramPrintWriter.println(":");
    zzacR.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzlp.zzd(zzacT).post(new zzlp.zzb(zzacT, zzacQ, paramConnectionResult));
  }
  
  public void zzom()
  {
    zzacR.unregisterConnectionFailedListener(this);
    zzacR.disconnect();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */