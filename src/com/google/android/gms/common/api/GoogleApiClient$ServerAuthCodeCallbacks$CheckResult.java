package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public class GoogleApiClient$ServerAuthCodeCallbacks$CheckResult
{
  private Set<Scope> zzTm;
  private boolean zzaaV;
  
  private GoogleApiClient$ServerAuthCodeCallbacks$CheckResult(boolean paramBoolean, Set<Scope> paramSet)
  {
    zzaaV = paramBoolean;
    zzTm = paramSet;
  }
  
  public static CheckResult newAuthNotRequiredResult()
  {
    return new CheckResult(false, null);
  }
  
  public static CheckResult newAuthRequiredResult(Set<Scope> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "A non-empty scope set is required if further auth is needed.");
      return new CheckResult(true, paramSet);
    }
  }
  
  public boolean zznD()
  {
    return zzaaV;
  }
  
  public Set<Scope> zznE()
  {
    return zzTm;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */