package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

class OperatorOnErrorResumeNextViaFunction$1
  extends Subscriber<T>
{
  private boolean done = false;
  
  OperatorOnErrorResumeNextViaFunction$1(OperatorOnErrorResumeNextViaFunction paramOperatorOnErrorResumeNextViaFunction, Subscriber paramSubscriber, ProducerArbiter paramProducerArbiter, SerialSubscription paramSerialSubscription) {}
  
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
      Subscriber local1 = new Subscriber()
      {
        public void onCompleted()
        {
          val$child.onCompleted();
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          val$child.onError(paramAnonymousThrowable);
        }
        
        public void onNext(T paramAnonymousT)
        {
          val$child.onNext(paramAnonymousT);
        }
        
        public void setProducer(Producer paramAnonymousProducer)
        {
          val$pa.setProducer(paramAnonymousProducer);
        }
      };
      val$ssub.set(local1);
      ((Observable)OperatorOnErrorResumeNextViaFunction.access$000(this$0).call(paramThrowable)).unsafeSubscribe(local1);
      return;
    }
    catch (Throwable paramThrowable)
    {
      val$child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (done) {
      return;
    }
    val$child.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    val$pa.setProducer(paramProducer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */