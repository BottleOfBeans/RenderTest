package src.App;

import java.awt.geom.Ellipse2D;

public class Particle extends GameWindow{
    double x,y,z, radius;


    public Particle(int gx, int gy, int gz, int gradius){
        x = gx;
        y = gy;
        z = gz;
        radius = gradius;
    }

    public Ellipse2D.Double getParticle(){
        double[][] self = {
                {x,y,z}
        };
        Matrix selfMat = new Matrix(self);

        double projX = selfMat.multiplyMatricies(TwoDProjectionMatrix).matrix[0][0];
        double projY = selfMat.multiplyMatricies(TwoDProjectionMatrix).matrix[0][1];
        double projSize = radius*focalLength/z;
        return new Ellipse2D.Double(projX - projSize, projY - projSize, projSize*2, projSize*2);
    }
}
