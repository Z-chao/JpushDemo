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
     * audience : {"tag":["bbb"]}
     * notification : {"alert":"从接口上做的 推送   推送给  用户 能收到吗!","android":{}}
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

        @Override
        public String toString() {
            return "AudienceBean{" +
                    "tag=" + tag +
                    '}';
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
        public NotificationBean(String alert, AndroidBean android) {
            this.alert = alert;
            this.android = android;
        }

        @Override
        public String toString() {
            return "NotificationBean{" +
                    "alert='" + alert + '\'' +
                    ", android=" + android +
                    '}';
        }

        /**
         * alert : 从接口上做的 推送   推送给  用户 能收到吗!
         * android : {}
         */

        private String alert;
        private AndroidBean android;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public AndroidBean getAndroid() {
            return android;
        }

        public void setAndroid(AndroidBean android) {
            this.android = android;
        }

        public static class AndroidBean {
            public AndroidBean() {
            }
        }
    }
}
