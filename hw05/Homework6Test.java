/* Homework6Test.java */

import dict.*;

/**
 *  Initializes a hash table, then stocks it with random SimpleBoards.
 **/

public class Homework6Test {

  /**
   *  Generates a random 8 x 8 SimpleBoard.
   **/

  private static SimpleBoard randomBoard() {
    SimpleBoard board = new SimpleBoard();
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
	double fval = Math.random() * 12;
	int value = (int) fval;
	board.setElementAt(x, y, value);
      }
    }
    return board;
  }

  /**
   *  Empties the given table, then inserts "numBoards" boards into the table.
   *  @param table is the hash table to be initialized.
   *  @param numBoards is the number of random boards to place in the table.
   **/

  private static int insertnum = 0;
  public static void initTable(HashTableChained table, int numBoards) {
    table.makeEmpty();
    for (int i = 0; i < numBoards; i++) {
      table.insert(randomBoard(), new Integer(i));
      insertnum++;
    }
  }

  /**
   *  Creates a hash table and stores a certain number of SimpleBoards in it.
   *  The number is 100 by default, but you can specify any number at the
   *  command line.  For example:
   *
   *    java Homework6Test 12000
   **/

  public static void main(String[] args) {
    int numBoards;

    if (args.length == 0) {
      numBoards = 100;
    } else {
      numBoards = Integer.parseInt(args[0]);
    }
    HashTableChained table = new HashTableChained(numBoards);
    initTable(table, numBoards);
    System.out.print("Insert elem: " + insertnum + "\r\n");
    // To test your hash function, add a method to your HashTableChained class
    // that counts the number of collisions--or better yet, also prints
    // a histograph of the number of entries in each bucket.  Call this method
    // from here.
    table.reportcollisions();
    System.out.print("table info: " + "\r\n" + table);

      //test case
      HashTableChained table1 = new HashTableChained(128);
      System.out.print("table1 size should be 0, in fact it is " + table1.size() + "\r\n");
      System.out.print("so table1 is empty ? " + (table1.isEmpty()? "yes":"no") + "\r\n");
      table1.insert(5, 10);
      System.out.print("now table1 size should be 1, in fact it is " + table1.size() + "\r\n");
      Entry e;
      if((e = table1.find(5)) != null)
      {
          System.out.print("table1 contains element 5" + "\r\n");
          System.out.print("its value is " + table1.getValue(e) + "\r\n");
      }
      else
          System.out.println("something's wrong");

      table1.remove(5);
      System.out.println("after remove element 5, can i still find it in table1 ? "
                        + ((table1.find(5) == null)? "No" : "Yes"));

  }

}
