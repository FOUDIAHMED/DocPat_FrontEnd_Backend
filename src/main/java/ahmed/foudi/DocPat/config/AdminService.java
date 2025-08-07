package ahmed.foudi.DocPat.config;

import ahmed.foudi.DocPat.dao.AdminRepository;
import ahmed.foudi.DocPat.entities.Admin;
import ahmed.foudi.DocPat.entities.enums.AppRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createDefaultAdmin() {
        Optional<Admin> existingAdmin = adminRepository.findByEmail("admin@example.com");

        if (existingAdmin.isEmpty()) {
            Admin admin = new Admin();
            admin.setFirstName("Admin");
            admin.setLastName("Admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setPhoneNumber("0612345678");
            admin.setAppRole(AppRole.ADMIN);

            adminRepository.save(admin);
            System.out.println("✅ Default admin created successfully!");
        } else {
            System.out.println("⚠️ Admin already exists, skipping creation.");
        }
    }
}
