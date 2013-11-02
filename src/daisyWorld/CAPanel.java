/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CAPanel.java
 *
 * Created on Nov 16, 2009, 9:48:44 PM
 */
package daisyWorld;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author David
 */
public class CAPanel extends javax.swing.JPanel {

    public int size = 100;
    public int nStates = 2;
    public int paletteNo = 2;
    boolean individual = false;
    public int[][] statesCur = new int[size][size];
    public int[][] statesOld = new int[size][size];
    //0 = rainbow
    //1 = heat
    //2 = terrain
    public String[][] palettes = {
        {
            "#FF0000", "#FF1F00", "#FF3D00", "#FF5C00", "#FF7A00", "#FF9900",
            "#FFB800", "#FFD600", "#FFF500", "#EBFF00", "#CCFF00", "#ADFF00",
            "#8FFF00", "#70FF00", "#52FF00", "#33FF00", "#14FF00", "#00FF0A",
            "#00FF29", "#00FF47", "#00FF66", "#00FF85", "#00FFA3", "#00FFC2",
            "#00FFE0", "#00FFFF", "#00E0FF", "#00C2FF", "#00A3FF", "#0085FF",
            "#0066FF", "#0047FF", "#0029FF", "#000AFF", "#1400FF", "#3300FF",
            "#5200FF", "#7000FF", "#8F00FF", "#AD00FF", "#CC00FF", "#EB00FF",
            "#FF00F5", "#FF00D6", "#FF00B8", "#FF0099", "#FF007A", "#FF005C",
            "#FF003D", "#FF001F"},
        {
            "#FF0000", "#FF0700", "#FF0E00", "#FF1500", "#FF1C00", "#FF2200",
            "#FF2900", "#FF3000", "#FF3700", "#FF3E00", "#FF4500", "#FF4C00",
            "#FF5300", "#FF5A00", "#FF6000", "#FF6700", "#FF6E00", "#FF7500",
            "#FF7C00", "#FF8300", "#FF8A00", "#FF9100", "#FF9800", "#FF9F00",
            "#FFA500", "#FFAC00", "#FFB300", "#FFBA00", "#FFC100", "#FFC800",
            "#FFCF00", "#FFD600", "#FFDD00", "#FFE300", "#FFEA00", "#FFF100",
            "#FFF800", "#FFFF00", "#FFFF0B", "#FFFF20", "#FFFF35", "#FFFF4A",
            "#FFFF60", "#FFFF75", "#FFFF8A", "#FFFF9F", "#FFFFB5", "#FFFFCA",
            "#FFFFDF", "#FFFFF4"},
        {
            "#00A600", "#07A800", "#0EAB00", "#16AE00", "#1DB000", "#25B300",
            "#2DB600", "#36B800", "#3EBB00", "#47BE00", "#50C000", "#59C300",
            "#63C600", "#6CC800", "#76CB00", "#80CE00", "#8BD000", "#95D300",
            "#A0D600", "#ABD800", "#B6DB00", "#C2DE00", "#CEE000", "#D9E300",
            "#E6E600", "#E6DD09", "#E7D612", "#E7CF1C", "#E8C825", "#E8C32E",
            "#E9BE38", "#E9BA41", "#EAB74B", "#EAB454", "#EBB25E", "#EBB167",
            "#ECB171", "#ECB17B", "#EDB285", "#EDB48E", "#EEB798", "#EEBAA2",
            "#EFBFAC", "#EFC4B6", "#F0C9C0", "#F0D0CA", "#F1D7D4", "#F1DFDE",
            "#F2E8E8", "#F2F2F2"},
        {
            "#80FFFF", "#85FFFF", "#8AFFFF", "#8FFFFF", "#94FFFF", "#99FFFF",
            "#9EFFFF", "#A3FFFF", "#A8FFFF", "#ADFFFF", "#B2FFFF", "#B8FFFF",
            "#BDFFFF", "#C2FFFF", "#C7FFFF", "#CCFFFF", "#D1FFFF", "#D6FFFF",
            "#DBFFFF", "#E0FFFF", "#E6FFFF", "#EBFFFF", "#F0FFFF", "#F5FFFF",
            "#FAFFFF", "#FFFAFF", "#FFF5FF", "#FFF0FF", "#FFEBFF", "#FFE6FF",
            "#FFE0FF", "#FFDBFF", "#FFD6FF", "#FFD1FF", "#FFCCFF", "#FFC7FF",
            "#FFC2FF", "#FFBDFF", "#FFB8FF", "#FFB2FF", "#FFADFF", "#FFA8FF",
            "#FFA3FF", "#FF9EFF", "#FF99FF", "#FF94FF", "#FF8FFF", "#FF8AFF",
            "#FF85FF", "#FF80FF"
        },
        {
            "#00A600", "#07A800", "#0EAB00", "#16AE00", "#1DB000", "#25B300",
            "#2DB600", "#36B800", "#3EBB00", "#47BE00", "#50C000", "#59C300",
            "#63C600", "#6CC800", "#76CB00", "#80CE00", "#8BD000", "#95D300",
            "#A0D600", "#ABD800", "#B6DB00", "#C2DE00", "#CEE000", "#D9E300",
            "#E6E600", "#E6DD09", "#E7D612", "#E7CF1C", "#E8C825", "#E8C32E",
            "#E9BE38", "#E9BA41", "#EAB74B", "#EAB454", "#EBB25E", "#EBB167",
            "#ECB171", "#ECB17B", "#EDB285", "#EDB48E", "#EEB798", "#EEBAA2",
            "#EFBFAC", "#EFC4B6", "#F0C9C0", "#F0D0CA", "#F1D7D4", "#F1DFDE",
            "#F2E8E8", "#F2F2F2"
        }
    };
    public String[] curPalette = {
        "#00A600", "#07A800", "#0EAB00", "#16AE00", "#1DB000", "#25B300",
        "#2DB600", "#36B800", "#3EBB00", "#47BE00", "#50C000", "#59C300",
        "#63C600", "#6CC800", "#76CB00", "#80CE00", "#8BD000", "#95D300",
        "#A0D600", "#ABD800", "#B6DB00", "#C2DE00", "#CEE000", "#D9E300",
        "#E6E600", "#E6DD09", "#E7D612", "#E7CF1C", "#E8C825", "#E8C32E",
        "#E9BE38", "#E9BA41", "#EAB74B", "#EAB454", "#EBB25E", "#EBB167",
        "#ECB171", "#ECB17B", "#EDB285", "#EDB48E", "#EEB798", "#EEBAA2",
        "#EFBFAC", "#EFC4B6", "#F0C9C0", "#F0D0CA", "#F1D7D4", "#F1DFDE",
        "#F2E8E8", "#F2F2F2"
    };
    public int x = 0, y = 0;
    public double wBox = 5, hBox = 5;
    public boolean needsInitialization = true;

