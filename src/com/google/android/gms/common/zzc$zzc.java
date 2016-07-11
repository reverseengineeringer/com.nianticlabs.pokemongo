package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzc$zzc
  extends zzc.zza
{
  private static final WeakReference<byte[]> zzaaj = new WeakReference(null);
  private WeakReference<byte[]> zzaai = zzaaj;
  
  zzc$zzc(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])zzaai.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = zznr();
        zzaai = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] zznr();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzc.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */