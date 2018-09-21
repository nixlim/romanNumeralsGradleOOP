import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class RomanNumeralsConverter {

  private final Map<Integer, String> BASE_VALUES_MAP =
    new HashMap<Integer, String>() {{
      put (1, "I");
      put (4, "IV");
      put (5, "V");
      put (9, "IX");
      put (10, "X");
      put (40, "XL");
      put (50, "L");
      put (90, "XC");
      put (100, "C");
      put (400, "CD");
      put (500, "D");
      put (900, "CM");
      put (1000, "M");
    }};

  private StringBuilder romanNumeralString;

  public RomanNumeralsConverter () {
    this.romanNumeralString = new StringBuilder();
  }

  public String convert (int arabicNumberToConvert) {
    return romanNumeral(arabicNumberToConvert);
  }

  private String romanNumeral(int arabicNumberToConvert) {
    int nearestBaseValue = findNearestBaseValue(arabicNumberToConvert);
    int numberOfBasesInTheArabicNumber = arabicNumberToConvert / nearestBaseValue;
    int numberRemainingAfterLargestBaseHasBeenDeducted =
      arabicNumberToConvert % nearestBaseValue;

    this.romanNumeralString = buildRomanNumeralString (nearestBaseValue,
      numberOfBasesInTheArabicNumber);
    return numberRemainingAfterLargestBaseHasBeenDeducted != 0 ?
      convert (numberRemainingAfterLargestBaseHasBeenDeducted) :
      this.romanNumeralString.toString();
  }

  private StringBuilder buildRomanNumeralString(int nearestBaseValue,
                                         int numberOfBasesInTheArabicNumber) {
    this.romanNumeralString.append(repeatBaseValue(nearestBaseValue,
      numberOfBasesInTheArabicNumber));
    return this.romanNumeralString;
  }

  private String repeatBaseValue (int nearestBaseValue,
                                  int numberOfBasesInTheArabicNumber) {
    return Stream.generate(() -> BASE_VALUES_MAP.get(nearestBaseValue))
      .limit(numberOfBasesInTheArabicNumber)
      .collect(joining());
  }

  private int findNearestBaseValue(int arabicNumberToConvert) {
    int nearestBaseValue = 0;
    int minimumDifference = Integer.MAX_VALUE;
    if (BASE_VALUES_MAP.get (arabicNumberToConvert) != null) {
      nearestBaseValue = arabicNumberToConvert;
    } else {
      for (Integer key : BASE_VALUES_MAP.keySet ()) {
        int differenceBetweenBaseValueMapKeyAndArabicNumber = (arabicNumberToConvert - key);
        if (differenceBetweenBaseValueMapKeyAndArabicNumber < minimumDifference
          && differenceBetweenBaseValueMapKeyAndArabicNumber > 0) {
          nearestBaseValue = key;
          minimumDifference = differenceBetweenBaseValueMapKeyAndArabicNumber;
        }
      }
    }
    return nearestBaseValue;
  }
}
