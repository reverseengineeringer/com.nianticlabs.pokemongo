package com.nianticproject.holoholo.sfida.unity;

import com.nianticproject.holoholo.sfida.service.SfidaButtonDetector.OnClickListener;

public class PokestopClickCallback
  implements SfidaButtonDetector.OnClickListener
{
  private String pokestopId;
  
  public PokestopClickCallback(String paramString)
  {
    pokestopId = paramString;
  }
  
  public String getId()
  {
    return pokestopId;
  }
  
  public void onClick() {}
  
  public void onPress() {}
  
  public void onRelease() {}
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.PokestopClickCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */