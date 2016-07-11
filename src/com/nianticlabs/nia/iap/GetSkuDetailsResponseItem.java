package com.nianticlabs.nia.iap;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class GetSkuDetailsResponseItem
{
  private static final String TAG = "SkuDetailsResponseItem";
  private String description;
  private String price;
  private String price_amount_micros;
  private String price_currency_code;
  private String productId;
  private String title;
  private String type;
  
  static GetSkuDetailsResponseItem fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      GetSkuDetailsResponseItem localGetSkuDetailsResponseItem = new GetSkuDetailsResponseItem();
      productId = paramString.getString("productId");
      type = paramString.getString("type");
      price = paramString.getString("price");
      price_amount_micros = paramString.getString("price_amount_micros");
      price_currency_code = paramString.getString("price_currency_code");
      title = paramString.getString("title");
      description = paramString.getString("description");
      return localGetSkuDetailsResponseItem;
    }
    catch (JSONException paramString)
    {
      Log.e("SkuDetailsResponseItem", "Failed to parse GetSkuDetailsResponseItem", paramString);
    }
    return null;
  }
  
  static GetSkuDetailsResponseItem fromPurchasableItemDetails(PurchasableItemDetails paramPurchasableItemDetails)
  {
    GetSkuDetailsResponseItem localGetSkuDetailsResponseItem = new GetSkuDetailsResponseItem();
    productId = paramPurchasableItemDetails.getItemId();
    type = "inapp";
    price = paramPurchasableItemDetails.getPrice();
    price_amount_micros = "";
    price_currency_code = "";
    title = paramPurchasableItemDetails.getTitle();
    description = paramPurchasableItemDetails.getDescription();
    return localGetSkuDetailsResponseItem;
  }
  
  static PurchasableItemDetails toPurchasableItemDetails(GetSkuDetailsResponseItem paramGetSkuDetailsResponseItem)
  {
    return new PurchasableItemDetails(productId, title, description, price);
  }
  
  String getCurrencyCode()
  {
    return price_currency_code;
  }
  
  int getPriceE6()
  {
    try
    {
      int i = Integer.parseInt(price_amount_micros);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0;
  }
  
  String getProductId()
  {
    return productId;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.iap.GetSkuDetailsResponseItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */