public class driver {
  public static void main( String[] args) {
    if ( args.length == 0) {
      WordSearch Wse = new WordSearch( 6, 6, "words.txt");
      System.out.println( Wse);
    }
    if ( args.length > 0 && args.length < 3)
    System.out.println("Bat formatting; java Driver [rows cols filename [randomSeed [answers]]], square brackets denotes optional");
    if ( args.length == 3) {
      try {
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        String filename = args[2];
        WordSearch WSe = new WordSearch( rows, cols, filename);
        System.out.println( WSe);
      } catch( NumberFormatException e) {
        System.out.println("Parameters rows and cols must be numbers");
      }
    }
    if ( args.length == 4) {
      try{
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        String filename = args[2];
        int seed = Integer.parseInt( args[3]);
        WordSearch WSe = new WordSearch( rows, cols, filename, seed);
        WSe.fill();
        System.out.println( WSe);
      } catch( NumberFormatException e) {
        System.out.println("Parameters rows, cols, and seed must be numbers");
      }
    }
    if ( args.length == 5) {
      try {
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        String filename = args[2];
        int seed = Integer.parseInt( args[3]);
        WordSearch WSe = new WordSearch( rows, cols, filename, seed);
        if (!( args[4].equals("key")))
        WSe.fill();
        System.out.println( WSe);
        }catch( NumberFormatException e) {
          System.out.println("Parameters rows,cols,and seed must be numbers");
        }
      }
    }
  }
