package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzlr;

public final class zzc$zza
{
  public static zzlr<Integer> zzahH = zzlr.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
  public static zzlr<String> zzahI = zzlr.zzu("gms:common:stats:connections:ignored_calling_processes", "");
  public static zzlr<String> zzahJ = zzlr.zzu("gms:common:stats:connections:ignored_calling_services", "");
  public static zzlr<String> zzahK = zzlr.zzu("gms:common:stats:connections:ignored_target_processes", "");
  public static zzlr<String> zzahL = zzlr.zzu("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
  public static zzlr<Long> zzahM = zzlr.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000L));
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzc.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */