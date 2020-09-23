package es.upm.miw.iwvg_devops.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;
    String id;
    String name;
    String familyName;
    List<Fraction> fractions;

    @BeforeEach
    void before() {
        fractions = new ArrayList<>();
        id = "1";
        name = "Cristian";
        familyName = "Martinez";

        user = new User(id, name, familyName, fractions);
    }

    @Test
    void testUserWithoutParams() {
        user = new User();
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testUser() {
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(familyName, user.getFamilyName());
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals(name + " " + familyName, user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals(name.substring(0, 1) + ".", user.initials());
    }

    @Test
    void testAddFractions() {
        user.addFraction(new Fraction());
        assertEquals(1, user.getFractions().size());
    }

    @Test
    void testSetFamilyName() {
        familyName = "Hidalgo";
        user.setFamilyName(familyName);
        assertEquals(familyName, user.getFamilyName());
    }

    @Test
    void testSetName() {
        name = "Jose";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void testSetFractions() {
        fractions.add(new Fraction());
        user.setFractions(fractions);
        assertEquals(fractions.size(), user.getFractions().size());
    }
}
