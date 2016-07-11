package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final String packageName;
  public final int versionCode;
  public final int zzaRR;
  public final int zzaRS;
  public final String zzaRT;
  public final String zzaRU;
  public final boolean zzaRV;
  public final String zzaRW;
  public final boolean zzaRX;
  public final int zzaRY;
  
  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    versionCode = paramInt1;
    packageName = paramString1;
    zzaRR = paramInt2;
    zzaRS = paramInt3;
    zzaRT = paramString2;
    zzaRU = paramString3;
    zzaRV = paramBoolean1;
    zzaRW = paramString4;
    zzaRX = paramBoolean2;
    zzaRY = paramInt4;
  }
  
  @Deprecated
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    versionCode = 1;
    packageName = ((String)zzx.zzw(paramString1));
    zzaRR = paramInt1;
    zzaRS = paramInt2;
    zzaRW = null;
    zzaRT = paramString2;
    zzaRU = paramString3;
    zzaRV = paramBoolean;
    zzaRX = false;
    zzaRY = 0;
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
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      paramObject = (PlayLoggerContext)paramObject;
    } while ((versionCode == versionCode) && (packageName.equals(packageName)) && (zzaRR == zzaRR) && (zzaRS == zzaRS) && (zzw.equal(zzaRW, zzaRW)) && (zzw.equal(zzaRT, zzaRT)) && (zzw.equal(zzaRU, zzaRU)) && (zzaRV == zzaRV) && (zzaRX == zzaRX) && (zzaRY == zzaRY));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(versionCode), packageName, Integer.valueOf(zzaRR), Integer.valueOf(zzaRS), zzaRW, zzaRT, zzaRU, Boolean.valueOf(zzaRV), Boolean.valueOf(zzaRX), Integer.valueOf(zzaRY) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(versionCode).append(',');
    localStringBuilder.append("package=").append(packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(zzaRR).append(',');
    localStringBuilder.append("logSource=").append(zzaRS).append(',');
    localStringBuilder.append("logSourceName=").append(zzaRW).append(',');
    localStringBuilder.append("uploadAccount=").append(zzaRT).append(',');
    localStringBuilder.append("loggingId=").append(zzaRU).append(',');
    localStringBuilder.append("logAndroidId=").append(zzaRV).append(',');
    localStringBuilder.append("isAnonymous=").append(zzaRX).append(',');
    localStringBuilder.append("qosTier=").append(zzaRY);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.PlayLoggerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */