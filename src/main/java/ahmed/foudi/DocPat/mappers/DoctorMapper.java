package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.request.DoctorRequest;
import ahmed.foudi.DocPat.dto.response.DoctorResponse;
import ahmed.foudi.DocPat.entities.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    

    Doctor toEntity(DoctorRequest request);

    DoctorResponse toResponse(Doctor dto);
    List<DoctorResponse> toResponseList(List<Doctor> doctors);
    DoctorDto toEmbedded(Doctor entity);
} 