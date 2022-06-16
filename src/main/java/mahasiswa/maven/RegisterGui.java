package mahasiswa.maven;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class RegisterGui extends ComponentGui{

    public RegisterGui(){
        initComponent();
    }

    void initComponent(){
        jendela.setTitle("Mahasiswa-Register");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setSize(320,480);
        jendela.setLocationRelativeTo(null);
        jendela.getContentPane().setBackground(new Color(0xf0e5d8));
        jendela.setLayout(null);

        jendela.setVisible(true);

        lblregister.setBounds(120,50,70,25);
        jendela.add(lblregister);
        lblnama.setBounds(35,95,40,25);
        jendela.add(lblnama);
        flnama.setBounds(130,95,130,25);
        jendela.add(flnama);

        lblalamat.setBounds(35,140,80,25);
        jendela.add(lblalamat);
        flalamat.setBounds(130,140,130,25);
        jendela.add(flalamat);

        lblpassword.setBounds(35,185,80,25);
        jendela.add(lblpassword);
        flpass.setBounds(130,185,130,25);
        jendela.add(flpass);

        lbljurusan.setBounds(35,230,80,25);
        jendela.add(lbljurusan);
        fljurusan.setBounds(130,230,130,25);
        jendela.add(fljurusan);

        lblgender.setBounds(35,270,80,25);
        L.setBounds(35,270,80,25);
        P.setBounds(130,270,80,25);
        group.add(L);
        group.add(P);
        jendela.add(L);
        jendela.add(P);

        btnregister.setBounds(90,290,140,25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        jendela.add(btnregister);

        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(new Color(0xf0e5d8));
        btnlogin.setBorder(null);
        jendela.add(btnlogin);

        btnregister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });

        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.black);
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jendela.dispose();
                new LoginGui();
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender="";
                if(L.isSelected()){
                    gender = "L";
                }else if(P.isSelected()){
                    gender = "P";
                }
                String nama = flnama.getText();
                String pass = flpass.getText();
                String alamat = flalamat.getText();
                String jurusan = fljurusan.getText();
                String npm = "06.2019.1.11.1";
                try {
                    String hasil = ApacheHttp.sendPOSTRegister(nama,npm,pass,jurusan,gender,alamat);
                    Gson gson = new Gson();
                    ResponNew respon = gson.fromJson(hasil,ResponNew.class);
                    if (respon.status==1){
                        JOptionPane.showMessageDialog(null,"Mahasiswa Berhasil Masuk");
                        JOptionPane.showMessageDialog(null,respon.message);
                    }else {
                        JOptionPane.showMessageDialog(null,"Gagal");
                        JOptionPane.showMessageDialog(null,respon.message);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
}

