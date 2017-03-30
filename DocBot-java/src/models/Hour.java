package models;

/**
 * @author BenAfonso
 */
public class Hour {

    /**
     *
     */
    public String hour;

    /**
     * Default constructor
     */
    public Hour() {
    }

    /**
     * @author BenAfonso
     */
    public class Disponibility {

        /**
         *
         */
        public int id;
        /**
         *
         */
        public Hour hourStart;
        /**
         *
         */
        public Hour hourEnd;
        /**
         *
         */
        public String description;
        /**
         *
         */
        public boolean isBooked;

        /**
         * Default constructor
         */
        public Disponibility() {
        }

        /**
         * @author BenAfonso
         */
        public class RequestAppointment {

            /**
             * Default constructor
             */
            public RequestAppointment() {
            }


        }

    }

}