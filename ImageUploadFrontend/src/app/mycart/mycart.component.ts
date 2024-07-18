import { Component, OnInit } from '@angular/core';
import { MyCart } from '../models/my-cart';
import { MyCartService } from '../services/my-cart.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mycart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mycart.component.html',
  styleUrl: './mycart.component.css'
})
export class MycartComponent implements OnInit {
mc:MyCart[] = []
e = localStorage.getItem("email")
constructor(private mcs:MyCartService,private router:Router){

}
  ngOnInit(): void {
    this.mcs.getByEmail(this.e).subscribe((data:MyCart[])=>{
      if(data!=null){
        this.mc = data
      }
    })
  }
  buy(cid:any){
    this.router.navigate(['buynow', cid]);
  }

}
