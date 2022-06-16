package mahasiswa.maven;

public class Mhs {
    int id;
    String npm;
    String nama;
    String pass;
    String jenis_kelamin;
    String alamat;
    String jurusan;

    public Mhs(int id, String npm, String nama, String pass, String jenis_kelamin, String alamat, String jurusan) {
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.pass = pass;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }

    public Mhs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Mhs{" +
                "id=" + id +
                ", npm='" + npm + '\'' +
                ", nama='" + nama + '\'' +
                ", pass='" + pass + '\'' +
                ", jenis_kelamin='" + jenis_kelamin + '\'' +
                ", alamat='" + alamat + '\'' +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }
}
