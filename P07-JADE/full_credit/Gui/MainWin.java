package Gui;


import Store.Filling;
import Store.Donut;
import Store.Shot;
import Store.Frosting;
import Store.Darkness;
import Store.Java;
import Store.Store;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainWin extends JFrame{

    private Store store;
    private JLabel data;
    private JMenuItem mJava;
    private JButton bJava;
    private JMenuItem mDonut;
    private JButton bDonut;
    private JButton bHelp;

    public MainWin(String mainWindowTitle){
        super(mainWindowTitle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu create = new JMenu("Create");
        JMenu help = new JMenu("Help");
        JMenuItem about=new JMenuItem("About");
        JMenuItem java = new JMenuItem("Java");
        JMenuItem donut = new JMenuItem("Donut");
        JMenuItem quit       = new JMenuItem("Quit");

        java.addActionListener(event -> {
            onCreateJavaClick();
        });
        donut.addActionListener(event -> onCreateDonutClick());
        quit.addActionListener(event -> onQuitClick());
        about.addActionListener(event -> onAboutClick());


        file.add(quit);
        create.add(java);
        create.add(donut);

        help.add(about);
        menubar.add(file);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);




        JToolBar toolbar = new JToolBar();

        bJava  = new JButton(new ImageIcon("button1.png"));
        add(bJava, BorderLayout.NORTH);
        bJava.setLocation(50,50);
        bJava.setSize(50,20);
        bJava.addActionListener(event -> onCreateJavaClick());

        bDonut    = new JButton(new ImageIcon("button2.png"));
        add(bDonut, BorderLayout.NORTH);
        bDonut.setLocation(150,50);
        bDonut.setSize(50,20);
        bDonut.addActionListener(event -> onCreateDonutClick());

        bHelp = new JButton(new ImageIcon("button3.png"));
        add(bHelp, BorderLayout.NORTH);
        bHelp.setLocation(250,50);
        bHelp.setSize(50,20);
        bHelp.addActionListener(event -> onAboutClick());

        toolbar.add(Box.createHorizontalStrut(25));


        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        data = new JLabel();
        add(data, BorderLayout.PAGE_END);


        setVisible(true);


    }

    protected void onCreateJavaClick() {
         ArrayList A1=new ArrayList();

        JFrame Fr=new JFrame("Input");
        Fr.setLayout(new FlowLayout());
        Fr.setTitle("Input");



        AtomicBoolean canceled = new AtomicBoolean(true);

        Fr.setSize(500,400);


        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(2, 5, 2, 5);
        constraints.fill= GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;


        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
        constraintsLabel.weightx = 0;

        JLabel jName = new JLabel("Java name?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        Fr.add(jName, constraintsLabel);

        JTextField names = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(names, constraints);

        JLabel price = new JLabel("Price?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 1;
        Fr.add(price, constraintsLabel);

        JTextField priceL = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(priceL, constraints);

        JLabel cost = new JLabel("Cost?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 2;
        Fr.add(price, constraintsLabel);

        JTextField costL = new JTextField(20);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(costL, constraints);

        JLabel dark = new JLabel("Darkness?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 3;
        Fr.add(jName, constraintsLabel);

        Darkness[] darkOp = {Darkness.blond,Darkness.dark,Darkness.light,Darkness.medium,Darkness.extreme};
        JComboBox types = new JComboBox<Darkness>(darkOp);
        types.setEditable(true);
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.weighty = 0;
        Fr.add(types, constraints);

        JLabel shot = new JLabel("Shot?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 4;
        Fr.add(shot, constraintsLabel);

        Shot[] shotOp = {Shot.none,Shot.hazelnut,Shot.chocolate,Shot.peppermint,Shot.vanilla};
        JComboBox types1 = new JComboBox<Shot>(shotOp);
        types.setEditable(true);
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.weighty = 0;
        Fr.add(types1, constraints);




        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> {
            canceled.set(false);
            Fr.setVisible(false);
            String a= names.getText();

            double b=Double.parseDouble(priceL.getText());
            double c=Double.parseDouble(costL.getText());
            Java J1=new Java(a,b,c,darkOp[types.getSelectedIndex()]);
            J1.addShot(shotOp[types1.getSelectedIndex()]);
            A1.add(J1);
            String statement=A1.get(0).toString();
            JLabel L1=new JLabel(statement);
            MainWin.super.add(L1);

        });
        Fr.add(ok);


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> {
            canceled.set(true);
            Fr.setVisible(false);
        });
        Fr.add(cancel);

        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;



        Fr.setVisible(true);

    }






    protected void onCreateDonutClick(){
       ArrayList A1=new ArrayList();

        JFrame Fr=new JFrame("Input");
        Fr.setLayout(new FlowLayout());
        Fr.setTitle("Input");



        AtomicBoolean canceled = new AtomicBoolean(true);

        Fr.setSize(500,400);


        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(2, 5, 2, 5);
        constraints.fill= GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;


        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
        constraintsLabel.weightx = 0;

        JLabel jName = new JLabel("Donut name?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        Fr.add(jName, constraintsLabel);

        JTextField names = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(names, constraints);

        JLabel price = new JLabel("Price?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 1;
        Fr.add(price, constraintsLabel);

        JTextField priceL = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(priceL, constraints);

        JLabel cost = new JLabel("Cost?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 2;
        Fr.add(price, constraintsLabel);

        JTextField costL = new JTextField(20);
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(costL, constraints);

        JLabel dark = new JLabel("Frosting?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 3;
        Fr.add(jName, constraintsLabel);

        Frosting[] darkOp = {Frosting.unfrosted,Frosting.creme,Frosting.Bavarian,Frosting.strawberry};
        JComboBox types = new JComboBox<Frosting>(darkOp);
        types.setEditable(true);
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.weighty = 0;
        Fr.add(types, constraints);

        JLabel shot = new JLabel("Filling?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 4;
        Fr.add(shot, constraintsLabel);

        Filling[] shotOp = {Filling.unfilled,Filling.strawberry,Filling.vanilla,Filling.chocolate};
        JComboBox types1 = new JComboBox<Filling>(shotOp);
        types.setEditable(true);
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.weighty = 0;
        Fr.add(types1, constraints);

        JLabel sprinkles = new JLabel("Sprinkles?");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 5;
        Fr.add(sprinkles, constraintsLabel);

        Boolean[] sprinklesOp = {true,false};
        JComboBox types2 = new JComboBox<Boolean>(sprinklesOp);
        types.setEditable(true);
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.weighty = 0;
        Fr.add(types2, constraints);




        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> {
            canceled.set(false);
            Fr.setVisible(false);
            String a= names.getText();

            double b=Double.parseDouble(priceL.getText());
            double c=Double.parseDouble(costL.getText());
            Donut J1=new Donut(a,b,c,darkOp[types.getSelectedIndex()],sprinklesOp[types2.getSelectedIndex()],shotOp[types1.getSelectedIndex()]);
            A1.add(J1);
            String statement=A1.get(0).toString();
            JLabel L1=new JLabel(statement);
            MainWin.super.add(L1);

        });
        Fr.add(ok);


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(event -> {
            canceled.set(true);
            Fr.setVisible(false);
        });
        Fr.add(cancel);

        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;



        Fr.setVisible(true);


    }

    protected void onAboutClick(){
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Java and Donut Express");



        JLabel title = new JLabel("<html>"
                + "<p><font size=+4>Java and Donut Express</font></p>"
                + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
                + "<p>Version 0.1</p>"
                + "<p>Copyright 2021 by Victor Arowosafe</p>"
                + "<p>Licensed under Gnu GPL 3.0</p>"
                + "<p>Donut Logo by PixelKit  licensed for personal purposes </p>"
                + "<p><font size=-2>https://iconarchive.com/show/tasty-bites-icons-by-pixelkit/donuts-icon.html</font></p>"
                + "<p>Coffee icon, licensed for personal</p><p>and commercial purposes </p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/java_226777</font></p>"
                + "<p>Help icon, licensed for personal</p><p>and commercial purposes </p>"
                + "<p><font size=-2>https://www.flaticon.com/free-icon/java_226777</font></p>"
                + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);

        about.setSize(450,400);
        about.setVisible(true);
    }



    protected void onQuitClick(){
        System.exit(0);
    }

    public static void main(String[] args){
        MainWin win=new MainWin("JADE");
        //win.setVisible(true);
       // win.onCreateJavaClick();

    }



}

