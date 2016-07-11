package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

public final class AsyncSubject<T>
  extends Subject<T, T>
{
  volatile Object lastValue;
  private final NotificationLite<T> nl = NotificationLite.instance();
  final SubjectSubscriptionManager<T> state;
  
  protected AsyncSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    state = paramSubjectSubscriptionManager;
  }
  
  public static <T> AsyncSubject<T> create()
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    onTerminated = new Action1()
    {
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        Object localObject = val$state.get();
        NotificationLite localNotificationLite = val$state.nl;
        paramAnonymousSubjectObserver.accept(localObject, localNotificationLite);
        if ((localObject == null) || ((!localNotificationLite.isCompleted(localObject)) && (!localNotificationLite.isError(localObject)))) {
          paramAnonymousSubjectObserver.onCompleted();
        }
      }
    };
    return new AsyncSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
  }
  
  @Experimental
  public Throwable getThrowable()
  {
    Object localObject = state.get();
    if (nl.isError(localObject)) {
      return nl.getError(localObject);
    }
    return null;
  }
  
  @Experimental
  public T getValue()
  {
    Object localObject1 = lastValue;
    Object localObject2 = state.get();
    if ((!nl.isError(localObject2)) && (nl.isNext(localObject1))) {
      return (T)nl.getValue(localObject1);
    }
    return null;
  }
  
  @Experimental
  public T[] getValues(T[] paramArrayOfT)
  {
    Object localObject1 = lastValue;
    Object localObject2 = state.get();
    if ((!nl.isError(localObject2)) && (nl.isNext(localObject1)))
    {
      localObject2 = nl.getValue(localObject1);
      localObject1 = paramArrayOfT;
      if (paramArrayOfT.length == 0) {
        localObject1 = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      }
      localObject1[0] = localObject2;
      localObject2 = localObject1;
      if (localObject1.length > 1)
      {
        localObject1[1] = null;
        localObject2 = localObject1;
      }
    }
    do
    {
      return (T[])localObject2;
      localObject2 = paramArrayOfT;
    } while (paramArrayOfT.length <= 0);
    paramArrayOfT[0] = null;
    return paramArrayOfT;
  }
  
  @Experimental
  public boolean hasCompleted()
  {
    Object localObject = state.get();
    return (localObject != null) && (!nl.isError(localObject));
  }
  
  public boolean hasObservers()
  {
    return state.observers().length > 0;
  }
  
  @Experimental
  public boolean hasThrowable()
  {
    Object localObject = state.get();
    return nl.isError(localObject);
  }
  
  @Experimental
  public boolean hasValue()
  {
    Object localObject1 = lastValue;
    Object localObject2 = state.get();
    return (!nl.isError(localObject2)) && (nl.isNext(localObject1));
  }
  
  public void onCompleted()
  {
    if (state.active)
    {
      Object localObject2 = lastValue;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = nl.completed();
      }
      localObject2 = state.terminate(localObject1);
      int j = localObject2.length;
      int i = 0;
      if (i < j)
      {
        Object localObject3 = localObject2[i];
        if (localObject1 == nl.completed()) {
          ((SubjectSubscriptionManager.SubjectObserver)localObject3).onCompleted();
        }
        for (;;)
        {
          i += 1;
          break;
          ((SubjectSubscriptionManager.SubjectObserver)localObject3).onNext(nl.getValue(localObject1));
          ((SubjectSubscriptionManager.SubjectObserver)localObject3).onCompleted();
        }
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (state.active)
    {
      Object localObject2 = nl.error(paramThrowable);
      Object localObject1 = null;
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = state.terminate(localObject2);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          localObject2 = arrayOfSubjectObserver[i];
          try
          {
            ((SubjectSubscriptionManager.SubjectObserver)localObject2).onError(paramThrowable);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new ArrayList();
              }
              ((List)localObject2).add(localThrowable);
              localObject1 = localObject2;
            }
          }
        }
      }
      Exceptions.throwIfAny((List)localObject1);
    }
  }
  
  public void onNext(T paramT)
  {
    lastValue = nl.next(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.AsyncSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */