package Gui;


import Store.Filling;
import Store.Donut;
import Store.Shot;
import Store.Frosting;
import Store.Darkness;
import Store.Java;
import Store.Store;
import Store.Person;
import Store.Customer;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainWin extends JFrame{

    private Store store;
    private JLabel data;
    private JMenuItem mJava;
    private JButton bJava;
    private JMenuItem mDonut;
    private JButton bDonut;
    private JButton bHelp;
    private JMenuItem mNew;
    private JButton bNew;
    private JMenuItem mOpen;
    private JButton bOpen;
    private JMenuItem mSaveAs;
    private JButton bSaveAs;
    private JMenuItem mSave;
    private JButton bSave;
    private JMenuItem mCustomer;
    private JButton bCustomer;
    private ArrayList listj=new ArrayList();
    private ArrayList listd=new ArrayList();
    private ArrayList listc=new ArrayList();
    //private JFrame main;
    private File filename;
    private File filename2;
    private int i=0;
    private JPanel statusPanel;
    private JLabel statusLabel;


    public MainWin(String mainWindowTitle){
        super(mainWindowTitle);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu create = new JMenu("Create");
        JMenu help = new JMenu("Help");
        JMenu view =new JMenu("View");
        mCustomer = new JMenuItem("People");
        JMenuItem about=new JMenuItem("About");
        JMenuItem java = new JMenuItem("Java");
        JMenuItem donut = new JMenuItem("Donut");
        mSaveAs = new JMenuItem("Save As");
        mOpen = new JMenuItem("Open");
        mNew = new JMenuItem("New");
        mSave = new JMenuItem("Save");
        mCustomer.addActionListener(event -> onCreateCustomerClick());
        JMenuItem quit       = new JMenuItem("Quit");

        java.addActionListener(event -> {
            onCreateJavaClick();
        });
        donut.addActionListener(event -> onCreateDonutClick());
        quit.addActionListener(event -> onQuitClick());
        about.addActionListener(event -> onAboutClick());
        mSave.addActionListener(event -> onSaveClick());
        mNew.addActionListener(event -> onNewClick());
        mOpen.addActionListener(event -> onOpenClick());
        mSaveAs.addActionListener(event -> onSaveAsClick());


        view.add(mCustomer);
        file.add(mNew);
        file.add(mOpen);
        file.add(mSave);
        file.add(mSaveAs);
        file.add(quit);
        create.add(java);
        create.add(donut);

        help.add(about);
        menubar.add(view);
        menubar.add(file);
        menubar.add(create);
        menubar.add(help);
        setJMenuBar(menubar);




        JToolBar toolbar = new JToolBar();

        bNew  = new JButton(new ImageIcon("New store"));
        bNew.setToolTipText("New Store");
        add(bNew, BorderLayout.NORTH);
        bNew.setLocation(60,50);
        bNew.setSize(50,20);
        bNew.addActionListener(event -> onNewClick());

        bOpen  = new JButton(new ImageIcon("Open"));
        bOpen.setToolTipText("Open");
        add(bOpen, BorderLayout.NORTH);
        bOpen.setLocation(100,50);
        bOpen.setSize(50,20);
        bOpen.addActionListener(event -> onOpenClick());

        bSave  = new JButton(new ImageIcon("Save"));
        bSave.setToolTipText("Save");
        add(bSave, BorderLayout.NORTH);
        bSave.setLocation(140,50);
        bSave.setSize(50,20);
        bSave.addActionListener(event -> onSaveClick());

        bSaveAs  = new JButton(new ImageIcon("Save As"));
        bSaveAs.setToolTipText("Save As");
        add(bSaveAs, BorderLayout.NORTH);
        bSaveAs.setLocation(180,50);
        bSaveAs.setSize(50,20);
        bSaveAs.addActionListener(event -> onSaveAsClick());

        bJava  = new JButton(new ImageIcon("New Java"));
        bJava.setToolTipText("New Java");
        add(bJava, BorderLayout.NORTH);
        bJava.setLocation(220,50);
        bJava.setSize(50,20);
        bJava.addActionListener(event -> onCreateJavaClick());

        bDonut    = new JButton(new ImageIcon("New Donut"));
        bDonut.setToolTipText("New Donut");
        add(bDonut, BorderLayout.NORTH);
        bDonut.setLocation(260,50);
        bDonut.setSize(50,20);
        bDonut.addActionListener(event -> onCreateDonutClick());

        bHelp = new JButton(new ImageIcon("Help"));
        bHelp.setToolTipText("Help");
        add(bHelp, BorderLayout.NORTH);
        bHelp.setLocation(300,50);
        bHelp.setSize(50,20);
        bHelp.addActionListener(event -> onAboutClick());

        bCustomer = new JButton(new ImageIcon("New Customer"));
        bCustomer.setToolTipText("New Customer");
        add(bCustomer, BorderLayout.NORTH);
        bCustomer.setLocation(340,50);
        bCustomer.setSize(50,20);
        bCustomer.addActionListener(event -> onCreateCustomerClick());

        JButton bCustomerList = new JButton(new ImageIcon("List Customers"));
        bCustomerList.setToolTipText("List Customers");
        add(bCustomerList, BorderLayout.NORTH);
        bCustomerList.setLocation(380,50);
        bCustomerList.setSize(50,20);
        bCustomerList.addActionListener(event -> onCustomerListClick());

        statusPanel = new JPanel();
        //statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //add(statusPanel, BorderLayout.SOUTH);
       // statusPanel.setPreferredSize(new Dimension(getWidth(), 16));
       // statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("");
        //statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        getContentPane().add(statusPanel,BorderLayout.PAGE_END);



        toolbar.add(Box.createHorizontalStrut(25));


        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        data = new JLabel();
        add(data, BorderLayout.PAGE_END);


        setVisible(true);


    }

    protected void onNewClick(){
        MainWin win = new MainWin("JADE");
        win.setVisible(true);
    }

    protected void onCustomerListClick(){
        JFrame f2=new JFrame("List of Customers");
        JPanel P1=new JPanel();

        String join="";
        for(int i=0;i<listc.size();i++){
            join=join+listc.get(i).toString()+"\n";

        }
        statusLabel=new JLabel(join+"\n");
        P1.add(statusLabel);
        f2.add(P1);
        f2.setSize(400,300);
        f2.setVisible(true);

    }

    protected void onCreateCustomerClick(){
        ArrayList A1=new ArrayList();

        JFrame Fr=new JFrame("New Customer");
        Fr.setLayout(new FlowLayout());
        Fr.setTitle("New Customer");



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

        JLabel jName = new JLabel("Name");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        Fr.add(jName, constraintsLabel);

        JTextField names = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(names, constraints);

        JLabel price = new JLabel("Phone (Example: 123-45-6789");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 1;
        Fr.add(price, constraintsLabel);

        JTextField priceL = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 1;
        Fr.add(priceL, constraints);






        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> {
            canceled.set(false);
            Fr.setVisible(false);
            String a= names.getText();

            double b=Double.parseDouble(priceL.getText());
            Customer C1=new Customer(names.getText(),priceL.getText());
            listc.add(C1);

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

    protected void onOpenClick() {

    if(i==0){
     final JFileChooser fc = new JFileChooser(filename);
    FileNameExtensionFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
    fc.addChoosableFileFilter(nimFiles);
    fc.setFileFilter(nimFiles);

    int result = fc.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        filename = fc.getSelectedFile();

        try {
            FileInputStream fileIn =new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Java emp = (Java) in.readObject();
            listj.add(emp);
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    i++;
}
    if(i==1){
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileNameExtensionFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
        fc.addChoosableFileFilter(nimFiles);         // Add "Nim file" filter
        fc.setFileFilter(nimFiles);                  // Show Nim files only by default

        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();

            try {
                FileInputStream fileIn =new FileInputStream(filename2);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Donut emp = (Donut) in.readObject();
                listd.add(emp);
                in.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    }

        protected void onSaveClick(){
        try  {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(filename2));
            bw.write(listj.get(0).toString() + '\n');
            bw1.write(listd.get(0).toString() + '\n');
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onSaveAsClick(){
        final JFileChooser fc = new JFileChooser(filename);
        FileNameExtensionFilter nimFiles = new FileNameExtensionFilter("Store files", "store");
        fc.addChoosableFileFilter(nimFiles);
        fc.setFileFilter(nimFiles);

        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();
            if(!filename.getAbsolutePath().endsWith(".store"))
                filename = new File(filename.getAbsolutePath() + ".store");
            filename2 = new File(filename.getAbsolutePath() +"2"+ ".store");
            onSaveClick();
        }

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
            listj.add(J1);
            String statement=listj.get(0).toString();
            JLabel L1=new JLabel(statement+"\n");
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
            listd.add(J1);
            String statement=listd.get(0).toString();
            JLabel L1=new JLabel(statement+"\n");
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

