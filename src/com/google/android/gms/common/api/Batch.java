package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzlc<BatchResult>
{
  private boolean zzaaA;
  private final PendingResult<?>[] zzaaB;
  private int zzaay;
  private boolean zzaaz;
  private final Object zzpd = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    zzaay = paramList.size();
    zzaaB = new PendingResult[zzaay];
    int i = 0;
    while (i < paramList.size())
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      zzaaB[i] = paramGoogleApiClient;
      paramGoogleApiClient.zza(new PendingResult.zza()
      {
        public void zzt(Status paramAnonymousStatus)
        {
          for (;;)
          {
            synchronized (Batch.zza(Batch.this))
            {
              if (isCanceled()) {
                return;
              }
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.zza(Batch.this, true);
                Batch.zzb(Batch.this);
                if (Batch.zzc(Batch.this) == 0)
                {
                  if (!Batch.zzd(Batch.this)) {
                    break;
                  }
                  Batch.zze(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess()) {
              Batch.zzb(Batch.this, true);
            }
          }
          if (Batch.zzf(Batch.this)) {}
          for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.zzabb)
          {
            zzb(new BatchResult(paramAnonymousStatus, Batch.zzg(Batch.this)));
            break;
          }
        }
      });
      i += 1;
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = zzaaB;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, zzaaB);
  }
  
  public static final class Builder
  {
    private GoogleApiClient zzVs;
    private List<PendingResult<?>> zzaaD = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      zzVs = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(zzaaD.size());
      zzaaD.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(zzaaD, zzVs, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */