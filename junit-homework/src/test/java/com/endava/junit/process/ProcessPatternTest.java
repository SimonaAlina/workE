package com.endava.junit.process;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessPatternTest {
	private ProcessPattern processPattern;

	@Before
	public void setUp() throws Exception {
		this.processPattern = new ProcessPattern();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void generatePositionJunior() throws Exception {
		String result = this.processPattern.generatePosition("junior", 1);
		assertEquals(result, "Junior Developer");
	}

	@Test
	public void generatePositionMiddle1() throws Exception {
		String result = this.processPattern.generatePosition("middle", 1);
		assertEquals(result, "Developer 1");
	}

	@Test
	public void generatePositionMiddle2() throws Exception {
		String result = this.processPattern.generatePosition("middle", 4);
		assertEquals(result, "Developer 2");
	}

	@Test
	public void generatePositionSen1() throws Exception {
		String result = this.processPattern.generatePosition("senior", 3);
		assertEquals(result, "Senior 1");
	}

	@Test
	public void generatePositionSen2() throws Exception {
		String result = this.processPattern.generatePosition("senior", 7);
		assertEquals(result, "Senior 2");
	}

	@Test
	public void generatePositionOther() throws Exception {
		String result = this.processPattern.generatePosition("test", 5);
		assertEquals(result, "Unknown Position");
	}

	@Test
	public void generatePositionAgeNeg() throws Exception {
		String result = this.processPattern.generatePosition("test", -5);
		assertNull(result);
	}

	@Test
	public void generatePositionGradeNull() throws Exception {
		String result = this.processPattern.generatePosition(null, 6);
		assertNull(result);
	}
}
