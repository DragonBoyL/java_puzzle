package ui;

import javax.swing.*;
import java.util.Random;

public class GameJframe extends JFrame {

    //创建二维数组管理数据
    int[][] data =new int[4][4];
    public GameJframe(){

        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据(打乱)
        initData();

        //初始化图片
        initImage();


        //让代码显示
        this.setVisible(true);

    }

    private void initData() {
        int[] tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //打乱数组中数据的位置
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        //放到二位数组
        for (int i = 0; i < tempArr.length; i++) {
            data[i/4][i%4]=tempArr[i];
        }


    }

    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //加载图片的序号
                int number=data[i][j];
                //ImageIcon
                //ImageIcon icon=new ImageIcon("E:\\IDEA\\pintu\\资料\\素材\\image\\animal\\animal1\\2.jpg");
                //JLable管理容器
                JLabel jLabel1=new JLabel(new ImageIcon("E:\\IDEA\\pintu\\资料\\素材\\image\\animal\\animal3\\"+number+".jpg"));
                //指定图片位置
                jLabel1.setBounds(105*j,105*i,105,105);
                //把管理容器添加到界面
//        this.add(jLabel);
                this.getContentPane().add(jLabel1);

                number++;
            }
        }


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

        //取消默认的居中
        this.setLayout(null);
    }
}
