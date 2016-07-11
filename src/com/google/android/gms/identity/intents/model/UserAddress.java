package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
  private final int mVersionCode;
  String name;
  String phoneNumber;
  String zzGw;
  String zzaDk;
  String zzaDl;
  String zzaDm;
  String zzaDn;
  String zzaDo;
  String zzaDp;
  String zzaDq;
  String zzaDr;
  String zzaDs;
  boolean zzaDt;
  String zzaDu;
  String zzaDv;
  
  UserAddress()
  {
    mVersionCode = 1;
  }
  
  UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14)
  {
    mVersionCode = paramInt;
    name = paramString1;
    zzaDk = paramString2;
    zzaDl = paramString3;
    zzaDm = paramString4;
    zzaDn = paramString5;
    zzaDo = paramString6;
    zzaDp = paramString7;
    zzaDq = paramString8;
    zzGw = paramString9;
    zzaDr = paramString10;
    zzaDs = paramString11;
    phoneNumber = paramString12;
    zzaDt = paramBoolean;
    zzaDu = paramString13;
    zzaDv = paramString14;
  }
  
  public static UserAddress fromIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
      return null;
    }
    return (UserAddress)paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress1()
  {
    return zzaDk;
  }
  
  public String getAddress2()
  {
    return zzaDl;
  }
  
  public String getAddress3()
  {
    return zzaDm;
  }
  
  public String getAddress4()
  {
    return zzaDn;
  }
  
  public String getAddress5()
  {
    return zzaDo;
  }
  
  public String getAdministrativeArea()
  {
    return zzaDp;
  }
  
  public String getCompanyName()
  {
    return zzaDu;
  }
  
  public String getCountryCode()
  {
    return zzGw;
  }
  
  public String getEmailAddress()
  {
    return zzaDv;
  }
  
  public String getLocality()
  {
    return zzaDq;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public String getPostalCode()
  {
    return zzaDr;
  }
  
  public String getSortingCode()
  {
    return zzaDs;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public boolean isPostBox()
  {
    return zzaDt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.UserAddress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */