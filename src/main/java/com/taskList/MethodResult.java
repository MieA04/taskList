package com.taskList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MethodTest
 *
 * @author MieMie
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodResult<T> {

    private Boolean result = false;
    private T data;

}
