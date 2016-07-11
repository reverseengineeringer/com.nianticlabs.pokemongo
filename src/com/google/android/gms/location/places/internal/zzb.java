package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class zzb
  extends zzu
  implements AutocompletePrediction
{
  public zzb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private String zzwX()
  {
    return zzF("ap_description", "");
  }
  
  private String zzwY()
  {
    return zzF("ap_primary_text", "");
  }
  
  private String zzwZ()
  {
    return zzF("ap_secondary_text", "");
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzxa()
  {
    return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzxb()
  {
    return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzxc()
  {
    return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  public String getDescription()
  {
    return zzwX();
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzwX(), zzxa(), paramCharacterStyle);
  }
  
  public List<AutocompletePredictionEntity.SubstringEntity> getMatchedSubstrings()
  {
    return zzxa();
  }
  
  public String getPlaceId()
  {
    return zzF("ap_place_id", null);
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zza("ap_place_types", Collections.emptyList());
  }
  
  public CharSequence getPrimaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzwY(), zzxb(), paramCharacterStyle);
  }
  
  public CharSequence getSecondaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzwZ(), zzxc(), paramCharacterStyle);
  }
  
  public AutocompletePrediction zzwV()
  {
    return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzwW(), zzwX(), zzxa(), zzwY(), zzxb(), zzwZ(), zzxc());
  }
  
  public int zzwW()
  {
    return zzz("ap_personalization_type", 6);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */