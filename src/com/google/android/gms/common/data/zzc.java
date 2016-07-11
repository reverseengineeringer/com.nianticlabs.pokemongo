package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc
{
  protected final DataHolder zzabq;
  protected int zzadl;
  private int zzadm;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    zzabq = ((DataHolder)zzx.zzw(paramDataHolder));
    zzbr(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzw.equal(Integer.valueOf(zzadl), Integer.valueOf(zzadl)))
      {
        bool1 = bool2;
        if (zzw.equal(Integer.valueOf(zzadm), Integer.valueOf(zzadm)))
        {
          bool1 = bool2;
          if (zzabq == zzabq) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return zzabq.zze(paramString, zzadl, zzadm);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return zzabq.zzg(paramString, zzadl, zzadm);
  }
  
  protected float getFloat(String paramString)
  {
    return zzabq.zzf(paramString, zzadl, zzadm);
  }
  
  protected int getInteger(String paramString)
  {
    return zzabq.zzc(paramString, zzadl, zzadm);
  }
  
  protected long getLong(String paramString)
  {
    return zzabq.zzb(paramString, zzadl, zzadm);
  }
  
  protected String getString(String paramString)
  {
    return zzabq.zzd(paramString, zzadl, zzadm);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(zzadl), Integer.valueOf(zzadm), zzabq });
  }
  
  public boolean isDataValid()
  {
    return !zzabq.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    zzabq.zza(paramString, zzadl, zzadm, paramCharArrayBuffer);
  }
  
  protected void zzbr(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < zzabq.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      zzadl = paramInt;
      zzadm = zzabq.zzbt(zzadl);
      return;
    }
  }
  
  public boolean zzce(String paramString)
  {
    return zzabq.zzce(paramString);
  }
  
  protected Uri zzcf(String paramString)
  {
    return zzabq.zzh(paramString, zzadl, zzadm);
  }
  
  protected boolean zzcg(String paramString)
  {
    return zzabq.zzi(paramString, zzadl, zzadm);
  }
  
  protected int zzou()
  {
    return zzadl;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */