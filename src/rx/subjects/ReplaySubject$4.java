package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$4
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$4(ReplaySubject.BoundedState paramBoundedState) {}
  
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
    //   43: checkcast 42	rx/subjects/ReplaySubject$NodeList$Node
    //   46: astore 5
    //   48: iload 4
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   55: invokevirtual 48	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   58: astore 6
    //   60: aload 5
    //   62: aload 6
    //   64: if_acmpeq +20 -> 84
    //   67: iload 4
    //   69: istore_2
    //   70: aload_1
    //   71: aload_0
    //   72: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   75: aload 5
    //   77: aload_1
    //   78: invokevirtual 52	rx/subjects/ReplaySubject$BoundedState:replayObserverFromIndex	(Lrx/subjects/ReplaySubject$NodeList$Node;Lrx/subjects/SubjectSubscriptionManager$SubjectObserver;)Lrx/subjects/ReplaySubject$NodeList$Node;
    //   81: invokevirtual 54	rx/subjects/SubjectSubscriptionManager$SubjectObserver:index	(Ljava/lang/Object;)V
    //   84: iload 4
    //   86: istore_2
    //   87: aload_1
    //   88: monitorenter
    //   89: iload_3
    //   90: istore_2
    //   91: aload 6
    //   93: aload_0
    //   94: getfield 18	rx/subjects/ReplaySubject$4:val$state	Lrx/subjects/ReplaySubject$BoundedState;
    //   97: invokevirtual 48	rx/subjects/ReplaySubject$BoundedState:tail	()Lrx/subjects/ReplaySubject$NodeList$Node;
    //   100: if_acmpne +42 -> 142
    //   103: iload_3
    //   104: istore_2
    //   105: aload_1
    //   106: iconst_0
    //   107: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   110: iconst_1
    //   111: istore_2
    //   112: aload_1
    //   113: monitorexit
    //   114: iconst_1
    //   115: ifne +66 -> 181
    //   118: aload_1
    //   119: monitorenter
    //   120: aload_1
    //   121: iconst_0
    //   122: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   125: aload_1
    //   126: monitorexit
    //   127: return
    //   128: astore 5
    //   130: aload_1
    //   131: monitorexit
    //   132: aload 5
    //   134: athrow
    //   135: astore 5
    //   137: aload_1
    //   138: monitorexit
    //   139: aload 5
    //   141: athrow
    //   142: iload_3
    //   143: istore_2
    //   144: aload_1
    //   145: monitorexit
    //   146: goto -110 -> 36
    //   149: astore 5
    //   151: aload_1
    //   152: monitorexit
    //   153: aload 5
    //   155: athrow
    //   156: astore 5
    //   158: iload_2
    //   159: ifne +12 -> 171
    //   162: aload_1
    //   163: monitorenter
    //   164: aload_1
    //   165: iconst_0
    //   166: putfield 36	rx/subjects/SubjectSubscriptionManager$SubjectObserver:emitting	Z
    //   169: aload_1
    //   170: monitorexit
    //   171: aload 5
    //   173: athrow
    //   174: astore 5
    //   176: aload_1
    //   177: monitorexit
    //   178: aload 5
    //   180: athrow
    //   181: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	4
    //   0	182	1	paramSubjectObserver	SubjectSubscriptionManager.SubjectObserver<T>
    //   38	121	2	i	int
    //   35	108	3	j	int
    //   32	53	4	k	int
    //   46	30	5	localNode1	ReplaySubject.NodeList.Node
    //   128	5	5	localObject1	Object
    //   135	5	5	localObject2	Object
    //   149	5	5	localObject3	Object
    //   156	16	5	localObject4	Object
    //   174	5	5	localObject5	Object
    //   58	34	6	localNode2	ReplaySubject.NodeList.Node
    // Exception table:
    //   from	to	target	type
    //   120	127	128	finally
    //   130	132	128	finally
    //   2	16	135	finally
    //   16	18	135	finally
    //   19	31	135	finally
    //   137	139	135	finally
    //   91	103	149	finally
    //   105	110	149	finally
    //   112	114	149	finally
    //   144	146	149	finally
    //   151	153	149	finally
    //   39	48	156	finally
    //   51	60	156	finally
    //   70	84	156	finally
    //   87	89	156	finally
    //   153	156	156	finally
    //   164	171	174	finally
    //   176	178	174	finally
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */