package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$zza
{
  private final HashMap<Object, Integer> zzadA;
  private boolean zzadB;
  private String zzadC;
  private final String[] zzadp;
  private final ArrayList<HashMap<String, Object>> zzady;
  private final String zzadz;
  
  private DataHolder$zza(String[] paramArrayOfString, String paramString)
  {
    zzadp = ((String[])zzx.zzw(paramArrayOfString));
    zzady = new ArrayList();
    zzadz = paramString;
    zzadA = new HashMap();
    zzadB = false;
    zzadC = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.DataHolder.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */