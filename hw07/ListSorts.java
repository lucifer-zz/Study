/* ListSorts.java */

import list.*;
import sun.awt.image.ImageWatched;

import java.util.Random;

public class ListSorts {

  private final static int SORTSIZE = 1000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
      if((q != null) && (!q.isEmpty())) {
       /*   LinkedQueue newmainqueue = new LinkedQueue();
          LinkedQueue newsubqueue;
          Object item = null;
          try {

              while ((item = q.dequeue()) != null) {
                  newsubqueue = new LinkedQueue();
                  newsubqueue.enqueue(item);
                  newmainqueue.enqueue(newsubqueue);
              }
          } catch (QueueEmptyException e) {
              e.printStackTrace();
          } finally {
              return newmainqueue;
          }
*/
          int size = q.size();
          LinkedQueue newsubqueue;
          Object item = null;

              try{
                  for(int i = 0; i < size; i++)
                  {
                    item = q.dequeue();
                    newsubqueue = new LinkedQueue();
                    newsubqueue.enqueue(item);
                    q.enqueue(newsubqueue);
                  }
              } catch (QueueEmptyException e) {
                  e.printStackTrace();
              } finally {
                  return q;
              }

      }
    return q;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
      if((!q1.isEmpty())||(!q2.isEmpty()))
      {
          LinkedQueue mergequeue = new LinkedQueue();
          Object item1 = null, item2 = null;
          try{
              item1 = q1.dequeue();
              item2 = q2.dequeue();
              int result = 0;
              while((item1 != null)&&(item2 != null))
              {
                  result = ((Comparable)item1).compareTo(item2);
                  if(result == 0)
                  {
                      mergequeue.enqueue(item1);
                      mergequeue.enqueue(item2);
                      item1 = item2 = null;
                      item1 = q1.dequeue();
                      item2 = q2.dequeue();
                  }else if(result > 0)
                  {
                      mergequeue.enqueue(item2);
                      item2 = null;
                      item2 = q2.dequeue();
                  }else
                  {
                      mergequeue.enqueue(item1);
                      item1 = null;
                      item1 = q1.dequeue();
                  }
              }
          }catch (QueueEmptyException e)
          {
               e.printStackTrace();
          }finally {
              if ((item1 != null)||(q1.size() > 0)) {
                  if(item1 != null)
                  mergequeue.enqueue(item1);
                  try{
                      item1 = q1.dequeue();
                      while(item1 != null)
                      {
                          mergequeue.enqueue(item1);
                          item1 = q1.dequeue();
                      }
                  }catch (QueueEmptyException e)
                  {
                      e.printStackTrace();
                  }
                  finally {
                      return mergequeue;
                  }
              } else if ((item2 != null)||(q2.size() > 0))
              {
                  if(item2 != null)
                  mergequeue.enqueue(item2);
                  try{
                      item2 = q2.dequeue();
                      while(item2 != null)
                      {
                          mergequeue.enqueue(item2);
                          item2 = q2.dequeue();
                      }
                  }catch (QueueEmptyException e)
                  {
                      e.printStackTrace();
                  }
                  finally {
                      return mergequeue;
                  }
              }
              else
              {
                  //two queues become empty at same time = =
                  return mergequeue;
              }

          }
      }
    return null;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
      if(qIn.size() <= 1)
          return;
      try{
          Object item = qIn.dequeue();
          int result = 0;
          while(item != null)
          {
              result = pivot.compareTo(item);
              if(result > 0)
              {
                  qSmall.enqueue(item);
              }else if(result < 0)
              {
                  qLarge.enqueue(item);
              }else{
                  qEquals.enqueue(item);
              }
              item = qIn.dequeue();
          }

      }catch (QueueEmptyException e)
      {
          e.printStackTrace();
      }finally {

      }

  }

    public static void  ConverseQueue(LinkedQueue q)
    {
         if(!q.isEmpty())
         {
             if(q.nth(1) instanceof LinkedQueue)
             {
                 try{
                     LinkedQueue tmp = (LinkedQueue)q.dequeue();
                     int size = tmp.size();
                     for(int i = 0; i < size; i++)
                     {
                         q.enqueue(tmp.dequeue());
                     }
                 }catch (QueueEmptyException e)
                 {
                     e.printStackTrace();
                 }finally {
                    return;
                 }


             }
         }
    }
  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  private static boolean transfermark = true;
  private static int step = 0;
  public static void mergeSort(LinkedQueue q) {
    // Your solution here

      if(q.size() <= 1)
      {
          System.out.println("there is no need to merge");
          return;
      }
      step++;
      LinkedQueue q1, q2;
      if(transfermark)
      {
          q = makeQueueOfQueues(q);
          transfermark = false;
      }
      try{

              q1 = (LinkedQueue)q.dequeue();
              q2 = (LinkedQueue)q.dequeue();
              q.enqueue(mergeSortedQueues(q1, q2));
              mergeSort(q);


      }catch (QueueEmptyException e)
      {
          e.printStackTrace();
      }finally {
          step--;
          if(step == 0)
          {
              ConverseQueue(q);
              transfermark = true;
          }
   //
          return;
      }
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {

      if(q.size() <= 1)
          return;
      Object item = null;
      int size = q.size();
      int index = 0;

      Random rand = new Random();
      index = rand.nextInt(size);
      item = q.nth(index);
      LinkedQueue largerqueue = new LinkedQueue();
      LinkedQueue equalqueue = new LinkedQueue();
      LinkedQueue smallerqueue = new LinkedQueue();

      partition(q, (Comparable)item, smallerqueue, equalqueue, largerqueue);

      quickSort(smallerqueue);
      quickSort(largerqueue);

      if(!smallerqueue.isEmpty())
          q.append(smallerqueue);
      if(!equalqueue.isEmpty())
          q.append(equalqueue);
      if(!largerqueue.isEmpty())
          q.append(largerqueue);

    // Your solution here.
  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
        q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());


    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());


    /* Remove these comments for Part III.*/
    Timer stopWatch = new Timer();

    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");


    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

  }

}
