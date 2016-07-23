package com.endava.junit.process;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProcessPatternTest.class, SplitPatternTest.class })
public class AllTests {

}
