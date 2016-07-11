package com.voxelbusters.nativeplugins.base.interfaces;

public abstract interface IAppLifeCycleListener
{
  public abstract void onApplicationPause();
  
  public abstract void onApplicationQuit();
  
  public abstract void onApplicationResume();
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.base.interfaces.IAppLifeCycleListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */