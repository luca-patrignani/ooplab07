package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int number;

        Month(final int number) {
            this.number = number;
        }

        static Month fromString(String string) {
            final String lowerString = string.toLowerCase();
            Month month = null;
            int occurrences = 0;
            for (Month m : Month.values()) {
                if (m.name().toLowerCase().startsWith(lowerString)) {
                    month = m;
                    occurrences++;
                }
            }
            if (occurrences != 1 || month == null) {
                throw new IllegalArgumentException("Ambiguous month name: " + string);
            }
            return month;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                final Month month0 = Month.fromString(arg0);
                final Month month1 = Month.fromString(arg1);
                return Integer.compare(month0.number, month1.number);
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String arg0, String arg1) {
                final Month month0 = Month.fromString(arg0);
                final Month month1 = Month.fromString(arg1);
                return month0.compareTo(month1);
            }
            
        };
    }
}
