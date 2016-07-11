package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzsg
{
  final int tag;
  final byte[] zzbiw;
  
  zzsg(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    zzbiw = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzsg)) {
        return false;
      }
      paramObject = (zzsg)paramObject;
    } while ((tag == tag) && (Arrays.equals(zzbiw, zzbiw)));
    return false;
  }
  
  public int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(zzbiw);
  }
  
  int zzB()
  {
    return 0 + zzrx.zzlO(tag) + zzbiw.length;
  }
  
  void zza(zzrx paramzzrx)
    throws IOException
  {
    paramzzrx.zzlN(tag);
    paramzzrx.zzF(zzbiw);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */