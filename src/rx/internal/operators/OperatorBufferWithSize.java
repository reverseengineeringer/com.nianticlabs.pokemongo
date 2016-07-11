package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

public final class OperatorBufferWithSize<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final int skip;
  
  public OperatorBufferWithSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("count must be greater than 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("skip must be greater than 0");
    }
    count = paramInt1;
    skip = paramInt2;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super List<T>> paramSubscriber)
  {
    if (count == skip) {
      new Subscriber(paramSubscriber)
      {
        List<T> buffer;
        
        public void onCompleted()
        {
          List localList = buffer;
          buffer = null;
          if (localList != null) {}
          try
          {
            paramSubscriber.onNext(localList);
            paramSubscriber.onCompleted();
            return;
          }
          catch (Throwable localThrowable)
          {
            onError(localThrowable);
          }
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          buffer = null;
          paramSubscriber.onError(paramAnonymousThrowable);
        }
        
        public void onNext(T paramAnonymousT)
        {
          if (buffer == null) {
            buffer = new ArrayList(count);
          }
          buffer.add(paramAnonymousT);
          if (buffer.size() == count)
          {
            paramAnonymousT = buffer;
            buffer = null;
            paramSubscriber.onNext(paramAnonymousT);
          }
        }
        
        public void setProducer(final Producer paramAnonymousProducer)
        {
          paramSubscriber.setProducer(new Producer()
          {
            private volatile boolean infinite = false;
            
            public void request(long paramAnonymous2Long)
            {
              if (infinite) {
                return;
              }
              if (paramAnonymous2Long >= Long.MAX_VALUE / count)
              {
                infinite = true;
                paramAnonymousProducer.request(Long.MAX_VALUE);
                return;
              }
              paramAnonymousProducer.request(count * paramAnonymous2Long);
            }
          });
        }
      };
    }
    new Subscriber(paramSubscriber)
    {
      final List<List<T>> chunks = new LinkedList();
      int index;
      
      public void onCompleted()
      {
        try
        {
          Iterator localIterator = chunks.iterator();
          while (localIterator.hasNext())
          {
            List localList = (List)localIterator.next();
            try
            {
              paramSubscriber.onNext(localList);
            }
            catch (Throwable localThrowable)
            {
              onError(localThrowable);
              return;
            }
          }
          paramSubscriber.onCompleted();
          return;
        }
        finally
        {
          chunks.clear();
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        chunks.clear();
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        int i = index;
        index = (i + 1);
        if (i % skip == 0) {
          chunks.add(new ArrayList(count));
        }
        Iterator localIterator = chunks.iterator();
        while (localIterator.hasNext())
        {
          List localList = (List)localIterator.next();
          localList.add(paramAnonymousT);
          if (localList.size() == count)
          {
            localIterator.remove();
            paramSubscriber.onNext(localList);
          }
        }
      }
      
      public void setProducer(final Producer paramAnonymousProducer)
      {
        paramSubscriber.setProducer(new Producer()
        {
          private volatile boolean firstRequest = true;
          private volatile boolean infinite = false;
          
          private void requestInfinite()
          {
            infinite = true;
            paramAnonymousProducer.request(Long.MAX_VALUE);
          }
          
          public void request(long paramAnonymous2Long)
          {
            if (paramAnonymous2Long == 0L) {}
            do
            {
              return;
              if (paramAnonymous2Long < 0L) {
                throw new IllegalArgumentException("request a negative number: " + paramAnonymous2Long);
              }
            } while (infinite);
            if (paramAnonymous2Long == Long.MAX_VALUE)
            {
              requestInfinite();
              return;
            }
            if (firstRequest)
            {
              firstRequest = false;
              if (paramAnonymous2Long - 1L >= (Long.MAX_VALUE - count) / skip)
              {
                requestInfinite();
                return;
              }
              paramAnonymousProducer.request(count + skip * (paramAnonymous2Long - 1L));
              return;
            }
            if (paramAnonymous2Long >= Long.MAX_VALUE / skip)
            {
              requestInfinite();
              return;
            }
            paramAnonymousProducer.request(skip * paramAnonymous2Long);
          }
        });
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */