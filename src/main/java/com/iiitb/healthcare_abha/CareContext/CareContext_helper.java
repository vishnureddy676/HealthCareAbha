package com.iiitb.healthcare_abha.CareContext;

public class CareContext_helper {


        private String requestId;
        private String timestamp;
        Link LinkObject;


        // Getter Methods

        public String getRequestId() {
            return requestId;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public Link getLink() {
            return LinkObject;
        }

        // Setter Methods

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public void setLink(Link linkObject) {
            this.LinkObject = linkObject;
        }
    }


