package Part04Package;
public class AgeData implements Comparable{

        protected int age = 0;
        protected int numberOfPeople = 0;

        /**
         * default constructor
         */
        AgeData(){age = 0; numberOfPeople = 0;}

        /**
         * constructor with parameter
         * @param personAge values of age
         */
        AgeData(int personAge){this.age  = personAge ; ++numberOfPeople;}

        /**
         * this function compares age values of particular object with given age values as parameter
         * @param o age to be compared with these objects age value
         * @return returns 0 ifs equal -1 if this.age is smaller than the personAge else 1
         */
        @Override
        public int compareTo(Object o){
                if(this.age == (int)o){
                        return 0;
                }
                else if (this.age > (int) o){
                        return 1;
                }
                else {
                        return -1;
                }
        }

        /**
         * @return returns age + space + numberOfPeople as String values
         */
        public String toString() {
                return String.valueOf(age) + " - "+String.valueOf(numberOfPeople);
        }
}