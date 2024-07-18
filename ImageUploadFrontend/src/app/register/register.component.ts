import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Register } from '../models/register';
import { RegisterService } from '../services/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  r:Register = new Register()

  constructor(private rs: RegisterService,private router:Router){

  }

  submitdata(){
    this.rs.insert(this.r).subscribe((data:Register)=>{
      if(data!=null){
        alert("user registered successfully")
        this.router.navigate(["login"])
      }
    })
  }
}
