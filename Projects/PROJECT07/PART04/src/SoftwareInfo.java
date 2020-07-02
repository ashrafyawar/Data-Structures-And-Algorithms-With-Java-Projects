public class SoftwareInfo implements Comparable {
    private String SoftwareNameAndVersion = null;
    private  int SoftwarePrice = 0;
    private int SoftwareQuantity = 0;

     public SoftwareInfo(){
        this.SoftwareNameAndVersion = null;
        this.SoftwarePrice = 0;
        this.SoftwareQuantity += 1;
    }

    public SoftwareInfo(String SoftwareNameAndVersion,int SoftwarePrice,int SoftwareQuantity){
        this.SoftwareNameAndVersion = SoftwareNameAndVersion;
        this.SoftwarePrice = SoftwarePrice;
        this.SoftwareQuantity = SoftwareQuantity;
    }

    public String getSoftwareNameAndVersion() {
        return SoftwareNameAndVersion;
    }

    public void setSoftwareNameAndVersion(String softwareNameAndVersion) { SoftwareNameAndVersion = softwareNameAndVersion; }

    public int getSoftwarePrice() {
        return SoftwarePrice;
    }

    public void setSoftwarePrice(int softwarePrice) {
        SoftwarePrice = softwarePrice;
    }

    public int getSoftwareQuantity() {
        return SoftwareQuantity;
    }

    public void setSoftwareQuantity(int softwareQuantity) {
        SoftwareQuantity = softwareQuantity;
    }
    public void incrementQuantity(int a){ this.SoftwareQuantity += a;}
    public  void decrementQuantity(int a){ this.SoftwareQuantity  = this.SoftwareQuantity - a;}

    //this porsion is take from geeksforgeeks
    private int compareString(String str, String argumentString) {

        int lim= Math.min(str.length(), argumentString.length());

        int k=0;
        while(k<lim) {
            if(str.charAt(k)!= argumentString.charAt(k)) {
                return (int) str.charAt(k)- argumentString.charAt(k);
            }
            k++;
        }
        return str.length() - argumentString.length();
    }

    @Override
    public String toString() {
        return getSoftwareNameAndVersion();
    }

    public String printSoft(){return"Software Name: "+ this.SoftwareNameAndVersion +"  Software Price: "+ this.SoftwarePrice +"$   Software Quantity: "+ this.SoftwareQuantity;}

    @Override
    public int compareTo(Object o) {
        return compareString(this.getSoftwareNameAndVersion(),o.toString());
     }
}