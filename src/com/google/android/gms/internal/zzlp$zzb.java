package com.google.android.gms.internal;

import android.app.Dialog;
import android.content.IntentSender.SendIntentException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

class zzlp$zzb
  implements Runnable
{
  private final int zzacU;
  private final ConnectionResult zzacV;
  
  public zzlp$zzb(zzlp paramzzlp, int paramInt, ConnectionResult paramConnectionResult)
  {
    zzacU = paramInt;
    zzacV = paramConnectionResult;
  }
  
  public void run()
  {
    if ((!zzlp.zza(zzacT)) || (zzlp.zzb(zzacT))) {
      return;
    }
    zzlp.zza(zzacT, true);
    zzlp.zza(zzacT, zzacU);
    zzlp.zza(zzacT, zzacV);
    if (zzacV.hasResolution()) {
      try
      {
        int i = zzacT.getActivity().getSupportFragmentManager().getFragments().indexOf(zzacT);
        zzacV.startResolutionForResult(zzacT.getActivity(), (i + 1 << 16) + 1);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        zzlp.zzc(zzacT);
        return;
      }
    }
    if (zzlp.zzol().isUserResolvableError(zzacV.getErrorCode()))
    {
      GooglePlayServicesUtil.showErrorDialogFragment(zzacV.getErrorCode(), zzacT.getActivity(), zzacT, 2, zzacT);
      return;
    }
    if (zzacV.getErrorCode() == 18)
    {
      final Dialog localDialog = zzlp.zzol().zza(zzacT.getActivity(), zzacT);
      zzlp.zza(zzacT, zzll.zza(zzacT.getActivity().getApplicationContext(), new zzll()
      {
        protected void zzoi()
        {
          zzlp.zzc(zzacT);
          localDialog.dismiss();
        }
      }));
      return;
    }
    zzlp.zza(zzacT, zzacU, zzacV);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlp.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */