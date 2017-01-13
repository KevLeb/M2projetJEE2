package fr.test;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.Test;

import fr.services.MessageManager;

public class TestMessageManager {

    @EJB
    MessageManager messageManager;

    public TestMessageManager() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
        assertNotNull(messageManager);
    }

    @Test
    public void testAddMessage() throws Exception {
        messageManager.addMessage("Hello");
        messageManager.addMessage("Salut");
    }

}