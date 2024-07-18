import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [RouterLink,CommonModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent implements OnInit {

  usertype = "guest"

  constructor(private router:Router){
    
  }
  ngOnInit(): void {
   
    this.router.events.subscribe((val:any)=>{
      if(val.url){
        let e=localStorage.getItem("email")
        console.log("email="+e)
        if(e!=null)
          {
            this.usertype="user"
          }
          else
          {
            
            let ae=localStorage.getItem("aemail")
            console.log("aemail="+ae)
                if(ae!=null)
                  this.usertype="admin"
                else
                  this.usertype="guest"
          }


      }
    })
  }
  adminlogout(){
    alert("admin logout")
    localStorage.removeItem("aemail")
 
this.router.navigate(["home"])
  }

  logout(){
    alert("user logout")
    localStorage.removeItem("email")
 
    this.router.navigate(["home"])
  }

}
