/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.util.forunittest;

import org.springframework.stereotype.Component;

/**
 *
 * @author ahsan
 */
@Component
public class SomeRandomLogic {

    public boolean isAnyGreaterThan100(int[] intArray, boolean isException) {
        if (!isException) {
            for (int i : intArray) {
                if (i > 100) {
                    return true;
                }
            }
        }
        if(isException)
            throw new ArrayIndexOutOfBoundsException("exception has been thrown");
        return false;
    }
}
