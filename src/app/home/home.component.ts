import { CommonModule } from "@angular/common"
import { Component } from "@angular/core"
import { FormsModule } from "@angular/forms"
import { NavbarComponent } from "../layouts/navbar/navbar.component"

interface Doctor {
  name: string
  speciality: string
  image: string
}

interface Service {
  icon: string
  title: string
  description: string
}

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
  imports:[CommonModule,FormsModule,NavbarComponent]
})
export class HomeComponent {
  doctors: Doctor[] = [
    {
      name: "Dr. Sarah Johnson",
      speciality: "Cardiologist",
      image: "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-69Kc6O2jiD0vgVjZxPi73NOrNuMw9Q.png",
    },
    {
      name: "Dr. Michael Chen",
      speciality: "Neurologist",
      image: "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-69Kc6O2jiD0vgVjZxPi73NOrNuMw9Q.png",
    },
    {
      name: "Dr. Emily Williams",
      speciality: "Pediatrician",
      image: "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-69Kc6O2jiD0vgVjZxPi73NOrNuMw9Q.png",
    },
    {
      name: "Dr. James Wilson",
      speciality: "Orthopedic Surgeon",
      image: "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-69Kc6O2jiD0vgVjZxPi73NOrNuMw9Q.png",
    },
  ]

  services: Service[] = [
    {
      icon: "heart",
      title: "Cardiology",
      description: "Expert heart care and cardiovascular treatments",
    },
    {
      icon: "brain",
      title: "Neurology",
      description: "Specialized care for neurological conditions",
    },
    {
      icon: "bone",
      title: "Orthopedics",
      description: "Complete bone and joint care services",
    },
    {
      icon: "eye",
      title: "Ophthalmology",
      description: "Complete eye care and treatments",
    },
    {
      icon: "tooth",
      title: "Dental Care",
      description: "Complete dental and oral health services",
    },
    {
      icon: "stethoscope",
      title: "General Medicine",
      description: "Primary healthcare and medical services",
    },
  ]

  features: Service[] = [
    {
      icon: "calendar",
      title: "Easy Scheduling",
      description: "Book appointments online anytime",
    },
    {
      icon: "clock",
      title: "24/7 Service",
      description: "Round-the-clock medical support",
    },
    {
      icon: "ambulance",
      title: "Emergency Care",
      description: "Immediate medical attention",
    },
    {
      icon: "user-md",
      title: "Expert Doctors",
      description: "Experienced medical professionals",
    },
  ]

  onSubmit(form: any) {
    console.log("Form submitted:", form.value)
  }
}

