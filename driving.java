public class driving{
  public static void main( String[] args) {

    WordSearch WSe = new WordSearch( 10, 24, "words.txt");
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

    WSe.addAllWords();
    System.out.println(WSe);
    }
  }
