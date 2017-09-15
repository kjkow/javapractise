package chapter4;

/**
 * Created by kamil on 2017-09-15.
 */
public class CommentExample {

    private boolean closed;

    //Method finnishes when this.cloded is true. Throws Exception if timeout is reached
    public synchronized void waitForClose(final long timeOutMillis) throws Exception{
        if(!closed){
            wait(timeOutMillis);
            if(!closed) throw new Exception("MockResponseSender could not be closed");
        }
    }

    /**
     * Firstly, the comment doesn't say more than code  itself
     * Secondly, method finnishes not WHEN but IF this.closed is true
     */
}
