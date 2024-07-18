import { Component } from '@angular/core';
import { Register } from '../models/register';
import { RegisterService } from '../services/register.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
lg:Register = new Register()

constructor(private rs:RegisterService,private router:Router){

}

submitdata(){
this.rs.getLogin(this.lg.email,this.lg.password).subscribe((data:Register)=>{
  if(data!=null){
    alert("user login successfull")
    localStorage.setItem("email",data.email)
    this.router.navigate(["home"])
  }
})
}
}
