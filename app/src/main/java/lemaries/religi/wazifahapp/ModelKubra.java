package lemaries.religi.wazifahapp;

/**
 * Created by Kotak Hitam on 5/6/2017.
 */

public class ModelKubra {
    private int ID_KUBRA, COUNTER;

    public ModelKubra() {
    }

    public ModelKubra(int ID_KUBRA, int COUNTER) {
        this.ID_KUBRA = ID_KUBRA;
        this.COUNTER = COUNTER;
    }

    public int getID_KUBRA() {
        return ID_KUBRA;
    }

    public void setID_KUBRA(int ID_KUBRA) {
        this.ID_KUBRA = ID_KUBRA;
    }

    public int getCOUNTER() {
        return COUNTER;
    }

    public void setCOUNTER(int COUNTER) {
        this.COUNTER = COUNTER;
    }
}
