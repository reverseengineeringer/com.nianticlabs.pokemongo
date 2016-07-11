package com.google.android.gms.internal;

public final class zzsa
  implements Cloneable
{
  private static final zzsb zzbin = new zzsb();
  private int mSize;
  private boolean zzbio = false;
  private int[] zzbip;
  private zzsb[] zzbiq;
  
  zzsa()
  {
    this(10);
  }
  
  zzsa(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    zzbip = new int[paramInt];
    zzbiq = new zzsb[paramInt];
    mSize = 0;
  }
  
  private void gc()
  {
    int m = mSize;
    int[] arrayOfInt = zzbip;
    zzsb[] arrayOfzzsb = zzbiq;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      zzsb localzzsb = arrayOfzzsb[i];
      k = j;
      if (localzzsb != zzbin)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfzzsb[j] = localzzsb;
          arrayOfzzsb[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    zzbio = false;
    mSize = j;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzsb[] paramArrayOfzzsb1, zzsb[] paramArrayOfzzsb2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzsb1[i].equals(paramArrayOfzzsb2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzlT(int paramInt)
  {
    int i = 0;
    int j = mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = zzbip[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzsa)) {
        return false;
      }
      paramObject = (zzsa)paramObject;
      if (size() != ((zzsa)paramObject).size()) {
        return false;
      }
    } while ((zza(zzbip, zzbip, mSize)) && (zza(zzbiq, zzbiq, mSize)));
    return false;
  }
  
  public int hashCode()
  {
    if (zzbio) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + zzbip[i]) * 31 + zzbiq[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    if (zzbio) {
      gc();
    }
    return mSize;
  }
  
  public final zzsa zzFH()
  {
    int i = 0;
    int j = size();
    zzsa localzzsa = new zzsa(j);
    System.arraycopy(zzbip, 0, zzbip, 0, j);
    while (i < j)
    {
      if (zzbiq[i] != null) {
        zzbiq[i] = zzbiq[i].zzFI();
      }
      i += 1;
    }
    mSize = j;
    return localzzsa;
  }
  
  void zza(int paramInt, zzsb paramzzsb)
  {
    int i = zzlT(paramInt);
    if (i >= 0)
    {
      zzbiq[i] = paramzzsb;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < mSize) && (zzbiq[j] == zzbin))
    {
      zzbip[j] = paramInt;
      zzbiq[j] = paramzzsb;
      return;
    }
    i = j;
    if (zzbio)
    {
      i = j;
      if (mSize >= zzbip.length)
      {
        gc();
        i = zzlT(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (mSize >= zzbip.length)
    {
      j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      zzsb[] arrayOfzzsb = new zzsb[j];
      System.arraycopy(zzbip, 0, arrayOfInt, 0, zzbip.length);
      System.arraycopy(zzbiq, 0, arrayOfzzsb, 0, zzbiq.length);
      zzbip = arrayOfInt;
      zzbiq = arrayOfzzsb;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(zzbip, i, zzbip, i + 1, mSize - i);
      System.arraycopy(zzbiq, i, zzbiq, i + 1, mSize - i);
    }
    zzbip[i] = paramInt;
    zzbiq[i] = paramzzsb;
    mSize += 1;
  }
  
  zzsb zzlR(int paramInt)
  {
    paramInt = zzlT(paramInt);
    if ((paramInt < 0) || (zzbiq[paramInt] == zzbin)) {
      return null;
    }
    return zzbiq[paramInt];
  }
  
  zzsb zzlS(int paramInt)
  {
    if (zzbio) {
      gc();
    }
    return zzbiq[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */