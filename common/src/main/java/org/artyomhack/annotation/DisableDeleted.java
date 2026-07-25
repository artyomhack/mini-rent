package org.artyomhack.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, которая включает удалённые записи.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableDeleted {

    /**
     * Имя фильтра, для которого отключаем удаление.
     */
    String filter();
}
