package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzc();
  public static zzmn zzSY = zzmp.zzqt();
  final int versionCode;
  private String zzSZ;
  private String zzSs;
  private String zzTa;
  private Uri zzTb;
  private String zzTc;
  private long zzTd;
  private String zzwN;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong)
  {
    versionCode = paramInt;
    zzwN = zzx.zzcr(paramString1);
    zzSs = paramString2;
    zzSZ = paramString3;
    zzTa = paramString4;
    zzTb = paramUri;
    zzTc = paramString5;
    zzTd = paramLong;
  }
  
  private JSONObject zzlX()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", getId());
      if (getIdToken() != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      if (getEmail() != null) {
        localJSONObject.put("email", getEmail());
      }
      if (getDisplayName() != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      if (zzlT() != null) {
        localJSONObject.put("photoUrl", zzlT().toString());
      }
      if (zzlU() != null) {
        localJSONObject.put("serverAuthCode", zzlU());
      }
      localJSONObject.put("expirationTime", zzTd);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).zzlW().equals(zzlW());
  }
  
  public String getDisplayName()
  {
    return zzTa;
  }
  
  public String getEmail()
  {
    return zzSZ;
  }
  
  public String getId()
  {
    return zzwN;
  }
  
  public String getIdToken()
  {
    return zzSs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzlT()
  {
    return zzTb;
  }
  
  public String zzlU()
  {
    return zzTc;
  }
  
  public long zzlV()
  {
    return zzTd;
  }
  
  public String zzlW()
  {
    return zzlX().toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */