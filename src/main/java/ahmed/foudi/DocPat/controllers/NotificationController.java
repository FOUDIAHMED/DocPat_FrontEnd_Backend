package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.response.NotificationResponse;
import ahmed.foudi.DocPat.entities.Notification;
import ahmed.foudi.DocPat.services.interfaces.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
//        return ResponseEntity.ok(notificationService.findByUserId(userId));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.save(notification));
    }

//    @PutMapping("/{id}/read")
//    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
//        Notification notification = notificationService.findById(id);
//        notification.setRead(true);
//        return ResponseEntity.ok(notificationService.save(notification));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}