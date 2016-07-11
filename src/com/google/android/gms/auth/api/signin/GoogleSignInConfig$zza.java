package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.common.api.Scope;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class GoogleSignInConfig$zza
{
  private Account zzQd;
  private boolean zzTi;
  private boolean zzTj;
  private boolean zzTk;
  private String zzTl;
  private Set<Scope> zzTm = new HashSet(Arrays.asList(new Scope[] { GoogleSignInConfig.zzTg }));
  
  public GoogleSignInConfig zzmc()
  {
    return new GoogleSignInConfig(zzTm, zzQd, zzTi, zzTj, zzTk, zzTl, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInConfig.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */