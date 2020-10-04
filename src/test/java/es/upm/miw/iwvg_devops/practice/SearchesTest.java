package es.upm.miw.iwvg_devops.practice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {
    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        assertEquals(List.of("O.", "A.", "O.", "A."), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of(), new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        String idUser = "2";
        Fraction fractionFirstProper = new Fraction(-1, 5);
        Fraction fractionTest = new Searches().findFirstProperFractionByUserId(idUser);
        assertNotNull(fractionTest);
        assertEquals(fractionFirstProper.getNumerator(), fractionTest.getNumerator());
        assertEquals(fractionFirstProper.getDenominator(), fractionTest.getDenominator());
    }
}
