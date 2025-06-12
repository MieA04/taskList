package com.taskList;

import java.util.Objects;

/**
 * Demo
 *
 * @author MieMie
 */
public class TestMethod {

    public MethodResult<String> m1(Integer i){

        if (Objects.isNull(i)){
            return new MethodResult<String>(false, null);
        }

        i = i + 10;

        if (i < 20){
            return new MethodResult<String>(true, "i < 20");
        }
        else {
            return new MethodResult<String>(false, "i >= 20");
        }
    }

    public MethodResult<String> m2(String str){

        if (Objects.isNull(str)){
            return new MethodResult<>(false, null);
        }

        if (str.equals("hello")){
            return new MethodResult<>(true, str);
        }
        else {
            return new MethodResult<>(false, null);
        }
    }

    public MethodResult<String> m3(String str){

        if (Objects.isNull(str)){
            return new MethodResult<>(true, null);
        }

        return new MethodResult<>(false, str);

    }

}
