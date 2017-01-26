package lemaries.religi.wazifahapp;

/**
 * Created by Kotak Hitam on 1/25/2017.
 */

public class ModelSugra {
    private int ID, FK_ID_DOA, COUNTER;

    public ModelSugra() {
    }

    public ModelSugra(int ID, int FK_ID_DOA, int COUNTER) {
        this.ID = ID;
        this.FK_ID_DOA = FK_ID_DOA;
        this.COUNTER = COUNTER;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFK_ID_DOA() {
        return FK_ID_DOA;
    }

    public void setFK_ID_DOA(int FK_ID_DOA) {
        this.FK_ID_DOA = FK_ID_DOA;
    }

    public int getCOUNTER() {
        return COUNTER;
    }

    public void setCOUNTER(int COUNTER) {
        this.COUNTER = COUNTER;
    }
}
