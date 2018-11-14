package testate.testat21;

public class Box
{
	private int width;
	private int height;
	private int depth;
	
	public Box(int _width, int _height, int _depth)
	{
	width = _width;
	height = _height;
	depth = _depth;
	}
	
	public int getVolumeSize()
	{
		return width * height * depth;
	}
	public int getAreaSize()
	{
		return width * height * 2 + height * depth * 2 + width * depth * 2;
	}
	public int getEdgesLength()
	{
		return width * 4 + height * 4 + depth * 4;
	}
	public boolean isCube()
	{
		return width == depth && width == height;
	}
	
	public int compareTo(Box box)
	{
		return getVolumeSize() - box.getVolumeSize();
	}
	
	public boolean encloses(Box box)
	{
		if(box.getVolumeSize() > getVolumeSize())
			return false;
		return encloses(box.getWidth(), box.getDepth(), box.getHeight())
				|| encloses(box.getDepth(),box.getHeight() ,box.getWidth())
				|| encloses(box.getWidth(), box.getHeight(), box.getDepth());
			
	}
	
	private boolean enclosesFace(int bottom1, int bottom2, int height)
	{
		return encloses(bottom1, bottom2, height) || encloses(bottom2, bottom1, height);
	}
	private boolean encloses(int _width, int _depth, int _height)
	{
		return _width <= getWidth()&& _depth <= getDepth()&& _height <= getHeight();
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	
}
