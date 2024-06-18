package com.piggymetrics.notification.unit.domain;

import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
import com.piggymetrics.notification.domain.Recipient;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RecipientTest {
    @Test
    void addingNewScheduledNotifications(){
        Recipient recipient = new Recipient();

        recipient.setScheduledNotifications(Map.of(NotificationType.BACKUP,new NotificationSettings()));

        assertThat(recipient.getScheduledNotifications().get(NotificationType.BACKUP)).isNotNull();
    }

    @Test
    void addingNewScheduledNotificationsWeirdWay(){
        Recipient recipient = new Recipient();
        recipient.setAccountName("account name");
        recipient.setEmail("em@ma.il");

        recipient.setScheduledNotifications(new HashMap<>());
        recipient.getScheduledNotifications().put(NotificationType.BACKUP,new NotificationSettings());

        assertThat(recipient.getScheduledNotifications().get(NotificationType.BACKUP)).isNotNull();
    }
}