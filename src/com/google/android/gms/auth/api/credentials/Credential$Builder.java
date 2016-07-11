package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class Credential$Builder
{
  private String mName;
  private Uri zzSh;
  private List<IdToken> zzSi;
  private String zzSj;
  private String zzSk;
  private String zzSl;
  private String zzSm;
  private final String zzwN;
  
  public Credential$Builder(Credential paramCredential)
  {
    zzwN = Credential.zza(paramCredential);
    mName = Credential.zzb(paramCredential);
    zzSh = Credential.zzc(paramCredential);
    zzSi = Credential.zzd(paramCredential);
    zzSj = Credential.zze(paramCredential);
    zzSk = Credential.zzf(paramCredential);
    zzSl = Credential.zzg(paramCredential);
    zzSm = Credential.zzh(paramCredential);
  }
  
  public Credential$Builder(String paramString)
  {
    zzwN = paramString;
  }
  
  public Credential build()
  {
    if ((!TextUtils.isEmpty(zzSj)) && (!TextUtils.isEmpty(zzSk))) {
      throw new IllegalStateException("Only one of password or accountType may be set");
    }
    return new Credential(3, zzwN, mName, zzSh, zzSi, zzSj, zzSk, zzSl, zzSm);
  }
  
  public Builder setAccountType(String paramString)
  {
    String str = Uri.parse(paramString).getScheme();
    if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str))) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      zzSk = paramString;
      return this;
    }
  }
  
  public Builder setName(String paramString)
  {
    mName = paramString;
    return this;
  }
  
  public Builder setPassword(String paramString)
  {
    zzSj = paramString;
    return this;
  }
  
  public Builder setProfilePictureUri(Uri paramUri)
  {
    zzSh = paramUri;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */