package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsi.zzd;
import java.util.ArrayList;

public class zzb
{
  private final ArrayList<zza> zzaRK = new ArrayList();
  private int zzaRL;
  
  public zzb()
  {
    this(100);
  }
  
  public zzb(int paramInt)
  {
    zzaRL = paramInt;
  }
  
  private void zzBu()
  {
    while (getSize() > getCapacity()) {
      zzaRK.remove(0);
    }
  }
  
  public void clear()
  {
    zzaRK.clear();
  }
  
  public int getCapacity()
  {
    return zzaRL;
  }
  
  public int getSize()
  {
    return zzaRK.size();
  }
  
  public boolean isEmpty()
  {
    return zzaRK.isEmpty();
  }
  
  public ArrayList<zza> zzBt()
  {
    return zzaRK;
  }
  
  public void zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    zzaRK.add(new zza(paramPlayLoggerContext, paramLogEvent, null));
    zzBu();
  }
  
  public static class zza
  {
    public final PlayLoggerContext zzaRM;
    public final LogEvent zzaRN;
    public final zzsi.zzd zzaRO;
    
    private zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
    {
      zzaRM = ((PlayLoggerContext)zzx.zzw(paramPlayLoggerContext));
      zzaRN = ((LogEvent)zzx.zzw(paramLogEvent));
      zzaRO = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */