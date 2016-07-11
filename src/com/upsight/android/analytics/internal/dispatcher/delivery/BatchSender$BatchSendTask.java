package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.text.TextUtils;
import com.upsight.android.internal.util.NetworkHelper;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;

class BatchSender$BatchSendTask
  implements Runnable
{
  public static final String NETWORK_ERROR = "Network communication problems";
  private BatchSender.Request mRequest;
  
  public BatchSender$BatchSendTask(BatchSender paramBatchSender, BatchSender.Request paramRequest)
  {
    mRequest = paramRequest;
  }
  
  public void run()
  {
    if (!NetworkHelper.isConnected(BatchSender.access$000(this$0)))
    {
      BatchSender.access$100(this$0, mRequest, BatchSender.FailReason.NETWORK, "Network communication problems");
      return;
    }
    try
    {
      localObject = BatchSender.access$500(this$0).send(new UpsightRequest(BatchSender.access$000(this$0), mRequest, BatchSender.access$200(this$0), BatchSender.access$300(this$0), BatchSender.access$400(this$0)));
      ResponseParser.Response localResponse = null;
      if (!TextUtils.isEmpty(body))
      {
        localResponse = BatchSender.access$600(this$0).parse(body);
        BatchSender.access$700(this$0, responses);
      }
      if (((UpsightEndpoint.Response)localObject).isOk())
      {
        BatchSender.access$800(this$0, mRequest);
        return;
      }
    }
    catch (IOException localIOException)
    {
      BatchSender.access$100(this$0, mRequest, BatchSender.FailReason.NETWORK, "Network communication problems");
      return;
    }
    BatchSender.access$400(this$0).e("BatchSender", "Received " + statusCode + " HTTP response code from server", new Object[0]);
    Object localObject = this$0;
    BatchSender.Request localRequest = mRequest;
    BatchSender.FailReason localFailReason = BatchSender.FailReason.SERVER;
    if (localIOException != null) {}
    for (String str = error;; str = null)
    {
      BatchSender.access$100((BatchSender)localObject, localRequest, localFailReason, str);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.BatchSendTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */