package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence
  implements SafeParcelable, Geofence
{
  public static final zzo CREATOR = new zzo();
  private final int mVersionCode;
  private final String zzBY;
  private final int zzaEi;
  private final short zzaEk;
  private final double zzaEl;
  private final double zzaEm;
  private final float zzaEn;
  private final int zzaEo;
  private final int zzaEp;
  private final long zzaFO;
  
  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    zzdx(paramString);
    zze(paramFloat);
    zza(paramDouble1, paramDouble2);
    paramInt2 = zzhc(paramInt2);
    mVersionCode = paramInt1;
    zzaEk = paramShort;
    zzBY = paramString;
    zzaEl = paramDouble1;
    zzaEm = paramDouble2;
    zzaEn = paramFloat;
    zzaFO = paramLong;
    zzaEi = paramInt2;
    zzaEo = paramInt3;
    zzaEp = paramInt4;
  }
  
  public ParcelableGeofence(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void zza(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
  }
  
  private static void zzdx(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static void zze(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  private static int zzhc(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String zzhd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static ParcelableGeofence zzn(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzeJ(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof ParcelableGeofence)) {
        return false;
      }
      paramObject = (ParcelableGeofence)paramObject;
      if (zzaEn != zzaEn) {
        return false;
      }
      if (zzaEl != zzaEl) {
        return false;
      }
      if (zzaEm != zzaEm) {
        return false;
      }
    } while (zzaEk == zzaEk);
    return false;
  }
  
  public long getExpirationTime()
  {
    return zzaFO;
  }
  
  public double getLatitude()
  {
    return zzaEl;
  }
  
  public double getLongitude()
  {
    return zzaEm;
  }
  
  public int getNotificationResponsiveness()
  {
    return zzaEo;
  }
  
  public String getRequestId()
  {
    return zzBY;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(zzaEl);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(zzaEm);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(zzaEn)) * 31 + zzaEk) * 31 + zzaEi;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zzhd(zzaEk), zzBY, Integer.valueOf(zzaEi), Double.valueOf(zzaEl), Double.valueOf(zzaEm), Float.valueOf(zzaEn), Integer.valueOf(zzaEo / 1000), Integer.valueOf(zzaEp), Long.valueOf(zzaFO) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public short zzwI()
  {
    return zzaEk;
  }
  
  public float zzwJ()
  {
    return zzaEn;
  }
  
  public int zzwK()
  {
    return zzaEi;
  }
  
  public int zzwL()
  {
    return zzaEp;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.ParcelableGeofence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */