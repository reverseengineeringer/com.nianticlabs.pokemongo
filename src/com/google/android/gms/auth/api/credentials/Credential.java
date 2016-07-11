package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  private final String mName;
  final int mVersionCode;
  private final Uri zzSh;
  private final List<IdToken> zzSi;
  private final String zzSj;
  private final String zzSk;
  private final String zzSl;
  private final String zzSm;
  private final String zzwN;
  
  Credential(int paramInt, String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    mVersionCode = paramInt;
    zzwN = ((String)zzx.zzw(paramString1));
    mName = paramString2;
    zzSh = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      zzSi = paramString1;
      zzSj = paramString3;
      zzSk = paramString4;
      zzSl = paramString5;
      zzSm = paramString6;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(zzwN, zzwN)) && (TextUtils.equals(mName, mName)) && (zzw.equal(zzSh, zzSh)) && (TextUtils.equals(zzSj, zzSj)) && (TextUtils.equals(zzSk, zzSk)) && (TextUtils.equals(zzSl, zzSl)));
    return false;
  }
  
  public String getAccountType()
  {
    return zzSk;
  }
  
  public String getGeneratedPassword()
  {
    return zzSl;
  }
  
  public String getId()
  {
    return zzwN;
  }
  
  public List<IdToken> getIdTokens()
  {
    return zzSi;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getPassword()
  {
    return zzSj;
  }
  
  public Uri getProfilePictureUri()
  {
    return zzSh;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzwN, mName, zzSh, zzSj, zzSk, zzSl });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzlI()
  {
    return zzSm;
  }
  
  public static class Builder
  {
    private String mName;
    private Uri zzSh;
    private List<IdToken> zzSi;
    private String zzSj;
    private String zzSk;
    private String zzSl;
    private String zzSm;
    private final String zzwN;
    
    public Builder(Credential paramCredential)
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
    
    public Builder(String paramString)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */