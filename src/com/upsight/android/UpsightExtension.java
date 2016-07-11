package com.upsight.android;

public abstract class UpsightExtension<T extends BaseComponent, U>
{
  private T mExtensionComponent;
  
  public U getApi()
    throws IllegalStateException
  {
    throw new IllegalStateException("This Upsight extension supports no public API.");
  }
  
  public final T getComponent()
  {
    return mExtensionComponent;
  }
  
  protected void onCreate(UpsightContext paramUpsightContext) {}
  
  protected void onPostCreate(UpsightContext paramUpsightContext) {}
  
  protected abstract T onResolve(UpsightContext paramUpsightContext);
  
  final void setComponent(T paramT)
  {
    mExtensionComponent = paramT;
  }
  
  public static abstract interface BaseComponent<T extends UpsightExtension>
  {
    public abstract void inject(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */