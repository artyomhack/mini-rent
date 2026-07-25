package org.artyomhack.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Свойство для брони.
 */
@Data
@ConfigurationProperties(prefix = "application.booking")
public class BookingProperties {

    /**
     * Лимит времени в единице часа.
     */
    private LimitHour limitHour;

    @Data
    public static class LimitHour {
        /**
         * Максимальное время для создания брони.
         */
        private int max;

        /**
         * Минимальное время для создания брони.
         */
        private int min;
    }
}
