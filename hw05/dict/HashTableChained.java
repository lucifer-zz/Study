/* HashTableChained.java */

package dict;
import java.lang.Math;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
  private int size = 0;
  private int prime, capacity;
  private long scale, shift;
  private double loadfactor = 0.5;
  private Entry[] bucket;

  private static class CollisionsRecorder
  {
      private static class CollisionInfo
      {
          private CollisionInfo(String k)
          {
              key = k;
              count = 1;
          }
          private int count;
          private String key;
      }
      private static LinkedList<CollisionInfo> records = new LinkedList<CollisionInfo>();
      private static int amount;
      public static void recordinfo(String key)
      {
          int recordsize = records.size();
          for(int index = 0; index < recordsize; index++)
          {
              CollisionInfo record = records.get(index);
              if(record.key == key)
              {
                  record.count++;
                  amount++;
                  return;
              }
          }

          CollisionInfo newrecord = new CollisionInfo(key);
          amount++;
          records.add(newrecord);
      }

      public static void reportinfo()
      {
          System.out.print("Since now, collision count: " + amount + "\r\n");

          if(amount > 0)
          {
              System.out.print("Collision Detail:"+ "\r\n");
              int size = records.size();
              CollisionInfo info;
              for(int index = 0; index < size; index++)
              {
                  info = records.get(index);
                  System.out.print("Key: " + info.key + "\r\n");
                  System.out.print("Count: " + info.count + "\r\n");
              }
          }

      }
  }


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
      capacity = (int)(sizeEstimate / loadfactor);
      prime = 103;
      Random rand = new Random();
      scale = rand.nextInt(prime - 1) + 1;
      shift = rand.nextInt(prime);
      bucket = new Entry[capacity];
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
      this(100);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    if((code > Integer.MAX_VALUE) || (code < Integer.MIN_VALUE))
    {
        System.out.println("Invalid code");
        return -1;
    }
//    int compcode = 0;
    //To do: adjust the value of a, b, p based on special algorithm
//    int a = 41, b = 5, p = 107;
 //   compcode = Math.abs(((a * code + b)% p) % capcity);


    return (int)((Math.abs(code * scale + shift) % prime) % capacity);
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return (size == 0);
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/


  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.

    if(capacity < 2 * size)
    {
        rehash();
    }

    Entry e = find(key);
    int index = compFunction(key.hashCode());
    Entry newentry = new Entry();
    newentry.key = key;
    newentry.value = value;

    if(e == null)
    {
        LinkedList<Entry> newentrylist = new LinkedList<Entry>();
        newentrylist.add(newentry);

        Entry newbucketentry = new Entry();
        newbucketentry.key = key;
        newbucketentry.value = newentrylist;

        while(index < capacity)
        {
            if(bucket[index] == null)
            {
                bucket[index] = newbucketentry;
                break;
            }
            else
            {
                index = getantoherposition(index);
                CollisionsRecorder.recordinfo(key.toString());
            }
        }
    }
    else
    {
        ((LinkedList)e.value()).add(newentry);
    }
    size++;
    return newentry;
  }

  public  void reportcollisions()
  {
      CollisionsRecorder.reportinfo();
  }

  //implement it lately
  private void rehash()
  {
      if(capacity < 2 * size)
      {
          //rehash
      }
  }
  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
    if(size == 0)
        return null;
    int index = compFunction(key.hashCode());
    Entry e = bucket[index];
    if(e != null)
    {
        if(e.key() == key)
        {
            //return (Entry)(((LinkedList)e.value()).get(0));
            return e;
        }
        else
        {
            int curindex = index;
            index = getantoherposition(index);
            while(index != curindex)
            {
                e = bucket[index];
                if(e != null)
                {
                    if(e.key == key)
                    {
                        //return (Entry)(((LinkedList)e.value()).get(0));
                        return e;
                    }
                }

                index = getantoherposition(index);
            }
        }
    }

    return null;
  }

  /**
   *  get value with specialized entry, here we get general list entry from find operation
   *  then we can use getValue operation to get value we want
   *
   *  @param e the entry we want to get value.
   *  @return the value we want
   **/
  public Object getValue(Entry e)
  {
      LinkedList<Entry> list = (LinkedList<Entry>)e.value();
      return ((Entry)(list.getFirst())).value();
  }

  //It helps us to get another valid position when we encounter insertion collision
  //To do: use more reasonable strategy to get position in case of avoiding further collision
  private int getantoherposition(int index)
  {
      index = index + 1;
      if(index >= capacity)
          index = 0;
      return index;
  }

  public String toString()
  {
      String s = null;
      LinkedList<Entry> list = null;
      Object obj = null;
      for(int index = 0; index < capacity; index++)
      {
          Entry e = bucket[index];
          if(e != null)
          {
              list = (LinkedList<Entry>)e.value();
              int len = list.size();

              for(int i = 0; i < len; i++)
              {
                  if(s == null)
                    s = "Key is " + "\r\n";
                  else
                    s += "Key is " + "\r\n";
                  s += list.get(i).key() + "\r\n" ;
                  s += "Value is " + list.get(i).value() + "\r\n";
              }
          }
      }

      return s;
  }
  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
    int index = compFunction(key.hashCode());
    Entry listentry = bucket[index];
    if(listentry != null)
    {
        LinkedList<Entry> curlist = (LinkedList)listentry.value();
        Random rand = new Random();
        int delindex = rand.nextInt(curlist.size());
        Entry delentry = (Entry)(curlist.get(delindex));
        curlist.remove(delindex);
        if(curlist.isEmpty())
        {
            bucket[index] = null;
        }
        size--;
        return delentry;
    }
    return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
      Entry listentry = null;
      LinkedList<Entry> list = null;
      for(int index = 0; index < capacity; index++)
      {
          if(bucket[index] != null)
          {
              listentry = bucket[index];
              bucket[index] = null;
              list = (LinkedList<Entry>)listentry.value();
              list.clear();
          }
      }
      size = 0;
  }

}
