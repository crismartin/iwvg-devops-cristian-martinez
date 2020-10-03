package es.upm.miw.iwvg_devops.practice;

import java.util.stream.Stream;

public class Searches {
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::initials);
    }
}
