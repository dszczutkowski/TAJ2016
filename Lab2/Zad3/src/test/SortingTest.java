package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Sorting;


public class SortingTest {

	private Sorting sorting;
	int[] arr1 = { 1,2,-1,-3,4 };
	int[] arr2 = { 3,2,1,0 };
	int[] arr3 = { -2,-1,0,1,2 };
	int[] arr4 = { 1 };
	int[] arr5 = { 1,2,3,2,1 };
	int[] arr6 = { 0 };
	int[] arr7 = { };
	
	
	@Before
	public void setup()
	{
		sorting = new Sorting();
	}
	
	@Test
	public void testSorting()
	{
		sorting.setTable(arr1);
		assertArrayEquals(sorting.sort(), new int[]{-3,-1,1,2,4});
		sorting.setTable(arr2);
		assertArrayEquals(sorting.sort(), new int[]{0,1,2,3});
		sorting.setTable(arr3);
		assertArrayEquals(sorting.sort(), new int[]{-2,-1,0,1,2});
		sorting.setTable(arr4);
		assertArrayEquals(sorting.sort(), new int[]{1});
		sorting.setTable(arr5);
		assertArrayEquals(sorting.sort(), new int[]{1,1,2,2,3});
		sorting.setTable(arr6);
		assertArrayEquals(sorting.sort(), new int[]{0});
		sorting.setTable(arr7);
		assertArrayEquals(sorting.sort(), new int[]{});
	}
	
	@Test
	public void testThrowsExceptionNull()
	{
		try
		{
			sorting.setTable(null);
		} catch(ArrayIndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	@After
	public void teardown()
	{
		sorting = null;
	}

}


