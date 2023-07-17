package DAO.Enums;

public enum ELinkFile {
    CLIENTS("D:\\case-study\\Hotel_Manager\\src\\main\\java\\DAO\\file\\clients.txt"),
    ROOMS("D:\\case-study\\Hotel_Manager\\src\\main\\java\\DAO\\file\\rooms.txt"),
    FOODS("D:\\case-study\\Hotel_Manager\\src\\main\\java\\DAO\\file\\foods.txt"),
    RESERVATIONS("D:\\case-study\\Hotel_Manager\\src\\main\\java\\DAO\\file\\reservations.txt"),
    MANAGER("D:\\case-study\\Hotel_Manager\\src\\main\\java\\DAO\\file\\managers.txt");

    private final String filePath;
    ELinkFile(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }
}
