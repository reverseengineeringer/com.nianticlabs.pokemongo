package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class OperatorOnErrorResumeNextViaObservable$1
  extends Subscriber<T>
{
  private boolean done = false;
  
  OperatorOnErrorResumeNextViaObservable$1(OperatorOnErrorResumeNextViaObservable paramOperatorOnErrorResumeNextViaObservable, Subscriber paramSubscriber) {}
  
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
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
    unsubscribe();
    this$0.resumeSequence.unsafeSubscribe(val$child);
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
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */