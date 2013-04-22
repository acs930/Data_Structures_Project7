
public class kdTree {
  
	private treeNode root;
	
	
	public kdTree()
	{
		root = new treeNode();
	}
	
	public kdTree(int x, int y)
	{
		root = new treeNode(x, y, null, null);
	}
	
	public treeNode getRootNode()
	{
		return root;
	}
	
	public void searchTree(int x, int y)
	{
		treeNode currentNode = root;
		int treeLevel = 1;
		
		while(currentNode.hasNext())
		{
			if(treeLevel%2 == 1)
			{
				if(x > root.getX())
				{
					currentNode = currentNode.getRight();
					System.out.println("you are at level:  " + treeLevel);
					treeLevel++;
				}
				else if(x < root.getX())
				{
					currentNode = currentNode.getLeft();
					System.out.println("you are at level:  " + treeLevel);
					treeLevel++;
				}
				
				else
				{
					if(y == currentNode.getY())
					{
						System.out.println("The node with data " + x + " and "+ y + " exists.");
						return;
					}
				}
			}
			
			else 
			{
				if(y  > root.getY())
				{
					currentNode = currentNode.getRight();
					System.out.println("you are at level:  " + treeLevel);
					treeLevel++;
				}
				else if(y < root.getY())
				{
					currentNode = currentNode.getLeft();
					System.out.println("you are at level:  " + treeLevel);
					treeLevel++;
				}
				
				else
				{
					if(x == currentNode.getX())
					{
						System.out.println("The node with data " + x + " and "+ y + " exists.");
						return;
					}
				}
			}
		}
		
		System.out.println("The node with data " + x + " and "+ y + " does not exist.");
	}
	
	public void printTree()
	{
		
	}
	
	
	
	public void addToTree(int x, int y)
	{
		treeNode currentNode = root;
		treeNode newNode = new treeNode(x, y, null, null);
		int treeLevel = 1;
		
		while(currentNode.hasNext())
		{
			if(treeLevel%2 == 1)
			{
				if(newNode.getX() >= root.getX())
				{
					currentNode = currentNode.getRight();
					treeLevel++;
				}
				else
				{
					currentNode = currentNode.getLeft();
					treeLevel++;
				}
			}
			
			else 
			{
				if(newNode.getY() >= root.getY())
				{
					currentNode = currentNode.getRight();
					treeLevel++;
				}
				else
				{
					currentNode = currentNode.getLeft();
					treeLevel++;
				}
			}
			
		}
		
		if(treeLevel%2 == 1)
		{
			if(newNode.getX() >= root.getX())
			{
				currentNode.setRight(newNode);
			}
			else
			{
				currentNode.setLeft(newNode);
			}
		}
		
		else 
		{
			if(newNode.getY() >= root.getY())
			{
				currentNode.setRight(newNode);
			}
			else
			{
				currentNode.setLeft(newNode);
			}
		}
			
		
	}
	
	public int addToTreeRecursive(int x, int y)
	{
		int result = 0;
		
		result = addEntry(getRootNode(),  x,  y, 1);
		
		//System.out.println("success");
		return result;
	}
	
	private int addEntry(treeNode rootNode, int x, int y, int treeLevel)
	{
		int result = 0;
		treeNode newEntry = new treeNode(x, y, null, null);
		int comparison;
		
		if(treeLevel%2 == 1)
		{
			comparison = newEntry.compareX(rootNode);
		}
		
		else
		{
			comparison = newEntry.compareY(rootNode);
		}
		
		if (comparison < 0)
		{
			if(rootNode.hasLeft())
			{
				treeLevel++;
				result = addEntry(rootNode.getLeft(), newEntry.getX(), newEntry.getY(), treeLevel);
			}
			
			else
			{
				rootNode.setLeft(newEntry);
			}
		}
		
		else 
		{
			if(rootNode.hasRight())
			{
				treeLevel++;
				result = addEntry(rootNode.getRight(), newEntry.getX(), newEntry.getY(), treeLevel);
			}
			else
			{
				rootNode.setRight(newEntry);
			}
		}
		
		
		return result;
	}
	
	public int getEntry( int x, int y)
	{
		return findEntry(getRootNode(), x, y, 1);
	}
	
	private int findEntry(treeNode root, int x, int y, int treeLevel)
	{
		int result = 0;
		
		if(root != null)
		{
			int rootX = root.getX();
			int rootY = root.getY();
			
			if((x == rootX)&& (y==rootY))
			{
				System.out.println("The node with data " + x + " and "+ y + " exists.");
			}
			
			else
			{
				if(treeLevel%2 == 1)
				{
					if(x < rootX)
					{
						treeLevel++;
						result = findEntry(root.getLeft(), x, y, treeLevel );
						
					}
					
					else
					{
						treeLevel++;
						result = findEntry(root.getRight(), x, y, treeLevel);
					}
				}
				else
				{
					if(y < rootY)
					{
						treeLevel++;
						result = findEntry(root.getLeft(), x, y, treeLevel );
						
					}
					
					else
					{
						treeLevel++;
						result = findEntry(root.getRight(), x, y, treeLevel);
					}
				}
			}
		}
		
		//System.out.println("???");
		return result;
		
	}
	

	
	public static void main(String[] args)
	{
		kdTree myTree = new kdTree(50,50);
		
		System.out.println("hello");
		myTree.addToTreeRecursive(40, 74);
		myTree.addToTreeRecursive(73, 92);
		myTree.addToTreeRecursive(62, 5);
		myTree.addToTreeRecursive(42, 7);
		
		myTree.getEntry(42, 7);
		
		
		
	}
}





//Make addToTree do what the kd tree is supposed to do when nodes are added to it
//then in the constructor allow the user to pass an array of data and fill accordingly
