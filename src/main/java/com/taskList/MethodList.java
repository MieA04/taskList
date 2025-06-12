package com.taskList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * MethodList
 *
 * @author MieMie
 */
public class MethodList {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        ArrayList<Task> taskQueue = new ArrayList<>();

        Class<Demo> demoClass = Demo.class;

        Method m1 = demoClass.getMethod("m1", Integer.class);
        Method m2 = demoClass.getMethod("m2", String.class);

        Task task1 = new Task("m1", m1, new Object[]{1});
        Task task2 = new Task("m2", m2, new Object[]{"hello"});

        taskQueue.add(task1);
        taskQueue.add(task2);

        for (Task task : taskQueue) {
            Method method = task.getTaskMethod();
            Object[] params = task.getTaskParams();

            // 确保参数数量匹配
            if (params != null && params.length != method.getParameterCount()) {
                throw new IllegalArgumentException("Parameter count mismatch for method: " + method.getName());
            }

            System.out.println("Task: " + task.getTaskName());

            MethodResult invoke = (MethodResult)method.invoke(new Demo(), params);// 安全调用
            System.out.println("Result: " + invoke.getResult());
            System.out.println("Data: " + invoke.getData());
        }

    }

}
