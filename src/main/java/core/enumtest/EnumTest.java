package core.enumtest;

/**
 * @author wonseok.song
 * @since 2021-01-25
 */
public enum EnumTest {
  MONDAY("1", "224");

  private String 요일별숫자;
  private String 일괄;
  private String 평일토일;
  private String 요일별;

  EnumTest(String 요일별숫자, String 일괄) {
    this.요일별숫자 = 요일별숫자;
    this.일괄 = 일괄;
  }

  public String 요일별숫자_가져오기() {
    return this.요일별숫자;
  }

}

class Test {

  public static void main(String[] args) {
//    EnumTest.MONDAY test = EnumTest.MONDAY

    EnumTest.MONDAY.요일별숫자_가져오기();

  }
}
