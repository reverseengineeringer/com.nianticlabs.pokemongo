package rx.internal.operators;

import rx.Subscriber;
import rx.functions.FuncN;

final class OnSubscribeCombineLatest$SingleSourceRequestableSubscriber<T, R>
  extends Subscriber<T>
{
  private final Subscriber<? super R> child;
  private final FuncN<? extends R> combinator;
  
  OnSubscribeCombineLatest$SingleSourceRequestableSubscriber(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
  {
    super(paramSubscriber);
    child = paramSubscriber;
    combinator = paramFuncN;
  }
  
  public void onCompleted()
  {
    child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    child.onNext(combinator.call(new Object[] { paramT }));
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.SingleSourceRequestableSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */