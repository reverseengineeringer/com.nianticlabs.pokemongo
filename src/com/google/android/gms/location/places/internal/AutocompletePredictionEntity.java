package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity
  implements SafeParcelable, AutocompletePrediction
{
  public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
  private static final List<SubstringEntity> zzaGN = Collections.emptyList();
  final int mVersionCode;
  final List<Integer> zzaFT;
  final String zzaGO;
  final List<SubstringEntity> zzaGP;
  final int zzaGQ;
  final String zzaGR;
  final List<SubstringEntity> zzaGS;
  final String zzaGT;
  final List<SubstringEntity> zzaGU;
  final String zzaGt;
  
  AutocompletePredictionEntity(int paramInt1, String paramString1, List<Integer> paramList, int paramInt2, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    mVersionCode = paramInt1;
    zzaGt = paramString1;
    zzaFT = paramList;
    zzaGQ = paramInt2;
    zzaGO = paramString2;
    zzaGP = paramList1;
    zzaGR = paramString3;
    zzaGS = paramList2;
    zzaGT = paramString4;
    zzaGU = paramList3;
  }
  
  public static AutocompletePredictionEntity zza(String paramString1, List<Integer> paramList, int paramInt, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    return new AutocompletePredictionEntity(0, paramString1, paramList, paramInt, (String)zzx.zzw(paramString2), paramList1, paramString3, paramList2, paramString4, paramList3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompletePredictionEntity)) {
        return false;
      }
      paramObject = (AutocompletePredictionEntity)paramObject;
    } while ((zzw.equal(zzaGt, zzaGt)) && (zzw.equal(zzaFT, zzaFT)) && (zzw.equal(Integer.valueOf(zzaGQ), Integer.valueOf(zzaGQ))) && (zzw.equal(zzaGO, zzaGO)) && (zzw.equal(zzaGP, zzaGP)) && (zzw.equal(zzaGR, zzaGR)) && (zzw.equal(zzaGS, zzaGS)) && (zzw.equal(zzaGT, zzaGT)) && (zzw.equal(zzaGU, zzaGU)));
    return false;
  }
  
  public String getDescription()
  {
    return zzaGO;
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzaGO, zzaGP, paramCharacterStyle);
  }
  
  public List<? extends AutocompletePrediction.Substring> getMatchedSubstrings()
  {
    return zzaGP;
  }
  
  public String getPlaceId()
  {
    return zzaGt;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zzaFT;
  }
  
  public CharSequence getPrimaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzaGR, zzaGS, paramCharacterStyle);
  }
  
  public CharSequence getSecondaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzaGT, zzaGU, paramCharacterStyle);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaGt, zzaFT, Integer.valueOf(zzaGQ), zzaGO, zzaGP, zzaGR, zzaGS, zzaGT, zzaGU });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("placeId", zzaGt).zzg("placeTypes", zzaFT).zzg("fullText", zzaGO).zzg("fullTextMatchedSubstrings", zzaGP).zzg("primaryText", zzaGR).zzg("primaryTextMatchedSubstrings", zzaGS).zzg("secondaryText", zzaGT).zzg("secondaryTextMatchedSubstrings", zzaGU).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public AutocompletePrediction zzwV()
  {
    return this;
  }
  
  public static class SubstringEntity
    implements SafeParcelable, AutocompletePrediction.Substring
  {
    public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzv();
    final int mLength;
    final int mOffset;
    final int mVersionCode;
    
    public SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
    {
      mVersionCode = paramInt1;
      mOffset = paramInt2;
      mLength = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof SubstringEntity)) {
          return false;
        }
        paramObject = (SubstringEntity)paramObject;
      } while ((zzw.equal(Integer.valueOf(mOffset), Integer.valueOf(mOffset))) && (zzw.equal(Integer.valueOf(mLength), Integer.valueOf(mLength))));
      return false;
    }
    
    public int getLength()
    {
      return mLength;
    }
    
    public int getOffset()
    {
      return mOffset;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { Integer.valueOf(mOffset), Integer.valueOf(mLength) });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("offset", Integer.valueOf(mOffset)).zzg("length", Integer.valueOf(mLength)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzv.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.AutocompletePredictionEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */