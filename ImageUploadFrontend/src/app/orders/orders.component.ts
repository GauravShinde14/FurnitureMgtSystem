import { Component } from '@angular/core';
import { Buynow } from '../models/buynow';
import { BuynowService } from '../services/buynow.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent {
  bn:Buynow[] = []
  e = localStorage.getItem("email")
  constructor(private bns:BuynowService,private router:Router){
  
  }
    ngOnInit(): void {
      this.bns.getALL().subscribe((data:Buynow[])=>{
        if(data!=null){
          this.bn = data
        }
      })
    }
   
  
}
