/**
 * A quadratic expression object.
 * Can perform a number of operations on the expression.
 */
public class QuadraticExpression
{
    private double a = 0;
    private double b = 0;
    private double c = 0;
    
    /**
     * Default constructor sets all value to 0.
     */
    public QuadraticExpression()
    {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    
    /**
     * Constructor to create the expression with set values.
     */
    public QuadraticExpression(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /**
     * Changes the expression to a string.
     * @return a string version of the expression.
     */
    public String toString()
    {
        return a+"x^2 + "+b+"x + "+c;
    }
    
    /**
     * Evaluates the expression at x.
     * @return the calculated expression.
     * @param x Any value for the variable x.
     */
    public double evaluate(double x)
    {
        return a*x*x + b*x + c;
    }
    
    public void setA(double newA){ this.a = newA; }
    public void setB(double newB){ this.b = newB; }
    public void setC(double newC){ this.c = newC; }
    
    /**
     * Scales the given epxression by the value of variable r.
     * @return a new scaled expression.
     * @param r This is the scaling factor.
     * @param q This is the original expression to be scaled.
     */
    public static QuadraticExpression scale(double r, QuadraticExpression q)
    {
        QuadraticExpression qe = new QuadraticExpression();
        qe.a = q.a * r;
        qe.b = q.b * r;
        qe.c = q.c * r;
        return qe;
    }
    
    /**
     * Calculates the number of roots for the calling expression.
     * @return either 0,1,2 for the number of roots
     *          or 3 if the number is infinite.
     */
    public int numberOfRoots()
    {
        if (a==0 && b==0 && c==0)
        {
            return 3;
        }
        else if((a==0 && b==0) || Math.sqrt(b) - 4*a*c < 0)
        {
            return 0;
        }
        else if (a==0 || (Math.sqrt(b) - 4*a*c == 0))
        {
            return 1;
        }
        return 2;
    }
    
    /** 
     * Creates a new expression that is the sum of q1 and q2.
     * @return a new expression, qe, that is the sum of the two passed expressions.
     * @param q1 The first expression.
     * @param q2 The second expression.
     */
    public static QuadraticExpression add(QuadraticExpression q1, QuadraticExpression q2)
    {
        QuadraticExpression qe = new QuadraticExpression();
        qe.a = q1.a + q2.a;
        qe.b = q1.b + q2.b;
        qe.c = q1.c + q2.c;
        return qe;
    }
    
    /** 
     * Add q to the calling expression object.
     * @param q The epxression being added to the calling object.
     */
    public void add(QuadraticExpression q)
    {
        this.a += q.a;
        this.b += q.b;
        this.c += q.c;
    }
    
    /** 
     * Compute the smaller root of the expression.
     * @return which root is smaller or the maximum value if root number is infinite.
     */
    public double smallerRoot() throws Exception
    {
        int roots = numberOfRoots();
        
        if(roots == 0)
        {
            throw new Exception();
        }
        else if(roots == 3)
        {
            return -Double.MAX_VALUE;
        }
        else
        {
            double determinant = Math.sqrt(b) - 4*a*c;
            
            if(determinant == 0)
            {
                return -(b / (2*a));
            }
            else
            { 
                double root1 = (-b + determinant) / (2 * a);
                double root2 = (-b - determinant) / (2 * a);
                
                if (root1 < root2)
                {
                    return root1;
                }
                else
                {
                    return root2;
                }
            }
        }
    }
    
    /**
     * Compute the larger root of the expression.
     * @return which root is larger or the maximum value if the root number is infinite.
     */
    public double largerRoot() throws Exception
    {
        int roots = numberOfRoots();
        
        if(roots == 0)
        {
            throw new Exception();
        }
        else if(roots == 3)
        {
            return -Double.MAX_VALUE;
        }
        else
        {
            double determinant = Math.sqrt(b) - 4*a*c;
            
            if(determinant == 0)
            {
                return -(b / (2*a));
            }
            else
            { 
                double root1 = (-b + determinant) / (2 * a);
                double root2 = (-b - determinant) / (2 * a);
                
                if (root1 > root2)
                {
                    return root1;
                }
                else
                {
                    return root2;
                }
            }
        }
    }
    
    /**
     * Overrides the equals function to determine if two expressions are equivalent.
     * @return true or false depending on equivalency.
     * @param obj This is a call to the object being checked.
     */
    @Override
    public boolean equals(Object obj)
    {
        //If the object is compared with itself then return true   
        if(obj == this)
        {
            return true;
        }
        
        // Check if q is an instance of QuadraticExpression or not 
        if(!(obj instanceof QuadraticExpression))
        {
            return false;
        }
        
        // Type cast q
        QuadraticExpression newobj = (QuadraticExpression) obj;
        
        // Compare the data members and return accordingly  
      return ((newobj.a == this.a) && (newobj.b == this.b) && (newobj.c == this.c));   
    }
    
    /**
     * Clones the calling object.
     * @return a copy of the calling expression.
     */
    public QuadraticExpression clone()
    {
        QuadraticExpression qe= new QuadraticExpression();
        qe.a = this.a;
        qe.b = this.b;
        qe.c = this.c;
        return qe;
    }
}
