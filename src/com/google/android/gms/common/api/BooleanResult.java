package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult
  implements Result
{
  private final Status zzSC;
  private final boolean zzaaE;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    zzSC = ((Status)zzx.zzb(paramStatus, "Status must not be null"));
    zzaaE = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((zzSC.equals(zzSC)) && (zzaaE == zzaaE));
    return false;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public boolean getValue()
  {
    return zzaaE;
  }
  
  public final int hashCode()
  {
    int j = zzSC.hashCode();
    if (zzaaE) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */