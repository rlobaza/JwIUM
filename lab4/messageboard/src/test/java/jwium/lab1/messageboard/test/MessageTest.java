package jwium.lab1.messageboard.test;
import jwium.lab1.messageboard.model.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

/**
 * Tests the funcionality of the Message class.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * <p>Methods named with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class MessageTest {
    
    // toString()
    @Test
    void toString_validContentAndAuthor_formatsTimestampAuthorAndContent() {
        Message message = new Message("Hello world!", "user");

        String result = message.toString();

        assertNotNull(result);
        assertTrue(result.endsWith(" - user: Hello world!"));
        assertTrue(result.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2} - user: Hello world!"));
    }

    @Test
    void toStringOnlyContentUsesDefaultAuthorUnknownUser() {
        Message message = new Message("This is a message.");

        String result = message.toString();

        assertTrue(result.endsWith(" - unknown_user: This is a message."));
        assertTrue(result.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2} - unknown_user: This is a message."));
    }

    @Test
    void toString_defaultConstructorEmptyContent_formatsWithEmptyContentAndDefaultAuthor() {
        Message message = new Message();

        String result = message.toString();

        assertTrue(result.endsWith(" - unknown_user: "));
        assertTrue(result.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2} - unknown_user: "));
    }

    @Test
    void toString_emptyStringsAndWhitespace_preservesExactCharacters() {
        Message message = new Message("   ", "");

        String result = message.toString();

        assertTrue(result.endsWith(" - :    "));
    }

    @Test
    void toString_specialCharactersAndPunctuation_keepsCharactersIntact() {
        Message message = new Message("Test: 100% [OK] - finished!", "user_user-1");

        String result = message.toString();

        assertTrue(result.endsWith(" - user_user-1: Test: 100% [OK] - finished!"));
    }

    @Test
    void toString_nullPostTimeInMessageData_throwsNullPointerException() {
        Message message = new Message("Is this the content?", "user");

        try {
            Field dataField = Message.class.getDeclaredField("messageData");
            dataField.setAccessible(true);
            MessageData originalData = (MessageData) dataField.get(message);
            MessageData brokenData = new MessageData(
                    originalData.content(),
                    originalData.author(),
                    null
            );
            dataField.set(message, brokenData);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to prepare test data via reflection: " + e.getMessage());
        }

        assertThrows(NullPointerException.class, message::toString);
    }

    @Test
    void toString_nullAuthorAndContent_doesNotThrowExceptionAndFormatsNullStrings() {
        Message message = new Message(null, null);

        String result = assertDoesNotThrow(message::toString);
        assertTrue(result.endsWith(" - null: null"));
    }
}
