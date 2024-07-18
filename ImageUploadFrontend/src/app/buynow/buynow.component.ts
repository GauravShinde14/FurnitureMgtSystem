import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Buynow } from '../models/buynow';
import { BuynowService } from '../services/buynow.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MyCartService } from '../services/my-cart.service';
import { LivingroomService } from '../services/livingroom.service';

@Component({
  selector: 'app-buynow',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './buynow.component.html',
  styleUrl: './buynow.component.css'
})
export class BuynowComponent implements OnInit{
  by:Buynow[] = []
  bn :Buynow = new Buynow()
  id: any
  bid:any
  constructor(private bns:BuynowService,private router:Router,private activatedroute:ActivatedRoute,private mcs:MyCartService,private lrs:LivingroomService){}

  
  ngOnInit(): void {
    this.id = this.activatedroute.snapshot.params['id'];
    this.mcs.getByid(this.id).subscribe((data=>{
      if(data!=null){
        this.bn.bname = data.pname
        this.bn.bprice = data.pprice
        this.bn.btype = data.ptype
        this.bn.bemail = data.email
        // alert(JSON.stringify(this.bn))
        // alert(JSON.stringify(data))
      }
    }))


    this.bid = this.activatedroute.snapshot.params['id']
    let e = localStorage.getItem("email")
    this.lrs.getbyId(this.bid).subscribe(data=>{
      if(data!=null){
        this.bn.bname = data.productName
        this.bn.bprice = data.price
        this.bn.btype = data.type
        this.bn.bemail = e
        // alert(JSON.stringify(this.bn))
        // alert(JSON.stringify(data))
      }
    })
    
  }
  submitdata(){
    this.bns.insert(this.bn).subscribe((data:Buynow)=>{
      if(data!=null){
        alert("Order placed successfully")
        this.router.navigate(["home"])
      }
    })
  }
}
