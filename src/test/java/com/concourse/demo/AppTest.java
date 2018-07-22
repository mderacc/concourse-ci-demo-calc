package com.concourse.demo;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void splitOperationWithValidTokensTest()
    {
        List<String> tokens = App.splitOperation("2+3");
        assertTrue( !tokens.isEmpty() );
    }

    @Test
    public void splitOperationWithBadTokenTest()
    {
        List<String> tokens = App.splitOperation("2+");
        assertTrue( tokens.isEmpty() );
    }
}
