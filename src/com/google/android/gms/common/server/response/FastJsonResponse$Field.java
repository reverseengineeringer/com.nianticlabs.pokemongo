package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.Map;

public class FastJsonResponse$Field<I, O>
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  private final int mVersionCode;
  protected final int zzagU;
  protected final boolean zzagV;
  protected final int zzagW;
  protected final boolean zzagX;
  protected final String zzagY;
  protected final int zzagZ;
  protected final Class<? extends FastJsonResponse> zzaha;
  protected final String zzahb;
  private FieldMappingDictionary zzahc;
  private FastJsonResponse.zza<I, O> zzahd;
  
  FastJsonResponse$Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
  {
    mVersionCode = paramInt1;
    zzagU = paramInt2;
    zzagV = paramBoolean1;
    zzagW = paramInt3;
    zzagX = paramBoolean2;
    zzagY = paramString1;
    zzagZ = paramInt4;
    if (paramString2 == null) {
      zzaha = null;
    }
    for (zzahb = null; paramConverterWrapper == null; zzahb = paramString2)
    {
      zzahd = null;
      return;
      zzaha = SafeParcelResponse.class;
    }
    zzahd = paramConverterWrapper.zzpz();
  }
  
  protected FastJsonResponse$Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.zza<I, O> paramzza)
  {
    mVersionCode = 1;
    zzagU = paramInt1;
    zzagV = paramBoolean1;
    zzagW = paramInt2;
    zzagX = paramBoolean2;
    zzagY = paramString;
    zzagZ = paramInt3;
    zzaha = paramClass;
    if (paramClass == null) {}
    for (zzahb = null;; zzahb = paramClass.getCanonicalName())
    {
      zzahd = paramzza;
      return;
    }
  }
  
  public static Field zza(String paramString, int paramInt, FastJsonResponse.zza<?, ?> paramzza, boolean paramBoolean)
  {
    return new Field(paramzza.zzpB(), paramBoolean, paramzza.zzpC(), false, paramString, paramInt, null, paramzza);
  }
  
  public static <T extends FastJsonResponse> Field<T, T> zza(String paramString, int paramInt, Class<T> paramClass)
  {
    return new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
  }
  
  public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String paramString, int paramInt, Class<T> paramClass)
  {
    return new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
  }
  
  public static Field<Integer, Integer> zzj(String paramString, int paramInt)
  {
    return new Field(0, false, 0, false, paramString, paramInt, null, null);
  }
  
  public static Field<Double, Double> zzk(String paramString, int paramInt)
  {
    return new Field(4, false, 4, false, paramString, paramInt, null, null);
  }
  
  public static Field<Boolean, Boolean> zzl(String paramString, int paramInt)
  {
    return new Field(6, false, 6, false, paramString, paramInt, null, null);
  }
  
  public static Field<String, String> zzm(String paramString, int paramInt)
  {
    return new Field(7, false, 7, false, paramString, paramInt, null, null);
  }
  
  public static Field<ArrayList<String>, ArrayList<String>> zzn(String paramString, int paramInt)
  {
    return new Field(7, true, 7, true, paramString, paramInt, null, null);
  }
  
  public I convertBack(O paramO)
  {
    return (I)zzahd.convertBack(paramO);
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(mVersionCode).append('\n');
    localStringBuilder1.append("                 typeIn=").append(zzagU).append('\n');
    localStringBuilder1.append("            typeInArray=").append(zzagV).append('\n');
    localStringBuilder1.append("                typeOut=").append(zzagW).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(zzagX).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(zzagY).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(zzagZ).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(zzpM()).append('\n');
    if (zzpL() != null) {
      localStringBuilder1.append("     concreteType.class=").append(zzpL().getCanonicalName()).append('\n');
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (zzahd == null) {}
    for (String str = "null";; str = zzahd.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public void zza(FieldMappingDictionary paramFieldMappingDictionary)
  {
    zzahc = paramFieldMappingDictionary;
  }
  
  public int zzpB()
  {
    return zzagU;
  }
  
  public int zzpC()
  {
    return zzagW;
  }
  
  public Field<I, O> zzpG()
  {
    return new Field(mVersionCode, zzagU, zzagV, zzagW, zzagX, zzagY, zzagZ, zzahb, zzpO());
  }
  
  public boolean zzpH()
  {
    return zzagV;
  }
  
  public boolean zzpI()
  {
    return zzagX;
  }
  
  public String zzpJ()
  {
    return zzagY;
  }
  
  public int zzpK()
  {
    return zzagZ;
  }
  
  public Class<? extends FastJsonResponse> zzpL()
  {
    return zzaha;
  }
  
  String zzpM()
  {
    if (zzahb == null) {
      return null;
    }
    return zzahb;
  }
  
  public boolean zzpN()
  {
    return zzahd != null;
  }
  
  ConverterWrapper zzpO()
  {
    if (zzahd == null) {
      return null;
    }
    return ConverterWrapper.zza(zzahd);
  }
  
  public Map<String, Field<?, ?>> zzpP()
  {
    zzx.zzw(zzahb);
    zzx.zzw(zzahc);
    return zzahc.zzcw(zzahb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse.Field
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */