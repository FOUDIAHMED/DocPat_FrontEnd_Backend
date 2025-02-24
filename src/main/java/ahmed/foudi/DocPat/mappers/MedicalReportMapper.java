package ahmed.foudi.DocPat.mappers;


import ahmed.foudi.DocPat.dto.embedded.MedicalReportDto;
import ahmed.foudi.DocPat.dto.request.MedicalReportRequest;
import ahmed.foudi.DocPat.dto.response.MedicalReportResponse;
import ahmed.foudi.DocPat.entities.MedicalReport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalReportMapper {
    

    MedicalReport toEntity(MedicalReportRequest request);


    MedicalReportResponse toResponse(MedicalReport medicalReport);

    MedicalReportDto toEmbedded(MedicalReport medicalReport);

    List<MedicalReportResponse> toResponseList(List<MedicalReport> medicalReports);
    List<MedicalReportDto> toEmbeddedList(List<MedicalReport> medicalReports);
} 