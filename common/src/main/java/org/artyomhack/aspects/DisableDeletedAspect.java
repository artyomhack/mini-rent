package org.artyomhack.aspects;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.annotation.DisableDeleted;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

/**
 * Аспект на отключение удалённых записей.
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class DisableDeletedAspect {

    private final EntityManager em;

    /**
     * Метод, который перехватывает аннотацию {@link DisableDeleted}
     * и убирает поиск для удалённых записей.
     */
    @Around("@annotation(disableDeleted)")
    public Object manageDeletedFilter(ProceedingJoinPoint joinPoint, DisableDeleted disableDeleted) throws Throwable {
        log.debug("Включаем аспект DisableDeletedAspect, отключаем поиск для удалённых записей.");
        Session session = em.unwrap(Session.class);
        String filterName = disableDeleted.filter();

        session.disableFilter(filterName);

        try {
            return joinPoint.proceed();
        } finally {
            log.debug("Аспект DisableDeletedAspect, включаем поиск для удалённых записей.");
            session.enableFilter(filterName);
        }
    }
}
