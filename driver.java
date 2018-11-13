public class driver {
  public static void main( String[] args) {
    if ( args.length == 3) {
      int rows = Integer.parseInt( args[0]);
      int cols = Integer.parseInt( args[1]);
      String filename = args[2];
      WordSearch WSe = new WordSearch( rows, cols, filename);
    }
    if ( args.length == 4) {
      int rows = Integer.parseInt( args[0]);
      int cols = Integer.parseInt( args[1]);
      String filename = args[2];
      int seed = Integer.parseInt( args[3]);
      WordSearch WSe = new WordSearch( rows, cols, filename, seed);
    }
  }
}
