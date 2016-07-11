package com.upsight.android;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.analytics.dispatcher.EndpointResponse;
import com.upsight.android.analytics.internal.action.ActionMapResponse;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesApi;
import com.upsight.android.managedvariables.UpsightManagedVariablesComponent;
import com.upsight.android.managedvariables.internal.BaseManagedVariablesModule;
import com.upsight.android.managedvariables.internal.DaggerManagedVariablesComponent;
import com.upsight.android.managedvariables.internal.DaggerManagedVariablesComponent.Builder;
import com.upsight.android.managedvariables.internal.type.UxmBlockProvider;
import com.upsight.android.managedvariables.internal.type.UxmContent;
import com.upsight.android.managedvariables.internal.type.UxmContentFactory;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.annotation.Created;
import java.io.IOException;
import javax.inject.Inject;

public class UpsightManagedVariablesExtension
  extends UpsightExtension<UpsightManagedVariablesComponent, UpsightManagedVariablesApi>
{
  public static final String EXTENSION_NAME = "com.upsight.extension.managedvariables";
  private static final String UPSIGHT_ACTION_MAP = "upsight.action_map";
  private UpsightLogger mLogger;
  @Inject
  UpsightManagedVariablesApi mManagedVariables;
  private ObjectMapper mMapper;
  @Inject
  UxmBlockProvider mUxmBlockProvider;
  @Inject
  UxmContentFactory mUxmContentFactory;
  
  public UpsightManagedVariablesApi getApi()
  {
    return mManagedVariables;
  }
  
  protected void onCreate(UpsightContext paramUpsightContext)
  {
    mMapper = paramUpsightContext.getCoreComponent().objectMapper();
    mLogger = paramUpsightContext.getLogger();
    UpsightDataProvider.register(paramUpsightContext, mUxmBlockProvider);
    paramUpsightContext.getDataStore().subscribe(this);
  }
  
  protected UpsightManagedVariablesComponent onResolve(UpsightContext paramUpsightContext)
  {
    return DaggerManagedVariablesComponent.builder().baseManagedVariablesModule(new BaseManagedVariablesModule(paramUpsightContext)).build();
  }
  
  @Created
  public void onResponse(EndpointResponse paramEndpointResponse)
  {
    if (!"upsight.action_map".equals(paramEndpointResponse.getType())) {}
    for (;;)
    {
      return;
      try
      {
        paramEndpointResponse = mMapper.readTree(paramEndpointResponse.getContent());
        paramEndpointResponse = (ActionMapResponse)mMapper.treeToValue(paramEndpointResponse, ActionMapResponse.class);
        if ("datastore_factory".equals(paramEndpointResponse.getActionFactory()))
        {
          paramEndpointResponse = mUxmContentFactory.create(paramEndpointResponse);
          if (paramEndpointResponse != null)
          {
            paramEndpointResponse.executeActions("content_received");
            return;
          }
        }
      }
      catch (IOException paramEndpointResponse)
      {
        mLogger.w("Upsight", "Unable to parse action map", new Object[] { paramEndpointResponse });
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightManagedVariablesExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */