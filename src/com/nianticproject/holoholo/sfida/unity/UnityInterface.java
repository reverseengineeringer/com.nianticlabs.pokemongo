package com.nianticproject.holoholo.sfida.unity;

public abstract interface UnityInterface
{
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract boolean init();
  
  public abstract boolean notifyCancel();
  
  public abstract boolean notifyCancelDowser();
  
  public abstract boolean notifyError();
  
  public abstract boolean notifyFoundDowser();
  
  public abstract boolean notifyNoPokeball();
  
  public abstract boolean notifyPokeballShakeAndBroken(String paramString);
  
  public abstract boolean notifyPokemonCaught();
  
  public abstract boolean notifyProximityDowser(String paramString);
  
  public abstract boolean notifyReachedPokestop(String paramString);
  
  public abstract boolean notifyReadyForThrowPokeball(String paramString);
  
  public abstract boolean notifyRewardItems(String paramString);
  
  public abstract boolean notifySpawnedLegendaryPokemon(String paramString);
  
  public abstract boolean notifySpawnedPokemon(String paramString);
  
  public abstract boolean notifySpawnedUncaughtPokemon(String paramString);
  
  public abstract boolean notifyStartDowser();
  
  public abstract void releaseSfida();
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.UnityInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */