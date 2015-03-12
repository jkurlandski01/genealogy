package javaTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class JavaSortTest {
	
	public enum CAR_MODEL  {OUTBACK, HIGHLANDER, MUSTANG, THUNDERBIRD}
	
	@Test
	public void testEnumSet()	{
		EnumSet<CAR_MODEL> imported = EnumSet.of(CAR_MODEL.OUTBACK, CAR_MODEL.HIGHLANDER);
		EnumSet<CAR_MODEL> domestic = EnumSet.of(CAR_MODEL.MUSTANG, CAR_MODEL.THUNDERBIRD);
		
		CAR_MODEL myCar = CAR_MODEL.MUSTANG;
		CAR_MODEL myWifesCar = CAR_MODEL.OUTBACK;
		
		assertTrue(imported.contains(myWifesCar));
		assertFalse(imported.contains(myCar));
	    
	    assertTrue(domestic.contains(myCar));
	    assertFalse(domestic.contains(myWifesCar));
	}
	
	@Test
	public void testSimpleEnumSort()	{
		List<CAR_MODEL> carList = Lists.newArrayList();
		carList.add(CAR_MODEL.MUSTANG);
		carList.add(CAR_MODEL.THUNDERBIRD);
		carList.add(CAR_MODEL.OUTBACK);
		carList.add(CAR_MODEL.HIGHLANDER);
		Collections.sort(carList);
		
		assertEquals(CAR_MODEL.OUTBACK, carList.get(0));
		assertEquals(CAR_MODEL.HIGHLANDER, carList.get(1));
		assertEquals(CAR_MODEL.MUSTANG, carList.get(2));
		assertEquals(CAR_MODEL.THUNDERBIRD, carList.get(3));
	}
	
	@Test
	public void testSortEnum()	{
		TreeMap<CAR_MODEL, Float> map1 = new TreeMap<CAR_MODEL, Float>();
		map1.put(CAR_MODEL.HIGHLANDER, new Float(33000));
		map1.put(CAR_MODEL.MUSTANG, new Float(28000));
		map1.put(CAR_MODEL.OUTBACK, new Float(26000));
		map1.put(CAR_MODEL.THUNDERBIRD, new Float(21000));
		
		List<CAR_MODEL> keyList = new ArrayList<CAR_MODEL>(map1.keySet());
		assertEquals(CAR_MODEL.HIGHLANDER, keyList.get(1));
		assertEquals(CAR_MODEL.MUSTANG, keyList.get(2));
		assertEquals(CAR_MODEL.OUTBACK, keyList.get(0));
		assertEquals(CAR_MODEL.THUNDERBIRD, keyList.get(3));
	}

	@Test
	public void testTreeMap() {
		//TreeMap<String, Double> map1 = Maps.newTreeMap();
		TreeMap<String, Double> map1 = new TreeMap<String, Double>();
		map1.put("one", new Double(1.0));
		map1.put("two", new Double(2.0));
		map1.put("three", new Double(3.0));
		
		// Convert to list for convenience.
		//List<String> keyList = Lists.newArrayList(map1.keySet());
		List<String> keyList = new ArrayList<String>(map1.keySet());
		
		assertEquals("one", keyList.get(0));
		assertEquals("three", keyList.get(1));
		assertEquals("two", keyList.get(2));
		
		Double actual = map1.get(keyList.get(0));
		assertEquals(1.0, actual, 0.0);
		actual = map1.get(keyList.get(1));
		assertEquals(3.0, actual, 0.0);
		actual = map1.get(keyList.get(2));
		assertEquals(2.0, actual, 0.0);
		
	}

	@Test
	public void testArraysSort() {
//		Set<String> set = Sets.newHashSet("one", "two", "three", "four");
//		String[] setArray = set.toArray((new String[set.size()]));
		
		String[] array = {"one", "two", "three", "four"};
		Arrays.sort(array);
	
		// Test the sorted keys.
		assertEquals("four", array[0]);
		assertEquals("one", array[1]);
		assertEquals("three", array[2]);
		assertEquals("two", array[3]);
	
		System.out.println("Printing the sorted array.");
		System.out.println(array.toString());
		
		List<String> list = Arrays.asList(array);
		System.out.println("Printing the sorted array after converting it to a list.");
		System.out.println(list);
	}


	@Test
	public void testCollectionsSort() {
    	Map<String, Double> map = Maps.newHashMap(ImmutableMap.of("one", new Double(1), "two", 
    			new Double(2), "three", new Double(3), "four", new Double(3)));
    	
    	Set<String> keys = map.keySet();
    	List<String> keyList = Lists.newArrayList(keys);
		Collections.sort(keyList);

		System.out.println("Printing the sorted key list.");
		System.out.println(keyList.toString());
		System.out.println("Printing the original map's keys.");
		System.out.println(map.keySet());

		// Test the sorted keys.
		String actual = keyList.get(0);
		assertEquals("four", actual);
		actual = keyList.get(1);
		assertEquals("one", actual);
		actual = keyList.get(2);
		assertEquals("three", actual);
		actual = keyList.get(3);
		assertEquals("two", actual);
	}

	@Test
	public void testCollectionsSortOnList() {
		List<Integer> list = Lists.newArrayList(new Integer(23), new Integer(8), new Integer(14), new Integer(67));
		
		System.out.println("Printing the unsorted list.");
		System.out.println(list.toString());
		
		Collections.sort(list);
	
		System.out.println("Printing the sorted list.");
		System.out.println(list.toString());
	
		// Test the sorted keys.
		assertEquals(8, list.get(0).intValue());
		assertEquals(14, list.get(1).intValue());
		assertEquals(23, list.get(2).intValue());
		assertEquals(67, list.get(3).intValue());
	}

	@Test
	public void testCollectionsSortOnSet() {
		Set<Integer> set = Sets.newHashSet(new Integer(23), new Integer(8), new Integer(14), new Integer(67));
		
		System.out.println("Printing the unsorted set.");
		System.out.println(set.toString());
		
		List<Integer> list = Lists.newArrayList(set);
		Collections.sort(list);
	
		System.out.println("Printing the sorted list.");
		System.out.println(list.toString());
	
		// Test the sorted keys.
		assertEquals(8, list.get(0).intValue());
		assertEquals(14, list.get(1).intValue());
		assertEquals(23, list.get(2).intValue());
		assertEquals(67, list.get(3).intValue());
	}
}
