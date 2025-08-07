package ahmed.foudi.DocPat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Provider {
    @Id
    private Long id;

    private String ProviderName;

    private String ProviderAddress;
    private String ProviderCity;
    private String ProviderState;
    private String ProviderZip;
    private String ProviderEmail;
    private String ProviderPhone;
    private String ProviderFax;
    private String ProviderWebsite;
    private String ProviderDescription;



}
