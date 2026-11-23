
package jwium.lab1.messageboard.test;
import jwium.lab1.messageboard.model.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the funcionality of the MessagesManager class.
 * 
 * <p>Documentation documented with the help of AI (Model: Gemini).
 * <p>Methods named with the help of AI (Model: Gemini).
 * 
 * @author Rafal Lobaza
 * @version 1.0
 */
public class MessagesManagerTest {
    private MessagesManager manager;

    @BeforeEach
    void setUp() {
        manager = new MessagesManager();
    }

    // addDescriptionFromArgs(ArrayList<String> args)
    @Test
    void addDescriptionFromArgs_singleArgument_setsDescriptionAndReturnsTrue() {
        ArrayList<String> args = new ArrayList<>(List.of("This is the description."));

        boolean result = manager.addDescriptionFromArgs(args);

        assertTrue(result);
        assertEquals("This is the description.", manager.getDescription());
    }

    @Test
    void addDescriptionFromArgs_multipleArguments_usesFirstElementAsBoundary() {
        ArrayList<String> args = new ArrayList<>(List.of("This is the first argument.", "This is the second argument."));

        boolean result = manager.addDescriptionFromArgs(args);

        assertTrue(result);
        assertEquals("This is the first argument.", manager.getDescription());
    }

    @Test
    void addDescriptionFromArgs_emptyList_returnsFalseAndKeepsDefaultDescription() {
        ArrayList<String> args = new ArrayList<>();

        boolean result = manager.addDescriptionFromArgs(args);

        assertFalse(result);
        assertEquals("", manager.getDescription());
    }

    @Test
    void addDescriptionFromArgs_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> manager.addDescriptionFromArgs(null));
    }

    // addMessage(Message message)
    @Test
    void addMessage_validMessageObject_addsToMessagesAndListModel() {
        Message msg = new Message("This is the content.", "user");

        manager.addMessage(msg);

        assertEquals(1, manager.getMessages().size());
        assertSame(msg, manager.getMessages().get(0));
        assertEquals(1, manager.getMessagesListModel().getSize());
        assertSame(msg, manager.getMessagesListModel().getElementAt(0));
    }

    @Test
    void addMessage_hiddenMessageObject_addsToMessagesButNotVisibleListModel() {
        Message hiddenMsg = new Message("This is the hidden message.", "user");
        hiddenMsg.setStatus(MessageStatus.HIDDEN);

        manager.addMessage(hiddenMsg);

        assertEquals(1, manager.getMessages().size());
        assertEquals(0, manager.getMessagesListModel().getSize());
    }

    @Test
    void addMessage_nullMessageObject_addsNullToMessagesAndThrowsInListModelRefresh() {
        assertThrows(NullPointerException.class, () -> manager.addMessage((Message) null));
    }

    // addMessage(String content)
    @Test
    void addMessage_contentOnly_createsMessageWithDefaultAuthor() {
        manager.addMessage("Hello world!");

        assertEquals(1, manager.getMessages().size());
        assertEquals("Hello world!", manager.getMessages().get(0).getContent());
        assertEquals("unknown_user", manager.getMessages().get(0).getAuthor());
        assertEquals(1, manager.getMessagesListModel().getSize());
    }

    @Test
    void addMessage_emptyContent_addsMessageWithEmptyString() {
        manager.addMessage("");

        assertEquals(1, manager.getMessages().size());
        assertEquals("", manager.getMessages().get(0).getContent());
    }

    @Test
    void addMessage_nullContent_addsMessageWithNullContentWithoutThrowing() {
        assertDoesNotThrow(() -> manager.addMessage((String) null));
        assertEquals(1, manager.getMessages().size());
        assertNull(manager.getMessages().get(0).getContent());
    }

    // addMessage(String content, String author)
    @Test
    void addMessage_contentAndAuthor_createsMessageWithGivenValues() {
        manager.addMessage("This is the message.", "user");

        assertEquals(1, manager.getMessages().size());
        assertEquals("This is the message.", manager.getMessages().get(0).getContent());
        assertEquals("user", manager.getMessages().get(0).getAuthor());
        assertEquals(1, manager.getMessagesListModel().getSize());
    }

    @Test
    void addMessage_emptyContentAndAuthor_addsBoundaryEmptyStrings() {
        manager.addMessage("", "");

        assertEquals(1, manager.getMessages().size());
        assertEquals("", manager.getMessages().get(0).getContent());
        assertEquals("", manager.getMessages().get(0).getAuthor());
    }

    @Test
    void addMessage_nullContentAndNullAuthor_addsMessageWithNullsWithoutThrowing() {
        assertDoesNotThrow(() -> manager.addMessage(null, null));
        assertEquals(1, manager.getMessages().size());
        assertNull(manager.getMessages().get(0).getContent());
        assertNull(manager.getMessages().get(0).getAuthor());
    }

    // removeMessage(Message message)
    @Test
    void removeMessage_existingMessage_removesItAndReturnsTrue() {
        Message m1 = new Message("This is the first message.", "user1");
        Message m2 = new Message("This is the second message.", "user2");
        manager.addMessage(m1);
        manager.addMessage(m2);

        boolean removed = manager.removeMessage(m1);

        assertTrue(removed);
        assertEquals(1, manager.getMessages().size());
        assertSame(m2, manager.getMessages().get(0));
        assertEquals(1, manager.getMessagesListModel().getSize());
        assertSame(m2, manager.getMessagesListModel().getElementAt(0));
    }

    @Test
    void removeMessage_nonExistentOrNullMessage_returnsFalseWithoutChangingList() {
        Message m1 = new Message("This is the first message.", "user1");
        Message notAdded = new Message("This is the message that will not be added.", "user2");
        manager.addMessage(m1);

        assertFalse(manager.removeMessage(notAdded));
        assertFalse(manager.removeMessage((Message) null));
        assertEquals(1, manager.getMessages().size());
        assertEquals(1, manager.getMessagesListModel().getSize());
    }

    // filterMessagesByAuthor(String author)
    @Test
    void filterMessagesByAuthor_caseSensitiveSubstring_showsOnlyMatchingMessages() {
        manager.addMessage("This is the first message.", "User");
        manager.addMessage("This is the second message.", "user");
        manager.addMessage("This is the third message.", "User123");
        manager.addMessage("This is the fourth message.", "test_name");

        manager.filterMessagesByAuthor("Use");

        assertEquals(2, manager.getMessagesListModel().getSize());
        assertEquals("This is the first message.", manager.getMessagesListModel().getElementAt(0).getContent());
        assertEquals("This is the third message.", manager.getMessagesListModel().getElementAt(1).getContent());
        assertEquals(MessageStatus.VISIBLE, manager.getMessages().get(0).getStatus());
        assertEquals(MessageStatus.HIDDEN, manager.getMessages().get(1).getStatus());
        assertEquals(4, manager.getMessages().size());
    }

    @Test
    void filterMessagesByAuthor_emptyBlankOrNullQueryOnEmptyAndPopulatedList_handlesBoundaryCases() {
        assertDoesNotThrow(() -> manager.filterMessagesByAuthor(null));
        assertDoesNotThrow(() -> manager.filterMessagesByAuthor(""));
        assertDoesNotThrow(() -> manager.filterMessagesByAuthor("   "));
        assertEquals(0, manager.getMessagesListModel().getSize());
        
        manager.addMessage("This is the first message.", "user1");
        manager.addMessage("This is the second message.", "user2");

        manager.filterMessagesByAuthor(null);
        assertEquals(2, manager.getMessagesListModel().getSize());

        manager.filterMessagesByAuthor("   ");
        assertEquals(2, manager.getMessagesListModel().getSize());
    }

    // stopFilteringMessages()
    @Test
    void stopFilteringMessages_afterFiltering_restoresAllMessagesToVisible() {
        manager.addMessage("This is the first message.", "user1");
        manager.addMessage("This is the second message.", "user2");
        manager.filterMessagesByAuthor("user1");
        assertEquals(1, manager.getMessagesListModel().getSize());

        manager.stopFilteringMessages();

        assertEquals(2, manager.getMessagesListModel().getSize());
        assertTrue(manager.getMessages().stream().allMatch(m -> m.getStatus() == MessageStatus.VISIBLE));
    }

    @Test
    void stopFilteringMessages_onEmptyList_doesNotThrowAndKeepsEmptyModel() {
        assertDoesNotThrow(() -> manager.stopFilteringMessages());
        assertEquals(0, manager.getMessages().size());
        assertEquals(0, manager.getMessagesListModel().getSize());
    }
}
