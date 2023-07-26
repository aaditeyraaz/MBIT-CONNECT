package SpleshScreen;

public class FileInfoModel {
    String filename;
    String fileurl;
    String author;

    public FileInfoModel(String filename, String fileurl,String author) {
        this.filename = filename;
        this.fileurl = fileurl;
        this.author=author;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public FileInfoModel() {
    }





    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }


}
