import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-footer',
  imports: [CommonModule,RouterModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  currentYear = new Date().getFullYear();
  
  // These could be loaded from a service in a real application
  quickLinks = [
    { name: 'Find a Doctor', url: '/doctors' },
    { name: 'Services', url: '/services' },
    { name: 'Appointments', url: '/appointments' },
    { name: 'Patient Portal', url: '/portal' },
    { name: 'Emergency Care', url: '/emergency' }
  ];
  
  patientResources = [
    { name: 'Medical Records', url: '/records' },
    { name: 'Insurance Information', url: '/insurance' },
    { name: 'Billing & Payments', url: '/billing' },
    { name: 'Patient Forms', url: '/forms' },
    { name: 'FAQs', url: '/faqs' }
  ];
  
  aboutLinks = [
    { name: 'About Us', url: '/about' },
    { name: 'Our Team', url: '/team' },
    { name: 'Careers', url: '/careers' },
    { name: 'News & Events', url: '/news' },
    { name: 'Contact Us', url: '/contact' }
  ];
  
  socialLinks = [
    { name: 'Facebook', url: 'https://facebook.com', icon: 'fa-facebook-f' },
    { name: 'Twitter', url: 'https://twitter.com', icon: 'fa-twitter' },
    { name: 'Instagram', url: 'https://instagram.com', icon: 'fa-instagram' },
    { name: 'LinkedIn', url: 'https://linkedin.com', icon: 'fa-linkedin-in' },
    { name: 'YouTube', url: 'https://youtube.com', icon: 'fa-youtube' }
  ];

}
