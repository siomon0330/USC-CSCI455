
// Name:Chuanli Wei
// USC loginid:6222006323
// CS 455 PA2
// Spring 2017


import java.util.ArrayList;

/**
 A polynomial. Polynomials can be added together, evaluated, and
 converted to a string form for printing.
 */
public class Polynomial {

    /**
     * Representation invariants:
     * Terms are unique
     * Terms are in decreasing order
     * There is no Term with coeff of 0
     * The polynomial size is >= 0
     */
    ArrayList<Term> polynomial;


    /**
     * Creates the 0 polynomial
     */
    public Polynomial() {

        polynomial = new ArrayList<Term>();
        assert isValidPolynomial();
    }


    /**
     * Creates polynomial with single term given
     */
    public Polynomial(Term term) {

        polynomial = new ArrayList<Term>();
        polynomial.add(term);
        removeZeroCoeff(polynomial);
        assert isValidPolynomial();

    }


    /**
     * Returns the Polynomial that is the sum of this polynomial and b
     * (neither poly is modified)
     * @ param Polynomial b  the Polynomial that we want to add
     */

    public Polynomial add(Polynomial b) {

        Polynomial newPoly = new Polynomial();
        int i = 0;
        int j = 0;

        while (i < polynomial.size() && j < b.polynomial.size()) {

            if (polynomial.get(i).getExpon() < b.polynomial.get(j).getExpon()) {

                newPoly.polynomial.add(b.polynomial.get(j));
                j++;

            } else if (polynomial.get(i).getExpon() > b.polynomial.get(j).getExpon()) {

                newPoly.polynomial.add(polynomial.get(i));
                i++;

            } else {

                double newCoeff = polynomial.get(i).getCoeff() + b.polynomial.get(j).getCoeff();
                int newExp = polynomial.get(i).getExpon();
                Term newTerm = new Term(newCoeff, newExp);
                newPoly.polynomial.add(newTerm);
                i++;
                j++;
            }

        }

        //add the left-over
        while (i < polynomial.size()) {

            newPoly.polynomial.add(polynomial.get(i));
            i++;
        }

        //add the left-over
        while (j < b.polynomial.size()) {

            newPoly.polynomial.add(b.polynomial.get(j));
            j++;
        }

        //remove the 0-coeff term
        removeZeroCoeff(newPoly.polynomial);

        assert isValidPolynomial();
        assert b.isValidPolynomial();
        assert newPoly.isValidPolynomial();
        return newPoly;


    }


    /**
     * Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {

        double value = 0;
        for (int i = 0; i < polynomial.size(); i++) {

            value = value + polynomial.get(i).getCoeff() * (Math.pow(x, polynomial.get(i).getExpon()));
        }

        assert isValidPolynomial();
        return value;

    }


    /**
     * Return a String version of the polynomial with the
     * following format, shown by example:
     * zero poly:   "0.0"
     * 1-term poly: "3.2x^2"
     * 4-term poly: "3.0x^5 + -x^2 + x + -7.9"
     * <p>
     * Polynomial is in a simplified form (only one term for any exponent),
     * with no zero-coefficient terms, and terms are shown in
     * decreasing order by exponent.
     */
    public String toFormattedString() {
        String string = "";

        if (polynomial.size() == 0) {

            return "0.0";
        }else {

            for (int i = 0; i < polynomial.size(); i++) {

                //Special formatting format if coeff == 1
                if(polynomial.get(i).getCoeff()==1){
                     if(polynomial.get(i).getExpon()==0){
                       string = string + 1.0+" + ";

                     }else if(polynomial.get(i).getExpon()==1){

                       string = string +"x"+ " + ";

                     }else {

                       string = string + "x^" + polynomial.get(i).getExpon() + " + ";
                     }

                //Sepcial formatting if coeff == 1
                }else if(polynomial.get(i).getCoeff()==-1) {

                     if(polynomial.get(i).getExpon()==0){

                      string = string + -1.0+" + ";
                     }else if(polynomial.get(i).getExpon()==1){

                      string = string +"-x"+ " + ";
                     }else {
                      string = string + "-x^" + polynomial.get(i).getExpon() + " + ";
                  }

                //Special formatting if exp==0
                } else if(polynomial.get(i).getExpon()==0){
                  string = string + polynomial.get(i).getCoeff() + " + ";

                //Special formatting if exp == 1
                }else if(polynomial.get(i).getExpon()==1){
                  string = string + polynomial.get(i).getCoeff() + "x" + " + ";

                //Other standard formatting
                }else {

                  string = string + polynomial.get(i).getCoeff() + "x^" + polynomial.get(i).getExpon() + " + ";
              }
            }

        assert isValidPolynomial();
        //subString to get rid of the last "+"
        return string.substring(0, string.length() - 2);

        }

    }

    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
     * Returns true iff the poly data is in a valid state.
     * Representation invariants:
     * Terms are unique
     * Terms are in decreasing order
     * There is no Term with coeff of 0
     * The polynomial size is >= 0
     */
    private boolean isValidPolynomial() {

        //Terms are in decreasing order and unique
        for(int i =0; i < polynomial.size()-1; i++){
            if(polynomial.get(i).getExpon() <= polynomial.get(i+1).getExpon()){
                return false;
            }
        }


        //The number of term is >= 0
        if(polynomial.size() < 0){
            return false;
        }

        //There is no 0-coeff term
        for(int i =0; i < polynomial.size(); i++){
            if(polynomial.get(i).getCoeff()==0){
                return false;
            }
        }

        return true;
    }

    /**
     * Private methods to remove the term with coeff of 0
     * param ArrayList<Term> poly  the Polynomial we want to remove 0-coeff from it
     */

    private static void removeZeroCoeff(ArrayList<Term> poly){

        for (int i = poly.size()-1; i >= 0; i--){

            if(poly.get(i).getCoeff() == 0){

                poly.remove(i);
            }
        }
    }





}