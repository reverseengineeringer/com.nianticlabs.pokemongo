package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
  final int mVersionCode;
  private final long zzahn;
  private int zzaho;
  private final String zzahp;
  private final String zzahq;
  private final String zzahr;
  private final String zzahs;
  private final String zzaht;
  private final String zzahu;
  private final long zzahv;
  private final long zzahw;
  private long zzahx;
  
  ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    mVersionCode = paramInt1;
    zzahn = paramLong1;
    zzaho = paramInt2;
    zzahp = paramString1;
    zzahq = paramString2;
    zzahr = paramString3;
    zzahs = paramString4;
    zzahx = -1L;
    zzaht = paramString5;
    zzahu = paramString6;
    zzahv = paramLong2;
    zzahw = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return zzaho;
  }
  
  public long getTimeMillis()
  {
    return zzahn;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzpX()
  {
    return zzahp;
  }
  
  public String zzpY()
  {
    return zzahq;
  }
  
  public String zzpZ()
  {
    return zzahr;
  }
  
  public String zzqa()
  {
    return zzahs;
  }
  
  public String zzqb()
  {
    return zzaht;
  }
  
  public String zzqc()
  {
    return zzahu;
  }
  
  public long zzqd()
  {
    return zzahx;
  }
  
  public long zzqe()
  {
    return zzahw;
  }
  
  public long zzqf()
  {
    return zzahv;
  }
  
  public String zzqg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzpX()).append("/").append(zzpY()).append("\t").append(zzpZ()).append("/").append(zzqa()).append("\t");
    if (zzaht == null) {}
    for (String str = "";; str = zzaht) {
      return str + "\t" + zzqe();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */