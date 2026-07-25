package org.artyomhack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class MiniRestApplicationContextTest {

    @Test
    @DisplayName("Тест на контекст")
    public void contextTest() {

    }
}