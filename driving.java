public class driving{
  public static void main( String[] args) {

    WordSearch WSe = new WordSearch( 10, 14, "words.txt");
    System.out.println(WSe);
    /*
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _|
    */

    WordSearch WSe2 = new WordSearch( 10, 14, "words.txt", 50);
    System.out.println(WSe2);
    }
  }
