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

import java.util.Map;

import static com.piggymetrics.notification.domain.NotificationType.BACKUP;

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

        this.service.markNotified(BACKUP,recepient);
    }
}