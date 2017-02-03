class WholeNumber{
    private long value;
    public  WholeNumber(long value){
        this.value = value;
    }

    public long getValue(){
        return this.value;
    }
}

class Fraction {
    long nominator = 0;
    long denominator = 1;

    public Fraction(long nominator, long denominator){
        this.nominator = nominator;
        this.denominator = denominator;
        reduce();
        sign();
    }

    long largestDivisor(long a, long b) {
        return (b==0) ? a : largestDivisor(b, a%b);
    }

    void reduce(){
        if(nominator == 0){
            denominator = 1;
            return;
        }
        long ld = largestDivisor(nominator, denominator);
        nominator /= ld;
        denominator /= ld;
    }

    void sign(){
        if(nominator < 0 && denominator < 0){
            nominator = Math.abs(nominator);
            denominator = Math.abs(denominator);
        }
        else if(nominator < 0 || denominator < 0){
            nominator = -Math.abs(nominator);
            denominator = Math.abs(denominator);
        }
    }

    public long getNominator(){
        return nominator;
    }

    public long getDenominator(){
        return denominator;
    }

    public Fraction fractionalPart(){
        if(Math.abs(nominator) < denominator)
            return this;
        else if(denominator == 1)
            return new Fraction(0, 1);

        long newNominator = nominator % denominator;
        return new Fraction(newNominator, denominator);
    }

    public Fraction plus(Fraction f){
        long newNominator;
        long newDenominator;

        if(denominator == f.getDenominator()){
            newNominator = nominator + f.getNominator();
            newDenominator = denominator;
        }
        else
        {
            newNominator = nominator * f.getDenominator() + f.getNominator() * denominator;
            newDenominator = denominator * f.getDenominator();
        }

        return new Fraction(newNominator, newDenominator);
    }

    public Fraction minus(Fraction f){
        long newNominator;
        long newDenominator;

        if(denominator == f.getDenominator()){
            newNominator = nominator - f.getNominator();
            newDenominator = denominator;
        }
        else
        {
            newNominator = nominator * f.getDenominator() - f.getNominator() * denominator;
            newDenominator = denominator * f.getDenominator();
        }

        return new Fraction(newNominator, newDenominator);
    }

    public Fraction multiply(Fraction f){
        long newNominator = nominator * f.getNominator();
        long newDenominator = denominator * f.getDenominator();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction divide(Fraction f){
        long newNominator = nominator * f.getDenominator();
        long newDenominator = denominator * f.getNominator();
        return new Fraction(newNominator, newDenominator);
    }

    public boolean equals(Fraction f){
        return nominator == f.getNominator() && denominator == f.getDenominator();
    }

    public WholeNumber toWholeNumber(){
        if(denominator != 1)
            throw new RuntimeException("Tod und Verderben!");
        else
            return new WholeNumber(nominator);
    }
}
