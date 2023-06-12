import java.util.NoSuchElementException;

public class DoubleLinkedList 
{
	private Node first = null;
	private Node last = null;

	public void addFirst(String str) 
	{
		// Write code to create object
		Node fresh = new Node(str);
		// Write code to add this node in the beginning of the list
		//When list is empty.Make this node first as well as last
		if(first==null)
		{
			first=fresh;
			last=fresh;
			return;
		}
		//When list has already nodes
		//we want to add node from beginning (not from end)
		fresh.next=first;
		first.prev=fresh;
		first=fresh; 
	}
	public void addLast(String str) 
	{
		// Write code to create object
		Node fresh = new Node(str);
		// Write code to add this node at the end of the list
		//When list is empty.Make this node last as well as first
		if(first==null)
		{
			first=fresh;
			last=fresh;
			return;
		}
		//When list has already nodes
		//we want to add node to the end (not from beginning)
		last.next=fresh;//since we have added from beginning addFirst method,fresh node = 1st node at position 1st
		fresh.prev=last;//here last node=last node at last position(last values remains last in addFirst method)
		last=fresh;
	}
	public void add(String str)
	{
		addLast(str);
	}
	
	//adding at particular index
	public void add(int index,String str)
	{
		int x=size();
		if(index<0||index>x)
		{
			throw new IndexOutOfBoundsException("Index: "+index+" ,Size: "+x);
		}
		if(index==0)
		{
			addFirst(str);
			return;
		}
		if(index==x)
		{
			addLast(str);
			return;
		}
		//code to add between two nodes
		Node fresh=new Node(str);
		Node b1=first;
		for(int c=1;c<index;c++)
		{
			b1=b1.next;
		}
		Node b2=b1.next;
		b1.next=fresh;
		fresh.prev=b1;
		fresh.next=b2;
		b2.prev=fresh;
	}
	//we need to know the size of node to get the index value
	public int size()
	{
		if(first==null)
			return 0;
		int count=0;
		Node cur=first;
		while(cur!=null)
		{
			count++;
			cur=cur.next;
		}
		return count;
	}
	public String getFirst()
	{
		if(first==null)
			throw new NoSuchElementException();
		return first.data;
	}
	public String getLast()
	{
		if(last==null)
			throw new NoSuchElementException();
		return last.data;
	}
	public String get(int index)
	{
		int x=size();
		if(index<0||index>=x)
			throw new IndexOutOfBoundsException();
		Node cur=first;
		for(int c=1;c<index;c++)
		{
			cur=cur.next;
		}
		return cur.data;
	}
	
	public String removeFirst()
	{
		if(first==null)
			throw new NoSuchElementException();
		String str=first.data;
		first=first.next;
		first.prev=null;
		return str;
	}
	public String removeLast()
	{
		if(last==null)
			throw new NoSuchElementException();
		String str=last.data;
		Node l=last.prev;
		l.next=null;
		last=l;
		return str;
	}
	//removing from particular index
	public String remove(int index)
	{
		int x=size();
		if(index<0||index>=x)
		{
			throw new IndexOutOfBoundsException("Index: "+index+" ,Size: "+x);
		}
		if(index==0)
		{
			removeFirst();
			return null;
		}
		if(index==x-1)
		{
			removeLast();
			return null;
		}
		//code to remove between two nodes
		Node cur=first;
		for(int c=1;c<index;c++)
		{
			cur=cur.next;//we get the reference of node which we want to remove
		}
		String str=cur.data;//we need data of current node
		Node b1=cur.prev;
		Node b2=cur.next;
		b1.next=b2;	
		b2.prev=b1;
		cur.next=null;//since current node will be deleted
		cur.prev=null;//since current node will be deleted
		return cur.data;//returns data of current node
	}
	public void showList()
	{
		Node current=first;
		while(current!=null)
		{
			System.out.println(current.data);
			current=current.next;
	 	}
	}
}