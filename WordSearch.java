import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
    private char[][]data;
    private int seed;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      clear();
    }

    public WordSearch( int rows, int cols, String fileName) {
      randgen = new Random();
      ArrayList<String>wordsToAdd = new ArrayList<String>();
      ArrayList<String>wordsAdded = new ArrayList<String>();
      data = new char[rows][cols];
      clear();
      try{
        File f = new File(fileName);//can combine
        Scanner in = new Scanner(f);//into one line
        while ( in.hasNext()) {
          String word = in.nextLine();
          //System.out.println(word);
          wordsToAdd.add(word);
          //System.out.println(wordsToAdd);
          //System.out.println(wordsToAdd.size());
        }
        System.out.println(wordsToAdd);

        //addAllWords();

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
      }

    }



    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for ( int i=0; i< data.length; i++) {
        for ( int x=0; x< data[i].length; x++) {
          data[i][x] = '_' ;
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String output = "";
      for ( int i=0; i< data.length; i++) {
        for ( int x=-1; x < data[i].length + 1; x++) {
          if ( x == -1)
          output += "|";
          if ( x != -1 && x < data[i].length)
          output += data[i][x];
          if ( x == data[i].length)
          output += "| \n";
        }
      }
      //for ( int i= 0; i < wordsAdded.size(); i++) {
        //output += wordsAdded.get(i);
      //}
      return output;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
      if ( data[row].length < word.length() + col )
      return false;
      for ( int i = 0; i < word.length(); i++){
        if ( !( data[row][ col + i] == '_') && !( word.charAt(i) == data[row][col+i]))
        return false;
      }
      for ( int i = 0; i < word.length(); i++) {
        data[row][col + i] = word.charAt(i);
      }
      return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
      if ( data.length < word.length() + row)
      return false;
      for ( int i = 0; i < word.length(); i++) {
        if ( !(data[row + i][col] == '_') && !(word.charAt(i) == data[row +i][col]) )
        return false;
      }
      for ( int i = 0; i < word.length(); i++) {
        data[row +i][col] = word.charAt(i);
      }
      return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added from top left to bottom right, must fit on the WordGrid,
    *and must have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical locaiton of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@return true when the word is added successfully. When the word doesn't fit,
    *or there are overlapping letters that do not match, then false is returned.
    */
   public boolean addWordDiagonal(String word,int row, int col){
     if ( (data.length < word.length() + row) || (data[row].length < word.length() + col))
     return false;
     for ( int i = 0 ; i < word.length(); i++) {
       if ( !(data[row + i][col+i] == '_') && !(word.charAt(i) == data[row +i][col+i]) )
       return false;
     }
     for ( int i = 0; i < word.length(); i++) {
       data[row +i][col+i] = word.charAt(i);
     }
     return true;
   }
   /**Attempts to add a given word to the specified position of the WordGrid.
        *The word is added in the direction rowIncrement,colIncrement
        *Words must have a corresponding letter to match any letters that it overlaps.
        *
        *@param word is any text to be added to the word grid.
        *@param row is the vertical locaiton of where you want the word to start.
        *@param col is the horizontal location of where you want the word to start.
        *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
        *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
        *@return true when: the word is added successfully.
        *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
        *        OR there are overlapping letters that do not match
        */
       public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
         if( rowIncrement == 0 && colIncrement == 0)
         return false;
         if( rowIncrement == 1 && data.length < row + word.length())
         return false;
         if ( colIncrement == 1 && data[row].length < col + word.length())
         return false;
         if ( rowIncrement == -1 && row + 1 < word.length() )
         return false;
         if ( colIncrement == -1 && col + 1 < word.length() )
         return false;
         for ( int i = 0 ; i < word.length(); i++) {
           if ( !(data[row + i * rowIncrement][col + i * colIncrement] == '_') && !(word.charAt(i) == data[row + i * rowIncrement][col + i * colIncrement]) )
           return false;
         }
         for ( int i = 0; i < word.length(); i++) {
           data[row + i * rowIncrement][col + i * colIncrement] = word.charAt(i);
         }
         return true;
       }
      /*[rowIncrement,colIncrement] examples:
       *[-1,1] would add up to the right because (row -1 each time, col + 1 each time)
       *[1,0] would add to the right because (row+1), with no col change
       */

       public void addAllWords() {
        System.out.print( wordsToAdd );

        while( wordsToAdd.size() > 0) {
          //System.out.println(wordsToAdd);
          //System.out.println(wordsToAdd.size());
          String word = wordsToAdd.get( Math.abs( randgen.nextInt() % wordsToAdd.size() ) );
          for ( int attemps = 0; attemps < 25; attemps++) {
            int rows = Math.abs(randgen.nextInt() % data.length);
            int cols = Math.abs(randgen.nextInt() % data[0].length);
            if ( addWord(word, rows, cols, randgen.nextInt() % 2, randgen.nextInt() % 2 )){
              attemps = 25;
              wordsToAdd.remove(word);
              wordsAdded.add(word);
            }
          }
        }
       }
}
