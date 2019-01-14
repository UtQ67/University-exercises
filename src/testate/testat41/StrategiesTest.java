package testate.testat41;

import testate.testat41.strategies.*;

public class StrategiesTest
{

    public static void main( String[] args )
    {
        testStrategy();
    }

    public static void testStrategy()
    {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        ints.add( 5 );
        ints.add( 6 );
        ints.add( -9 );
        ints.add( 11 );
        ints.add( 2 );
        ints.add( 9 );
        ints.add( 7 );
        ints.add( -12 );
        ints.add( 5 );

        System.out.println("CountXStrategy");
        System.out.print("in: ");
        ints.showAll();
        CountXStrategy count5 = new CountXStrategy(5 );
        System.out.print("quantity: ");
        ints.inspectAll( count5 );
        System.out.println( count5.getQuantity() );
        System.out.println();

        System.out.println("CountInIntervalStrategy");
        System.out.print("in: ");
        ints.showAll();
        CountInIntervalStrategy count57 = new CountInIntervalStrategy(5, 7 );
        System.out.print("quantity: ");
        ints.inspectAll( count57 );
        System.out.println( count57.getQuantity() );
        System.out.println();

        System.out.println("AverageOfPositivesStrategy");
        System.out.print("in: ");
        ints.showAll();
        AverageOfPositivesStrategy average = new AverageOfPositivesStrategy();
        System.out.print("quantity: ");
        ints.inspectAll( average );
        System.out.println( average.getAverage() );
        System.out.println();

        System.out.println("AllToAbsStrategy");
        AllToAbsStrategy manip = new AllToAbsStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.substituteAll( manip );
        System.out.print("substituted: ");
        ints.showAll();
        System.out.println();

        System.out.println("AddNToPositiveStrategy");
        ints.add( -9 );
        ints.add( -11 );
        ints.add( -2 );
        AddNToPositivesStrategy add5 = new AddNToPositivesStrategy(5 );
        System.out.print("in: ");
        ints.showAll();
        ints.substituteAll( add5 );
        System.out.print("substituted: ");
        ints.showAll();
        System.out.println();

        System.out.println("DoubleAllInIntervalStrategy");
        DoubleAllInIntervalStrategy dblInterval = new DoubleAllInIntervalStrategy( -2, 12 );
        System.out.print("in: ");
        ints.showAll();
        ints.substituteAll( dblInterval );
        System.out.print("substituted: ");
        ints.showAll();
        System.out.println();

        System.out.println("RemoveAllNegatvesStrategy");
        RemoveAllNegatvesStrategy filterNegatives = new RemoveAllNegatvesStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.deleteSelected( filterNegatives );
        System.out.print("removed: ");
        ints.showAll();
        System.out.println();
        System.out.println("RemoveAllInIntervalStrategy");
        RemoveAllInIntervalStrategy removeInterval = new RemoveAllInIntervalStrategy( 10, 18 );
        System.out.print("in: ");
        ints.showAll();
        ints.deleteSelected( removeInterval );
        System.out.print("removed: ");
        ints.showAll();
        System.out.println();
        
        System.out.println("RemoveAndCountAllInIntervalStrategy");
        RemoveAndCountAllInIntervalStrategy removeAndCountInterval = new RemoveAndCountAllInIntervalStrategy( 10, 22 );
        System.out.print("in: ");
        ints.showAll();
        ints.deleteSelected( removeAndCountInterval );
        System.out.print("removed: ");
        ints.showAll();
        System.out.println("quantity: " +  removeAndCountInterval.getQuantity() );
        System.out.println();
        
        System.out.println("RemoveSmallerThanPredecessorStrategy");
        ints.add( 5 );
        ints.add( 6 );
        ints.add( -9 );
        ints.add( 11 );
        ints.add( 2 );
        ints.add( 9 );
        ints.add( 7 );
        ints.add( -12 );
        ints.add( 5 );
        RemoveSmallerThanPredecessorStrategy compPred = new RemoveSmallerThanPredecessorStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.deleteSelected( compPred );
        System.out.print("removed: ");
        ints.showAll();
        System.out.println();
        
        System.out.println("OneFollowsZeroStrategy");
        ints.add( 5 );
        ints.add( 0 );
        ints.add( -9 );
        ints.add( 11 );
        ints.add( 2 );
        ints.add( 0 );
        ints.add( 7 );
        ints.add( -12 );
        ints.add( 0 );
        OneFollowsZeroStrategy oneGenerator = new OneFollowsZeroStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.insertBehindSelected( oneGenerator );
        System.out.print("inserted: ");
        ints.showAll();
        System.out.println("size: " + ints.size());
        System.out.println();
        
        System.out.println("InsertFromListStrategy");
        DoublyLinkedList<Integer> second = new DoublyLinkedList<>();
        second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 );
        second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 );
        second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 );
        second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 ); second.add( 5 );
//        InsertFromListStrategy ifls = new InsertFromListStrategy( second );
//        System.out.print("in: ");
//        ints.showAll();
//        ints.insertBehindSelected( ifls );
//        System.out.print("inserted: ");
//        ints.showAll();
//        System.out.println("size: " + ints.size());
//        System.out.println();
        
        System.out.println("SubtotalStrategy");
        SubtotalStrategy sub = new SubtotalStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.insertBehindSelected( sub );
        System.out.print("inserted: ");
        ints.showAll();
        System.out.println("size: " + ints.size());
        System.out.println();
        
        System.out.println("SubtotalOfThreeElementsStrategy");
        SubtotalOfThreeElementsStrategy subThree = new SubtotalOfThreeElementsStrategy();
        System.out.print("in: ");
        ints.showAll();
        ints.insertBehindSelected( subThree );
        System.out.print("inserted: ");
        ints.showAll();
        System.out.println("size: " + ints.size());
        System.out.println();
    }
}
