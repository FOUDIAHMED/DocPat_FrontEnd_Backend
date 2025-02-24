package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.NotificationDto;
import ahmed.foudi.DocPat.dto.request.NotificationRequest;
import ahmed.foudi.DocPat.dto.response.NotificationResponse;
import ahmed.foudi.DocPat.entities.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    

    Notification toEntity(NotificationRequest request);


    NotificationResponse toResponse(Notification notification);

    NotificationDto toEmbedded(Notification notification);

    List<NotificationResponse> toResponseList(List<Notification> notifications);
    List<NotificationDto> toEmbeddedList(List<Notification> notifications);
} 