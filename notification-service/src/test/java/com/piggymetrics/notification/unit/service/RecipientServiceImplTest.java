package com.piggymetrics.notification.unit.service;

import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.Recipient;
import com.piggymetrics.notification.repository.RecipientRepository;
import com.piggymetrics.notification.service.RecipientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Map;

import static com.piggymetrics.notification.domain.NotificationType.BACKUP;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unused")
@ExtendWith(MockitoExtension.class)
class RecipientServiceImplTest {

    @InjectMocks
    private RecipientServiceImpl service;

    @Mock
    private RecipientRepository repository;

    @Test
    void markNotified() {
        Recipient recepient = new Recipient();
        recepient.setScheduledNotifications(Map.of(BACKUP,new NotificationSettings()));

        assertThat(recepient.getScheduledNotifications().get(BACKUP).getLastNotified()).isNull();


        this.service.markNotified(BACKUP,recepient);


        NotificationSettings actual = recepient.getScheduledNotifications().get(BACKUP);

        assertThat(actual.getLastNotified()).isBeforeOrEqualTo(new Date());
    }
}