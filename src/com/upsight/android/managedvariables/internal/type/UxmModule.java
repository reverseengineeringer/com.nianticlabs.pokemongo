package com.upsight.android.managedvariables.internal.type;

import android.content.res.Resources;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.UpsightAnalyticsComponent;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import javax.inject.Named;
import javax.inject.Singleton;
import org.apache.commons.io.IOUtils;
import rx.Scheduler;

@Module
public class UxmModule
{
  public static final String MAPPER_UXM_SCHEMA = "mapperUxmSchema";
  public static final String STRING_RAW_UXM_SCHEMA = "stringRawUxmSchema";
  
  @Provides
  @Singleton
  ManagedVariableManager provideManagedVariableManager(UpsightContext paramUpsightContext, @Named("main") Scheduler paramScheduler, UxmSchema paramUxmSchema)
  {
    return new ManagedVariableManager(paramScheduler, paramUpsightContext.getDataStore(), paramUxmSchema);
  }
  
  @Provides
  @Singleton
  UxmBlockProvider provideUxmBlockProvider(UpsightContext paramUpsightContext, @Named("stringRawUxmSchema") String paramString, UxmSchema paramUxmSchema)
  {
    return new UxmBlockProvider(paramUpsightContext, paramString, paramUxmSchema);
  }
  
  @Provides
  @Singleton
  UxmContentFactory provideUxmContentFactory(UpsightContext paramUpsightContext, @Named("main") Scheduler paramScheduler, UpsightUserExperience paramUpsightUserExperience)
  {
    Object localObject = paramUpsightContext.getCoreComponent();
    Bus localBus = ((UpsightCoreComponent)localObject).bus();
    localObject = ((UpsightCoreComponent)localObject).objectMapper();
    UpsightLogger localUpsightLogger = paramUpsightContext.getLogger();
    return new UxmContentFactory(new UxmContentActions.UxmContentActionContext(paramUpsightContext, localBus, (ObjectMapper)localObject, ((UpsightAnalyticsComponent)((UpsightAnalyticsExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.analytics")).getComponent()).clock(), paramScheduler.createWorker(), localUpsightLogger), paramUpsightUserExperience);
  }
  
  @Provides
  @Singleton
  UxmSchema provideUxmSchema(UpsightContext paramUpsightContext, @Named("mapperUxmSchema") ObjectMapper paramObjectMapper, @Named("stringRawUxmSchema") String paramString)
  {
    UpsightLogger localUpsightLogger = paramUpsightContext.getLogger();
    Object localObject = null;
    paramUpsightContext = (UpsightContext)localObject;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramUpsightContext = UxmSchema.create(paramString, paramObjectMapper, localUpsightLogger);
      paramObjectMapper = paramUpsightContext;
      if (paramUpsightContext == null)
      {
        paramObjectMapper = new UxmSchema(localUpsightLogger);
        localUpsightLogger.d("Upsight", "Empty UXM schema used", new Object[0]);
      }
      return paramObjectMapper;
    }
    catch (IllegalArgumentException paramUpsightContext)
    {
      for (;;)
      {
        localUpsightLogger.e("Upsight", paramUpsightContext, "Failed to parse UXM schema", new Object[0]);
        paramUpsightContext = (UpsightContext)localObject;
      }
    }
  }
  
  @Provides
  @Named("mapperUxmSchema")
  @Singleton
  ObjectMapper provideUxmSchemaMapper(UpsightContext paramUpsightContext)
  {
    return paramUpsightContext.getCoreComponent().objectMapper().copy().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
  }
  
  @Provides
  @Named("stringRawUxmSchema")
  @Singleton
  String provideUxmSchemaRawString(UpsightContext paramUpsightContext, @Named("resUxmSchema") Integer paramInteger)
  {
    UpsightLogger localUpsightLogger = paramUpsightContext.getLogger();
    try
    {
      paramUpsightContext = paramUpsightContext.getResources().openRawResource(paramInteger.intValue());
      if (paramUpsightContext != null) {
        return IOUtils.toString(paramUpsightContext);
      }
      localUpsightLogger.e("Upsight", "Failed to find UXM schema file", new Object[0]);
      return "";
    }
    catch (IOException paramUpsightContext)
    {
      localUpsightLogger.e("Upsight", paramUpsightContext, "Failed to read UXM schema file", new Object[0]);
    }
    return "";
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */