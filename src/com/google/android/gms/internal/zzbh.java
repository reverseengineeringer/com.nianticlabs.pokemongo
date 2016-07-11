package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;

@zzgr
public class zzbh
{
  private final Object zzpd = new Object();
  private final int zzrN;
  private final int zzrO;
  private final int zzrP;
  private final zzbm zzrQ;
  private ArrayList<String> zzrR = new ArrayList();
  private int zzrS = 0;
  private int zzrT = 0;
  private int zzrU = 0;
  private int zzrV;
  private String zzrW = "";
  
  public zzbh(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzrN = paramInt1;
    zzrO = paramInt2;
    zzrP = paramInt3;
    zzrQ = new zzbm(paramInt4);
  }
  
  private String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= paramInt);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < paramInt);
    return ((String)localObject).substring(0, paramInt);
  }
  
  private void zzx(String paramString)
  {
    if ((paramString == null) || (paramString.length() < zzrP)) {
      return;
    }
    synchronized (zzpd)
    {
      zzrR.add(paramString);
      zzrS += paramString.length();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbh)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzbh)paramObject;
    } while ((((zzbh)paramObject).zzcm() == null) || (!((zzbh)paramObject).zzcm().equals(zzcm())));
    return true;
  }
  
  public int getScore()
  {
    return zzrV;
  }
  
  public int hashCode()
  {
    return zzcm().hashCode();
  }
  
  public String toString()
  {
    return "ActivityContent fetchId: " + zzrT + " score:" + zzrV + " total_length:" + zzrS + "\n text: " + zza(zzrR, 200) + "\n signture: " + zzrW;
  }
  
  int zza(int paramInt1, int paramInt2)
  {
    return zzrN * paramInt1 + zzrO * paramInt2;
  }
  
  public boolean zzcl()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzrU == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String zzcm()
  {
    return zzrW;
  }
  
  public void zzcn()
  {
    synchronized (zzpd)
    {
      zzrV -= 100;
      return;
    }
  }
  
  public void zzco()
  {
    synchronized (zzpd)
    {
      zzrU -= 1;
      return;
    }
  }
  
  public void zzcp()
  {
    synchronized (zzpd)
    {
      zzrU += 1;
      return;
    }
  }
  
  public void zzcq()
  {
    synchronized (zzpd)
    {
      int i = zza(zzrS, zzrT);
      if (i > zzrV)
      {
        zzrV = i;
        zzrW = zzrQ.zza(zzrR);
      }
      return;
    }
  }
  
  int zzcr()
  {
    return zzrS;
  }
  
  public void zzg(int paramInt)
  {
    zzrT = paramInt;
  }
  
  public void zzv(String arg1)
  {
    zzx(???);
    synchronized (zzpd)
    {
      if (zzrU < 0) {
        zzb.zzaF("ActivityContent: negative number of WebViews.");
      }
      zzcq();
      return;
    }
  }
  
  public void zzw(String paramString)
  {
    zzx(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */