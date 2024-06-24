package com.piggymetrics.notification.unit.service;

import com.piggymetrics.notification.domain.NotificationSettings;
import com.piggymetrics.notification.domain.NotificationType;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipientServiceImplTest {

    @InjectMocks
    private RecipientServiceImpl service;

    @Mock
    private RecipientRepository mockRepository;

    @Test
    void findByAccountNameUsingMockRepositoryAsStub() {
        //Using mock repository as Stub
        Recipient actual = this.service.findByAccountName("admin");

        assertThat(actual).isNull();
    }

    @Test
    void findByAccountNameUsingMockRepositoryAsMock() {
        //Using mock repository as mock
        Recipient recipient = new Recipient();
        when(this.mockRepository.findByAccountName("admin")).thenReturn(recipient);
        Recipient actual = this.service.findByAccountName("admin");

        assertThat(actual).isEqualTo(recipient);
    }

    @Test
    void markNotifiedWhatIfTheMethodDoNotReturnsNothing(){
        //Arrange
        Recipient recipient = new Recipient();
        recipient.setScheduledNotifications(Map.of(NotificationType.BACKUP,new NotificationSettings()));

        //Act
        this.service.markNotified(NotificationType.BACKUP, recipient);

        //Assertion: Using mock as spy
        verify(this.mockRepository).save(recipient);

        NotificationSettings actual = recipient.getScheduledNotifications().get(BACKUP);
        assertThat(actual.getLastNotified()).isBeforeOrEqualTo(new Date());

    }
}