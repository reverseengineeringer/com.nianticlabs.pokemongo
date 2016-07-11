package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  implements SafeParcelable, FastJsonResponse.zza<String, Integer>
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private final HashMap<String, Integer> zzagP;
  private final HashMap<Integer, String> zzagQ;
  private final ArrayList<Entry> zzagR;
  
  public StringToIntConverter()
  {
    mVersionCode = 1;
    zzagP = new HashMap();
    zzagQ = new HashMap();
    zzagR = null;
  }
  
  StringToIntConverter(int paramInt, ArrayList<Entry> paramArrayList)
  {
    mVersionCode = paramInt;
    zzagP = new HashMap();
    zzagQ = new HashMap();
    zzagR = null;
    zzb(paramArrayList);
  }
  
  private void zzb(ArrayList<Entry> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Entry localEntry = (Entry)paramArrayList.next();
      zzi(zzagS, zzagT);
    }
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzb(Integer paramInteger)
  {
    String str = (String)zzagQ.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (zzagP.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public StringToIntConverter zzi(String paramString, int paramInt)
  {
    zzagP.put(paramString, Integer.valueOf(paramInt));
    zzagQ.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<Entry> zzpA()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzagP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, ((Integer)zzagP.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int zzpB()
  {
    return 7;
  }
  
  public int zzpC()
  {
    return 0;
  }
  
  public static final class Entry
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    final String zzagS;
    final int zzagT;
    
    Entry(int paramInt1, String paramString, int paramInt2)
    {
      versionCode = paramInt1;
      zzagS = paramString;
      zzagT = paramInt2;
    }
    
    Entry(String paramString, int paramInt)
    {
      versionCode = 1;
      zzagS = paramString;
      zzagT = paramInt;
    }
    
    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */