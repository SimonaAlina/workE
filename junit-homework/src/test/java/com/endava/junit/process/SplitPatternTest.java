package com.endava.junit.process;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class SplitPatternTest {
	private SplitPattern splitPattern;

	@Before
	public void setUp() throws Exception {
		this.splitPattern = new SplitPattern();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void getStringLengthSmall() throws Exception {
		String result = this.splitPattern.getStringLength("ana");
		assertEquals(result, "small");
	}

	@Test
	public void getStringLengthMedium() throws Exception {
		String result = this.splitPattern.getStringLength("alexandra");
		assertEquals(result, "medium");
	}

	@Test
	public void getStringLengthLong() throws Exception {
		String result = this.splitPattern.getStringLength("acest str este long");
		assertEquals(result, "long");
	}

	@Test
	public void splitByLength() throws Exception {
		List<String> str = new ArrayList<String>();
		str.add("ana");
		str.add("alexandra");
		str.add("ana-maria-ioana");
		List<String> res = new ArrayList<String>();
		res = splitPattern.splitByLength(str);
		assertEquals(3, res.size());

	}
}