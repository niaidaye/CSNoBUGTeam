package src.homework.day7;

/*
 * @Description:
 * @Author: LN
 *  @Date : 2023/11/16
 */

    // 证券交易人
    public class Trader {
        private String name;
        private String city;

        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        @Override
        public String toString() {
            return "{" +
                    "" + name +
                    ", " + city +
                    '}';
        }
    }



