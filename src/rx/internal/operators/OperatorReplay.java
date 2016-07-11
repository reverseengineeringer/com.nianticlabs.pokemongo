package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscriber;
import rx.subjects.Subject;

public final class OperatorReplay
{
  private OperatorReplay()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Subject<T, T> createScheduledSubject(Subject<T, T> paramSubject, Scheduler paramScheduler)
  {
    new SubjectWrapper(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        OperatorReplay.subscriberOf(val$observedOn).call(paramAnonymousSubscriber);
      }
    }, paramSubject);
  }
  
  public static <T> Observable.OnSubscribe<T> subscriberOf(Observable<T> paramObservable)
  {
    new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        val$target.unsafeSubscribe(paramAnonymousSubscriber);
      }
    };
  }
  
  public static final class SubjectWrapper<T>
    extends Subject<T, T>
  {
    final Subject<T, T> subject;
    
    public SubjectWrapper(Observable.OnSubscribe<T> paramOnSubscribe, Subject<T, T> paramSubject)
    {
      super();
      subject = paramSubject;
    }
    
    public boolean hasObservers()
    {
      return subject.hasObservers();
    }
    
    public void onCompleted()
    {
      subject.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      subject.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      subject.onNext(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorReplay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */