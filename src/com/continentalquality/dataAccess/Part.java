package com.continentalquality.dataAccess;

    public class Part {

        private String partNumber;
        private String partDescription;
        private String partPackaging;
        private int partPartPerBox;
        private int partBoxPerSkid;
        private double partWeightPerBox;
        private int partWeightClass;
        private String partComment;


        public String getPartNumber() {
            return partNumber;
        }
        public void setPartNumber(String partNumber) {
            this.partNumber = partNumber;
        }
        public String getPartDescription() {
            return partDescription;
        }
        public void setPartDescription(String partDescription) {
            this.partDescription = partDescription;
        }
        public String getPartPackaging() {
            return partPackaging;
        }
        public void setPartPackaging(String partPackaging) {
            this.partPackaging = partPackaging;
        }
        public int getPartPartPerBox() {
            return partPartPerBox;
        }
        public void setPartPartPerBox(int partPartPerBox) {
            this.partPartPerBox = partPartPerBox;
        }
        public int getPartBoxPerSkid() {
            return partBoxPerSkid;
        }
        public void setPartBoxPerSkid(int partBoxPerSkid) {
            this.partBoxPerSkid = partBoxPerSkid;
        }
        public double getPartWeightPerBox() {
            return partWeightPerBox;
        }
        public void setPartWeightPerBox(double partWeightPerBox) {
            this.partWeightPerBox = partWeightPerBox;
        }
        public int getPartWeightClass() {
            return partWeightClass;
        }
        public void setPartWeightClass(int partWeightClass) {
            this.partWeightClass = partWeightClass;
        }
        public String getPartComment() {
            return partComment;
        }
        public void setPartComment(String partComment) {
            this.partComment = partComment;
        }




    }
