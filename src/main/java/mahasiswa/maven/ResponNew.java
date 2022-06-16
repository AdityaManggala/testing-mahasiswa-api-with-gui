package mahasiswa.maven;

import java.util.List;

public class ResponNew {

    int status;
    String message;
    List<Mhs> mhs;

    public ResponNew(int status, String massage, List<Mhs> mhs) {
        this.status = status;
        this.message = massage;
        this.mhs = mhs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }

    public List<Mhs> getMhs() {
        return mhs;
    }

    public void setMhs(List<Mhs> mhs) {
        this.mhs = mhs;
    }

    @Override
    public String toString() {
        return "ResponNew{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", mhs=" + mhs +
                '}';
    }
}
