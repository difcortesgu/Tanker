package tanker;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

public class Obstaculo extends Elemento{

    public Obstaculo(double x, double y, double tamaño, double vida, Tablero tablero) {
        super(x, y, tamaño, vida, tablero);
    }

    @Override
    public boolean colision() {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void PaintComponent(Graphics2D g){
        g.drawRect((int)x, (int)y, (int)tamaño, (int)tamaño);
    }

}
