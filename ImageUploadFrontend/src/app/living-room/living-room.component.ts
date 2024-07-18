import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LivingRoom } from '../models/living-room';
import { LivingroomService } from '../services/livingroom.service';
import { Router } from '@angular/router';
import { MyCartService } from '../services/my-cart.service';
import { MyCart } from '../models/my-cart';

@Component({
  selector: 'app-living-room',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './living-room.component.html',
  styleUrl: './living-room.component.css'
})
export class LivingRoomComponent implements OnInit{
  userType ="default"
  lr:LivingRoom[] = []
  mc :MyCart = new MyCart()
 
  constructor(private lrs:LivingroomService,private router:Router,private mcs:MyCartService){

  }
  ngOnInit(): void {
   this.getAlllr()
   this.getadmindata()
  }


  getAlllr(){
    this.lrs.getAll().subscribe((data:LivingRoom[])=>{
      if(data!=null){
        this.lr=data
      }
    })
  }

  getadmindata(){
    if(localStorage.getItem("aemail")!=null){
      this.userType = "admin"
    }else if(localStorage.getItem("email")!=null){
      this.userType = "user"
    }
  }

  updateEmployee(id:any){
    this.router.navigate(['update', id]);
   
  }
  deleteEmployee(id:any){
    this.lrs.delete(id).subscribe((data=>{
      console.log(data)
      alert("deleted successfully ")
      this.getAlllr()
    }))
  }

  AddToCart(id:any){
    let e = localStorage.getItem("email")
    this.mc.email = e
    // this.mc.pname = this.lr.
    // this.lrs.getbyId(this.id).subscribe((data)=>{
    //   this.lr = data
    // }, error => console.log(error));

    this.lrs.getbyId(id).subscribe((data)=>{
        this.mc.pname = data.productName
        this.mc.pprice = data.price
        this.mc.ptype = data.type
        // alert(JSON.stringify(this.mc))
        
      this.mcs.insert(this.mc).subscribe((data:MyCart)=>{
        if(data!=null){

          alert("Added to mycart")
          // alert(JSON.stringify(this.mc))
        }
      })
      }, error => console.log(error));
    
  }

  buy(bid:any){
    this.router.navigate(['buynow', bid]);
  }
}
