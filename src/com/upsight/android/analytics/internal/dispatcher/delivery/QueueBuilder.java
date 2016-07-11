package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.dispatcher.schema.Schema;
import com.upsight.android.analytics.internal.dispatcher.util.Selector;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.logger.UpsightLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;
import rx.Scheduler;

public class QueueBuilder
{
  private static final String CHARSET_UTF_8 = "UTF-8";
  public static final String MACRO_APP_TOKEN = "{app_token}";
  public static final String MACRO_APP_VERSION = "{app_version}";
  public static final String MACRO_HOST = "{host}";
  public static final String MACRO_PROTOCOL = "{protocol}";
  public static final String MACRO_PROTOCOL_VERSION = "{version}";
  public static final String MACRO_SDK_VERSION = "{sdk_version}";
  private static final String PROTOCOL_VERSION = "v1";
  private Clock mClock;
  private Map<String, String> mEndpointMacros;
  private UpsightLogger mLogger;
  private ObjectMapper mObjectMapper;
  private Provider<ResponseParser> mResponseParserProvider;
  private Scheduler mRetryExecutor;
  private Scheduler mSendExecutor;
  private SignatureVerifier mSignatureVerifier;
  private UpsightContext mUpsight;
  
  QueueBuilder(UpsightContext paramUpsightContext, ObjectMapper paramObjectMapper, Clock paramClock, UpsightLogger paramUpsightLogger, Scheduler paramScheduler1, Scheduler paramScheduler2, SignatureVerifier paramSignatureVerifier, Provider<ResponseParser> paramProvider)
  {
    mUpsight = paramUpsightContext;
    mObjectMapper = paramObjectMapper;
    mClock = paramClock;
    mLogger = paramUpsightLogger;
    mRetryExecutor = paramScheduler1;
    mSendExecutor = paramScheduler2;
    mSignatureVerifier = paramSignatureVerifier;
    mResponseParserProvider = paramProvider;
    createEndpointMacroMap();
  }
  
  private void createEndpointMacroMap()
  {
    mEndpointMacros = new HashMap();
    mEndpointMacros.put("{version}", "v1");
    mEndpointMacros.put("{app_token}", mUpsight.getApplicationToken());
    mEndpointMacros.put("{app_version}", getAppVersionName(mUpsight));
    mEndpointMacros.put("{sdk_version}", mUpsight.getSdkVersion());
  }
  
  private String getAppVersionName(Context paramContext)
  {
    String str = "";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = str;
      if (localPackageInfo != null)
      {
        paramContext = str;
        if (versionName != null) {
          paramContext = URLEncoder.encode(versionName, "UTF-8");
        }
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      mLogger.e(QueueBuilder.class.getSimpleName(), "Could not get package info", new Object[] { paramContext });
      return "";
    }
    catch (UnsupportedEncodingException paramContext)
    {
      mLogger.e(QueueBuilder.class.getSimpleName(), "UTF-8 encoding not supported", new Object[] { paramContext });
    }
    return "";
  }
  
  public Queue build(String paramString, QueueConfig paramQueueConfig, Selector<Schema> paramSelector1, Selector<Schema> paramSelector2)
  {
    Object localObject = new UpsightEndpoint(prepareEndpoint(paramQueueConfig.getEndpointAddress()), mSignatureVerifier, mObjectMapper, mLogger);
    localObject = new BatchSender(mUpsight, paramQueueConfig.getBatchSenderConfig(), mRetryExecutor, mSendExecutor, (UpsightEndpoint)localObject, (ResponseParser)mResponseParserProvider.get(), mObjectMapper, mClock, mLogger);
    return new Queue(paramString, paramSelector1, paramSelector2, new BatcherFactory(paramQueueConfig.getBatcherConfig()), (BatchSender)localObject);
  }
  
  String prepareEndpoint(String paramString)
  {
    Iterator localIterator = mEndpointMacros.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramString = paramString.replace((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
    }
    return paramString;
  }
  
  private class BatcherFactory
    implements Batcher.Factory
  {
    private Batcher.Config mConfig;
    
    public BatcherFactory(Batcher.Config paramConfig)
    {
      mConfig = paramConfig;
    }
    
    public Batcher create(Schema paramSchema, BatchSender paramBatchSender)
    {
      return new Batcher(mConfig, paramSchema, paramBatchSender, mRetryExecutor);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */