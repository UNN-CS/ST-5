package org.st5;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProgramTest
        extends TestCase
{
    public ProgramTest(String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( ProgramTest.class );
    }

    public void testApp()
    {
        assertTrue( true );
    }
}
