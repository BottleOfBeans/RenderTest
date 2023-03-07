package src.App;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Particle extends GameWindow{
    double x,y,z, radius;


    public Particle(int gx, int gy, int gz, int gradius){
        x = gx;
        y = gy;
        z = gz;
        radius = gradius;
    }

    public Point2D.Double  getParticle(){
        double[][] self = {
                {x},
                {y},
                {z}
        };
        Matrix selfMat = new Matrix(self);

        Matrix finalMat = TwoDProjectionMatrix.multiplyMatricies(selfMat);

        double projX = finalMat.matrix[0][0];
        double projY = finalMat.matrix[1][0];
        double projSize = radius*focalLength/z;
        return new Point2D.Double(projX - projSize, -projSize);
    }
}
