package rx.internal.operators;

import java.util.Arrays;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class OperatorOnErrorReturn$1
  extends Subscriber<T>
{
  private boolean done = false;
  
  OperatorOnErrorReturn$1(OperatorOnErrorReturn paramOperatorOnErrorReturn, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (done) {
      return;
    }
    done = true;
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (done)
    {
      Exceptions.throwIfFatal(paramThrowable);
      return;
    }
    done = true;
    try
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      unsubscribe();
      Object localObject = this$0.resultFunction.call(paramThrowable);
      val$child.onNext(localObject);
      val$child.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      val$child.onError(new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable })));
    }
  }
  
  public void onNext(T paramT)
  {
    if (done) {
      return;
    }
    val$child.onNext(paramT);
  }
  
  public void setProducer(final Producer paramProducer)
  {
    val$child.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        paramProducer.request(paramAnonymousLong);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorReturn.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */