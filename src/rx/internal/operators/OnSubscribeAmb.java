package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeAmb<T>
  implements Observable.OnSubscribe<T>
{
  final AtomicReference<AmbSubscriber<T>> choice = selection.choice;
  final Selection<T> selection = new Selection(null);
  final Iterable<? extends Observable<? extends T>> sources;
  
  private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    sources = paramIterable;
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return new OnSubscribeAmb(paramIterable);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    localArrayList.add(paramObservable9);
    return amb(localArrayList);
  }
  
  private static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> paramCollection)
  {
    if (!paramCollection.isEmpty())
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext()) {
        ((AmbSubscriber)localIterator.next()).unsubscribe();
      }
      paramCollection.clear();
    }
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)choice.get();
        if (localAmbSubscriber != null) {
          localAmbSubscriber.unsubscribe();
        }
        OnSubscribeAmb.unsubscribeAmbSubscribers(selection.ambSubscribers);
      }
    }));
    Iterator localIterator = sources.iterator();
    for (;;)
    {
      Observable localObservable;
      if (localIterator.hasNext())
      {
        localObservable = (Observable)localIterator.next();
        if (!paramSubscriber.isUnsubscribed()) {}
      }
      else
      {
        if (paramSubscriber.isUnsubscribed()) {
          unsubscribeAmbSubscribers(selection.ambSubscribers);
        }
        paramSubscriber.setProducer(new Producer()
        {
          public void request(long paramAnonymousLong)
          {
            Object localObject = (OnSubscribeAmb.AmbSubscriber)choice.get();
            if (localObject != null) {
              OnSubscribeAmb.AmbSubscriber.access$300((OnSubscribeAmb.AmbSubscriber)localObject, paramAnonymousLong);
            }
            for (;;)
            {
              return;
              localObject = selection.ambSubscribers.iterator();
              while (((Iterator)localObject).hasNext())
              {
                OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)((Iterator)localObject).next();
                if (!localAmbSubscriber.isUnsubscribed())
                {
                  if (choice.get() == localAmbSubscriber)
                  {
                    OnSubscribeAmb.AmbSubscriber.access$300(localAmbSubscriber, paramAnonymousLong);
                    return;
                  }
                  OnSubscribeAmb.AmbSubscriber.access$300(localAmbSubscriber, paramAnonymousLong);
                }
              }
            }
          }
        });
        return;
      }
      AmbSubscriber localAmbSubscriber1 = new AmbSubscriber(0L, paramSubscriber, selection, null);
      selection.ambSubscribers.add(localAmbSubscriber1);
      AmbSubscriber localAmbSubscriber2 = (AmbSubscriber)choice.get();
      if (localAmbSubscriber2 != null)
      {
        selection.unsubscribeOthers(localAmbSubscriber2);
        return;
      }
      localObservable.unsafeSubscribe(localAmbSubscriber1);
    }
  }
  
  private static final class AmbSubscriber<T>
    extends Subscriber<T>
  {
    private boolean chosen;
    private final OnSubscribeAmb.Selection<T> selection;
    private final Subscriber<? super T> subscriber;
    
    private AmbSubscriber(long paramLong, Subscriber<? super T> paramSubscriber, OnSubscribeAmb.Selection<T> paramSelection)
    {
      subscriber = paramSubscriber;
      selection = paramSelection;
      request(paramLong);
    }
    
    private boolean isSelected()
    {
      if (chosen) {
        return true;
      }
      if (selection.choice.get() == this)
      {
        chosen = true;
        return true;
      }
      if (selection.choice.compareAndSet(null, this))
      {
        selection.unsubscribeOthers(this);
        chosen = true;
        return true;
      }
      selection.unsubscribeLosers();
      return false;
    }
    
    private final void requestMore(long paramLong)
    {
      request(paramLong);
    }
    
    public void onCompleted()
    {
      if (!isSelected()) {
        return;
      }
      subscriber.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (!isSelected()) {
        return;
      }
      subscriber.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (!isSelected()) {
        return;
      }
      subscriber.onNext(paramT);
    }
  }
  
  private static class Selection<T>
  {
    final Collection<OnSubscribeAmb.AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();
    final AtomicReference<OnSubscribeAmb.AmbSubscriber<T>> choice = new AtomicReference();
    
    public void unsubscribeLosers()
    {
      OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)choice.get();
      if (localAmbSubscriber != null) {
        unsubscribeOthers(localAmbSubscriber);
      }
    }
    
    public void unsubscribeOthers(OnSubscribeAmb.AmbSubscriber<T> paramAmbSubscriber)
    {
      Iterator localIterator = ambSubscribers.iterator();
      while (localIterator.hasNext())
      {
        OnSubscribeAmb.AmbSubscriber localAmbSubscriber = (OnSubscribeAmb.AmbSubscriber)localIterator.next();
        if (localAmbSubscriber != paramAmbSubscriber) {
          localAmbSubscriber.unsubscribe();
        }
      }
      ambSubscribers.clear();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeAmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */