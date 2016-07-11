package android.support.v4.content;

import android.support.v4.os.OperationCanceledException;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask
  extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  private final CountDownLatch mDone = new CountDownLatch(1);
  boolean waiting;
  
  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader) {}
  
  protected D doInBackground(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this$0.onLoadInBackground();
      return paramVarArgs;
    }
    catch (OperationCanceledException paramVarArgs)
    {
      if (!isCancelled()) {
        throw paramVarArgs;
      }
    }
    return null;
  }
  
  protected void onCancelled(D paramD)
  {
    try
    {
      this$0.dispatchOnCancelled(this, paramD);
      return;
    }
    finally
    {
      mDone.countDown();
    }
  }
  
  protected void onPostExecute(D paramD)
  {
    try
    {
      this$0.dispatchOnLoadComplete(this, paramD);
      return;
    }
    finally
    {
      mDone.countDown();
    }
  }
  
  public void run()
  {
    waiting = false;
    this$0.executePendingTask();
  }
  
  public void waitForLoader()
  {
    try
    {
      mDone.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader.LoadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */