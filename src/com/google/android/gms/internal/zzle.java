package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzle
  implements Releasable, Result
{
  protected final Status zzSC;
  protected final DataHolder zzabq;
  
  protected zzle(DataHolder paramDataHolder, Status paramStatus)
  {
    zzSC = paramStatus;
    zzabq = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public void release()
  {
    if (zzabq != null) {
      zzabq.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */