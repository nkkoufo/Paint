
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NAK5297
 */
public class MyNewJFrame extends javax.swing.JFrame {

    //variables

    private Frame frame;
    private Color c,c1,c2;
    private BasicStroke b;
    private GradientPaint gp;
    private TexturePaint tp;
    private int oldx, oldy;
    private boolean filled;
    private float transVal;
    private Image background, forground, clear;
    private Vector<BaseShape> v;
    private BaseShape bs;

    /**
     * Creates new form MyNewJFrame
     */
    public void paint(Graphics g) {
        super.paint(g);
        this.showEx();
        this.jPanel1.getGraphics().drawImage(this.background, 0, 0, null);
    }

    static void shape(MyNewJFrame my, BaseShape base) {
        my.bs = base;
    }

    private void closeProg() {
        //this is the method that closes the program
        System.exit(0);
    }

    public void showEx() {
        //shows example in jpanel3
        Graphics g = this.jPanel3.getGraphics();
        this.c = this.getColor();
        this.b = this.getB();
        this.transVal = this.transp();
        AlphaComposite ac = AlphaComposite.getInstance(3, this.transVal);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(this.b);
        g2d.setColor(this.c);
        g2d.setComposite(ac);
        //draws based on toggle
        if (this.jToggleButton1.isSelected()) {
            g2d.setPaint(gp);

        }
        g2d.drawLine(0, 0, this.jPanel3.getWidth(), this.jPanel3.getHeight());
    }

    public void open() {
        //this instiates the file chooser
        JFileChooser choose = new JFileChooser(".");
        FileF f = new FileF();
        choose.setFileFilter(f);

        if (choose.showOpenDialog(null) == 0) {
            try {
                //tries to set the file to the background image
                File nf = choose.getSelectedFile();
                this.background = ImageIO.read(nf);
                this.repaint();
            } catch (Exception ex) {
                //throw excption
                System.out.println("There was an Error Loading the file");
                ex.printStackTrace();
            }
        }
    }

    public void save() {
        //instiates filechooser
        JFileChooser choose = new JFileChooser(".");
        FileF f = new FileF();
        choose.setFileFilter(f);
        if (choose.showOpenDialog(null) == 0) {
            try {
                //writes image to the slected file
                File nf = choose.getSelectedFile();
                ImageIO.write((RenderedImage) ((Object) this.background), "png", nf);
            } catch (Exception ex) {
                //throw exception
                System.out.println("There was an Error saving the file");
                ex.printStackTrace();

            }
        }
    }

    public void print() {
        //insiates printer job
        PrinterJob print = PrinterJob.getPrinterJob();
        PageFormat page = print.pageDialog(new PageFormat());
        if (print.printDialog()) {
            Book b = new Book();
            //sends background to printer class
            Printer p = new Printer(this.background);
            b.append(p, page);
            print.setPageable(b);
            try {
                //tries to print
                print.print();
            } catch (PrinterException pe) {
                pe.printStackTrace();
            }

        }
    }

    public float transp() {
        //gets trasnparent value
        return 1.0f - (float) this.jSlider1.getValue() / 100.0f;
    }

    public Color getColor() {
        //gets color from the sliders
        return new Color(this.jSlider2.getValue(), this.jSlider3.getValue(), this.jSlider4.getValue());
    }

    public BasicStroke getB() {
        //determins if line is dashed and how thick
        int lineWidth = this.jSlider5.getValue();

        float[] fa = new float[]{10.0f, 10.0f, 10.0f};
        if (this.jCheckBox1.isSelected()) {
            return new BasicStroke(lineWidth, 0, 2, 10.0f, fa, 10.0f);
        }
        return new BasicStroke(lineWidth);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton1 = new SaveButton();
        try {
            closeButton1 = new CloseButton();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        jToolBar1 = new javax.swing.JToolBar();
        try {
            openButton2 = new OpenButton();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        saveButton2 = new SaveButton();
        clearButton1 = new ClearButton();
        printButton1 = new PrintButton();
        try {
            closeButton2 = new CloseButton();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }
        jToolBar2 = new javax.swing.JToolBar();
        ovalButton1 = new OvalButton();
        rectangleButton1 = new RectangleButton();
        lineButton1 = new LineButton();
        freeButton1 = new FreeButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox2 = new javax.swing.JCheckBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jSlider4 = new javax.swing.JSlider();
        jSlider5 = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        openButton2.setFocusable(false);
        openButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton2.setMaximumSize(new java.awt.Dimension(25, 25));
        openButton2.setMinimumSize(new java.awt.Dimension(25, 25));
        openButton2.setPreferredSize(new java.awt.Dimension(25, 25));
        openButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(openButton2);

        saveButton2.setFocusable(false);
        saveButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton2.setMaximumSize(new java.awt.Dimension(25, 25));
        saveButton2.setMinimumSize(new java.awt.Dimension(25, 25));
        saveButton2.setPreferredSize(new java.awt.Dimension(25, 25));
        saveButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton2);

        clearButton1.setFocusable(false);
        clearButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearButton1.setMaximumSize(new java.awt.Dimension(25, 25));
        clearButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        clearButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        clearButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(clearButton1);

        printButton1.setFocusable(false);
        printButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printButton1.setMaximumSize(new java.awt.Dimension(25, 25));
        printButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        printButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        printButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        printButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(printButton1);

        closeButton2.setFocusable(false);
        closeButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeButton2.setMaximumSize(new java.awt.Dimension(25, 25));
        closeButton2.setMinimumSize(new java.awt.Dimension(25, 25));
        closeButton2.setPreferredSize(new java.awt.Dimension(25, 25));
        closeButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        closeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(closeButton2);

        jToolBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setRollover(true);

        ovalButton1.setFocusable(false);
        ovalButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ovalButton1.setMaximumSize(new java.awt.Dimension(50, 25));
        ovalButton1.setMinimumSize(new java.awt.Dimension(50, 25));
        ovalButton1.setPreferredSize(new java.awt.Dimension(50, 25));
        ovalButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ovalButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(ovalButton1);

        rectangleButton1.setFocusable(false);
        rectangleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectangleButton1.setMaximumSize(new java.awt.Dimension(50, 25));
        rectangleButton1.setMinimumSize(new java.awt.Dimension(50, 25));
        rectangleButton1.setPreferredSize(new java.awt.Dimension(50, 25));
        rectangleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectangleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(rectangleButton1);

        lineButton1.setFocusable(false);
        lineButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineButton1.setMaximumSize(new java.awt.Dimension(50, 25));
        lineButton1.setMinimumSize(new java.awt.Dimension(50, 25));
        lineButton1.setPreferredSize(new java.awt.Dimension(50, 25));
        lineButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(lineButton1);

        freeButton1.setFocusable(false);
        freeButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        freeButton1.setMaximumSize(new java.awt.Dimension(30, 25));
        freeButton1.setMinimumSize(new java.awt.Dimension(30, 25));
        freeButton1.setPreferredSize(new java.awt.Dimension(30, 25));
        freeButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        freeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(freeButton1);

        jCheckBox1.setText("Dashed");
        jCheckBox1.setFocusable(false);
        jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox1.setMaximumSize(new java.awt.Dimension(60, 43));
        jCheckBox1.setMinimumSize(new java.awt.Dimension(60, 43));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(60, 43));
        jCheckBox1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jCheckBox1);

        jCheckBox3.setText("Filled");
        jCheckBox3.setFocusable(false);
        jCheckBox3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox3.setMaximumSize(new java.awt.Dimension(60, 43));
        jCheckBox3.setMinimumSize(new java.awt.Dimension(60, 43));
        jCheckBox3.setPreferredSize(new java.awt.Dimension(60, 43));
        jCheckBox3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jCheckBox3);

        jLabel1.setText("Transparency:");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 25));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 25));
        jToolBar2.add(jLabel1);

        jSlider1.setValue(0);
        jSlider1.setMaximumSize(new java.awt.Dimension(100, 25));
        jSlider1.setMinimumSize(new java.awt.Dimension(100, 25));
        jSlider1.setPreferredSize(new java.awt.Dimension(100, 25));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jToolBar2.add(jSlider1);

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Cyclic");
        jCheckBox2.setFocusable(false);
        jCheckBox2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBox2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jCheckBox2);

        jToggleButton1.setText("Gradiant");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton1);

        jToggleButton2.setText("Texture");
        jToggleButton2.setFocusable(false);
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton2);

        jToggleButton3.setText("Text");
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton3);

        jTextField1.setMaximumSize(new java.awt.Dimension(75, 25));
        jTextField1.setMinimumSize(new java.awt.Dimension(75, 25));
        jTextField1.setPreferredSize(new java.awt.Dimension(75, 25));
        jToolBar2.add(jTextField1);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setFocusable(false);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setMaximumSize(new java.awt.Dimension(50, 25));
        jPanel3.setMinimumSize(new java.awt.Dimension(50, 25));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        jSlider2.setBackground(new java.awt.Color(255, 255, 255));
        jSlider2.setForeground(new java.awt.Color(255, 0, 0));
        jSlider2.setMajorTickSpacing(50);
        jSlider2.setMaximum(255);
        jSlider2.setMinorTickSpacing(10);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setValue(0);
        jSlider2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanel2.add(jSlider2);

        jSlider3.setBackground(new java.awt.Color(255, 255, 255));
        jSlider3.setForeground(new java.awt.Color(51, 255, 51));
        jSlider3.setMajorTickSpacing(50);
        jSlider3.setMaximum(255);
        jSlider3.setMinorTickSpacing(10);
        jSlider3.setPaintLabels(true);
        jSlider3.setPaintTicks(true);
        jSlider3.setValue(0);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });
        jPanel2.add(jSlider3);

        jSlider4.setBackground(new java.awt.Color(255, 255, 255));
        jSlider4.setForeground(new java.awt.Color(0, 0, 255));
        jSlider4.setMajorTickSpacing(50);
        jSlider4.setMaximum(255);
        jSlider4.setMinorTickSpacing(10);
        jSlider4.setPaintLabels(true);
        jSlider4.setPaintTicks(true);
        jSlider4.setValue(0);
        jSlider4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider4StateChanged(evt);
            }
        });
        jPanel2.add(jSlider4);

        jSlider5.setMajorTickSpacing(20);
        jSlider5.setMinorTickSpacing(5);
        jSlider5.setPaintLabels(true);
        jSlider5.setPaintTicks(true);
        jSlider5.setValue(10);
        jSlider5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider5StateChanged(evt);
            }
        });
        jPanel2.add(jSlider5);

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Clear");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Print");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.save();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //this menu item closes the program by calling method
        this.closeProg();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void closeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton2ActionPerformed
        // this button closes program by calling method
        this.closeProg();
    }//GEN-LAST:event_closeButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //calles print method
        this.print();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void freeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeButton1ActionPerformed
        // TODO add your handling code here:
        shape(MyNewJFrame.this, new Free());
    }//GEN-LAST:event_freeButton1ActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jSlider3StateChanged

    private void jSlider4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jSlider4StateChanged

    private void jSlider5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider5StateChanged
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jSlider5StateChanged

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        this.repaint();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton1.isSelected()) {
            if  (jCheckBox2.isSelected()){
                JColorChooser jcc = new JColorChooser();
                this.c1 = null;
                this.c1 = JColorChooser.showDialog(rootPane, "Choose first color", c1);
                System.out.println(c1);
                this.c2 = null;
                this.c2 = JColorChooser.showDialog(rootPane, "Choose second 2", c2);
                this.gp = new GradientPaint(this.jPanel1.getWidth() / 2, 0.0f, this.c1, this.jPanel1.getWidth() / 2, this.jPanel1.getHeight(), this.c2);
            } else{
                JColorChooser jcc = new JColorChooser();
                this.c1 = null;
                c1 = JColorChooser.showDialog(rootPane, "Choose first color", c1);
                System.out.println(c1);
                this.c2 = null;
                this.c2 = JColorChooser.showDialog(rootPane, "Choose second 2", c2);
                this.gp = new GradientPaint(this.jPanel1.getWidth() / 2, 0.0f, this.c2, this.jPanel1.getWidth() / 2, this.jPanel1.getHeight(), this.c1);
            }
            this.repaint();
            
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        //this determines whether the shape is filled or not
        if (jCheckBox3.isSelected()) {
            this.filled = true;
        } else {
            this.filled = false;
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        //what happends with the mouse is pressed on the jpanel
        oldx = evt.getX();
        oldy = evt.getY();
        //sets back and forground
        if (this.background == null) {
            this.background = this.createImage(this.jPanel1.getWidth(), this.jPanel1.getHeight());
            this.forground = this.createImage(this.jPanel1.getWidth(), this.jPanel1.getHeight());
        }


    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // what happends when the mouse is released
        Graphics backg = this.background.getGraphics();
        Graphics foreg = this.forground.getGraphics();
        foreg.setColor(this.c);
        //this is to draw text
        if (this.jToggleButton3.isSelected()) {
            foreg.drawString(this.jTextField1.getText(), evt.getX(), evt.getY());
        }
        backg.drawImage(this.forground, 0, 0, null);
        MyNewJFrame.this.repaint();

    }//GEN-LAST:event_jPanel1MouseReleased

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // set texture
        if (this.jToggleButton2.isSelected()) {
            BufferedImage text = new BufferedImage(128, 128, 6);
            Graphics2D bT = text.createGraphics();
            ImageIcon ii = new ImageIcon("E:\\NetBeans\\Final\\src/bat.png");
            Image i = ii.getImage();
            bT.drawImage(i, 0, 0, null);
            Rectangle r = new Rectangle(128, 128);
            this.tp = new TexturePaint(text, r);

        }

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        //this decides what the values are
        int width = Math.abs(evt.getX() - this.oldx);
        int height = Math.abs(evt.getY() - this.oldy);
        int x = this.oldx < evt.getX() ? this.oldx : evt.getX();
        int y = this.oldy < evt.getY() ? this.oldy : evt.getY();
        if (this.bs instanceof Line || this.bs instanceof Free) {
            width = evt.getX();
            height = evt.getY();
            x = this.oldx;
            y = this.oldy;

        }
        //init graphics
        Graphics foreg = this.forground.getGraphics();
        foreg.drawImage(this.background, 0, 0, null);
        //draw image
        if (!this.jToggleButton3.isSelected()) {
            if (this.jToggleButton1.isSelected() && !this.jToggleButton2.isSelected()) {
                this.bs.drawS(foreg, x, y, width, height, this.c, this.b, this.filled, this.transVal, this.gp, null);
            } else if (!this.jToggleButton1.isSelected() && this.jToggleButton2.isSelected()) {
                this.bs.drawS(foreg, x, y, width, height, this.c, this.b, this.filled, this.transVal, null, this.tp);
            } else if (this.jToggleButton1.isSelected() && this.jToggleButton2.isSelected()) {
                this.bs.drawS(foreg, x, y, width, height, this.c, this.b, this.filled, this.transVal, this.gp, this.tp);
            } else {
                this.bs.drawS(foreg, x, y, width, height, this.c, this.b, this.filled, this.transVal, null, null);
            }

        }
        this.jPanel1.getGraphics().drawImage(this.forground, 0, 0, null);
        if (this.bs instanceof Free) {
            oldx = width;
            oldy = height;
            Graphics backg = this.background.getGraphics();
            backg.drawImage(this.forground, 0, 0, null);
        }
    }//GEN-LAST:event_jPanel1MouseDragged

    private void ovalButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalButton1ActionPerformed
        // TODO add your handling code here:
        //sets shape to oval
        shape(MyNewJFrame.this, new Oval());
    }//GEN-LAST:event_ovalButton1ActionPerformed

    private void rectangleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButton1ActionPerformed
        // TODO add your handling code here:
        //sets shape to rectangle
        shape(MyNewJFrame.this, new Rect());
    }//GEN-LAST:event_rectangleButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //clear image
        this.background = clear;
        this.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void clearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButton1ActionPerformed
        // TODO add your handling code here:
        //clear image;
        this.background = clear;
        this.repaint();

    }//GEN-LAST:event_clearButton1ActionPerformed

    private void lineButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButton1ActionPerformed
        // TODO add your handling code here:
        shape(MyNewJFrame.this, new Line());
    }//GEN-LAST:event_lineButton1ActionPerformed

    private void openButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButton2ActionPerformed
        // TODO add your handling code here:
        //calls open method
        this.open();
    }//GEN-LAST:event_openButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        // call save method
        this.open();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void saveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton2ActionPerformed
        // TODO add your handling code here:
        //call save method
        this.save();
    }//GEN-LAST:event_saveButton2ActionPerformed

    private void printButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButton1ActionPerformed
        // TODO add your handling code here:
        //calls print method
        this.print();
    }//GEN-LAST:event_printButton1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        //option for Cyclic or acyclic
        if(jCheckBox2.isSelected()){
            this.gp = new GradientPaint(this.jPanel1.getWidth() / 2, 0.0f, this.c1, this.jPanel1.getWidth() / 2, this.jPanel1.getHeight(), this.c2);
        } else{
            this.gp = new GradientPaint(this.jPanel1.getWidth() / 2, 0.0f, this.c2, this.jPanel1.getWidth() / 2, this.jPanel1.getHeight(), this.c1);
        }
        

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MyNewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MyNewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MyNewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MyNewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MyNewJFrame njf = new MyNewJFrame();
                njf.setDefaultCloseOperation(3);
                njf.setVisible(true);

            }
        });

    }

    public MyNewJFrame() {
        initComponents();
        this.bs = new Oval();
        this.filled = false;
        this.v = new Vector();
        JOptionPane.showMessageDialog(frame, "Keep in mind that the images for the buttons and texuture may not work becuase of the change in file path, but everything works fully on my computer");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ClearButton clearButton1;
    private CloseButton closeButton1;
    private CloseButton closeButton2;
    private FreeButton freeButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSlider jSlider5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private LineButton lineButton1;
    private OpenButton openButton2;
    private OvalButton ovalButton1;
    private PrintButton printButton1;
    private RectangleButton rectangleButton1;
    private SaveButton saveButton1;
    private SaveButton saveButton2;
    // End of variables declaration//GEN-END:variables
}
