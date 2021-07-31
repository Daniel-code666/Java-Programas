/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVectores;

/**
 *
 * @author Daniel
 */
public class Vector {
    
    protected double x, y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    protected String cuadrante()
    {
        if(x == 0 && y == 0)
        {
            return "El vector está en el origen";
        }
        
        if(x != 0 && y == 0)
        {
            return "El vector está sobre el eje x";
        }
        
        if(x == 0 && y != 0)
        {
            return "El vector está sobre el eje y";
        }
        
        if(x > 0 && y > 0)
        {
            return "El vector está sobre el sector I";
        }
        
        if(x < 0 && y > 0)
        {
            return "El vector está sobre el sector II";
        }
        
        if(x < 0 && y < 0)
        {
            return "El vector está sobre el sector III";
        }
        
        if(x > 0 && y < 0)
        {
            return "El vector está sobre el sector IV";
        }
        
        return "";
    }
    
    protected String vectorResult(String[] vector)
    {
        return "Vector resultante entre A(" + x + "," + y + ") y B(" + Double.parseDouble(vector[0]) + "," + Double.parseDouble(vector[1]) + ")"
                + " es: C(" + (x - Double.parseDouble(vector[0]) + "," + (y - Double.parseDouble(vector[1])) + ")");
    }
    
    @Override
    public String toString() {
        return "Vector(" + x + "," + y + ")";
    }
    
    
    
}
