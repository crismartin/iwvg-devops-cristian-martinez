package es.upm.miw.iwvg_devops.practice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction(){
        assertEquals(List.of("O.", "A.", "O.", "A."), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }
}
