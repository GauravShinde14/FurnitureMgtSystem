import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LivingRoomComponent } from './living-room/living-room.component';
import { AddFurnitureComponent } from './add-furniture/add-furniture.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UpdateComponent } from './update/update.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

import { MycartComponent } from './mycart/mycart.component';
import { BuynowComponent } from './buynow/buynow.component';
import { OrdersComponent } from './orders/orders.component';

export const routes: Routes = [
    
    {path:"livingroom",component:LivingRoomComponent},
    {path:"",component:HomeComponent},
    {path:"home",component:HomeComponent},
    {path:"add",component:AddFurnitureComponent},
    {path:"adminLogin",component:AdminLoginComponent},
    {path:"update/:id",component:UpdateComponent},
    {path:"register",component:RegisterComponent},
    {path:"login",component:LoginComponent},
    {path:"mycart",component:MycartComponent},
    {path:"buynow/:id",component:BuynowComponent},
    {path:"orders",component:OrdersComponent}

];
