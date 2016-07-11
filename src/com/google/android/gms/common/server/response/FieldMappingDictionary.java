package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzahe;
  private final ArrayList<Entry> zzahf;
  private final String zzahg;
  
  FieldMappingDictionary(int paramInt, ArrayList<Entry> paramArrayList, String paramString)
  {
    mVersionCode = paramInt;
    zzahf = null;
    zzahe = zzc(paramArrayList);
    zzahg = ((String)zzx.zzw(paramString));
    zzpQ();
  }
  
  public FieldMappingDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    mVersionCode = 1;
    zzahf = null;
    zzahe = new HashMap();
    zzahg = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzc(ArrayList<Entry> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Entry localEntry = (Entry)paramArrayList.get(i);
      localHashMap.put(className, localEntry.zzpU());
      i += 1;
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = zzahe.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)zzahe.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public void zza(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    zzahe.put(paramClass.getCanonicalName(), paramMap);
  }
  
  public boolean zzb(Class<? extends FastJsonResponse> paramClass)
  {
    return zzahe.containsKey(paramClass.getCanonicalName());
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> zzcw(String paramString)
  {
    return (Map)zzahe.get(paramString);
  }
  
  public void zzpQ()
  {
    Iterator localIterator1 = zzahe.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)zzahe.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).zza(this);
      }
    }
  }
  
  public void zzpR()
  {
    Iterator localIterator1 = zzahe.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)zzahe.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).zzpG());
      }
      zzahe.put(str1, localHashMap);
    }
  }
  
  ArrayList<Entry> zzpS()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzahe.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, (Map)zzahe.get(str)));
    }
    return localArrayList;
  }
  
  public String zzpT()
  {
    return zzahg;
  }
  
  public static class Entry
    implements SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    final String className;
    final int versionCode;
    final ArrayList<FieldMappingDictionary.FieldMapPair> zzahh;
    
    Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
    {
      versionCode = paramInt;
      className = paramString;
      zzahh = paramArrayList;
    }
    
    Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      versionCode = 1;
      className = paramString;
      zzahh = zzF(paramMap);
    }
    
    private static ArrayList<FieldMappingDictionary.FieldMapPair> zzF(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      if (paramMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }
    
    HashMap<String, FastJsonResponse.Field<?, ?>> zzpU()
    {
      HashMap localHashMap = new HashMap();
      int j = zzahh.size();
      int i = 0;
      while (i < j)
      {
        FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)zzahh.get(i);
        localHashMap.put(key, zzahi);
        i += 1;
      }
      return localHashMap;
    }
  }
  
  public static class FieldMapPair
    implements SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
    final String key;
    final int versionCode;
    final FastJsonResponse.Field<?, ?> zzahi;
    
    FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      versionCode = paramInt;
      key = paramString;
      zzahi = paramField;
    }
    
    FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      versionCode = 1;
      key = paramString;
      zzahi = paramField;
    }
    
    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */