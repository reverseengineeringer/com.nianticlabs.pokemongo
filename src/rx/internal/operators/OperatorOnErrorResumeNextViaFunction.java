package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T>
  implements Observable.Operator<T, T>
{
  private final Func1<Throwable, ? extends Observable<? extends T>> resumeFunction;
  
  public OperatorOnErrorResumeNextViaFunction(Func1<Throwable, ? extends Observable<? extends T>> paramFunc1)
  {
    resumeFunction = paramFunc1;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    final ProducerArbiter localProducerArbiter = new ProducerArbiter();
    final SerialSubscription localSerialSubscription = new SerialSubscription();
    Subscriber local1 = new Subscriber()
    {
      private boolean done = false;
      
      public void onCompleted()
      {
        if (done) {
          return;
        }
        done = true;
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (done)
        {
          Exceptions.throwIfFatal(paramAnonymousThrowable);
          return;
        }
        done = true;
        try
        {
          RxJavaPlugins.getInstance().getErrorHandler().handleError(paramAnonymousThrowable);
          unsubscribe();
          Subscriber local1 = new Subscriber()
          {
            public void onCompleted()
            {
              val$child.onCompleted();
            }
            
            public void onError(Throwable paramAnonymous2Throwable)
            {
              val$child.onError(paramAnonymous2Throwable);
            }
            
            public void onNext(T paramAnonymous2T)
            {
              val$child.onNext(paramAnonymous2T);
            }
            
            public void setProducer(Producer paramAnonymous2Producer)
            {
              val$pa.setProducer(paramAnonymous2Producer);
            }
          };
          localSerialSubscription.set(local1);
          ((Observable)resumeFunction.call(paramAnonymousThrowable)).unsafeSubscribe(local1);
          return;
        }
        catch (Throwable paramAnonymousThrowable)
        {
          paramSubscriber.onError(paramAnonymousThrowable);
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (done) {
          return;
        }
        paramSubscriber.onNext(paramAnonymousT);
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        localProducerArbiter.setProducer(paramAnonymousProducer);
      }
    };
    paramSubscriber.add(localSerialSubscription);
    localSerialSubscription.set(local1);
    paramSubscriber.setProducer(localProducerArbiter);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */