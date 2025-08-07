package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.request.DoctorRequest;
import ahmed.foudi.DocPat.dto.response.DoctorResponse;
import ahmed.foudi.DocPat.entities.Agent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    

    Agent toEntity(DoctorRequest request);

    DoctorResponse toResponse(Agent dto);
    List<DoctorResponse> toResponseList(List<Agent> doctors);
    DoctorDto toEmbedded(Agent entity);
} 