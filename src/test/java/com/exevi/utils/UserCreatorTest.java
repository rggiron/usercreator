package com.exevi.utils;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple UserCreator.
 */
public class UserCreatorTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserCreatorTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( UserCreatorTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        String p1 = UserCreator.newPasswordHash("juan");
        String p2 = UserCreator.newPasswordHash("juan");
        assertEquals(p1, p2);
    }
}
