
public class treeNode {
  
	private int xData;
	private int yData;
	private treeNode leftNode;
	private treeNode rightNode;
	
	public treeNode()
	{
		this(0,0, null, null);
	}
	
	public treeNode(int x, int y)
	{
		xData = x;
		yData = y;
		leftNode = null;
		rightNode = null;
	}
	
	public treeNode(int x, int y, treeNode theLeftNode, treeNode theRightNode)
	{
		xData = x;
		yData = y;
		leftNode = theLeftNode;
		rightNode = theRightNode;
	}
	
	public int getX()
	{
		return xData;
	}
	
	public int getY()
	{
		return yData;
	}
	
	public treeNode getLeft()
	{
		return leftNode;
	}
	
	public treeNode getRight()
	{
		return rightNode;
	}
	
	public boolean hasLeft()
	{
		if(getLeft() != null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean hasRight()
	{
		if(getRight() != null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean hasNext()
	{
		if((hasRight() == true) ||(hasLeft() == true))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	public void setLeft(treeNode newNode)
	{
		leftNode = newNode;
	}
	
	public void setRight(treeNode newNode)
	{
		rightNode = newNode;
	}
	
	public int compareX(treeNode compare)
	{
		int answer;
		answer = getX() - compare.getX();
		
		return answer;
	}
	
	public int compareY(treeNode compare)
	{
		int answer;
		answer = getY() - compare.getY();
		
		return answer;
	}
	
	public int getNumberOfNodes()
	{
		return 0;
	}
	
	public int getHeight()
	{
		return 0;
	}
	
	

}
