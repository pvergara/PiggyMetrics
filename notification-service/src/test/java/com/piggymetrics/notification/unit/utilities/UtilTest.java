package com.piggymetrics.notification.unit.utilities;

import com.piggymetrics.notification.utilities.Util;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ConstantValue")
class UtilTest {

    @Test
    void whenIPassTrueToChangeBooleanThenItReturnsFalse() {
        boolean actual = Util.changeBoolean(true);

        assertThat(actual).isFalse();
    }

    @Test
    void whenIPassFalseToChangeBooleanThenItReturnsTrue() {
        boolean actual = Util.changeBoolean(false);

        assertThat(actual).isTrue();
    }
}