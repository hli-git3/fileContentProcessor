/**
 * 
 */
package com.sky.core.processor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sky.core.processor.DuplicationRemover;

/**
 * @author hli
 *
 */
public class DuplicationRemoverTest {

	DuplicationRemover processor;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		processor = new DuplicationRemover();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		processor = null;
	}

	/**
	 * Test method for {@link com.sky.core.processor.DuplicationRemoverTest#removeDuplicateInteger(java.lang.String)}.
	 */
	@Test
	public void testRemoveDuplicateInteger() {
		List<Integer> set = processor.removeDuplicateInteger("src/test/resources/testFile1.txt");
		assertEquals(4, set.size());
	}

	@Test
	public void testRemoveDuplicateInteger2() {
		List<Integer> set = processor.removeDuplicateInteger("src/test/resources/testFile2.txt");
		assertEquals(11, set.size());
	}
	
	/**
	 * Test method for {@link com.sky.core.processor.DuplicationRemoverTest#convertItemsToString(java.util.Collection)}.
	 */
	@Test
	public void testConvertItemsToString() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		
		assertEquals("1, 3, 5", processor.convertItemsToString(list));
	}

}
