package com.basic.RESTautomationtraining.POJODeserialization;


    public class GetCoursesMainPojo {

        //Deserializaion will happen by using getters i.e will convert the json and store in java obj; declare all the variable(json keys) and add getter setter
        //Json={"instructor":"RahulShetty","url":"rahulshettycademy.com","services":"projectSupport","expertise":"Automation","courses":{"webAutomation":[{"courseTitle":"Selenium Webdriver Java","price":"50"},{"courseTitle":"Cypress","price":"40"},{"courseTitle":"Protractor","price":"40"}],"api":[{"courseTitle":"Rest Assured Automation using Java","price":"50"},{"courseTitle":"SoapUI Webservices testing","price":"40"}],"mobile":[{"courseTitle":"Appium-Mobile Automation using Java","price":"50"}]},"linkedIn":"https://www.linkedin.com/in/rahul-shetty-trainer/"}

        private String url;
        private String services;
        private String expertise;
        private Courses Courses; //mini json of courses is created inside Courses class, so 1stly will get value of mini json then that will be returned to main object

        private String instructor;
        private String linkedIn;



        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getServices() {
            return this.services;
        }

        public void setServices(String services) {
            this.services = services;
        }

        public String getExpertise() {
            return this.expertise;
        }

        public void setExpertise(String expertise) {
            this.expertise = expertise;
        }

        public Courses getCourses() { //the return type is changed as we are getting mini json from Courses class
            return this.Courses;
        }

        public void setCourses(Courses courses) { // here 1st Courses obj will get created then the value will be set
            this.Courses = courses;
        }

        public String getInstructor() {
            return this.instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public String getLinkedIn() {
            return this.linkedIn;
        }

        public void setLinkedIn(String linkedIn) {
            this.linkedIn = linkedIn;
        }
    }
