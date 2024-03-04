package ui;

import javax.swing.*;

public class LoginJframe extends JFrame {
    public LoginJframe(){
        this.setSize(488,430);
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //让代码显示
        this.setVisible(true);
    }
}
