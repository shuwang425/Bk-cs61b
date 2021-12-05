public class NBody {
    /** creat method readRadium
    */
	public static double readRadius (String planetsTxtPath) {

		In in = new In(planetsTxtPath);
		in.readInt();
		double radius = in.readDouble();
		return radius;

	}
    /**create a method readBodies to read into bodes
     * 
     * 
     * 
     */
    public static Planet[] readPlanets (String planetsTxtPath) {
        In in = new In ("./data/planets.txt");
		int number = in.readInt();
		Planet[] planets = new Planet[number];
    	in.readDouble();
    	for (int i = 0; i < number; i++){
    		double xP = in.readDouble();
    		double yP = in.readDouble();
    		double xV = in.readDouble();
    		double yV = in.readDouble();
    		double m = in.readDouble();
    		String img = in.readString();
    		planets[i] = new Planet (xP, yP, xV, yV, m, img);


    	}
    	return planets;

    }
    /** drwaing the initial universe state using main.
     * 
     * read in data*/
    public static void main(String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];
    	double uniRadius = readRadius(filename);

    	Planet[] Planets = readPlanets(filename);

    	// draw the back groudn using StdDraw

    	StdDraw.setScale( -uniRadius, uniRadius);
    	StdDraw.clear();
    	StdDraw.picture(0, 0, "./images/starfield.jpg");

    	//draw multi bodys
    	for (Planet planets: Planets){
    		planets.draw();
    	}
        
        /**
         * make animation
         **/
        StdDraw.enableDoubleBuffering();
        
        /*create x Forces and yForces array
        */
        for (double t = 0; t <= T; t += dt) {
        	double[] xForces = new double[Planets.length];
        	double[] yForces = new double [Planets.length];

        	 /** calculate the net x and y forces for each Body
         * and store in the xForces and yForces;
        */
        for (int i = 0; i < Planets.length; i++) {
        	xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
        	yForces[i] = Planets[i].calcNetForceExertedByY(Planets); 
        }
        
        /** update each planets
         * */
        for (int i = 0; i < Planets.length; i++) {
        	Planets[i].update(dt, xForces[i], yForces[i]);

        }
        /**
         * drawbackgroud
         * */
        StdDraw.picture(0, 0, "./images/starfield.jpg");

        /**
         * draw each plante
        */
        for (int i = 0; i < Planets.length; i++) {
        	Planets[i].draw();
        }
        StdDraw.show();

        /**
         * pause 10 seconds
         * */
        StdDraw.pause(10);
        }

        /**
         * Printing the universe
         * */
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                  Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);   
}
    	
    }






}




