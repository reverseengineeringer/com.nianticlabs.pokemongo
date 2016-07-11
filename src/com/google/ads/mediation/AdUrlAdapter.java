package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;

public final class AdUrlAdapter
  extends AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  public String getAdUnitId(Bundle paramBundle)
  {
    return "adurl";
  }
  
  protected Bundle zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 != null) {}
    for (;;)
    {
      paramBundle1.putBundle("sdk_less_server_data", paramBundle2);
      paramBundle1.putBoolean("_noRefresh", true);
      return paramBundle1;
      paramBundle1 = new Bundle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AdUrlAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */