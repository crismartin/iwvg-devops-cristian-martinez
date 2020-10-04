package es.upm.miw.iwvg_devops.practice;


import java.util.Collection;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::initials);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(Fraction::isNegativeSign))
                .map(User::getFamilyName)
                .distinct();

    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null);
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .map(User::getFractions)
                .flatMap(Collection::stream)
                .reduce(new Fraction(0, 1), (acum, nextFraction) -> (acum != null && nextFraction != null ? acum.add(nextFraction) : null)
                );
    }

}
