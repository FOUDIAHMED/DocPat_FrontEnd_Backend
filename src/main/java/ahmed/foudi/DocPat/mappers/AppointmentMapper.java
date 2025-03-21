package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.AppointementDto;
import ahmed.foudi.DocPat.dto.request.AppointmentRequest;
import ahmed.foudi.DocPat.dto.response.AppointmentResponse;
import ahmed.foudi.DocPat.entities.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper  {
    
    @Mapping(target = "patient.id" ,source = "patientId")
    @Mapping(target = "doctor.id" , source = "doctorId")
    Appointment toEntity(AppointmentRequest request);


    AppointmentResponse toResponse(Appointment appointment);

    AppointementDto toEmbedded(Appointment appointment);

    List<AppointmentResponse> toResponseList(List<Appointment> appointements);
    List<AppointementDto> toEmbeddedList(List<Appointment> appointements);
} 