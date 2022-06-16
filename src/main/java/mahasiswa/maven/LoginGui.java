package mahasiswa.maven;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGui extends ComponentGui{
    Gson gson = new Gson();

    public LoginGui() {
        initComponent();
    }

    void initComponent(){
        jendela.setSize(320, 480);
        jendela.setTitle("Data Mahasiswa");
        jendela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jendela.setLocationRelativeTo(null);
        jendela.getContentPane().setBackground(new Color(0xf0e5d8));
        jendela.setLayout(null);
        jendela.setVisible(true);

        lblnama.setBounds(35, 250, 40, 25);
        jendela.add(lblnama);
        jendela.validate();
        JTextField flnama = new JTextField();
        flnama.setBounds(130, 250, 130, 25);
        jendela.add(flnama);

        lblpassword.setBounds(35, 290, 80, 25);
        jendela.add(lblpassword);
        JPasswordField flpass = new JPasswordField();
        flpass.setBounds(130, 290, 130, 25);
        jendela.add(flpass);

        JButton btnlogin = new JButton("Login");
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        jendela.add(btnlogin);

        JButton btnregister = new JButton("Register");
        btnregister.setBounds(70, 400, 180, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(new Color(0xf0e5d8));
        jendela.add(btnregister);

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = flnama.getText();
                String pass = flpass.getText();
                try {
                    String hasil = ApacheHttp.sendPOSTLogin(user,pass);
                    ResponNew response = gson.fromJson(hasil,ResponNew.class);
                    System.out.println(response.status);
                    if (response.status==1){
                        JOptionPane.showMessageDialog(null,"Masuk");
                        JOptionPane.showMessageDialog(null,response.getMhs().get(0).toString());
                    }else {
                        JOptionPane.showMessageDialog(null,"gagal");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jendela.dispose();
                new RegisterGui();
            }
        });

    }
};


