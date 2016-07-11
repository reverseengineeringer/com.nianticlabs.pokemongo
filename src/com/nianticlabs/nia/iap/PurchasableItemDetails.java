package com.nianticlabs.nia.iap;

class PurchasableItemDetails
{
  private String description;
  private String itemId;
  private String price;
  private String title;
  
  PurchasableItemDetails(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    itemId = paramString1;
    title = paramString2;
    description = paramString3;
    price = paramString4;
  }
  
  String getDescription()
  {
    return description;
  }
  
  String getItemId()
  {
    return itemId;
  }
  
  String getPrice()
  {
    return price;
  }
  
  String getTitle()
  {
    return title;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.PurchasableItemDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */