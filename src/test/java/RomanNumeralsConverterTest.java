import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsConverterTest {
  RomanNumeralsConverter converter = new RomanNumeralsConverter();

  @Test
  public void convert5 () {
    assertEquals ("V", converter.convert(5));
  }

  @Test
  public void convert11 () {
    assertEquals ("XI", converter.convert(11));
  }

  @Test
  public void convert20 () {
    assertEquals ("XX", converter.convert(20));
  }

  @Test

  public void convert3549 () {
    assertEquals ("MMMDXLIX", converter.convert(3549));
  }

  @Test
  public void convert6 () {
    assertEquals("VI", new RomanNumeralsConverter().convert(6));
  }

  @Test
  public void convert14 () {
    assertEquals("XIV", new RomanNumeralsConverter().convert(14));
  }

  @Test
  public void convert100 () {
    assertEquals("C", new RomanNumeralsConverter().convert(100));
  }
}