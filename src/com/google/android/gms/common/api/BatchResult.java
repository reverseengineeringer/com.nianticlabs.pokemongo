package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status zzSC;
  private final PendingResult<?>[] zzaaB;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    zzSC = paramStatus;
    zzaaB = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (mId < zzaaB.length) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "The result token does not belong to this batch");
      return zzaaB[mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */