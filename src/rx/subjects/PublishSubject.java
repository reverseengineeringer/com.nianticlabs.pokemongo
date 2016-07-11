package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

public final class PublishSubject<T>
  extends Subject<T, T>
{
  private final NotificationLite<T> nl = NotificationLite.instance();
  final SubjectSubscriptionManager<T> state;
  
  protected PublishSubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager)
  {
    super(paramOnSubscribe);
    state = paramSubjectSubscriptionManager;
  }
  
  public static <T> PublishSubject<T> create()
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    onTerminated = new Action1()
    {
      public void call(SubjectSubscriptionManager.SubjectObserver<T> paramAnonymousSubjectObserver)
      {
        paramAnonymousSubjectObserver.emitFirst(val$state.get(), val$state.nl);
      }
    };
    return new PublishSubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager);
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
    return null;
  }
  
  @Experimental
  public Object[] getValues()
  {
    return new Object[0];
  }
  
  @Experimental
  public T[] getValues(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length > 0) {
      paramArrayOfT[0] = null;
    }
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
    return false;
  }
  
  public void onCompleted()
  {
    if (state.active)
    {
      Object localObject = nl.completed();
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = state.terminate(localObject);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSubjectObserver[i].emitNext(localObject, state.nl);
        i += 1;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (state.active)
    {
      Object localObject2 = nl.error(paramThrowable);
      paramThrowable = null;
      SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = state.terminate(localObject2);
      int j = arrayOfSubjectObserver.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfSubjectObserver[i];
          try
          {
            ((SubjectSubscriptionManager.SubjectObserver)localObject1).emitNext(localObject2, state.nl);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject1 = paramThrowable;
              if (paramThrowable == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localThrowable);
              paramThrowable = (Throwable)localObject1;
            }
          }
        }
      }
      Exceptions.throwIfAny(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = state.observers();
    int j = arrayOfSubjectObserver.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSubjectObserver[i].onNext(paramT);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.PublishSubject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */