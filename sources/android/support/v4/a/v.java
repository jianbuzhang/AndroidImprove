package android.support.v4.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class v {

    public interface b {
        View a();
    }

    public static class a {
        public View a;
    }

    public static Object a(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static Object a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static Object a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        TransitionSet transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static String a(View view) {
        return view.getTransitionName();
    }

    private static void a(Transition transition, final a aVar) {
        if (transition != null) {
            transition.setEpicenterCallback(new EpicenterCallback() {
                private Rect b;

                public Rect onGetEpicenter(Transition transition) {
                    if (this.b == null && aVar.a != null) {
                        this.b = v.c(aVar.a);
                    }
                    return this.b;
                }
            });
        }
    }

    public static void a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj2;
        final Transition transition3 = (Transition) obj3;
        final Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            final View view3 = view;
            final ArrayList<View> arrayList5 = arrayList;
            final ArrayList<View> arrayList6 = arrayList2;
            final ArrayList<View> arrayList7 = arrayList3;
            final Map<String, View> map2 = map;
            final ArrayList<View> arrayList8 = arrayList4;
            final View view4 = view2;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        v.a(transition, arrayList5);
                        v.b(transition, transition2, arrayList6, false);
                        v.b(transition, transition3, arrayList7, false);
                    }
                    if (transition2 != null) {
                        v.a(transition2, arrayList6);
                        v.b(transition2, transition, arrayList5, false);
                        v.b(transition2, transition3, arrayList7, false);
                    }
                    if (transition3 != null) {
                        v.a(transition3, arrayList7);
                    }
                    for (Entry entry : map2.entrySet()) {
                        ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                    }
                    int size = arrayList8.size();
                    for (int i = 0; i < size; i++) {
                        transition4.excludeTarget((View) arrayList8.get(i), false);
                    }
                    transition4.excludeTarget(view4, false);
                    return true;
                }
            });
        }
    }

    public static void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect c = c(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public Rect onGetEpicenter(Transition transition) {
                return c;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        b(obj, (ArrayList) arrayList);
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, Object obj2, Object obj3, View view, b bVar, View view2, a aVar, Map<String, String> map, ArrayList<View> arrayList, ArrayList<View> arrayList2, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList3) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj3;
        Object obj4 = (Transition) obj2;
        b(transition, transition2, arrayList2, true);
        if (obj != null || obj2 != null) {
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                a(obj4, view2, (Map) map2, (ArrayList) arrayList3);
                b(transition, obj4, arrayList3, true);
                b(transition2, obj4, arrayList3, true);
            }
            final View view3 = view;
            final View view4 = view2;
            final b bVar2 = bVar;
            final Map<String, String> map4 = map;
            final Map<String, View> map5 = map3;
            final ArrayList<View> arrayList4 = arrayList;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        transition.removeTarget(view4);
                    }
                    if (bVar2 != null) {
                        View a = bVar2.a();
                        if (a != null) {
                            if (!map4.isEmpty()) {
                                v.a(map5, a);
                                map5.keySet().retainAll(map4.values());
                                for (Entry entry : map4.entrySet()) {
                                    View view = (View) map5.get((String) entry.getValue());
                                    if (view != null) {
                                        view.setTransitionName((String) entry.getKey());
                                    }
                                }
                            }
                            if (transition != null) {
                                v.b(arrayList4, a);
                                arrayList4.removeAll(map5.values());
                                arrayList4.add(view4);
                                v.b(transition, arrayList4);
                            }
                        }
                    }
                    v.b(transition2, transition, arrayList4, true);
                    return true;
                }
            });
            a(transition, aVar);
        }
    }

    public static void a(Object obj, Object obj2, Object obj3, ArrayList<View> arrayList, boolean z) {
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        b((Transition) obj, transition2, arrayList, z);
        b(transition, transition2, arrayList, z);
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    private static void a(List<View> list, View view) {
        int size = list.size();
        if (!a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private static boolean a(Transition transition) {
        return (a(transition.getTargetIds()) && a(transition.getTargetNames()) && a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        Transition transition = (Transition) obj;
        if (transition == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    private static void b(Transition transition, Transition transition2, ArrayList<View> arrayList, boolean z) {
        if (transition != null) {
            int size = transition2 == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                transition.excludeTarget((View) arrayList.get(i), z);
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!a(transition) && a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static void b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    private static Rect c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }
}