    /** Creates new form CAPanel */
    public CAPanel() {
        initComponents();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                statesCur[i][j] = 0;
            }
        }
    }

    public CAPanel(int size, int nStates, int paletteNo, int[][] statesInit) {
        initComponents();
        this.size = size;
        this.nStates = nStates;
        initPalette(1);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                statesCur[i][j] = statesInit[i][j];
            }

        }

    }

    public void initPalette(int paletteNoA, boolean invert) {

        try {
            this.paletteNo = paletteNoA;
            int length = palettes[paletteNo].length;
            curPalette = new String[length];

            for (int i = 0; i < length; i++) {
                curPalette[length - i - 1] = palettes[paletteNo][i];
            }
            System.out.println("Palette is initialized and inverted: " + invert);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not set palette number " + paletteNo);
        }

    }

    private void initPalette(int paletteNoA) {

        try {
            this.paletteNo = paletteNoA;
            curPalette = new String[palettes[paletteNo].length];
            for (int i = 0; i < palettes[paletteNo].length; i++) {
                curPalette[i] = palettes[paletteNo][i];
            }
            System.out.println("Palette is initialized");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not set palette number " + paletteNo);
        }

    }

    public boolean updateState(int x, int y, int state) {
        individual = true;
        this.x = x;
        this.y = y;
        statesCur[this.x][this.y] = state;
        this.paintComponent(this.getGraphics());
        individual = false;
        return true;
    }

    public boolean setStates(int[][] states, int sizeA, boolean invertPalette) {
        //System.out.println("Old ss:" + this.size + " New ss: " + size);
        if (this.size != sizeA) {
            System.out.println("The size is now " + sizeA);
            statesCur = new int[sizeA][sizeA];
            statesOld = new int[sizeA][sizeA];
            this.size = sizeA;
            needsInitialization = true;
            //this.repaint();
        }
        //System.out.println("Humbug");
        if (needsInitialization) {
            //System.out.println("The palette is " + paletteNo);
            initPalette(this.paletteNo, invertPalette);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                statesCur[i][j] = states[i][j];
                if (needsInitialization) {
                    statesOld[i][j] = 0;
                }
            }
        }
        this.paintComponent(this.getGraphics());
        //System.out.println("Repainting");
        needsInitialization = false;
        return true;
    }

    public boolean setStates(int[][] states, int sizeA) {
        try {
            //System.out.println("Old ss:" + this.size + " New ss: " + size);
            if (this.size != sizeA) {
                System.out.println("The size is now " + sizeA);
                statesCur = new int[sizeA][sizeA];
                statesOld = new int[sizeA][sizeA];
                this.size = sizeA;
                needsInitialization = true;
                //this.repaint();
            }
            //System.out.println("Humbug");
            if (needsInitialization) {
                //System.out.println("The palette is " + paletteNo);
                initPalette(this.paletteNo);
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    statesCur[i][j] = states[i][j];
                    if (needsInitialization) {
                        statesOld[i][j] = 0;
                    }
                }
            }
            this.paintComponent(this.getGraphics());
            //System.out.println("Repainting");
            needsInitialization = false;
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Let UI delegate paint first
        // (including background filling, if I'm opaque)
        //super.paintComponent(g);

        //System.out.println("Painting component");

        //System.out.println("The border is " + border);

        int h = this.getHeight();
        int w = this.getWidth();
        wBox = (double) w / (double) size;
        hBox = (double) h / (double) size;
//System.out.println("Repainting with " + w + "," + h);


        //if (needsInitialization) {
        //determine piexel width and height
        //System.out.println("Got reinit signal");
        if (needsInitialization) {
            //g.setColor(Color.white);
            //g.fillRect(0, 0, w, h);
        }
        //}

        //determine color of box
        if (individual) {
            if (statesCur[x][y] == -1) {
                g.setColor(Color.black);

            } else {
                //System.out.println("The current state is " + statesCur[x][y] + " and the number of states is " + nStates + " and the palette position is " + ((int) (curPalette.length * (double) statesCur[x][y] / nStates) - 1));
                String colCur = curPalette[(int) (curPalette.length * (double) statesCur[x][y] / nStates) - 1];
                g.setColor(Color.decode(colCur));
            }
            int pixX = (int) ((x) * wBox);
            //int pixY = h - (y) * hBox;
            int pixY = (int) ((y) * hBox);
            //make a fillRect
            g.fillRect(pixX, pixY, (int) wBox, (int) hBox);
            statesOld[x][y] = statesCur[x][y];
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (statesCur[i][j] == 0) {
                        statesCur[i][j] = 1;
                    }
                    //System.out.println("The current state is " + statesCur[i][j]);
                    //System.out.println("There are a total of " + nStates + " states.");
                    //if (statesOld[i][j] != statesCur[i][j] || needsInitialization) {
                    if (statesCur[i][j] == -1) {
                        g.setColor(Color.black);

                    } else {
                        try {
                            String colCur = curPalette[(int) (curPalette.length * (double) statesCur[i][j] / nStates) - 1];

                            g.setColor(Color.decode(colCur));
                        } catch (Exception e) {
                            //System.err.println("Couldn't set color ");
                            g.setColor(Color.black);
                            //e.printStackTrace();
                        }
                    }
                    //determine pixel position of box upper corner
                    int pixX = (int) ((i) * wBox);
                    int pixY = h - (int) ((j) * hBox);

                    //make a fillRect
                    g.fillRect(pixX, pixY, (int) wBox + 1, (int) hBox + 1);
                    statesOld[i][j] = statesCur[i][j];
                    //}
                }
            }
        }

        //needsInitialization = false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CAPanel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
