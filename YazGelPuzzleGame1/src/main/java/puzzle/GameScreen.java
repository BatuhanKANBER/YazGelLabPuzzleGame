package puzzle;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameScreen extends JFrame {


    // DEĞİŞKENLER
    List<JButton> listForButtons = new LinkedList<>();
    String username;
    String image;
    int count = 0;
    Integer score = 0;
    JButton firstButton;
    JButton secondButton;

    //İSİM KONTROL FONKSİYONU
    public boolean nameIsUse(String name) throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader("bestscore.txt"));
        String line = br.readLine();

        while (line != null && line != " ") {
            String spl[] = line.split(":");
            if (name.equalsIgnoreCase(spl[0])) {
                JOptionPane.showMessageDialog(null, "BU OYUNCU ADI KULLANILIYOR!", "", 2);
                return true;
            }
            line = br.readLine();
        }
        return false;
    }
    // RESIM EKLEME ANA RESIM
    public Image imageForGame(int i) {
        try {
            BufferedImage bufimage1 = ImageIO.read(new File("images/images" + Integer.toString(i) + ".jpg"));
            Image image1 = bufimage1.getScaledInstance(listForButtons.get(i - 1).getWidth(), listForButtons.get(i - 1).getHeight(), Image.SCALE_SMOOTH);
            //  ImageIcon icon1 = new ImageIcon(image1);

            return image1;
        } catch (IOException ex) {
            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    // RESMI PARCALAYAN FONKSIYON
    public void divideFunction(String path) throws IOException {

        image = path;
        FileInputStream fs = new FileInputStream(path);

        BufferedImage bfimage = ImageIO.read(fs);

        int row = 4;
        int column = 4;
        int imageNumber = row * column;

        int newImageWidth = bfimage.getWidth() / column;
        int newImageHeight = bfimage.getHeight() / row;
        int imageNo = 0;
        BufferedImage bfimage1[] = new BufferedImage[imageNumber];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                bfimage1[imageNo] = new BufferedImage(newImageWidth, newImageHeight, 1);
                Graphics2D g = bfimage1[imageNo].createGraphics();
                imageNo++;
                g.drawImage(bfimage, 0, 0, newImageWidth, newImageHeight, newImageWidth
                                * y, newImageHeight * x, newImageWidth * y + newImageWidth,
                        newImageHeight * x + newImageHeight, null);
                g.dispose();
            }
        }
        System.out.println("Resim parcalandi");


        for (int i = 0; i < bfimage1.length; i++) {
            int j = i + 1;
            ImageIO.write(bfimage1[i], "jpg", new File("images/images" + j + ".jpg"));

        }
    }

    // RESMI 4X4 SEKLINDE SIRALAYAN FONKSIYON
    public void buttonsTable() {

        listForButtons.add(button1);
        listForButtons.add(button2);
        listForButtons.add(button3);
        listForButtons.add(button4);
        listForButtons.add(button5);
        listForButtons.add(button6);
        listForButtons.add(button7);
        listForButtons.add(button8);
        listForButtons.add(button9);
        listForButtons.add(button10);
        listForButtons.add(button11);
        listForButtons.add(button12);
        listForButtons.add(button13);
        listForButtons.add(button14);
        listForButtons.add(button15);
        listForButtons.add(button16);

        Container con = getContentPane();
        con.setLayout(null);
        int x = -110;
        int y = 90;

        for (int i = 0; i < 16; i++) {
            x += 160;

            switch (i) {
                case 4:
                    x = 50;
                    y += 160;
                    break;
                case 8:
                    x = 50;
                    y += 160;
                    break;
                case 12:
                    x = 50;
                    y += 160;
                    break;
                default:
                    break;
            }

            listForButtons.get(i).setBounds(x, y, 160, 160);
            listForButtons.get(i).setBorder(new LineBorder(Color.BLACK));
            con.add(listForButtons.get(i));
        }

    }


    //GİRİŞ EKRANI
    public GameScreen() throws FileNotFoundException, IOException {

        mainComponent();
        mixButton.setEnabled(false);

        boolean bool = true;
        while (bool) {
            username = JOptionPane.showInputDialog(null, "OYUNCU ADI:", "OYUNCU GİRİŞ", 3);
            if (username == null) {
                System.exit(0);
            }
            if (username.isEmpty() || username.equals(" ")) {
                JOptionPane.showMessageDialog(null, "ALAN BOŞ BIRAKILAMAZ!", "ERROR", 2);
            } else {
                if (nameIsUse(username)) {

                    bool = true;

                }
                else {
                    bool = false;
                    playerNameDynamicLabel.setText(username.toUpperCase());
                }
            }
        }



//        buttonsTable();
//        bestScoreFileReader();
//        buttonDisabled();

    }

    @SuppressWarnings("unchecked")
    private void mainComponent() {
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("button3");
        button4 = new JButton("button4");
        button5 = new JButton("button5");
        button6 = new JButton("button6");
        button7 = new JButton("button7");
        button8 = new JButton("button8");
        button9 = new JButton("button9");
        button10 = new JButton("button10");
        button11 = new JButton("button11");
        button12 = new JButton("button12");
        button13 = new JButton("button13");
        button14 = new JButton("button14");
        button15 = new JButton("button15");
        button16 = new JButton("button16");
        imageChooseButton = new JButton();
        mixButton = new JButton();
        bestPlayerNameStaticLabel = new JLabel();
        bestPlayerNameDynamicLabel = new JLabel();
        scoreStaticLabel = new JLabel();
        scoreDynamicLabel = new JLabel();
        bestScoreStaticLabel = new JLabel();
        bestScoreDynamicLabel = new JLabel();
        playerNameStaticLabel = new JLabel();
        playerNameDynamicLabel = new JLabel();
        imageLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new Point(100, 100));



        button1.setBackground(new Color(255,255,255));
        button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setName("1"); // NOI18N
        button1.setPreferredSize(new java.awt.Dimension(160, 160));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button2.setBackground(new Color(255,255,255));
        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button2.setName("2"); // NOI18N
        button2.setPreferredSize(new java.awt.Dimension(160, 160));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button3.setBackground(new Color(255,255,255));
        button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button3.setName("3"); // NOI18N
        button3.setPreferredSize(new java.awt.Dimension(160, 160));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button4.setBackground(new Color(255,255,255));
        button4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button4.setName("4"); // NOI18N
        button4.setPreferredSize(new java.awt.Dimension(160, 160));
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button5.setBackground(new Color(255,255,255));
        button5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button5.setName("5"); // NOI18N
        button5.setPreferredSize(new java.awt.Dimension(160, 160));
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button6.setBackground(new Color(255,255,255));
        button6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button6.setName("6"); // NOI18N
        button6.setPreferredSize(new java.awt.Dimension(160, 160));
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button7.setBackground(new Color(255,255,255));
        button7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button7.setName("7"); // NOI18N
        button7.setPreferredSize(new java.awt.Dimension(160, 160));
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button8.setBackground(new Color(255,255,255));
        button8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button8.setName("8"); // NOI18N
        button8.setPreferredSize(new java.awt.Dimension(160, 160));
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button9.setBackground(new Color(255,255,255));
        button9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button9.setName("9"); // NOI18N
        button9.setPreferredSize(new java.awt.Dimension(160, 160));
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button10.setBackground(new Color(255,255,255));
        button10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button10.setName("10"); // NOI18N
        button10.setPreferredSize(new java.awt.Dimension(160, 160));
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button11.setBackground(new Color(255,255,255));
        button11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button11.setName("11"); // NOI18N
        button11.setPreferredSize(new java.awt.Dimension(160, 160));
        button11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });


        button12.setBackground(new Color(255,255,255));
        button12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button12.setName("12"); // NOI18N
        button12.setPreferredSize(new java.awt.Dimension(160, 160));
        button12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button13.setBackground(new Color(255,255,255));
        button13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button13.setName("13"); // NOI18N
        button13.setPreferredSize(new java.awt.Dimension(160, 160));
        button13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button14.setBackground(new Color(255,255,255));
        button14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button14.setName("14"); // NOI18N
        button14.setPreferredSize(new java.awt.Dimension(160, 160));
        button14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button15.setBackground(new Color(255,255,255));
        button15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        button15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button15.setName("15"); // NOI18N
        button15.setPreferredSize(new java.awt.Dimension(160, 160));
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        button16.setBackground(new Color(255,255,255));
        button16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 56, 44)));
        button16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button16.setName("16"); // NOI18N
        button16.setPreferredSize(new java.awt.Dimension(160, 160));
        button16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    buttonClick(e);
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        imageChooseButton.setBackground(new java.awt.Color(255, 255, 255));
        imageChooseButton.setText("RESİM SEÇ");
        imageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(fileChooser);
                File f = fileChooser.getSelectedFile();
                String path = f.getAbsolutePath();
                try {
                    BufferedImage img = ImageIO.read(new File(path));
                    Image img1 = img.getScaledInstance(640, 640, Image.SCALE_SMOOTH);
                    ImageIcon ico = new ImageIcon(img1);
                    imageLabel.setIcon(ico);
                   // divideFunction(path);

                } catch (IOException message) {
                    message.getMessage();
                }
                mixButton.setEnabled(true);
            }
        });

        mixButton.setBackground(new Color(255, 255, 255));
        Icon icon=new ImageIcon("images/mix.png");
        mixButton.setIcon(icon);
        mixButton.setSize(12,12);
        mixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    mixFunction();
