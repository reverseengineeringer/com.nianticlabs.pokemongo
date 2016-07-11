package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzsb
  implements Cloneable
{
  private zzrz<?, ?> zzbir;
  private Object zzbis;
  private List<zzsg> zzbit = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzB()];
    zza(zzrx.zzC(arrayOfByte));
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzsb));
      paramObject = (zzsb)paramObject;
      if ((zzbis == null) || (zzbis == null)) {
        break;
      }
      bool1 = bool2;
    } while (zzbir != zzbir);
    if (!zzbir.zzbil.isArray()) {
      return zzbis.equals(zzbis);
    }
    if ((zzbis instanceof byte[])) {
      return Arrays.equals((byte[])zzbis, (byte[])zzbis);
    }
    if ((zzbis instanceof int[])) {
      return Arrays.equals((int[])zzbis, (int[])zzbis);
    }
    if ((zzbis instanceof long[])) {
      return Arrays.equals((long[])zzbis, (long[])zzbis);
    }
    if ((zzbis instanceof float[])) {
      return Arrays.equals((float[])zzbis, (float[])zzbis);
    }
    if ((zzbis instanceof double[])) {
      return Arrays.equals((double[])zzbis, (double[])zzbis);
    }
    if ((zzbis instanceof boolean[])) {
      return Arrays.equals((boolean[])zzbis, (boolean[])zzbis);
    }
    return Arrays.deepEquals((Object[])zzbis, (Object[])zzbis);
    if ((zzbit != null) && (zzbit != null)) {
      return zzbit.equals(zzbit);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzsb)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  int zzB()
  {
    int j;
    if (zzbis != null)
    {
      j = zzbir.zzX(zzbis);
      return j;
    }
    Iterator localIterator = zzbit.iterator();
    for (int i = 0;; i = ((zzsg)localIterator.next()).zzB() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public final zzsb zzFI()
  {
    int i = 0;
    zzsb localzzsb = new zzsb();
    try
    {
      zzbir = zzbir;
      if (zzbit == null) {
        zzbit = null;
      }
      while (zzbis == null)
      {
        return localzzsb;
        zzbit.addAll(zzbit);
      }
      if (!(zzbis instanceof zzse)) {
        break label92;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    zzbis = ((zzse)zzbis).zzFG();
    return localCloneNotSupportedException;
    label92:
    if ((zzbis instanceof byte[]))
    {
      zzbis = ((byte[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    if ((zzbis instanceof byte[][]))
    {
      localObject1 = (byte[][])zzbis;
      localObject2 = new byte[localObject1.length][];
      zzbis = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((zzbis instanceof boolean[]))
    {
      zzbis = ((boolean[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbis instanceof int[]))
    {
      zzbis = ((int[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbis instanceof long[]))
    {
      zzbis = ((long[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbis instanceof float[]))
    {
      zzbis = ((float[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbis instanceof double[]))
    {
      zzbis = ((double[])zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((zzbis instanceof zzse[]))
    {
      localObject1 = (zzse[])zzbis;
      localObject2 = new zzse[localObject1.length];
      zzbis = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].zzFG();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  void zza(zzrx paramzzrx)
    throws IOException
  {
    if (zzbis != null) {
      zzbir.zza(zzbis, paramzzrx);
    }
    for (;;)
    {
      return;
      Iterator localIterator = zzbit.iterator();
      while (localIterator.hasNext()) {
        ((zzsg)localIterator.next()).zza(paramzzrx);
      }
    }
  }
  
  void zza(zzsg paramzzsg)
  {
    zzbit.add(paramzzsg);
  }
  
  <T> T zzb(zzrz<?, T> paramzzrz)
  {
    if (zzbis != null)
    {
      if (zzbir != paramzzrz) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      zzbir = paramzzrz;
      zzbis = paramzzrz.zzE(zzbit);
      zzbit = null;
    }
    return (T)zzbis;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */