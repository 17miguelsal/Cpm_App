/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;


public class LienzoDibujo extends JPanel{
    
   private int xAnterior, yAnterior, xActual, yActual;
   protected Graphics2D g2d;
    

    public LienzoDibujo() {
        super();
        setPreferredSize(new Dimension(400, 400)); // Tamaño del panel
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xAnterior = e.getX();
                yAnterior = e.getY();
                g2d = (Graphics2D) getGraphics();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                g2d.dispose();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                xActual = e.getX();
                yActual = e.getY();
                g2d.drawLine(xAnterior, yAnterior, xActual, yActual);
                xAnterior = xActual;
                yAnterior = yActual;
            }
        });
        
    }
}
