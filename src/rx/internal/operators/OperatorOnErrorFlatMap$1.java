package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class OperatorOnErrorFlatMap$1
  extends Subscriber<T>
{
  OperatorOnErrorFlatMap$1(OperatorOnErrorFlatMap paramOperatorOnErrorFlatMap, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      ((Observable)OperatorOnErrorFlatMap.access$000(this$0).call(OnErrorThrowable.from(paramThrowable))).unsafeSubscribe(new Subscriber()
      {
        public void onCompleted() {}
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          val$child.onError(paramAnonymousThrowable);
        }
        
        public void onNext(T paramAnonymousT)
        {
          val$child.onNext(paramAnonymousT);
        }
      });
      return;
    }
    catch (Throwable paramThrowable)
    {
      val$child.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    val$child.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorOnErrorFlatMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */