package ahmed.foudi.DocPat.mappers;

import ahmed.foudi.DocPat.dto.request.RatingRequest;
import ahmed.foudi.DocPat.dto.response.RatingResponse;
import ahmed.foudi.DocPat.entities.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    

    Rating toEntity(RatingRequest request);

    RatingResponse toResponse(Rating rating);
    List<RatingResponse> toResponseList(List<Rating> ratings);

} 