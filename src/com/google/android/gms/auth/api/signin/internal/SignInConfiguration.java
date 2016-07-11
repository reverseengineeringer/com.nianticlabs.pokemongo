package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SignInConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzh();
  private static int zzTr = 31;
  final int versionCode;
  private String zzTl;
  private final String zzTs;
  private EmailSignInConfig zzTt;
  private GoogleSignInConfig zzTu;
  private FacebookSignInConfig zzTv;
  private String zzTw;
  
  SignInConfiguration(int paramInt, String paramString1, String paramString2, EmailSignInConfig paramEmailSignInConfig, GoogleSignInConfig paramGoogleSignInConfig, FacebookSignInConfig paramFacebookSignInConfig, String paramString3)
  {
    versionCode = paramInt;
    zzTs = zzx.zzcr(paramString1);
    zzTl = paramString2;
    zzTt = paramEmailSignInConfig;
    zzTu = paramGoogleSignInConfig;
    zzTv = paramFacebookSignInConfig;
    zzTw = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (SignInConfiguration)paramObject;
        if (zzTs.equals(((SignInConfiguration)paramObject).zzme()))
        {
          if (TextUtils.isEmpty(zzTl))
          {
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmb())) {
              continue;
            }
            label45:
            if (!TextUtils.isEmpty(zzTw)) {
              break label127;
            }
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmi())) {
              continue;
            }
            label65:
            if (zzTt != null) {
              break label144;
            }
            if (((SignInConfiguration)paramObject).zzmf() != null) {
              continue;
            }
            label79:
            if (zzTv != null) {
              break label161;
            }
            if (((SignInConfiguration)paramObject).zzmh() != null) {
              continue;
            }
          }
          for (;;)
          {
            if (zzTu != null) {
              break label178;
            }
            if (((SignInConfiguration)paramObject).zzmg() != null) {
              break;
            }
            break label200;
            if (!zzTl.equals(((SignInConfiguration)paramObject).zzmb())) {
              break;
            }
            break label45;
            label127:
            if (!zzTw.equals(((SignInConfiguration)paramObject).zzmi())) {
              break;
            }
            break label65;
            label144:
            if (!zzTt.equals(((SignInConfiguration)paramObject).zzmf())) {
              break;
            }
            break label79;
            label161:
            if (!zzTv.equals(((SignInConfiguration)paramObject).zzmh())) {
              break;
            }
          }
          label178:
          boolean bool = zzTu.equals(((SignInConfiguration)paramObject).zzmg());
          if (!bool) {}
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label200:
    return true;
  }
  
  public int hashCode()
  {
    return new zzc().zzl(zzTs).zzl(zzTl).zzl(zzTw).zzl(zzTt).zzl(zzTu).zzl(zzTv).zzmd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzmb()
  {
    return zzTl;
  }
  
  public String zzme()
  {
    return zzTs;
  }
  
  public EmailSignInConfig zzmf()
  {
    return zzTt;
  }
  
  public GoogleSignInConfig zzmg()
  {
    return zzTu;
  }
  
  public FacebookSignInConfig zzmh()
  {
    return zzTv;
  }
  
  public String zzmi()
  {
    return zzTw;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */