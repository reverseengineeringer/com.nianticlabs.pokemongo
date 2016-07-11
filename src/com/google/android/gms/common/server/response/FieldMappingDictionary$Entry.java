package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary$Entry
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final String className;
  final int versionCode;
  final ArrayList<FieldMappingDictionary.FieldMapPair> zzahh;
  
  FieldMappingDictionary$Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
  {
    versionCode = paramInt;
    className = paramString;
    zzahh = paramArrayList;
  }
  
  FieldMappingDictionary$Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
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

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */