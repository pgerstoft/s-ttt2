package slack.slack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EscapedEntityTest {

    @Test
    public void testEscapedUserId(){
        assertEquals("U012ABCDEF", EscapedEntity.getUserId("<@U012ABCDEF|ernie>"));
    }

    @Test
    public void testEscapedUserName(){
        assertEquals("@ernie", EscapedEntity.getUserName("<@U012ABCDEF|ernie>"));
    }

}