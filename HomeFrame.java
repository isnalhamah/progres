/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.sql.Connection;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Game.Main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class HomeFrame extends javax.swing.JFrame {
    public static int panelCount = 1;
    int height = 321;
    ArrayList<String> lukisan = Connect.lukisan;
    ArrayList<String> patung = Connect.patung;
    CardLayout cardLayout;
    ImageIcon selectedImageIcon;
    String image;
    
    public HomeFrame() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(51,51,51));
        setVisible(true);
        
        welcome.setText("Welcome, " + Connect.name);
        
        artPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel.setPreferredSize(new Dimension(570, height));
        artPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 30,20));
        artPanel1.setPreferredSize(new Dimension(570, height));
        
        Main.add(HomePanel, "Home");
        Main.add(Lukisan, "Lukisan");
        Main.add(Patung, "Patung");
        Main.add(Quiz, "Quiz");
        Main.add(Admin, "Admin");
        
        cardLayout = (CardLayout)(Main.getLayout());
        getName("Lukisan", lukisan, artPanel);
        getName("Patung", patung, artPanel1);
        pack();
        
        
//        HomePanel.setLayout(new BoxLayout(HomePanel, BoxLayout.Y_AXIS));
        
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        artPanel.setBackground(Color.DARK_GRAY);
        artPanel1.setBackground(Color.DARK_GRAY);
                
        jPanel1.setBackground(Color.decode("#002147"));
        
        mouseEnter(Art);
        mouseEnter(Game);
        mouseEnter(admin);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioLukisan);
        group.add(radioPatung);
        
        for(int i = 0; i < lukisan.size(); i++){
            list.addItem(lukisan.get(i));
        }

        for(int i = 0; i < patung.size(); i++){
            list.addItem(patung.get(i));
        }
        
        deskripsi.setLineWrap(true);
        deskripsi.setWrapStyleWord(true);
       
    }
    
    
    public void getName(String jenis, ArrayList<String> string, JPanel panel){
        if(panelCount == 1){
            Connect.getAllNames(jenis);
            for(int i = 0; i < string.size(); i++){
                addPanel(string.get(i), jenis, panel);
            }
        }
        panelCount = 1;
    }



    

    
//    public void setImage(JLabel label, String path){
//        ImageIcon icon = new ImageIcon(path);
//        Image ori = icon.getImage();
//        Image scaled = ori.getScaledInstance(HomePanel.getWidth(), HomePanel.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon imgScaled = new ImageIcon(scaled);
//        label.setPreferredSize(HomePanel.getPreferredSize());
//        label.setIcon(imgScaled);
//        HomePanel.add(label);
//        HomePanel.add(Box.createVerticalStrut(20));
//        updateHomePanelSize();
//    }
    
