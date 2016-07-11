package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

public final class OnSubscribeUsing<T, Resource>
  implements Observable.OnSubscribe<T>
{
  private final Action1<? super Resource> dispose;
  private final boolean disposeEagerly;
  private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
  private final Func0<Resource> resourceFactory;
  
  public OnSubscribeUsing(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Observable<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    resourceFactory = paramFunc0;
    observableFactory = paramFunc1;
    dispose = paramAction1;
    disposeEagerly = paramBoolean;
  }
  
  private Throwable disposeEagerlyIfRequested(Action0 paramAction0)
  {
    if (disposeEagerly) {}
    try
    {
      paramAction0.call();
      return null;
    }
    catch (Throwable paramAction0) {}
    return paramAction0;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      Object localObject1 = resourceFactory.call();
      Object localObject2 = new DisposeAction(dispose, localObject1, null);
      paramSubscriber.add((Subscription)localObject2);
      localObject1 = (Observable)observableFactory.call(localObject1);
      if (disposeEagerly) {
        localObject1 = ((Observable)localObject1).doOnTerminate((Action0)localObject2);
      }
      for (;;)
      {
        try
        {
          ((Observable)localObject1).unsafeSubscribe(Subscribers.wrap(paramSubscriber));
          return;
        }
        catch (Throwable localThrowable1)
        {
          localObject2 = disposeEagerlyIfRequested((Action0)localObject2);
          if (localObject2 == null) {
            break;
          }
        }
        continue;
        paramSubscriber.onError(new CompositeException(Arrays.asList(new Throwable[] { localThrowable1, localObject2 })));
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      paramSubscriber.onError(localThrowable2);
      return;
    }
    paramSubscriber.onError(localThrowable2);
  }
  
  private static final class DisposeAction<Resource>
    extends AtomicBoolean
    implements Action0, Subscription
  {
    private static final long serialVersionUID = 4262875056400218316L;
    private Action1<? super Resource> dispose;
    private Resource resource;
    
    private DisposeAction(Action1<? super Resource> paramAction1, Resource paramResource)
    {
      dispose = paramAction1;
      resource = paramResource;
      lazySet(false);
    }
    
    public void call()
    {
      if (compareAndSet(false, true)) {}
      try
      {
        dispose.call(resource);
        return;
      }
      finally
      {
        resource = null;
        dispose = null;
      }
    }
    
    public boolean isUnsubscribed()
    {
      return get();
    }
    
    public void unsubscribe()
    {
      call();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeUsing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */