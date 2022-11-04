package it.unibo.mvc.api;

/**
 *
 */
public interface DrawNumberView {

    /**
     * @param observer the controller to attach
     */
    void setController(DrawNumberController observer);

    /**
     * This method is called before the UI is used. It should finalize its status (if needed).
     */
    void start();

    /**
     * @param res the result of the last draw
     */
    void result(DrawResult res);
}
