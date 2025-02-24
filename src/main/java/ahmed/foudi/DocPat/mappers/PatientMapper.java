package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.PatientDto;
import ahmed.foudi.DocPat.dto.request.PatientRequest;
import ahmed.foudi.DocPat.dto.response.PatientResponse;
import ahmed.foudi.DocPat.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    

    Patient toEntity(PatientRequest request);

    PatientResponse toResponse(Patient patient);
    PatientDto toEmbedded(Patient patient);

    List<PatientResponse> toResponseList(List<Patient> patients);
    List<PatientDto> toEmbeddedList(List<Patient> patients);


} 