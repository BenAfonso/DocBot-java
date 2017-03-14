package models;

import java.util.*;

/**
 * @author BenAfonso
 */
public class Hour {

    /**
     * Default constructor
     */
    public Hour() {
    }

    /**
     * 
     */
    public String hour;


    /**
     * @author BenAfonso
     */
    public class Disponibility {

        /**
         * Default constructor
         */
        public Disponibility() {
        }

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