//    private void updateHomePanelSize() {
//        int totalHeight = 0;
//        for (Component component : HomePanel.getComponents()) {
//            totalHeight += component.getPreferredSize().height;
//        }
//        HomePanel.setPreferredSize(new Dimension(1025, totalHeight-250));
//        HomePanel.revalidate();
//    }
//    

    
    public void delete(String Delete){
        Connect.delete(Delete); 
    }
    
    public void addPanel(String nama, String jenis, JPanel panel){
        art art = new art();
        art.setImage(nama);
        
        if(jenis.equals("Lukisan")){
            panelCount++;
            panel.add(art);
            setHeight(panel);
            panel.revalidate();
            panel.repaint();
        }else if(jenis.equals("Patung")){
            panelCount++;
            panel.add(art);
            setHeight(panel);
            panel.revalidate();
            panel.repaint();
        }
    }
    
    public void setHeight(JPanel panel){
        if (panelCount % 3 == 0) {
            height += 270 + 15;
            panel.setPreferredSize(new Dimension(596, height));
        }
    }
    
    public void mouseEnter(JButton button){
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                button.setFont(button.getFont().deriveFont(Font.BOLD));
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setFont(button.getFont().deriveFont(Font.PLAIN));
            }
        });
    }
    
    private ImageIcon selectImage() {
        JFileChooser fileChooser = new JFileChooser(new File("D:\\Dokumen\\Semester 5\\PBO\\Project\\src\\Karya"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return new ImageIcon(selectedFile.getAbsolutePath());
        } else {
            return null;
        }
    }

    public JButton getMyButton(){
        return admin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        HomePanel = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        admin = new javax.swing.JButton();
        Art = new javax.swing.JButton();
        Game = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        Game1 = new javax.swing.JButton();
        Art1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Lukisan = new keeptoo.KGradientPanel();
        scrollPanel = new javax.swing.JScrollPane();
        artPanel = new javax.swing.JPanel();
        Filter = new javax.swing.JButton();
        filterList = new javax.swing.JComboBox<>();
        backLukisan = new javax.swing.JLabel();
        Patung = new keeptoo.KGradientPanel();
        Filter1 = new javax.swing.JButton();
        filterList1 = new javax.swing.JComboBox<>();
        scrollPanel1 = new javax.swing.JScrollPane();
        artPanel1 = new javax.swing.JPanel();
        backPatung = new javax.swing.JLabel();
        Quiz = new keeptoo.KGradientPanel();
        startButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        backQuiz = new javax.swing.JLabel();
        Admin = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nomor = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        artist = new javax.swing.JTextField();
        tahun = new javax.swing.JTextField();
        chooseImage = new javax.swing.JButton();
        radioLukisan = new javax.swing.JRadioButton();
        radioPatung = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        list = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setResizable(false);

        Main.setBackground(new java.awt.Color(51, 51, 51));
        Main.setForeground(new java.awt.Color(102, 102, 102));
        Main.setLayout(new java.awt.CardLayout());

        HomePanel.setkEndColor(new java.awt.Color(51, 51, 51));
        HomePanel.setkStartColor(new java.awt.Color(51, 102, 255));
        HomePanel.setMinimumSize(new java.awt.Dimension(1025, 486));
        HomePanel.setOpaque(false);
        HomePanel.setPreferredSize(new java.awt.Dimension(1025, 486));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        welcome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        admin.setBackground(new java.awt.Color(153, 153, 153));
        admin.setForeground(new java.awt.Color(0, 0, 0));
        admin.setText("Admin");
        admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        Art.setBackground(new java.awt.Color(153, 153, 153));
        Art.setForeground(new java.awt.Color(0, 0, 0));
        Art.setText("Art");
        Art.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtActionPerformed(evt);
            }
        });

        Game.setBackground(new java.awt.Color(153, 153, 153));
        Game.setForeground(new java.awt.Color(0, 0, 0));
        Game.setText("Quiz");
        Game.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Game.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameActionPerformed(evt);
            }
        });

        Quit.setBackground(new java.awt.Color(153, 153, 153));
        Quit.setForeground(new java.awt.Color(0, 0, 0));
        Quit.setText("Quit");
        Quit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        Game1.setBackground(new java.awt.Color(153, 153, 153));
        Game1.setForeground(new java.awt.Color(0, 0, 0));
        Game1.setText("Game");
        Game1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Game1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game1ActionPerformed(evt);
            }
        });

        Art1.setBackground(new java.awt.Color(153, 153, 153));
        Art1.setForeground(new java.awt.Color(0, 0, 0));
        Art1.setText("Leaderboard");
        Art1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Art1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Art1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ART GALLERY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Game, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Game1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Art1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Art1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Game, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Game1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        HomePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 320, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/mennyfox55.gif"))); // NOI18N
        HomePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1030, -1));

        Main.add(HomePanel, "card7");

        Lukisan.setkEndColor(new java.awt.Color(0, 51, 255));
        Lukisan.setkStartColor(new java.awt.Color(102, 204, 255));

        scrollPanel.setForeground(new java.awt.Color(102, 102, 102));
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        artPanel.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout artPanelLayout = new javax.swing.GroupLayout(artPanel);
        artPanel.setLayout(artPanelLayout);
        artPanelLayout.setHorizontalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        artPanelLayout.setVerticalGroup(
            artPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(artPanel);

        Filter.setBackground(new java.awt.Color(255, 255, 255));
        Filter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Filter.setForeground(new java.awt.Color(0, 0, 0));
        Filter.setText("Filter");
        Filter.setBorder(null);
        Filter.setContentAreaFilled(false);
        Filter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        filterList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lukisan", "Patung", "Sastra", "Musik" }));
        filterList.setFocusable(false);
        filterList.setLightWeightPopupEnabled(false);
        filterList.setRequestFocusEnabled(false);
        filterList.setVerifyInputWhenFocusTarget(false);
        filterList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterListActionPerformed(evt);
            }
        });

        backLukisan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backLukisan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLukisan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLukisanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LukisanLayout = new javax.swing.GroupLayout(Lukisan);
        Lukisan.setLayout(LukisanLayout);
        LukisanLayout.setHorizontalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(LukisanLayout.createSequentialGroup()
                        .addComponent(backLukisan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter)
                        .addGap(18, 18, 18)
                        .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        LukisanLayout.setVerticalGroup(
            LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LukisanLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LukisanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Filter))
                    .addComponent(backLukisan))
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Main.add(Lukisan, "card2");

        Patung.setkEndColor(new java.awt.Color(0, 51, 255));
        Patung.setkStartColor(new java.awt.Color(51, 204, 255));

        Filter1.setBackground(new java.awt.Color(255, 255, 255));
        Filter1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Filter1.setForeground(new java.awt.Color(0, 0, 0));
        Filter1.setText("Filter");
        Filter1.setBorder(null);
        Filter1.setContentAreaFilled(false);
        Filter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Filter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter1ActionPerformed(evt);
            }
        });

        filterList1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lukisan", "Patung", "Sastra", "Musik" }));
        filterList1.setFocusable(false);
        filterList1.setLightWeightPopupEnabled(false);
        filterList1.setRequestFocusEnabled(false);
        filterList1.setVerifyInputWhenFocusTarget(false);
        filterList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterList1ActionPerformed(evt);
            }
        });

        scrollPanel1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout artPanel1Layout = new javax.swing.GroupLayout(artPanel1);
        artPanel1.setLayout(artPanel1Layout);
        artPanel1Layout.setHorizontalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );
        artPanel1Layout.setVerticalGroup(
            artPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );

        scrollPanel1.setViewportView(artPanel1);

        backPatung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backPatung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backPatung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backPatungMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PatungLayout = new javax.swing.GroupLayout(Patung);
        Patung.setLayout(PatungLayout);
        PatungLayout.setHorizontalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatungLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PatungLayout.createSequentialGroup()
                        .addComponent(backPatung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filter1)
                        .addGap(18, 18, 18)
                        .addComponent(filterList1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PatungLayout.setVerticalGroup(
            PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatungLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Filter1))
                    .addComponent(backPatung))
                .addGap(18, 18, 18)
                .addComponent(scrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        Main.add(Patung, "card2");

        startButton.setText("Start");
        startButton.setBorderPainted(false);
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Leaderboard");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("1. Score pada quiz ini dapat dilihat pada Leaderboard");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("2. Score akan bertambah sejumlah 10 untuk setiap jawwaban yang benar");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("3. Maksimal nilai score yang diperoleh yaitu 100 dengan jumlah pengerjaan soal yang tak terbatas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("4. Hanya terdapat 3 jenis pertanyaan dengan karya yang berbeda-beda");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("5. Waktu pengerjaan hanya 1 menit");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("6. Jawaban dapat diketikan pada textfield yang tersedia");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("7. Tekan tombol ENTER untuk input jawaban");

        backQuiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        backQuiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backQuizMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout QuizLayout = new javax.swing.GroupLayout(Quiz);
        Quiz.setLayout(QuizLayout);
        QuizLayout.setHorizontalGroup(
            QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuizLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizLayout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(436, 436, 436))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizLayout.createSequentialGroup()
                        .addGroup(QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizLayout.createSequentialGroup()
                                    .addGroup(QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addGap(206, 206, 206))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QuizLayout.createSequentialGroup()
                                .addComponent(backQuiz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 730, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))))
        );
        QuizLayout.setVerticalGroup(
            QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuizLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(QuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuizLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(QuizLayout.createSequentialGroup()
                        .addComponent(backQuiz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        Main.add(Quiz, "card7");

        Admin.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Admin.setkEndColor(new java.awt.Color(0, 204, 204));
        Admin.setkStartColor(new java.awt.Color(153, 153, 255));
        Admin.setPreferredSize(new java.awt.Dimension(1027, 486));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Masukan Karya");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nomor Karya :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nama Artist : ");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tahun Karya : ");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Gambar Karya : ");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nama Karya : ");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Deskripsi Karya :");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Jenis Karya : ");

        chooseImage.setText("Image");
        chooseImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageActionPerformed(evt);
            }
        });

        radioLukisan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        radioLukisan.setForeground(new java.awt.Color(0, 0, 0));
        radioLukisan.setText("Lukisan");
        radioLukisan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        radioPatung.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        radioPatung.setForeground(new java.awt.Color(0, 0, 0));
        radioPatung.setText("Patung");
        radioPatung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        deskripsi.setColumns(20);
        deskripsi.setRows(5);
        jScrollPane2.setViewportView(deskripsi);

        submit.setText("SUBMIT");
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/left-arrow.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Hapus Karya");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Nama Karya : ");

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin);
        Admin.setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel9)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(AdminLayout.createSequentialGroup()
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdminLayout.createSequentialGroup()
                                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19))
                                .addGap(46, 46, 46)
                                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AdminLayout.createSequentialGroup()
                                        .addComponent(radioLukisan)
                                        .addGap(26, 26, 26)
                                        .addComponent(radioPatung))
                                    .addComponent(chooseImage)
                                    .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nomor)
                                        .addComponent(nama)
                                        .addComponent(artist)
                                        .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel18)
                            .addGroup(AdminLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(60, 60, 60)
                                .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submit)
                            .addGroup(AdminLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62))
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(nomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(artist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(chooseImage))
                        .addGap(18, 18, 18)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(radioLukisan)
                            .addComponent(radioPatung))))
                .addGap(32, 32, 32)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jButton2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Main.add(Admin, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
       Quiz quiz =  new Quiz();
       quiz.setVisible(true);
       dispose();
    }//GEN-LAST:event_startButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = Connect.getConnection();
        Leaderboard leaderBoard = new Leaderboard();
        while (Leaderboard.listModel.isEmpty()) {
            String sqlLeader = "SELECT * FROM account ORDER BY highscore DESC";
            try (PreparedStatement stmt = con.prepareStatement(sqlLeader)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    int i = 1;
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String highscore = rs.getString("highscore");
                        Leaderboard.listModel.addElement(i + ". " + username + ": " + highscore);
                        i++;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        leaderBoard.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String jenis;
        if(radioLukisan.isSelected()){
            jenis = "Lukisan";
        }else{
            jenis = "Patung";
        }
        Input input = new Input(nomor, nama, artist, tahun, image, jenis, deskripsi);
        input.input();
        nomor.setText("");
        nama.setText("");
        artist.setText("");
        tahun.setText("");
        deskripsi.setText("");
        radioLukisan.setSelected(false); 
        image = "";
    }//GEN-LAST:event_submitActionPerformed

    private void chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageActionPerformed
        selectedImageIcon = selectImage();
        chooseImage.setText(nama.getText());
        image = selectedImageIcon.getDescription();
    }//GEN-LAST:event_chooseImageActionPerformed

    private void filterList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterList1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterList1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nama = list.getName();
        delete(nama);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_jLabel19MouseClicked

    private void Filter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter1ActionPerformed
        int index = filterList1.getSelectedIndex();

        switch(index){
            case 0 :
            cardLayout.show(Main, "Lukisan");
            break;
            case 1 :
            cardLayout.show(Main, "Patung");
        }
    }//GEN-LAST:event_Filter1ActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        int index = filterList.getSelectedIndex();

        switch(index){
            case 0 :
            cardLayout.show(Main, "Lukisan");
            break;
            case 1 :
            cardLayout.show(Main, "Patung");
        }
    }//GEN-LAST:event_FilterActionPerformed

    private void filterListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterListActionPerformed

    private void backPatungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPatungMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backPatungMouseClicked

    private void backLukisanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLukisanMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backLukisanMouseClicked

    private void backQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backQuizMouseClicked
        cardLayout.show(Main, "Home");
    }//GEN-LAST:event_backQuizMouseClicked

    private void Game1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Game1ActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_Game1ActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        this.dispose();
        WelcomeFrame Login = new WelcomeFrame();
        Login.setVisible(true);
        Login.setLocationRelativeTo(null);
    }//GEN-LAST:event_QuitActionPerformed

    private void GameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameActionPerformed
        cardLayout.show(Main, "Quiz");
    }//GEN-LAST:event_GameActionPerformed

    private void ArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtActionPerformed
        cardLayout.show(Main, "Lukisan");
    }//GEN-LAST:event_ArtActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        cardLayout.show(Main, "Admin");
    }//GEN-LAST:event_adminActionPerformed

    private void Art1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Art1ActionPerformed
        Connection con = Connect.getConnection();
        Leaderboard leaderBoard = new Leaderboard();
        while (Leaderboard.listModel.isEmpty()) {
            String sqlLeader = "SELECT * FROM account ORDER BY highscore DESC";
            try (PreparedStatement stmt = con.prepareStatement(sqlLeader)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    int i = 1;
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String highscore = rs.getString("highscore");
                        String score = rs.getString("score");
                        Leaderboard.listModel.addElement(i + ". " + username + " => " + "Quiz = " + highscore + " & Game = " + score);
                        i++;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        leaderBoard.setVisible(true);
    }//GEN-LAST:event_Art1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel Admin;
    private javax.swing.JButton Art;
    private javax.swing.JButton Art1;
    private javax.swing.JButton Filter;
    private javax.swing.JButton Filter1;
    private javax.swing.JButton Game;
    private javax.swing.JButton Game1;
    private keeptoo.KGradientPanel HomePanel;
    private keeptoo.KGradientPanel Lukisan;
    private javax.swing.JPanel Main;
    private keeptoo.KGradientPanel Patung;
    private javax.swing.JButton Quit;
    private keeptoo.KGradientPanel Quiz;
    private javax.swing.JButton admin;
    private javax.swing.JPanel artPanel;
    private javax.swing.JPanel artPanel1;
    private javax.swing.JTextField artist;
    private javax.swing.JLabel backLukisan;
    private javax.swing.JLabel backPatung;
    private javax.swing.JLabel backQuiz;
    private javax.swing.JButton chooseImage;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JComboBox<String> filterList;
    private javax.swing.JComboBox<String> filterList1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> list;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nomor;
    private javax.swing.JRadioButton radioLukisan;
    private javax.swing.JRadioButton radioPatung;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JScrollPane scrollPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tahun;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
