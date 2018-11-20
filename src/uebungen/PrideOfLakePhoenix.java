package uebungen;


/**
 * # We have a ship which needs to be loaded with containers.
 * # Every container has a known weight.
 * # The containers get loaded in a specific not changeable order.
 *
 * Is it possible to load the ship without making it to tip over?
 *
 * This is a solution of this problem with recursive backtracking
 */
public class PrideOfLakePhoenix
{
	/**
	 * # We have 2 sited we can load. Right and Left.
	 * # After loading the ship it needs to have a divergence of 0
	 */
	public static boolean existsTotalBalance(int[] containers, int limit)
	{
		return existsTotalBalance(containers, limit, 0, 0);
	}
	
	private static boolean existsTotalBalance(int[] containers, int limit, int divergence, int unitsLoaded)
	{
		// If divergence is too high the ship is tipping over. Not possible to continue loading with this configuration
		if(Math.abs(divergence) > limit)
			return false;
		
		// If every unit is loaded check if ship is in balance
		if(unitsLoaded >= containers.length)
			return  divergence == 0;
		
		return existsTotalBalance(containers, limit, divergence + containers[unitsLoaded], unitsLoaded + 1)
			   || existsTotalBalance(containers, limit, divergence - containers[unitsLoaded], unitsLoaded + 1);
	}
	
	/**
	 *  # We have 3 position we can load. Left, middle, Right.
	 */
	public static boolean existsBlanaceWith3Holds(int[] containers, int limit)
	{
		return existsBlanaceWith3Holds(containers, limit, 0, 0);
	}
	
	
	private static boolean existsBlanaceWith3Holds(int[] containers, int limit, int divergence, int unitsLoaded)
	{
		if(Math.abs(divergence) > limit)
			return false;
		
		if(unitsLoaded >= containers.length)
			return divergence == 0;
		
		// Check if you can load ship without loading middle one
		if(existsTotalBalance(containers, limit, divergence, unitsLoaded))
			return true;
		
		// If not, load middle one
		return existsBlanaceWith3Holds(containers, limit, divergence, unitsLoaded+1);
	}
	
	/**
	 * Adds a container limit to the problem. Every hold is only allowed to hold containerLimit containers
	 */
	public static boolean existsBalanceWith3LimitedHolds(int[] containers, int limit, int divergence, int unitsLoaded, int containerLimit)
	{
		return existsBalanceWith3LimitedHolds(containers, limit, divergence, unitsLoaded, containerLimit, containerLimit, containerLimit);
	}
	
	private static boolean existsBalanceWith3LimitedHolds(int[] containers, int limit, int divergence, int unitsLoaded, int leftSpace, int middleSpace, int rightSpace)
	{
		// If divergence is too high the ship is tipping over. Not possible to continue loading with this configuration
		if(Math.abs(divergence) > limit)
			return false;
		
		// If every unit is loaded check if ship is in balance
		if(unitsLoaded >= containers.length)
			return  divergence == 0;
		
		if(leftSpace>0)
		{
			if(existsBalanceWith3LimitedHolds(containers, limit, divergence + containers[unitsLoaded], unitsLoaded, leftSpace-1, middleSpace, rightSpace))
				return true;
		}
		if(rightSpace>0)
		{
			if(existsBalanceWith3LimitedHolds(containers, limit, divergence - containers[unitsLoaded], unitsLoaded, leftSpace, middleSpace, rightSpace-1))
				return true;
		}
		if(middleSpace>0)
		{
			return existsBalanceWith3LimitedHolds(containers, limit, divergence, unitsLoaded+1, leftSpace, middleSpace-1, rightSpace);
		}
		return false;
	}

}
