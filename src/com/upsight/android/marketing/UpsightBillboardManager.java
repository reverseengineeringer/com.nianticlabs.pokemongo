package com.upsight.android.marketing;

import com.upsight.android.marketing.internal.billboard.Billboard;

public abstract interface UpsightBillboardManager
{
  public abstract boolean registerBillboard(Billboard paramBillboard);
  
  public abstract boolean registerContentMediator(UpsightContentMediator paramUpsightContentMediator);
  
  public abstract boolean unregisterBillboard(Billboard paramBillboard);
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */