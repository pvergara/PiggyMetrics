package com.piggymetrics.notification.unit.utilities;

import com.piggymetrics.notification.utilities.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ConstantValue")
class UtilTest {

//    Fast
//    Isolated
//    Repeatable
//    Self-validating
//    Timely

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

    @Test
    void whenIPassABCToReserveStringThenItReturnsCBA(){
        //Red
        //Green
        //Refactor...
        String actual = Util.reverse("ABC");

        assertThat(actual).isEqualTo("CBA");
    }

    @Test
    void whenIPassABCDToReserveStringThenItReturnsDCBA(){
        //...Refactor
        String actual = Util.reverse("ABCD");

        assertThat(actual).isEqualTo("DCBA");
    }

    @Test
    void whenIPassABAToReserveStringThenItReturnsABA(){
        var actual = Util.reverse("ABA");

        assertThat(actual).isEqualTo("ABA");
    }

    @Test
    void whenIPassABBAToReserveStringThenItReturnsABBA(){
        var actual = Util.reverse("ABBA");

        assertThat(actual).isEqualTo("ABBA");
    }

    @Test
    void whenIPassNullToReserveStringThenItReturnsABC(){
        String actual = Util.reverse(null);

        assertThat(actual).isNull();
    }

    @Test
    void sortingACollection(){
        var actual = Util.sort(List.of(7, 3, 6, 2, 1, 2));

        assertThat(actual).isEqualTo(List.of(1,2,2,3,6,7));
    }

    @Test
    void sortingACollectionStrings(){
        var actual = Util.sort(List.of("7", "3", "6", "2", "1", "2"));

        assertThat(actual).isEqualTo(List.of("1","2","2","3","6","7"));
    }
}