package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzaa
  extends zzg<zzu>
{
  private static final zzaa zzags = new zzaa();
  
  private zzaa()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View zzb(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    return zzags.zzc(paramContext, paramInt1, paramInt2);
  }
  
  private View zzc(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    try
    {
      zzd localzzd = zze.zzy(paramContext);
      paramContext = (View)zze.zzp(((zzu)zzas(paramContext)).zza(localzzd, paramInt1, paramInt2));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new zzg.zza("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public zzu zzaN(IBinder paramIBinder)
  {
    return zzu.zza.zzaM(paramIBinder);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */