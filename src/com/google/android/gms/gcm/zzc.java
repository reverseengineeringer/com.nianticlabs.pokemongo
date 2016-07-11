package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzc
{
  public static final zzc zzaCI = new zzc(0, 30, 3600);
  public static final zzc zzaCJ = new zzc(1, 30, 3600);
  private final int zzaCK;
  private final int zzaCL;
  private final int zzaCM;
  
  private zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    zzaCK = paramInt1;
    zzaCL = paramInt2;
    zzaCM = paramInt3;
  }
  
  public int zzvZ()
  {
    return zzaCK;
  }
  
  public int zzwa()
  {
    return zzaCL;
  }
  
  public int zzwb()
  {
    return zzaCM;
  }
  
  public Bundle zzz(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", zzaCK);
    paramBundle.putInt("initial_backoff_seconds", zzaCL);
    paramBundle.putInt("maximum_backoff_seconds", zzaCM);
    return paramBundle;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */