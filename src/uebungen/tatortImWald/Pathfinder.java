package uebungen.tatortImWald;

public class Pathfinder
{
	 public static void main(String[] args)
	 {
	 	Forest forest = new Forest(15, 15);
	 	Pathfinder pathfinder = new Pathfinder();
	 	
	 	pathfinder.find(forest, Forest.NODIRECTION);
	 	
	 	forest.show();
	 	forest.showTrace();
	 }
	
	
	public boolean find(Forest fo, int comeFrom)
	{
		if(fo.found())
			return true;
		
		int direction = 0;
		while (direction < 4)
		{
			if(direction != comeFrom)
			{
				if (fo.possibleMoveTo(direction))
				{
					fo.moveTo(direction);
					if (find(fo, fo.getReverseDirection(direction)))
					{
						fo.setTrace(direction);
						return true;
					}
					fo.moveTo(fo.getReverseDirection(direction));
				}
			}
			direction++;
		}
		
		return false;
	}
}