//                } catch (IOException message) {
//                    message.getMessage();
//                }
            }
        });

        playerNameStaticLabel.setFont(new Font("Dialog", 1, 12));
        playerNameStaticLabel.setText("OYUNCU:");

        playerNameDynamicLabel.setFont(new Font("Dialog", 1, 12));
        playerNameDynamicLabel.setForeground(new Color(0, 0, 0));

        scoreStaticLabel.setFont(new Font("Dialog", 1, 12));
        scoreStaticLabel.setText("SKOR:");

        scoreDynamicLabel.setFont(new Font("Dialog", 1, 12));
        scoreDynamicLabel.setForeground(new Color(0, 0, 0));

        bestScoreStaticLabel.setFont(new Font("Dialog", 1, 12));
        bestScoreStaticLabel.setText("EN YÜKSEK SKOR:");

        bestScoreDynamicLabel.setFont(new Font("Dialog", 1, 12));
        bestScoreDynamicLabel.setForeground(new Color(187, 182, 0));

        bestPlayerNameStaticLabel.setFont(new Font("Dialog", 1, 12));
        bestPlayerNameStaticLabel.setText("EN İYİ OYUNUCU:");

        bestPlayerNameDynamicLabel.setFont(new Font("Dialog", 1, 12));
        bestPlayerNameDynamicLabel.setForeground(new Color(187, 182, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(imageChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(mixButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(bestScoreStaticLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bestPlayerNameDynamicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(bestPlayerNameStaticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bestScoreDynamicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scoreStaticLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(playerNameStaticLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scoreDynamicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                        .addComponent(playerNameDynamicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(imageLabel, 900, 1000, Short.MAX_VALUE))
                                .addContainerGap(75, Short.MAX_VALUE))

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(bestScoreStaticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(imageChooseButton))
                                                        .addComponent(bestPlayerNameDynamicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scoreDynamicLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(scoreStaticLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bestPlayerNameStaticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bestScoreDynamicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(mixButton))
                                        .addComponent(playerNameStaticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playerNameDynamicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(button8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(button13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                                .addComponent(imageLabel, 818, 818, Short.MAX_VALUE))

        );

        pack();
    }

    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton button10;
    private javax.swing.JButton button11;
    private javax.swing.JButton button12;
    private javax.swing.JButton button13;
    private javax.swing.JButton button14;
    private javax.swing.JButton button15;
    private javax.swing.JButton button16;
    private javax.swing.JButton imageChooseButton;
    private javax.swing.JButton mixButton;
    private javax.swing.JLabel bestPlayerNameStaticLabel;
    private javax.swing.JLabel bestPlayerNameDynamicLabel;
    private javax.swing.JLabel scoreStaticLabel;
    private javax.swing.JLabel scoreDynamicLabel;
    private javax.swing.JLabel bestScoreStaticLabel;
    private javax.swing.JLabel bestScoreDynamicLabel;
    private javax.swing.JLabel playerNameStaticLabel;
    private javax.swing.JLabel playerNameDynamicLabel;
    private javax.swing.JLabel imageLabel;

}
