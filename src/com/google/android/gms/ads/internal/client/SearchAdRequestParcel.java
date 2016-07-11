package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class SearchAdRequestParcel
  implements SafeParcelable
{
  public static final zzae CREATOR = new zzae();
  public final int backgroundColor;
  public final int versionCode;
  public final int zztP;
  public final int zztQ;
  public final int zztR;
  public final int zztS;
  public final int zztT;
  public final int zztU;
  public final int zztV;
  public final String zztW;
  public final int zztX;
  public final String zztY;
  public final int zztZ;
  public final int zzua;
  public final String zzub;
  
  SearchAdRequestParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    versionCode = paramInt1;
    zztP = paramInt2;
    backgroundColor = paramInt3;
    zztQ = paramInt4;
    zztR = paramInt5;
    zztS = paramInt6;
    zztT = paramInt7;
    zztU = paramInt8;
    zztV = paramInt9;
    zztW = paramString1;
    zztX = paramInt10;
    zztY = paramString2;
    zztZ = paramInt11;
    zzua = paramInt12;
    zzub = paramString3;
  }
  
  public SearchAdRequestParcel(SearchAdRequest paramSearchAdRequest)
  {
    versionCode = 1;
    zztP = paramSearchAdRequest.getAnchorTextColor();
    backgroundColor = paramSearchAdRequest.getBackgroundColor();
    zztQ = paramSearchAdRequest.getBackgroundGradientBottom();
    zztR = paramSearchAdRequest.getBackgroundGradientTop();
    zztS = paramSearchAdRequest.getBorderColor();
    zztT = paramSearchAdRequest.getBorderThickness();
    zztU = paramSearchAdRequest.getBorderType();
    zztV = paramSearchAdRequest.getCallButtonColor();
    zztW = paramSearchAdRequest.getCustomChannels();
    zztX = paramSearchAdRequest.getDescriptionTextColor();
    zztY = paramSearchAdRequest.getFontFace();
    zztZ = paramSearchAdRequest.getHeaderTextColor();
    zzua = paramSearchAdRequest.getHeaderTextSize();
    zzub = paramSearchAdRequest.getQuery();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.SearchAdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */