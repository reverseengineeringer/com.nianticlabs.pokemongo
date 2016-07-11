package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$2
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$2(ReplaySubject.UnboundedReplayState paramUnboundedReplayState) {}
  
  /* Error */
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    // Byte code:
    //   0: aload_1
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   6: ifeq +10 -> 16
    //   9: aload_1
    //   10: getfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   13: ifeq +6 -> 19
    //   16: aload_1
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: iconst_0
    //   21: putfield 33	rx/subjects/SubjectSubscriptionManager$SubjectObserver:first	Z
    //   24: aload_1
    //   25: iconst_1
    //   26: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   29: aload_1
    //   30: monitorexit
    //   31: iconst_0
    //   32: istore 4
    //   34: iconst_0
    //   35: istore_3
    //   36: iload 4
    //   38: istore_2
    //   39: aload_1
    //   40: invokevirtual 40	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	()Ljava/lang/Object;
    //   43: checkcast 42	java/lang/Integer
    //   46: invokevirtual 46	java/lang/Integer:intValue	()I
    //   49: istore 6
    //   51: iload 4
    //   53: istore_2
    //   54: aload_0
    //   55: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
    //   58: getfield 51	rx/subjects/ReplaySubject$UnboundedReplayState:index	I
    //   61: istore 5
    //   63: iload 6
    //   65: iload 5
    //   67: if_icmpeq +23 -> 90
    //   70: iload 4
    //   72: istore_2
    //   73: aload_1
    //   74: aload_0
    //   75: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
    //   78: iload 6
    //   80: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aload_1
    //   84: invokevirtual 59	rx/subjects/ReplaySubject$UnboundedReplayState:replayObserverFromIndex	(Ljava/lang/Integer;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Ljava/lang/Integer;
    //   87: invokevirtual 61	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   90: iload 4
    //   92: istore_2
    //   93: aload_1
    //   94: monitorenter
    //   95: iload_3
    //   96: istore_2
    //   97: iload 5
    //   99: aload_0
    //   100: getfield 18	rx/subjects/ReplaySubject$2:val$state	Lrx/subjects/ReplaySubject$UnboundedReplayState;
    //   103: getfield 51	rx/subjects/ReplaySubject$UnboundedReplayState:index	I
    //   106: if_icmpne +42 -> 148
    //   109: iload_3
    //   110: istore_2
    //   111: aload_1
    //   112: iconst_0
    //   113: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   116: iconst_1
    //   117: istore_2
    //   118: aload_1
    //   119: monitorexit
    //   120: iconst_1
    //   121: ifne +66 -> 187
    //   124: aload_1
    //   125: monitorenter
    //   126: aload_1
    //   127: iconst_0
    //   128: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   131: aload_1
    //   132: monitorexit
    //   133: return
    //   134: astore 7
    //   136: aload_1
    //   137: monitorexit
    //   138: aload 7
    //   140: athrow
    //   141: astore 7
    //   143: aload_1
    //   144: monitorexit
    //   145: aload 7
    //   147: athrow
    //   148: iload_3
    //   149: istore_2
    //   150: aload_1
    //   151: monitorexit
    //   152: goto -116 -> 36
    //   155: astore 7
    //   157: aload_1
    //   158: monitorexit
    //   159: aload 7
    //   161: athrow
    //   162: astore 7
    //   164: iload_2
    //   165: ifne +12 -> 177
    //   168: aload_1
    //   169: monitorenter
    //   170: aload_1
    //   171: iconst_0
    //   172: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   175: aload_1
    //   176: monitorexit
    //   177: aload 7
    //   179: athrow
    //   180: astore 7
    //   182: aload_1
    //   183: monitorexit
    //   184: aload 7
    //   186: athrow
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	2
    //   0	188	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   38	127	2	i	int
    //   35	114	3	j	int
    //   32	59	4	k	int
    //   61	46	5	m	int
    //   49	30	6	n	int
    //   134	5	7	localObject1	Object
    //   141	5	7	localObject2	Object
    //   155	5	7	localObject3	Object
    //   162	16	7	localObject4	Object
    //   180	5	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   126	133	134	finally
    //   136	138	134	finally
    //   2	16	141	finally
    //   16	18	141	finally
    //   19	31	141	finally
    //   143	145	141	finally
    //   97	109	155	finally
    //   111	116	155	finally
    //   118	120	155	finally
    //   150	152	155	finally
    //   157	159	155	finally
    //   39	51	162	finally
    //   54	63	162	finally
    //   73	90	162	finally
    //   93	95	162	finally
    //   159	162	162	finally
    //   170	177	180	finally
    //   182	184	180	finally
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */