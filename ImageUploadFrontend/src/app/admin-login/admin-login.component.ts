import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AdminLogin } from '../models/admin-login';
import { AdminloginService } from '../services/adminlogin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {

  ad : AdminLogin = new AdminLogin()

  constructor(private as:AdminloginService,private router:Router){

  }


  submitdata(){
    this.as.getAdmin(this.ad.email,this.ad.password).subscribe((data:AdminLogin)=>{
      if(data!= null){
        alert("admin login successfull")
        localStorage.setItem("aemail",data.email)
        this.router.navigate(["home"])

      }
    })
  }

}
