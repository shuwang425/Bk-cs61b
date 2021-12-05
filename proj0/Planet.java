/**create a public class Planet
// double xxPos: Its current x position
//double yyPos: Its current y position
//double xxVel: Its current velocity in the x direction
//double yyVel: Its current velocity in the y direction
//double mass: Its mass
//String imgFileName: The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)*/
public class Planet {
	double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    /* constructor 1  */
    public Planet (double xP, double yP, double xV, double yV, double m, String img){
    	xxPos = xP;
    	yyPos = yP;
    	xxVel = xV;
    	yyVel = yV;
    	mass = m;
    	imgFileName = img;
    }
    /* second constructor */
    public Planet (Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;

    }
    /** Create methods named calcDistance to calculates the distance between two bodys. 
 * return the distance distance;
 * */
    public double calcDistance (Planet b){
        double dx = this.xxPos - b.xxPos;
        double dy  = this.yyPos - b.yyPos;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }

    /**  create a calcForceExertedBy to calculate the force exerted on this body.
     * return the value force;
    */
    public double calcForceExertedBy (Planet b) {
        final double G = 6.67e-11;

        double force = G * this.mass * b.mass /(calcDistance(b) * calcDistance(b));
        return force;

    }

    /** calculate methods calcForceExertedByX to desccribe force in X direction
     * and calcForceExertedByY to describe force in Y direction
     * return the positive forceX and positive forceY;
     */
    public double calcForceExertedByX (Planet b){
        double dx = b.xxPos -this.xxPos;
        double forceX = this.calcForceExertedBy(b)*dx/this.calcDistance(b);
        
            return forceX;
        
    }

    public double calcForceExertedByY (Planet b){
        double dy = b.yyPos - this.yyPos;
        double forceY = calcForceExertedBy(b)* dy/calcDistance(b);
        
            return forceY;
       
    }


    /**Write methods calcNetForceExertedByX and calcNetForceExertedByY
     *each take in an array of Bodys and calculates the net X and net Y force
     * exerted by all bodies in that array upon the current Planet.
     * 
     * */
    public double calcNetForceExertedByX (Planet[] bodys) {
        double netX = 0.0;
        for (Planet i : bodys) {
            if (i.equals(this)){
              continue;  
          } else {
            netX = netX + this.calcForceExertedByX(i);
          }
        }
        return netX;
    }


    public double calcNetForceExertedByY (Planet[] bodys) {
        double netY = 0.0;
        for (Planet i : bodys) {
            if (i.equals(this)){
              continue;  
          } else {
            netY = netY + this.calcForceExertedByY(i);
          }
        }
        return netY;
    }
    /* updated the accelerate and velocity and postion
    */
    public void update (double dt, double fX, double fY){
        double aX = fX/this.mass;
        double aY = fY/this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
    // draw one body
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);

    }

   
} 

