package com.example.z_chao.jpushdemo;

import java.util.List;

/**
 * Created by Z-chao on 2017/3/8 23:03
 */

public class PushBean {
    public PushBean(String platform, AudienceBean audience, NotificationBean notification) {
        this.platform = platform;
        this.audience = audience;
        this.notification = notification;
    }

    /**
     * platform : all
     * audience : {"tag":["深圳","广州","北京"]}
     * notification : {"alert":"Hi, JPush!"}
     */

    private String platform;
    private AudienceBean audience;
    private NotificationBean notification;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public AudienceBean getAudience() {
        return audience;
    }

    public void setAudience(AudienceBean audience) {
        this.audience = audience;
    }

    public NotificationBean getNotification() {
        return notification;
    }

    public void setNotification(NotificationBean notification) {
        this.notification = notification;
    }

    public static class AudienceBean {
        public AudienceBean(List<String> tag) {
            this.tag = tag;
        }

        private List<String> tag;

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }
    }

    public static class NotificationBean {
        public NotificationBean(String alert) {
            this.alert = alert;
        }

        /**
         * alert : Hi, JPush!
         */

        private String alert;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }
    }
}
