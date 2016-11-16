package br.usp.exoma.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class ServiceException extends Exception {

    private List<Exception> messages = new ArrayList<Exception>();

    public ServiceException() {
        super();
        this.messages = new ArrayList<Exception>();
    }

    public ServiceException(String mensagem) {
        super(mensagem);
        this.addMessage(mensagem);
    }

    public ServiceException(String mensagem, Throwable cause) {
        super(mensagem, cause);
        this.addMessage(mensagem, cause);
    }

    public void addMessage(String mensagem) {
        this.messages.add(new Exception(mensagem));
    }

    public void addMessage(String mensagem, Throwable cause) {
        this.messages.add(new Exception(mensagem, cause));
    }

    public boolean hasMessages() {
        return this.messages.size() > 0;
    }

    public List<Exception> getMessages() {
        return messages;
    }
    
    

}
