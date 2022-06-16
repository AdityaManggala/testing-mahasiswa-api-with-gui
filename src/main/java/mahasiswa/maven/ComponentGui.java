package mahasiswa.maven;

import javax.swing.*;

public class ComponentGui {
    protected JFrame jendela = new JFrame();
    protected JLabel lblnama = new JLabel("Nama");
    protected JLabel lblpassword = new JLabel("Password");
    protected JLabel lblregister = new JLabel("Register");
    protected JLabel lblalamat = new JLabel("Alamat");
    protected JLabel lbljurusan = new JLabel("Jurusan");
    protected JTextField flnama = new JTextField();
    protected JPasswordField flpass = new JPasswordField();
    protected JTextField flalamat = new JTextField();
    protected JTextField fljurusan = new JTextField();
    protected JButton btnlogin = new JButton("Login");
    protected JButton btnregister = new JButton("Register");
    protected JRadioButton L = new JRadioButton("L");
    protected JRadioButton P = new JRadioButton("P");
    protected ButtonGroup group = new ButtonGroup();
    protected JLabel lblgender = new JLabel("Gender");

}
