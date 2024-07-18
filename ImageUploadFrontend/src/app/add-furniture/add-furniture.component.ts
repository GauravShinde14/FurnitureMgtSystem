import { Component } from '@angular/core';
import { LivingRoom } from '../models/living-room';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LivingroomService } from '../services/livingroom.service';

@Component({
  selector: 'app-add-furniture',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-furniture.component.html',
  styleUrl: './add-furniture.component.css'
})
export class AddFurnitureComponent {

 lr:LivingRoom =  new LivingRoom()
 selectedFile: File | null = null;

 constructor(private lrs: LivingroomService) {}

 onFileChange(event: any) {
   this.selectedFile = event.target.files[0];
 }

 submitdata() {
  console.log(this.selectedFile);
   if (this.selectedFile) {
     const formData: FormData = new FormData();
    
     formData.append('productName', this.lr.productName);
     formData.append('price', this.lr.price);
     formData.append('type', this.lr.type);
     formData.append('image', this.selectedFile);

     this.lrs.insert(formData).subscribe((data: LivingRoom) => {
       if (data != null) {
         alert('Furniture added successfully');
       }
     });
   } else {
     alert('Please select an image to upload.');
   }
 }


}
