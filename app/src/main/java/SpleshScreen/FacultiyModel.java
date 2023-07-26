package SpleshScreen;

public class FacultiyModel {
    private String fname;
    private String fpopst;
    private String fqulification;
    private String fimage;

    public FacultiyModel() {
    }

    public FacultiyModel(String fname, String fpopst, String fqulification, String fimage) {
        this.fname = fname;
        this.fpopst = fpopst;
        this.fqulification = fqulification;
        this.fimage = fimage;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpopst() {
        return fpopst;
    }

    public void setFpopst(String fpopst) {
        this.fpopst = fpopst;
    }

    public String getFqulification() {
        return fqulification;
    }

    public void setFqulification(String fqulification) {
        this.fqulification = fqulification;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }




}
