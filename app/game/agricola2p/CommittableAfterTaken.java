package game.agricola2p;

/**
 * Marker interface for Actions, which indicates that after they've been used, the
 * COMMIT task should be usable. By default, the COMMIT task doesn't become usable,
 * so the actual commands that follow it need to do this manually.
 *  
 * @author philihp
 */
public interface CommittableAfterTaken  {

}
