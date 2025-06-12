package com.taskList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Method;

/**
 * Task
 *
 * @author MieMie
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {

    private String taskName;
    private Method taskMethod;
    private Object[] taskParams;

    public Task(String taskName, Method taskMethod){
        this.taskName = taskName;
        this.taskMethod = taskMethod;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task task) {
            return task.getTaskName().equals(this.taskName);
        }
        return false;
    }

}
