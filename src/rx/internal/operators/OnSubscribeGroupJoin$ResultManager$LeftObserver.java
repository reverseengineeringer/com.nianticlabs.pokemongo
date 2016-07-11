package rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import rx.Subscriber;

final class OnSubscribeGroupJoin$ResultManager$LeftObserver
  extends Subscriber<T1>
{
  OnSubscribeGroupJoin$ResultManager$LeftObserver(OnSubscribeGroupJoin.ResultManager paramResultManager) {}
  
  public void onCompleted()
  {
    ArrayList localArrayList = null;
    synchronized (this$1.guard)
    {
      this$1.leftDone = true;
      if (this$1.rightDone) {
        localArrayList = new ArrayList(this$1.leftMap.values());
      }
    }
    throw ((Throwable)localObject1);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.errorAll(paramThrowable);
  }
  
  /* Error */
  public void onNext(T1 arg1)
  {
    // Byte code:
    //   0: invokestatic 73	rx/subjects/PublishSubject:create	()Lrx/subjects/PublishSubject;
    //   3: astore 5
    //   5: new 75	rx/observers/SerializedObserver
    //   8: dup
    //   9: aload 5
    //   11: invokespecial 78	rx/observers/SerializedObserver:<init>	(Lrx/Observer;)V
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   19: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
    //   22: astore 4
    //   24: aload 4
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 82	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftIds	I
    //   38: istore_2
    //   39: aload 6
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: putfield 82	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftIds	I
    //   47: aload_0
    //   48: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   51: getfield 39	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:leftMap	Ljava/util/Map;
    //   54: iload_2
    //   55: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aload_3
    //   59: invokeinterface 92 3 0
    //   64: pop
    //   65: aload 4
    //   67: monitorexit
    //   68: new 94	rx/internal/operators/OnSubscribeGroupJoin$WindowObservableFunc
    //   71: dup
    //   72: aload 5
    //   74: aload_0
    //   75: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   78: getfield 98	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:cancel	Lrx/subscriptions/RefCountSubscription;
    //   81: invokespecial 101	rx/internal/operators/OnSubscribeGroupJoin$WindowObservableFunc:<init>	(Lrx/Observable;Lrx/subscriptions/RefCountSubscription;)V
    //   84: invokestatic 106	rx/Observable:create	(Lrx/Observable$OnSubscribe;)Lrx/Observable;
    //   87: astore 4
    //   89: aload_0
    //   90: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   93: getfield 110	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:this$0	Lrx/internal/operators/OnSubscribeGroupJoin;
    //   96: getfield 114	rx/internal/operators/OnSubscribeGroupJoin:leftDuration	Lrx/functions/Func1;
    //   99: aload_1
    //   100: invokeinterface 120 2 0
    //   105: checkcast 103	rx/Observable
    //   108: astore 5
    //   110: new 122	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftDurationObserver
    //   113: dup
    //   114: aload_0
    //   115: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   118: iload_2
    //   119: invokespecial 125	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftDurationObserver:<init>	(Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;I)V
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   128: getfield 129	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:group	Lrx/subscriptions/CompositeSubscription;
    //   131: aload 6
    //   133: invokevirtual 135	rx/subscriptions/CompositeSubscription:add	(Lrx/Subscription;)V
    //   136: aload 5
    //   138: aload 6
    //   140: invokevirtual 139	rx/Observable:unsafeSubscribe	(Lrx/Subscriber;)Lrx/Subscription;
    //   143: pop
    //   144: aload_0
    //   145: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   148: getfield 110	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:this$0	Lrx/internal/operators/OnSubscribeGroupJoin;
    //   151: getfield 143	rx/internal/operators/OnSubscribeGroupJoin:resultSelector	Lrx/functions/Func2;
    //   154: aload_1
    //   155: aload 4
    //   157: invokeinterface 147 3 0
    //   162: astore 4
    //   164: aload_0
    //   165: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   168: getfield 26	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:guard	Ljava/lang/Object;
    //   171: astore_1
    //   172: aload_1
    //   173: monitorenter
    //   174: new 35	java/util/ArrayList
    //   177: dup
    //   178: aload_0
    //   179: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   182: getfield 54	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:rightMap	Ljava/util/Map;
    //   185: invokeinterface 45 1 0
    //   190: invokespecial 48	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   193: astore 5
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_0
    //   198: getfield 17	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:this$1	Lrx/internal/operators/OnSubscribeGroupJoin$ResultManager;
    //   201: getfield 151	rx/internal/operators/OnSubscribeGroupJoin$ResultManager:subscriber	Lrx/Subscriber;
    //   204: aload 4
    //   206: invokevirtual 153	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   209: aload 5
    //   211: invokeinterface 159 1 0
    //   216: astore_1
    //   217: aload_1
    //   218: invokeinterface 165 1 0
    //   223: ifeq +24 -> 247
    //   226: aload_3
    //   227: aload_1
    //   228: invokeinterface 169 1 0
    //   233: invokeinterface 172 2 0
    //   238: goto -21 -> 217
    //   241: astore_1
    //   242: aload_0
    //   243: aload_1
    //   244: invokevirtual 174	rx/internal/operators/OnSubscribeGroupJoin$ResultManager$LeftObserver:onError	(Ljava/lang/Throwable;)V
    //   247: return
    //   248: astore_1
    //   249: aload 4
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    //   254: astore_3
    //   255: aload_1
    //   256: monitorexit
    //   257: aload_3
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	LeftObserver
    //   38	81	2	i	int
    //   14	213	3	localSerializedObserver	rx.observers.SerializedObserver
    //   254	4	3	localObject1	Object
    //   3	207	5	localObject3	Object
    //   31	108	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	27	241	java/lang/Throwable
    //   68	174	241	java/lang/Throwable
    //   197	217	241	java/lang/Throwable
    //   217	238	241	java/lang/Throwable
    //   252	254	241	java/lang/Throwable
    //   257	259	241	java/lang/Throwable
    //   27	68	248	finally
    //   249	252	248	finally
    //   174	197	254	finally
    //   255	257	254	finally
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.ResultManager.LeftObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */