package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent
  extends zzf
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzh();
  private final long mTimeout;
  final int mVersionCode;
  private final long zzahn;
  private int zzaho;
  private final long zzahv;
  private long zzahx;
  private final String zzaia;
  private final int zzaib;
  private final List<String> zzaic;
  private final String zzaid;
  private int zzaie;
  private final String zzaif;
  private final String zzaig;
  private final float zzaih;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    mVersionCode = paramInt1;
    zzahn = paramLong1;
    zzaho = paramInt2;
    zzaia = paramString1;
    zzaif = paramString3;
    zzaib = paramInt3;
    zzahx = -1L;
    zzaic = paramList;
    zzaid = paramString2;
    zzahv = paramLong2;
    zzaie = paramInt4;
    zzaig = paramString4;
    zzaih = paramFloat;
    mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3)
  {
    this(1, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3);
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
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public String zzqc()
  {
    return zzaid;
  }
  
  public long zzqd()
  {
    return zzahx;
  }
  
  public long zzqf()
  {
    return zzahv;
  }
  
  public String zzqg()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("\t").append(zzqj()).append("\t").append(zzql()).append("\t");
    if (zzqm() == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str).append("\t").append(zzqn()).append("\t");
      if (zzqk() != null) {
        break label135;
      }
      str = "";
      label80:
      localStringBuilder = localStringBuilder.append(str).append("\t");
      if (zzqo() != null) {
        break label143;
      }
    }
    label135:
    label143:
    for (String str = "";; str = zzqo())
    {
      return str + "\t" + zzqp();
      str = TextUtils.join(",", zzqm());
      break;
      str = zzqk();
      break label80;
    }
  }
  
  public String zzqj()
  {
    return zzaia;
  }
  
  public String zzqk()
  {
    return zzaif;
  }
  
  public int zzql()
  {
    return zzaib;
  }
  
  public List<String> zzqm()
  {
    return zzaic;
  }
  
  public int zzqn()
  {
    return zzaie;
  }
  
  public String zzqo()
  {
    return zzaig;
  }
  
  public float zzqp()
  {
    return zzaih;
  }
  
  public long zzqq()
  {
    return mTimeout;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */