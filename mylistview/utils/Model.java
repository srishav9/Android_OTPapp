package utils;

/**
 * Created by risha on 29-Dec-17.
 */

public class Model {
        private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String NAME;
        private String EMAIL;
        private String IMAGE_PATH;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public void setEMAIL(String EMAIL) {
            this.EMAIL = EMAIL;
        }

        public String getIMAGE_PATH() {
            return IMAGE_PATH;
        }

        public void setIMAGE_PATH(String IMAGE_PATH) {
            this.IMAGE_PATH = IMAGE_PATH;
        }

}
