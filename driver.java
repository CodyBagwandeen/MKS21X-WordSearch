public class driver {
  public static void main( String[] args) {
    if ( args.length < 3)
    System.out.println("Bad formatting; java WordSearch [rows cols filename [randomSeed [key]]], square brackets denotes optional");
    if ( args.length == 3) {
      try {
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        if (!( rows > 0 ) || !(cols > 0)) {
          System.out.println( "rows and cols must be greater than 0");
          System.exit(1);
      }
        String filename = args[2];
        WordSearch WSe = new WordSearch( rows, cols, filename);
        System.out.println( WSe);
      } catch( NumberFormatException e) {
        System.out.println("Parameters rows and cols must be integers");
      }
    }
    if ( args.length == 4) {
      try{
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        if (!( rows > 0 ) || !(cols > 0)) {
          System.out.println( "rows and cols must be greater than 0");
          System.exit(1);
      }
        String filename = args[2];
        int seed = Integer.parseInt( args[3]);
        if ( !( seed >= 0 && seed <= 10000)) {
          System.out.println( "seed musts be 0 to 10000 inclusive");
          System.exit(1);
        }
        WordSearch WSe = new WordSearch( rows, cols, filename, seed);
        WSe.fill();
        System.out.println( WSe);
      } catch( NumberFormatException e) {
        System.out.println("Parameters rows, cols, and seed must be integers");
      }
    }
    if ( args.length >= 5) {
      try {
        int rows = Integer.parseInt( args[0]);
        int cols = Integer.parseInt( args[1]);
        if (!( rows > 0 ) || !(cols > 0)) {
          System.out.println( "rows and cols must be greater than 0");
          System.exit(1);
      }
        String filename = args[2];
        int seed = Integer.parseInt( args[3]);
        if ( !( seed >= 0 && seed <= 10000)) {
          System.out.println( "seed musts be 0 to 10000 inclusive");
          System.exit(1);
        }
        WordSearch WSe = new WordSearch( rows, cols, filename, seed);
        if (!( args[4].equals("key")))
        WSe.fill();
        System.out.println( WSe);
        }catch( NumberFormatException e) {
          System.out.println("Parameters rows,cols,and seed must be integers");
        }
      }
    }
  }
