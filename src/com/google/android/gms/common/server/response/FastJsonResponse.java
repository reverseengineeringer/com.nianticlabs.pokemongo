package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{
  private void zza(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    if (paramField.zzpB() == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.zzpL().cast(paramObject)).toString());
      return;
    }
    if (paramField.zzpB() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(zzmu.zzcz((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void zza(StringBuilder paramStringBuilder, Field paramField, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        zza(paramStringBuilder, paramField, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public String toString()
  {
    Map localMap = zzpD();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Field localField = (Field)localMap.get(str);
      if (zza(localField))
      {
        Object localObject = zza(localField, zzb(localField));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label139;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label139:
        switch (localField.zzpC())
        {
        default: 
          if (localField.zzpH()) {
            zza(localStringBuilder, localField, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(zzmk.zzi((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(zzmk.zzj((byte[])localObject)).append("\"");
          break;
        case 10: 
          zzmv.zza(localStringBuilder, (HashMap)localObject);
          continue;
          zza(localStringBuilder, localField, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  protected <O, I> I zza(Field<I, O> paramField, Object paramObject)
  {
    Object localObject = paramObject;
    if (Field.zzc(paramField) != null) {
      localObject = paramField.convertBack(paramObject);
    }
    return (I)localObject;
  }
  
  protected boolean zza(Field paramField)
  {
    if (paramField.zzpC() == 11)
    {
      if (paramField.zzpI()) {
        return zzcv(paramField.zzpJ());
      }
      return zzcu(paramField.zzpJ());
    }
    return zzct(paramField.zzpJ());
  }
  
  protected Object zzb(Field paramField)
  {
    String str = paramField.zzpJ();
    if (paramField.zzpL() != null)
    {
      boolean bool;
      if (zzcs(paramField.zzpJ()) == null)
      {
        bool = true;
        zzx.zza(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.zzpJ() });
        if (!paramField.zzpI()) {
          break label71;
        }
      }
      label71:
      for (paramField = zzpF();; paramField = zzpE())
      {
        if (paramField == null) {
          break label79;
        }
        return paramField.get(str);
        bool = false;
        break;
      }
      try
      {
        label79:
        paramField = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        paramField = getClass().getMethod(paramField, new Class[0]).invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return zzcs(paramField.zzpJ());
  }
  
  protected abstract Object zzcs(String paramString);
  
  protected abstract boolean zzct(String paramString);
  
  protected boolean zzcu(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean zzcv(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  public abstract Map<String, Field<?, ?>> zzpD();
  
  public HashMap<String, Object> zzpE()
  {
    return null;
  }
  
  public HashMap<String, Object> zzpF()
  {
    return null;
  }
  
  public static class Field<I, O>
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
    
    Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ConverterWrapper paramConverterWrapper)
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
    
    protected Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.zza<I, O> paramzza)
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
  
  public static abstract interface zza<I, O>
  {
    public abstract I convertBack(O paramO);
    
    public abstract int zzpB();
    
    public abstract int zzpC();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FastJsonResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */