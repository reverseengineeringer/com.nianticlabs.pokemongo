package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightContext;
import com.upsight.android.marketing.UpsightBillboard;

class UpsightPushBillboard$NoOpBillboard
  extends UpsightBillboard
{
  public void destroy() {}
  
  protected UpsightBillboard setUp(UpsightContext paramUpsightContext)
    throws IllegalStateException
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightPushBillboard.NoOpBillboard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */