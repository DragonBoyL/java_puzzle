package ui;

import domain.User;
import util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJframe extends JFrame {

    static ArrayList<User> allUsers=new ArrayList<>();
    static {
        allUsers.add(new User("zhangsan","123"));
        allUsers.add(new User("lisi","1234"));
    }

    public LoginJframe(){
        initJFrame();

        initView();
        //让代码显示
        this.setVisible(true);
    }

    private void initView() {
        //用户名
        JLabel usernameText=new JLabel(new ImageIcon("资料\\素材\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //用户名输入
        JTextField username=new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //密码
        JLabel passwordText=new JLabel(new ImageIcon("资料\\素材\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //密码输入
        JPasswordField password=new JPasswordField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码
        JLabel codeText=new JLabel(new ImageIcon("资料\\素材\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码输入
        JTextField code=new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        String codeStr= CodeUtil.getCode();
        //正确的验证码
        JLabel rightCode=new JLabel();
        rightCode.setText(codeStr);
        //验证码鼠标事件
        rightCode.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("更换验证码");
                String code=CodeUtil.getCode();
                rightCode.setText(code);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //登录按钮
        JButton login=new JButton();
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("资料\\素材\\image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击登录");
                String usernameInput=username.getText();
                String passwordInput=new String(password.getPassword());
                String codeInput=code.getText();

                //创建一个User对象
                User userInfo = new User(usernameInput, passwordInput);
                System.out.println("用户输入的用户名为" + usernameInput);
                System.out.println("用户输入的密码为" + passwordInput);

                if (codeInput.length() == 0) {
                    showJDialog("验证码不能为空");
                } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                    //校验用户名和密码是否为空
                    System.out.println("用户名或者密码为空");
                    //调用showJDialog方法并展示弹框
                    showJDialog("用户名或者密码为空");
                }else if(!codeInput.equalsIgnoreCase(rightCode.getText())){
                    showJDialog("验证码输入错误");
                }else if (contains(userInfo)) {
                    System.out.println("用户名和密码正确可以开始玩游戏了");
                    //关闭当前登录界面
                    setVisible(false);
                    //打开游戏的主界面
                    //需要把当前登录的用户名传递给游戏界面
                    new GameJframe();
                } else {
                System.out.println("用户名或密码错误");
                showJDialog("用户名或密码错误");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                login.setIcon(new ImageIcon("资料\\素材\\image\\login\\登录按下.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                login.setIcon(new ImageIcon("资料\\素材\\image\\login\\登录按钮.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.getContentPane().add(login);

        //6.添加注册按钮
        JButton register=new JButton();
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("资料\\素材\\image\\login\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("注册");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                register.setIcon(new ImageIcon("资料\\素材\\image\\login\\注册按下.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                register.setIcon(new ImageIcon("资料\\素材\\image\\login\\注册按钮.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.getContentPane().add(register);


        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("资料\\素材\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    private void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(488,430);
        this.setTitle("拼图 登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public boolean contains(User userInput){
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if(userInput.getName().equals(rightUser.getName()) && userInput.getPassword().equals(rightUser.getPassword())){
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }

}
