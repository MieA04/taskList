package com.taskList;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * TaskList
 *
 * @author MieMie
 */

@Data
public class TaskLink {

    private String taskListName;
    private LinkedList<Task> taskLink = new LinkedList<>();
    private final HashMap<String, Boolean> taskResult = new HashMap<>();

    // 头部插入一个新任务
    public void addFirst(Task task) {
        taskLink.addFirst(task);
    }

    // 尾部插入一个新任务
    public void addLast(Task task) {
        taskLink.addLast(task);
    }

    // 指定任务后加入一个任务
    public void addAfter(Task task, Task newTask) {
        int i = taskLink.lastIndexOf(task);

        if (i == taskLink.size() - 1) {
            taskLink.addLast(newTask);
        }

        if (i != -1) {
            taskLink.add(i + 1, newTask);
        }
    }

    // 指定任务前加入一个任务
    public void addBefore(Task task, Task newTask) {
        int i = taskLink.lastIndexOf(task);

        if (i == 0) {
            taskLink.addFirst(newTask);
        }

        if (i != -1) {
            taskLink.add(i, newTask);
        }
    }

    // 删除一个任务
    public void remove(Task task) {
        taskLink.remove(task);
    }

    // 查看任务列表
    public void showAllTask() {
        System.out.print("taskLink:");
        for (Task task : taskLink) {
            System.out.print(task.getTaskName() + " ");
        }
        System.out.println();
    }

    // 调用任务
    public void invoke(boolean safetySwitch) throws Exception {

        /*
        * 当任务错误时，会导致任务链
        */
        try {
            for (Task task : this.taskLink) {
                Method method = task.getTaskMethod();
                Object[] params = task.getTaskParams();

                // 确保参数数量匹配
                if (params != null && params.length != method.getParameterCount()) {
                    throw new IllegalArgumentException("Parameter count mismatch for method: " + method.getName());
                }

                MethodResult invoke = (MethodResult)method.invoke(new TestMethod(), params);

                taskResult.put(task.getTaskName(), invoke.getResult());

                if (!invoke.getResult() && safetySwitch){
                    System.out.println("Task " + task.getTaskName() + " failed.");
                    return;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            System.out.println("result" + taskResult);
        }

    }

    // 调用任务重载，默认开启安全开关
    public void invoke() throws Exception {
        invoke(true);
    }

    // 检查任务是否已存在
    public boolean checkTask(Task task) {
        return taskLink.contains(task);
    }

}
