package com.nianticproject.holoholo.sfida.unity;

import com.nianticproject.holoholo.sfida.service.SfidaButtonDetector.OnClickListener;

public class EncounterPokemonClickCallback
  implements SfidaButtonDetector.OnClickListener
{
  private String pokemonId;
  
  public EncounterPokemonClickCallback(String paramString)
  {
    pokemonId = paramString;
  }
  
  public String getId()
  {
    return pokemonId;
  }
  
  public void onClick() {}
  
  public void onPress() {}
  
  public void onRelease() {}
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.EncounterPokemonClickCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */