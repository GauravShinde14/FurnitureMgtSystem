import { Component, OnInit } from '@angular/core';
import { LivingRoom } from '../models/living-room';
import { LivingroomService } from '../services/livingroom.service';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-update',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent implements OnInit {
  selectedFile: File | null = null;
  lr:LivingRoom = new LivingRoom()
id: any

  constructor(private lrs:LivingroomService,private activatedroute:ActivatedRoute,private router:Router){

  }
  ngOnInit(): void {
    this.id = this.activatedroute.snapshot.params['id'];
    this.lrs.getbyId(this.id).subscribe((data)=>{
      this.lr = data
    }, error => console.log(error));
  }


  submitdata() {
    const formData: FormData = new FormData();
    formData.append('productName', this.lr.productName);
    formData.append('price', this.lr.price);
    formData.append('type', this.lr.type);
    if (this.selectedFile) {
      formData.append('image', this.selectedFile);
    }

    this.lrs.update(formData,this.id).subscribe((data:LivingRoom)=>{
      alert("updated")
    },error =>console.log(error))
    // this.lrs.update(formData,this.id).subscribe(
    //   (response) => {
    //     console.log('Update successful', response);
    //     this.router.navigate(['/livingroom']); // Adjust the route as needed
    //   },
    //   (error) => {
    //     console.error('Update failed', error);
    //   }
    // );
  }


  
 onFileChange(event: any) {
  this.selectedFile = event.target.files[0];
}
}
