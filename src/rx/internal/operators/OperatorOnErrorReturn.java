package rx.internal.operators;

import java.util.Arrays;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class OperatorOnErrorReturn<T>
  implements Observable.Operator<T, T>
{
  final Func1<Throwable, ? extends T> resultFunction;
  
  public OperatorOnErrorReturn(Func1<Throwable, ? extends T> paramFunc1)
  {
    resultFunction = paramFunc1;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
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
          Object localObject = resultFunction.call(paramAnonymousThrowable);
          paramSubscriber.onNext(localObject);
          paramSubscriber.onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          paramSubscriber.onError(new CompositeException(Arrays.asList(new Throwable[] { paramAnonymousThrowable, localThrowable })));
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (done) {
          return;
        }
        paramSubscriber.onNext(paramAnonymousT);
      }
      
      public void setProducer(final Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(new Producer()
        {
          public void request(long paramAnonymous2Long)
          {
            paramAnonymousProducer.request(paramAnonymous2Long);
          }
        });
      }
    };
    paramSubscriber.add(local1);
    return local1;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorReturn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */