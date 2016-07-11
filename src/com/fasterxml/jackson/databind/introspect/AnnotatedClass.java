package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class AnnotatedClass
  extends Annotated
{
  private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final Class<?> _class;
  protected AnnotationMap _classAnnotations;
  protected List<AnnotatedConstructor> _constructors;
  protected List<AnnotatedMethod> _creatorMethods;
  protected boolean _creatorsResolved = false;
  protected AnnotatedConstructor _defaultConstructor;
  protected List<AnnotatedField> _fields;
  protected AnnotatedMethodMap _memberMethods;
  protected final ClassIntrospector.MixInResolver _mixInResolver;
  protected final Class<?> _primaryMixIn;
  protected final List<Class<?>> _superTypes;
  
  private AnnotatedClass(Class<?> paramClass, List<Class<?>> paramList, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver, AnnotationMap paramAnnotationMap)
  {
    _class = paramClass;
    _superTypes = paramList;
    _annotationIntrospector = paramAnnotationIntrospector;
    _mixInResolver = paramMixInResolver;
    if (_mixInResolver == null) {}
    for (paramClass = null;; paramClass = _mixInResolver.findMixInClassFor(_class))
    {
      _primaryMixIn = paramClass;
      _classAnnotations = paramAnnotationMap;
      return;
    }
  }
  
  private AnnotationMap _addAnnotationsIfNotPresent(AnnotationMap paramAnnotationMap, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      Object localObject1 = null;
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        Object localObject2 = localObject1;
        if (paramAnnotationMap.addIfNotPresent(localAnnotation))
        {
          localObject2 = localObject1;
          if (_isAnnotationBundle(localAnnotation)) {
            localObject2 = _addFromBundle(localAnnotation, (List)localObject1);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        _addAnnotationsIfNotPresent(paramAnnotationMap, (Annotation[])((List)localObject1).toArray(new Annotation[((List)localObject1).size()]));
      }
    }
    return paramAnnotationMap;
  }
  
  private void _addAnnotationsIfNotPresent(AnnotatedMember paramAnnotatedMember, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      Object localObject1 = null;
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        Object localObject2 = localObject1;
        if (paramAnnotatedMember.addIfNotPresent(localAnnotation))
        {
          localObject2 = localObject1;
          if (_isAnnotationBundle(localAnnotation)) {
            localObject2 = _addFromBundle(localAnnotation, (List)localObject1);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        _addAnnotationsIfNotPresent(paramAnnotatedMember, (Annotation[])((List)localObject1).toArray(new Annotation[((List)localObject1).size()]));
      }
    }
  }
  
  private List<Annotation> _addFromBundle(Annotation paramAnnotation, List<Annotation> paramList)
  {
    Annotation[] arrayOfAnnotation = paramAnnotation.annotationType().getDeclaredAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    if (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      paramAnnotation = paramList;
      if (!(localAnnotation instanceof Target))
      {
        if (!(localAnnotation instanceof Retention)) {
          break label59;
        }
        paramAnnotation = paramList;
      }
      for (;;)
      {
        i += 1;
        paramList = paramAnnotation;
        break;
        label59:
        paramAnnotation = paramList;
        if (paramList == null) {
          paramAnnotation = new ArrayList();
        }
        paramAnnotation.add(localAnnotation);
      }
    }
    return paramList;
  }
  
  private void _addOrOverrideAnnotations(AnnotatedMember paramAnnotatedMember, Annotation[] paramArrayOfAnnotation)
  {
    if (paramArrayOfAnnotation != null)
    {
      Object localObject1 = null;
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        Object localObject2 = localObject1;
        if (paramAnnotatedMember.addOrOverride(localAnnotation))
        {
          localObject2 = localObject1;
          if (_isAnnotationBundle(localAnnotation)) {
            localObject2 = _addFromBundle(localAnnotation, (List)localObject1);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        _addOrOverrideAnnotations(paramAnnotatedMember, (Annotation[])((List)localObject1).toArray(new Annotation[((List)localObject1).size()]));
      }
    }
  }
  
  private AnnotationMap _emptyAnnotationMap()
  {
    return new AnnotationMap();
  }
  
  private AnnotationMap[] _emptyAnnotationMaps(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = NO_ANNOTATION_MAPS;
      return (AnnotationMap[])localObject;
    }
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[paramInt];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfAnnotationMap;
      if (i >= paramInt) {
        break;
      }
      arrayOfAnnotationMap[i] = _emptyAnnotationMap();
      i += 1;
    }
  }
  
  private final boolean _isAnnotationBundle(Annotation paramAnnotation)
  {
    return (_annotationIntrospector != null) && (_annotationIntrospector.isAnnotationBundle(paramAnnotation));
  }
  
  private boolean _isIncludableField(Field paramField)
  {
    if (paramField.isSynthetic()) {}
    while (Modifier.isStatic(paramField.getModifiers())) {
      return false;
    }
    return true;
  }
  
  public static AnnotatedClass construct(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return new AnnotatedClass(paramClass, ClassUtil.findSuperTypes(paramClass, null), paramAnnotationIntrospector, paramMixInResolver, null);
  }
  
  public static AnnotatedClass constructWithoutSuperTypes(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return new AnnotatedClass(paramClass, Collections.emptyList(), paramAnnotationIntrospector, paramMixInResolver, null);
  }
  
  private void resolveClassAnnotations()
  {
    _classAnnotations = new AnnotationMap();
    if (_annotationIntrospector != null)
    {
      if (_primaryMixIn != null) {
        _addClassMixIns(_classAnnotations, _class, _primaryMixIn);
      }
      _addAnnotationsIfNotPresent(_classAnnotations, _class.getDeclaredAnnotations());
      Iterator localIterator = _superTypes.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        _addClassMixIns(_classAnnotations, localClass);
        _addAnnotationsIfNotPresent(_classAnnotations, localClass.getDeclaredAnnotations());
      }
      _addClassMixIns(_classAnnotations, Object.class);
    }
  }
  
  private void resolveCreators()
  {
    Object localObject1 = null;
    Object localObject3 = _class.getDeclaredConstructors();
    int j = localObject3.length;
    int i = 0;
    Constructor localConstructor;
    Object localObject2;
    if (i < j)
    {
      localConstructor = localObject3[i];
      if (localConstructor.getParameterTypes().length == 0) {
        _defaultConstructor = _constructConstructor(localConstructor, true);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(Math.max(10, localObject3.length));
        }
        ((List)localObject2).add(_constructConstructor(localConstructor, false));
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {}
    for (_constructors = Collections.emptyList();; _constructors = ((List)localObject1))
    {
      if ((_primaryMixIn != null) && ((_defaultConstructor != null) || (!_constructors.isEmpty()))) {
        _addConstructorMixIns(_primaryMixIn);
      }
      if (_annotationIntrospector == null) {
        break;
      }
      if ((_defaultConstructor != null) && (_annotationIntrospector.hasIgnoreMarker(_defaultConstructor))) {
        _defaultConstructor = null;
      }
      if (_constructors == null) {
        break;
      }
      i = _constructors.size();
      for (;;)
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
        if (_annotationIntrospector.hasIgnoreMarker((AnnotatedMember)_constructors.get(j)))
        {
          _constructors.remove(j);
          i = j;
        }
      }
    }
    localObject1 = null;
    localObject3 = _findClassMethods(_class);
    j = localObject3.length;
    i = 0;
    if (i < j)
    {
      localConstructor = localObject3[i];
      if (!Modifier.isStatic(localConstructor.getModifiers())) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(8);
        }
        ((List)localObject2).add(_constructCreatorMethod(localConstructor));
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      _creatorMethods = Collections.emptyList();
    }
    do
    {
      _creatorsResolved = true;
      return;
      _creatorMethods = ((List)localObject1);
      if (_primaryMixIn != null) {
        _addFactoryMixIns(_primaryMixIn);
      }
    } while (_annotationIntrospector == null);
    i = _creatorMethods.size();
    for (;;)
    {
      j = i - 1;
      if (j < 0) {
        break;
      }
      i = j;
      if (_annotationIntrospector.hasIgnoreMarker((AnnotatedMember)_creatorMethods.get(j)))
      {
        _creatorMethods.remove(j);
        i = j;
      }
    }
  }
  
  private void resolveFields()
  {
    Map localMap = _findFields(_class, null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      _fields = Collections.emptyList();
      return;
    }
    _fields = new ArrayList(localMap.size());
    _fields.addAll(localMap.values());
  }
  
  private void resolveMemberMethods()
  {
    _memberMethods = new AnnotatedMethodMap();
    Object localObject2 = new AnnotatedMethodMap();
    _addMemberMethods(_class, _memberMethods, _primaryMixIn, (AnnotatedMethodMap)localObject2);
    Object localObject3 = _superTypes.iterator();
    Object localObject1;
    if (((Iterator)localObject3).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject3).next();
      if (_mixInResolver == null) {}
      for (localObject1 = null;; localObject1 = _mixInResolver.findMixInClassFor(localClass))
      {
        _addMemberMethods(localClass, _memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
        break;
      }
    }
    if (_mixInResolver != null)
    {
      localObject1 = _mixInResolver.findMixInClassFor(Object.class);
      if (localObject1 != null) {
        _addMethodMixIns(_class, _memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
      }
    }
    if ((_annotationIntrospector != null) && (!((AnnotatedMethodMap)localObject2).isEmpty()))
    {
      localObject1 = ((AnnotatedMethodMap)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AnnotatedMethod)((Iterator)localObject1).next();
        try
        {
          localObject3 = Object.class.getDeclaredMethod(((AnnotatedMethod)localObject2).getName(), ((AnnotatedMethod)localObject2).getRawParameterTypes());
          if (localObject3 != null)
          {
            localObject3 = _constructMethod((Method)localObject3);
            _addMixOvers(((AnnotatedMethod)localObject2).getAnnotated(), (AnnotatedMethod)localObject3, false);
            _memberMethods.add((AnnotatedMethod)localObject3);
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass)
  {
    if (_mixInResolver != null) {
      _addClassMixIns(paramAnnotationMap, paramClass, _mixInResolver.findMixInClassFor(paramClass));
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == null) {}
    for (;;)
    {
      return;
      _addAnnotationsIfNotPresent(paramAnnotationMap, paramClass2.getDeclaredAnnotations());
      paramClass1 = ClassUtil.findSuperTypes(paramClass2, paramClass1).iterator();
      while (paramClass1.hasNext()) {
        _addAnnotationsIfNotPresent(paramAnnotationMap, ((Class)paramClass1.next()).getDeclaredAnnotations());
      }
    }
  }
  
  protected void _addConstructorMixIns(Class<?> paramClass)
  {
    Object localObject1 = null;
    int i;
    int j;
    label25:
    Constructor localConstructor;
    Object localObject2;
    if (_constructors == null)
    {
      i = 0;
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      int m = arrayOfConstructor.length;
      j = 0;
      if (j >= m) {
        return;
      }
      localConstructor = arrayOfConstructor[j];
      if (localConstructor.getParameterTypes().length != 0) {
        break label96;
      }
      localObject2 = localObject1;
      if (_defaultConstructor != null)
      {
        _addMixOvers(localConstructor, _defaultConstructor, false);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      j += 1;
      localObject1 = localObject2;
      break label25;
      i = _constructors.size();
      break;
      label96:
      paramClass = (Class<?>)localObject1;
      if (localObject1 == null)
      {
        localObject1 = new MemberKey[i];
        k = 0;
        for (;;)
        {
          paramClass = (Class<?>)localObject1;
          if (k >= i) {
            break;
          }
          localObject1[k] = new MemberKey(((AnnotatedConstructor)_constructors.get(k)).getAnnotated());
          k += 1;
        }
      }
      localObject1 = new MemberKey(localConstructor);
      int k = 0;
      for (;;)
      {
        localObject2 = paramClass;
        if (k >= i) {
          break;
        }
        if (((MemberKey)localObject1).equals(paramClass[k])) {
          break label204;
        }
        k += 1;
      }
      label204:
      _addMixOvers(localConstructor, (AnnotatedConstructor)_constructors.get(k), true);
      localObject2 = paramClass;
    }
  }
  
  protected void _addFactoryMixIns(Class<?> paramClass)
  {
    Object localObject1 = null;
    int k = _creatorMethods.size();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int m = arrayOfMethod.length;
    int i = 0;
    if (i < m)
    {
      Method localMethod = arrayOfMethod[i];
      Object localObject2;
      if (!Modifier.isStatic(localMethod.getModifiers())) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (localMethod.getParameterTypes().length != 0)
        {
          paramClass = (Class<?>)localObject1;
          if (localObject1 == null)
          {
            localObject1 = new MemberKey[k];
            j = 0;
            for (;;)
            {
              paramClass = (Class<?>)localObject1;
              if (j >= k) {
                break;
              }
              localObject1[j] = new MemberKey(((AnnotatedMethod)_creatorMethods.get(j)).getAnnotated());
              j += 1;
            }
          }
          localObject1 = new MemberKey(localMethod);
          int j = 0;
          for (;;)
          {
            localObject2 = paramClass;
            if (j >= k) {
              break;
            }
            if (((MemberKey)localObject1).equals(paramClass[j])) {
              break label178;
            }
            j += 1;
          }
          label178:
          _addMixOvers(localMethod, (AnnotatedMethod)_creatorMethods.get(j), true);
          localObject2 = paramClass;
        }
      }
    }
  }
  
  protected void _addFieldMixIns(Class<?> paramClass1, Class<?> paramClass2, Map<String, AnnotatedField> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramClass2);
    ClassUtil.findSuperTypes(paramClass2, paramClass1, localArrayList);
    paramClass1 = localArrayList.iterator();
    if (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredFields();
      int j = paramClass2.length;
      int i = 0;
      label63:
      if (i < j)
      {
        localArrayList = paramClass2[i];
        if (_isIncludableField(localArrayList)) {
          break label94;
        }
      }
      for (;;)
      {
        i += 1;
        break label63;
        break;
        label94:
        AnnotatedField localAnnotatedField = (AnnotatedField)paramMap.get(localArrayList.getName());
        if (localAnnotatedField != null) {
          _addOrOverrideAnnotations(localAnnotatedField, localArrayList.getDeclaredAnnotations());
        }
      }
    }
  }
  
  protected void _addMemberMethods(Class<?> paramClass1, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    if (paramClass2 != null) {
      _addMethodMixIns(paramClass1, paramAnnotatedMethodMap1, paramClass2, paramAnnotatedMethodMap2);
    }
    if (paramClass1 == null) {
      return;
    }
    paramClass1 = _findClassMethods(paramClass1);
    int j = paramClass1.length;
    int i = 0;
    label31:
    if (i < j)
    {
      paramClass2 = paramClass1[i];
      if (_isIncludableMemberMethod(paramClass2)) {
        break label60;
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label60:
      AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(paramClass2);
      if (localAnnotatedMethod == null)
      {
        localAnnotatedMethod = _constructMethod(paramClass2);
        paramAnnotatedMethodMap1.add(localAnnotatedMethod);
        paramClass2 = paramAnnotatedMethodMap2.remove(paramClass2);
        if (paramClass2 != null) {
          _addMixOvers(paramClass2.getAnnotated(), localAnnotatedMethod, false);
        }
      }
      else
      {
        _addMixUnders(paramClass2, localAnnotatedMethod);
        if ((localAnnotatedMethod.getDeclaringClass().isInterface()) && (!paramClass2.getDeclaringClass().isInterface())) {
          paramAnnotatedMethodMap1.add(localAnnotatedMethod.withMethod(paramClass2));
        }
      }
    }
  }
  
  protected void _addMethodMixIns(Class<?> paramClass1, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramClass2);
    ClassUtil.findSuperTypes(paramClass2, paramClass1, localArrayList);
    paramClass1 = localArrayList.iterator();
    if (paramClass1.hasNext())
    {
      paramClass2 = ((Class)paramClass1.next()).getDeclaredMethods();
      int j = paramClass2.length;
      int i = 0;
      label63:
      if (i < j)
      {
        localArrayList = paramClass2[i];
        if (_isIncludableMemberMethod(localArrayList)) {
          break label94;
        }
      }
      for (;;)
      {
        i += 1;
        break label63;
        break;
        label94:
        AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(localArrayList);
        if (localAnnotatedMethod != null)
        {
          _addMixUnders(localArrayList, localAnnotatedMethod);
        }
        else
        {
          localAnnotatedMethod = paramAnnotatedMethodMap2.find(localArrayList);
          if (localAnnotatedMethod != null) {
            _addMixUnders(localArrayList, localAnnotatedMethod);
          } else {
            paramAnnotatedMethodMap2.add(_constructMethod(localArrayList));
          }
        }
      }
    }
  }
  
  protected void _addMixOvers(Constructor<?> paramConstructor, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean)
  {
    _addOrOverrideAnnotations(paramAnnotatedConstructor, paramConstructor.getDeclaredAnnotations());
    if (paramBoolean)
    {
      paramConstructor = paramConstructor.getParameterAnnotations();
      int i = 0;
      int k = paramConstructor.length;
      while (i < k)
      {
        Object localObject = paramConstructor[i];
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          paramAnnotatedConstructor.addOrOverrideParam(i, localObject[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixOvers(Method paramMethod, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
  {
    _addOrOverrideAnnotations(paramAnnotatedMethod, paramMethod.getDeclaredAnnotations());
    if (paramBoolean)
    {
      paramMethod = paramMethod.getParameterAnnotations();
      int i = 0;
      int k = paramMethod.length;
      while (i < k)
      {
        Object localObject = paramMethod[i];
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          paramAnnotatedMethod.addOrOverrideParam(i, localObject[j]);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void _addMixUnders(Method paramMethod, AnnotatedMethod paramAnnotatedMethod)
  {
    _addAnnotationsIfNotPresent(paramAnnotatedMethod, paramMethod.getDeclaredAnnotations());
  }
  
  protected AnnotationMap _collectRelevantAnnotations(Annotation[] paramArrayOfAnnotation)
  {
    return _addAnnotationsIfNotPresent(new AnnotationMap(), paramArrayOfAnnotation);
  }
  
  protected AnnotationMap[] _collectRelevantAnnotations(Annotation[][] paramArrayOfAnnotation)
  {
    int j = paramArrayOfAnnotation.length;
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[j];
    int i = 0;
    while (i < j)
    {
      arrayOfAnnotationMap[i] = _collectRelevantAnnotations(paramArrayOfAnnotation[i]);
      i += 1;
    }
    return arrayOfAnnotationMap;
  }
  
  protected AnnotatedConstructor _constructConstructor(Constructor<?> paramConstructor, boolean paramBoolean)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedConstructor(this, paramConstructor, _emptyAnnotationMap(), _emptyAnnotationMaps(paramConstructor.getParameterTypes().length));
    }
    if (paramBoolean) {
      return new AnnotatedConstructor(this, paramConstructor, _collectRelevantAnnotations(paramConstructor.getDeclaredAnnotations()), null);
    }
    Object localObject3 = paramConstructor.getParameterAnnotations();
    int i = paramConstructor.getParameterTypes().length;
    Object localObject4 = null;
    if (i != localObject3.length)
    {
      Class localClass = paramConstructor.getDeclaringClass();
      Object localObject2;
      Object localObject1;
      if ((localClass.isEnum()) && (i == localObject3.length + 2))
      {
        localObject2 = new Annotation[localObject3.length + 2][];
        System.arraycopy(localObject3, 0, localObject2, 2, localObject3.length);
        localObject1 = _collectRelevantAnnotations((Annotation[][])localObject2);
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 != null) {
          break;
        }
        throw new IllegalStateException("Internal error: constructor for " + paramConstructor.getDeclaringClass().getName() + " has mismatch: " + i + " parameters; " + localObject2.length + " sets of annotations");
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (localClass.isMemberClass())
        {
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (i == localObject3.length + 1)
          {
            localObject2 = new Annotation[localObject3.length + 1][];
            System.arraycopy(localObject3, 0, localObject2, 1, localObject3.length);
            localObject1 = _collectRelevantAnnotations((Annotation[][])localObject2);
          }
        }
      }
    }
    localObject3 = _collectRelevantAnnotations((Annotation[][])localObject3);
    return new AnnotatedConstructor(this, paramConstructor, _collectRelevantAnnotations(paramConstructor.getDeclaredAnnotations()), (AnnotationMap[])localObject3);
  }
  
  protected AnnotatedMethod _constructCreatorMethod(Method paramMethod)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedMethod(this, paramMethod, _emptyAnnotationMap(), _emptyAnnotationMaps(paramMethod.getParameterTypes().length));
    }
    return new AnnotatedMethod(this, paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), _collectRelevantAnnotations(paramMethod.getParameterAnnotations()));
  }
  
  protected AnnotatedField _constructField(Field paramField)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedField(this, paramField, _emptyAnnotationMap());
    }
    return new AnnotatedField(this, paramField, _collectRelevantAnnotations(paramField.getDeclaredAnnotations()));
  }
  
  protected AnnotatedMethod _constructMethod(Method paramMethod)
  {
    if (_annotationIntrospector == null) {
      return new AnnotatedMethod(this, paramMethod, _emptyAnnotationMap(), null);
    }
    return new AnnotatedMethod(this, paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), null);
  }
  
  protected Method[] _findClassMethods(Class<?> paramClass)
  {
    try
    {
      Method[] arrayOfMethod = paramClass.getDeclaredMethods();
      return arrayOfMethod;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
      if (localClassLoader == null) {
        throw localNoClassDefFoundError;
      }
      try
      {
        paramClass = localClassLoader.loadClass(paramClass.getName());
        return paramClass.getDeclaredMethods();
      }
      catch (ClassNotFoundException paramClass)
      {
        throw localNoClassDefFoundError;
      }
    }
  }
  
  protected Map<String, AnnotatedField> _findFields(Class<?> paramClass, Map<String, AnnotatedField> paramMap)
  {
    Class localClass = paramClass.getSuperclass();
    Object localObject = paramMap;
    if (localClass != null)
    {
      paramMap = _findFields(localClass, paramMap);
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if (!_isIncludableField(localField)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = paramMap;
          if (paramMap == null) {
            localObject = new LinkedHashMap();
          }
          ((Map)localObject).put(localField.getName(), _constructField(localField));
          paramMap = (Map<String, AnnotatedField>)localObject;
        }
      }
      localObject = paramMap;
      if (_mixInResolver != null)
      {
        paramClass = _mixInResolver.findMixInClassFor(paramClass);
        localObject = paramMap;
        if (paramClass != null)
        {
          _addFieldMixIns(localClass, paramClass, paramMap);
          localObject = paramMap;
        }
      }
    }
    return (Map<String, AnnotatedField>)localObject;
  }
  
  protected boolean _isIncludableMemberMethod(Method paramMethod)
  {
    if (Modifier.isStatic(paramMethod.getModifiers())) {}
    while ((paramMethod.isSynthetic()) || (paramMethod.isBridge()) || (paramMethod.getParameterTypes().length > 2)) {
      return false;
    }
    return true;
  }
  
  public Iterable<Annotation> annotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.annotations();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
    } while (_class == _class);
    return false;
  }
  
  public Iterable<AnnotatedField> fields()
  {
    if (_fields == null) {
      resolveFields();
    }
    return _fields;
  }
  
  public AnnotatedMethod findMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods.find(paramString, paramArrayOfClass);
  }
  
  protected AnnotationMap getAllAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations;
  }
  
  public Class<?> getAnnotated()
  {
    return _class;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.get(paramClass);
  }
  
  public Annotations getAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations;
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _constructors;
  }
  
  public AnnotatedConstructor getDefaultConstructor()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _defaultConstructor;
  }
  
  public int getFieldCount()
  {
    if (_fields == null) {
      resolveFields();
    }
    return _fields.size();
  }
  
  public Type getGenericType()
  {
    return _class;
  }
  
  public int getMemberMethodCount()
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods.size();
  }
  
  public int getModifiers()
  {
    return _class.getModifiers();
  }
  
  public String getName()
  {
    return _class.getName();
  }
  
  public Class<?> getRawType()
  {
    return _class;
  }
  
  public List<AnnotatedMethod> getStaticMethods()
  {
    if (!_creatorsResolved) {
      resolveCreators();
    }
    return _creatorMethods;
  }
  
  public boolean hasAnnotations()
  {
    if (_classAnnotations == null) {
      resolveClassAnnotations();
    }
    return _classAnnotations.size() > 0;
  }
  
  public int hashCode()
  {
    return _class.getName().hashCode();
  }
  
  public Iterable<AnnotatedMethod> memberMethods()
  {
    if (_memberMethods == null) {
      resolveMemberMethods();
    }
    return _memberMethods;
  }
  
  public String toString()
  {
    return "[AnnotedClass " + _class.getName() + "]";
  }
  
  public AnnotatedClass withAnnotations(AnnotationMap paramAnnotationMap)
  {
    return new AnnotatedClass(_class, _superTypes, _annotationIntrospector, _mixInResolver, paramAnnotationMap);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.AnnotatedClass
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */