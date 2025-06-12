package com.taskList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * MethodList
 *
 * @author MieMie
 */
public class TaskLinkDemo {

    public static void main(String[] args) throws Exception {

        TaskLink taskLink = new TaskLink();
        taskLink.addFirst(new Task("m1", TestMethod.class.getMethod("m1", Integer.class), new Object[]{8}));
        taskLink.addLast(new Task("m2", TestMethod.class.getMethod("m2", String.class), new Object[]{"hello1"}));
        taskLink.addLast(new Task("m3", TestMethod.class.getMethod("m3", String.class), new Object[]{null}));

        taskLink.showAllTask();
        taskLink.invoke(false);
        taskLink.invoke();

    }

}
