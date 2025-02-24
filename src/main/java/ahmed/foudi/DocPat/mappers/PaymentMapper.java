package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.PaymentDto;
import ahmed.foudi.DocPat.dto.request.PaymentRequest;
import ahmed.foudi.DocPat.dto.response.PaymentResponse;
import ahmed.foudi.DocPat.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    

    Payment toEntity(PaymentRequest request);


    PaymentResponse toResponse(Payment payment);

    PaymentDto toEmbedded(Payment payment);

    List<PaymentResponse> toResponseList(List<Payment> payments);
    List<PaymentDto> toEmbeddedList(List<Payment> payments);
} 