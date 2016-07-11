package com.upsight.android.analytics.internal.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.application.status")
public class ApplicationStatus
{
  @UpsightStorableIdentifier
  String id;
  @JsonProperty
  State state;
  
  ApplicationStatus() {}
  
  public ApplicationStatus(State paramState)
  {
    state = paramState;
  }
  
  public State getState()
  {
    return state;
  }
  
  public static enum State
  {
    BACKGROUND,  FOREGROUND;
    
    private State() {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ApplicationStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */