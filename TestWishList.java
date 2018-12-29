package test;

import implementations.WishList.WLRegular;
import Exception.OutofBoundPeriodException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestWishList {

    private WLRegular wishList;

    @BeforeEach
    void setUp() {
        wishList = new WLRegular() {
        };
    }

    @Test
    void testGetMoneyRounded() {
        int price = 1000, period = 10;
        double result = 100;
        result = wishList.getMoneyRounded(price, period);
        assertEquals(result, wishList.getMoneyRounded(1000, 10));
        assertEquals(100, wishList.getMoneyRounded(1001, 10));
        assertEquals(99, wishList.getMoneyRounded(999, 10));

    }

    @Test
    void testGetMoneyLeft() {
        double resultRounded = 99;
        int period = 10;
        int price = 999;
        double resultLeft;
        resultLeft = wishList.getMoneyLeft(resultRounded, price, period);
        assertEquals(108, resultLeft);
        assertEquals(100, wishList.getMoneyLeft(100, 1000, 10));
        assertEquals(101, wishList.getMoneyLeft(100, 1001, 10));
    }

    @Test
    void testCheckBoundingNotThrow() {
        int period = 10;
        try {
            wishList.checkBounding(period);
        } catch (OutofBoundPeriodException e1) {
            fail("shouldn't fail.");
        }
    }

    @Test
    void testCheckBoundingThrow() {
        int period = -1;
        try {
            wishList.checkBounding(period);
            fail("shouldn't fail.");
        } catch (OutofBoundPeriodException e1) {
            System.out.println("great.");
        }
    }

    @Test
    void testCheckArithmeticNotThrow() {
        int period = 10;
        int price = 100;
        try {
            wishList.getMoneyRounded(price, period);
        } catch (ArithmeticException e1) {
            fail("shouldn't fail.");
        }
    }


    @Test
    void testCheckArithmeticExceptionThrow() {
        int period = 0;
        int price = 100;
        try {
            wishList.getMoneyRounded(price, period);
            fail("shouldn't fail.");
        } catch (ArithmeticException e1) {
            System.out.println("great.");
        }
    }
}
