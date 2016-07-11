package com.google.android.gms.common.api;

import android.app.Activity;
import com.google.android.gms.common.internal.zzx;

public abstract class ResolvingResultCallbacks<R extends Result>
  extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int zzaaY;
  
  protected ResolvingResultCallbacks(Activity paramActivity, int paramInt)
  {
    mActivity = ((Activity)zzx.zzb(paramActivity, "Activity must not be null"));
    zzaaY = paramInt;
  }
  
  public abstract void onSuccess(R paramR);
  
  public abstract void onUnresolvableFailure(Status paramStatus);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.ResolvingResultCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */