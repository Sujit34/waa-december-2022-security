package edu.miu.springdata1Assignment.aspect.offensiveWords;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface OffensiveWordFilter {
}

