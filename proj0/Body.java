/**create a public class Body
// double xxPos: Its current x position
//double yyPos: Its current y position
//double xxVel: Its current velocity in the x direction
//double yyVel: Its current velocity in the y direction
//double mass: Its mass
//String imgFileName: The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)*/
public class Body {
	double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    /* constructor 1  */
    public Body (double xP, double yP, double xV, double yV, double m, String img){
    	xxPos = xP;
    	yyPos = yP;
    	xxVel = xV;
    	yyVel = yV;
    	mass = m;
    	imgFileName = img;
    }
    /* second constructor */
    public Body (Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;

    }
} 

/** Create methods named calcDistance to calculates the distance between two bodys. 
 * return the distance r;
 * */
public double calcDistance {
    double dx = this.xxPos - b.xxPos;
    double dy  = this.yyPos - b.yyPos;
    double r = Math.sqrt(dx*dx + dy*dy);
    return r;

}