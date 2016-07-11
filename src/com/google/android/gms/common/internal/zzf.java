package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzqx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  private final Account zzQd;
  private final String zzRq;
  private final Set<Scope> zzaaF;
  private final int zzaaG;
  private final View zzaaH;
  private final String zzaaI;
  private final zzqx zzaaT;
  private final Set<Scope> zzafh;
  private final Map<Api<?>, zza> zzafi;
  private Integer zzafj;
  
  public zzf(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzqx paramzzqx)
  {
    zzQd = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      zzaaF = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      zzafi = paramAccount;
      zzaaH = paramView;
      zzaaG = paramInt;
      zzRq = paramString1;
      zzaaI = paramString2;
      zzaaT = paramzzqx;
      paramAccount = new HashSet(zzaaF);
      paramSet = zzafi.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(nextzzTm);
      }
    }
    zzafh = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzf zzak(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zznB();
  }
  
  public Account getAccount()
  {
    return zzQd;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (zzQd != null) {
      return zzQd.name;
    }
    return null;
  }
  
  public void zza(Integer paramInteger)
  {
    zzafj = paramInteger;
  }
  
  public Set<Scope> zzb(Api<?> paramApi)
  {
    paramApi = (zza)zzafi.get(paramApi);
    if ((paramApi == null) || (zzTm.isEmpty())) {
      return zzaaF;
    }
    HashSet localHashSet = new HashSet(zzaaF);
    localHashSet.addAll(zzTm);
    return localHashSet;
  }
  
  public Account zzoI()
  {
    if (zzQd != null) {
      return zzQd;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public int zzoJ()
  {
    return zzaaG;
  }
  
  public Set<Scope> zzoK()
  {
    return zzaaF;
  }
  
  public Set<Scope> zzoL()
  {
    return zzafh;
  }
  
  public Map<Api<?>, zza> zzoM()
  {
    return zzafi;
  }
  
  public String zzoN()
  {
    return zzRq;
  }
  
  public String zzoO()
  {
    return zzaaI;
  }
  
  public View zzoP()
  {
    return zzaaH;
  }
  
  public zzqx zzoQ()
  {
    return zzaaT;
  }
  
  public Integer zzoR()
  {
    return zzafj;
  }
  
  public static final class zza
  {
    public final Set<Scope> zzTm;
    public final boolean zzafk;
    
    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzx.zzw(paramSet);
      zzTm = Collections.unmodifiableSet(paramSet);
      zzafk = paramBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */