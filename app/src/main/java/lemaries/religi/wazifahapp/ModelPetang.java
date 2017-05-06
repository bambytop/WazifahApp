package lemaries.religi.wazifahapp;

/**
 * Created by Kotak Hitam on 5/6/2017.
 */

public class ModelPetang {
    private int ID_DOA;
    private String NAMA, BACAAN;

    public ModelPetang() {
    }

    public ModelPetang(int ID_DOA, String NAMA, String BACAAN) {
        this.ID_DOA = ID_DOA;
        this.NAMA = NAMA;
        this.BACAAN = BACAAN;
    }

    public int getID_DOA() {
        return ID_DOA;
    }

    public void setID_DOA(int ID_DOA) {
        this.ID_DOA = ID_DOA;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getBACAAN() {
        return BACAAN;
    }

    public void setBACAAN(String BACAAN) {
        this.BACAAN = BACAAN;
    }
}
