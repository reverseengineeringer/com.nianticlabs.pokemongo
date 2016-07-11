package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class OperatorMulticast<T, R>
  extends ConnectableObservable<R>
{
  final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
  final Object guard;
  private Subscription guardedSubscription;
  final Observable<? extends T> source;
  final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
  private Subscriber<T> subscription;
  final List<Subscriber<? super R>> waitingForConnect;
  
  private OperatorMulticast(Object paramObject, final AtomicReference<Subject<? super T, ? extends R>> paramAtomicReference, final List<Subscriber<? super R>> paramList, Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    super(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super R> paramAnonymousSubscriber)
      {
        synchronized (OperatorMulticast.this)
        {
          if (paramAtomicReference.get() == null)
          {
            paramList.add(paramAnonymousSubscriber);
            return;
          }
          ((Subject)paramAtomicReference.get()).unsafeSubscribe(paramAnonymousSubscriber);
        }
      }
    });
    guard = paramObject;
    connectedSubject = paramAtomicReference;
    waitingForConnect = paramList;
    source = paramObservable;
    subjectFactory = paramFunc0;
  }
  
  public OperatorMulticast(Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    this(new Object(), new AtomicReference(), new ArrayList(), paramObservable, paramFunc0);
  }
  
  public void connect(Action1<? super Subscription> arg1)
  {
    Subject localSubject;
    synchronized (guard)
    {
      if (subscription != null)
      {
        ???.call(guardedSubscription);
        return;
      }
      localSubject = (Subject)subjectFactory.call();
      subscription = Subscribers.from(localSubject);
      final Object localObject3 = new AtomicReference();
      ((AtomicReference)localObject3).set(Subscriptions.create(new Action0()
      {
        public void call()
        {
          synchronized (guard)
          {
            if (guardedSubscription == localObject3.get())
            {
              Subscriber localSubscriber = subscription;
              OperatorMulticast.access$102(OperatorMulticast.this, null);
              OperatorMulticast.access$002(OperatorMulticast.this, null);
              connectedSubject.set(null);
              if (localSubscriber != null) {
                localSubscriber.unsubscribe();
              }
              return;
            }
            return;
          }
        }
      }));
      guardedSubscription = ((Subscription)((AtomicReference)localObject3).get());
      localObject3 = waitingForConnect.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        final Subscriber localSubscriber = (Subscriber)((Iterator)localObject3).next();
        localSubject.unsafeSubscribe(new Subscriber(localSubscriber)
        {
          public void onCompleted()
          {
            localSubscriber.onCompleted();
          }
          
          public void onError(Throwable paramAnonymousThrowable)
          {
            localSubscriber.onError(paramAnonymousThrowable);
          }
          
          public void onNext(R paramAnonymousR)
          {
            localSubscriber.onNext(paramAnonymousR);
          }
        });
      }
    }
    waitingForConnect.clear();
    connectedSubject.set(localSubject);
    ???.call(guardedSubscription);
    synchronized (guard)
    {
      ??? = subscription;
      if (??? != null)
      {
        source.subscribe((Subscriber)???);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMulticast
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */