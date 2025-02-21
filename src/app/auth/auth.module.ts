import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormGroup } from '@angular/forms';



@NgModule({
  declarations: [LoginComponent,RegisterComponent],
  imports: [
    CommonModule,LoginComponent,RegisterComponent
  ]
})
export class AuthModule { }
