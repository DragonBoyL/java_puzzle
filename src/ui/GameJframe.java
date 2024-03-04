package ui;

import javax.swing.*;

public class GameJframe extends JFrame {
    public GameJframe(){

        //初始化界面
        initJFrame();


        //初始化菜单
        initJMenuBar();

        //让代码显示
        this.setVisible(true);

    }

    private void initJMenuBar() {
        //菜单条
        JMenuBar jMenuBar=new JMenuBar();

        //两个选项
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");

        //选项下的条目
        JMenuItem replayItem=new JMenuItem("重新游戏");
        JMenuItem reLoginItem=new JMenuItem("重新登录");
        JMenuItem closeItem=new JMenuItem("关闭游戏");

        JMenuItem accountItem=new JMenuItem("github");

        //将条目添加到选项
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将选项添加到菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面剧中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
