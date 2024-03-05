package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener , ActionListener {

    //创建二维数组管理数据
    int[][] data =new int[4][4];
    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;
    //图片路径
    String path="资料\\素材\\image\\animal\\animal3\\";

    int[][] win =new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };

    //
    int step=0;

    //选项下的条目
    JMenuItem replayItem=new JMenuItem("重新游戏");
    JMenuItem reLoginItem=new JMenuItem("重新登录");
    JMenuItem closeItem=new JMenuItem("关闭游戏");

    JMenuItem accountItem=new JMenuItem("github");
    JMenuItem mnItem=new JMenuItem("美女");
    JMenuItem sportItem=new JMenuItem("运动");
    JMenuItem animalItem=new JMenuItem("动物");

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
            if(tempArr[i]==0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];


        }


    }

    private void initImage() {

        //清楚所有图片
        this.getContentPane().removeAll();


        //判断胜负
        if(victory()){
            JLabel winJLabel=new JLabel(new ImageIcon("资料\\素材\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount=new JLabel("步数："+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //先加载的图片在上方，

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //加载图片的序号
                int number=data[i][j];
                //ImageIcon
                //ImageIcon icon=new ImageIcon("E:\\IDEA\\pintu\\资料\\素材\\image\\animal\\animal1\\2.jpg");
                //JLable管理容器
                JLabel jLabel1=new JLabel(new ImageIcon(path+number+".jpg"));
                //指定图片位置
                jLabel1.setBounds(105*j+83,105*i+134,105,105);
                //添加边框
                jLabel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面
//        this.add(jLabel);
                this.getContentPane().add(jLabel1);

                number++;
            }
        }

        //添加背景图片
        JLabel background =new JLabel(new ImageIcon("资料\\素材\\image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    private void initJMenuBar() {
        //菜单条
        JMenuBar jMenuBar=new JMenuBar();

        //两个选项
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");

        JMenu chengJMenu=new JMenu("更换图片");


        //给条目添加事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        mnItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

        //将条目添加到选项
        chengJMenu.add(mnItem);
        chengJMenu.add(sportItem);
        chengJMenu.add(animalItem);

        functionJMenu.add(chengJMenu);
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
        //添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =e.getKeyCode();
        if(code==65){
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);

            //添加背景图片
            JLabel background =new JLabel(new ImageIcon("资料\\素材\\image\\background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;//返回结果/停止方法
        }

        int code=e.getKeyCode();
        if(code==37){
            System.out.println("向左移动");
            if(y==3){
                return ;
            }
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            step++;
            initImage();
        }else if(code==38){
            System.out.println("向上移动");
            if(x==3){
                return ;
            }
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            step++;
            initImage();
        }else if(code==39){
            System.out.println("向右移动");
            if(y==0){
                return ;
            }
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            step++;
            initImage();
        }else if(code==40){
            System.out.println("向下移动");
            if(x==0){
                return ;
            }
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            step++;
            initImage();
        }else if(code==65){
            initImage();
        }else if(code==87){
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x=3;
            y=3;
            initImage();

        }
    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==replayItem){
            System.out.println("重新游戏");
            initData();
            step=0;
            initImage();

        }else if(obj==reLoginItem){
            System.out.println("重新登录");
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJframe();
        }else if(obj==closeItem){
            System.out.println("关闭游戏");
            //关闭虚拟机
            System.exit(0);
        }else if(obj==accountItem){
            System.out.println("github");
            JDialog jDialog=new JDialog();
            JLabel jLabel=new JLabel(new ImageIcon("资料\\素材\\image\\about.png"));
            jLabel.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭无法进行下面的操作
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }else if(obj==mnItem){
            //随机选择图片
            Random r=new Random();
            int index=r.nextInt(1,14);
            //修改path
            path="资料\\素材\\image\\girl\\girl"+index+"\\";
            //重开
            initData();
            step=0;
            initImage();
        }else if(obj==sportItem){
            //随机选择图片
            Random r=new Random();
            int index=r.nextInt(1,11);
            //修改path
            path="资料\\素材\\image\\sport\\sport"+index+"\\";
            //重开
            initData();
            step=0;
            initImage();
        }else if(obj==animalItem){
            //随机选择图片
            Random r=new Random();
            int index=r.nextInt(1,9);
            //修改path
            path="资料\\素材\\image\\animal\\animal"+index+"\\";
            //重开
            initData();
            step=0;
            initImage();

        }
    }
}
