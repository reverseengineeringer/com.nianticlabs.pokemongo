package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
  private final int mVersionCode;
  private final Uri zzaeg;
  private final int zznQ;
  private final int zznR;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzaeg = paramUri;
    zznQ = paramInt2;
    zznR = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height must not be negative");
    }
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(zzi(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri zzi(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url")) {}
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      return localUri;
    }
    catch (JSONException paramJSONObject) {}
    return null;
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
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((zzw.equal(zzaeg, zzaeg)) && (zznQ == zznQ) && (zznR == zznR));
    return false;
  }
  
  public int getHeight()
  {
    return zznR;
  }
  
  public Uri getUrl()
  {
    return zzaeg;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int getWidth()
  {
    return zznQ;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaeg, Integer.valueOf(zznQ), Integer.valueOf(zznR) });
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", zzaeg.toString());
      localJSONObject.put("width", zznQ);
      localJSONObject.put("height", zznR);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return String.format("Image %dx%d %s", new Object[] { Integer.valueOf(zznQ), Integer.valueOf(zznR), zzaeg.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */