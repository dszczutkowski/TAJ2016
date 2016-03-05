package projekt1zad1;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	
	private List<Integer> stack;
	
	public MyStack()
	{
		stack = new ArrayList<Integer>();
	}
	
	public List<Integer> getStack() {
		return stack;
	}

	public void setStack(List<Integer> stack) {
		this.stack = stack;
	}

	public void MyPush(int a)
	{
		stack.add(a);
	}
	
	public void MyPop()
	{
		int size = stack.size();
		stack.remove(size - 1);
	}
	
	public boolean IsNull()
	{
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public int MyTop()
	{
		int size = stack.size();
		if(size <= 0)
			throw new NullPointerException();
		else
			return stack.get(size - 1);
	}
}
