import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SignUpComponent } from '../sign-up/sign-up.component';
import { LogInComponent } from '../log-in/log-in.component';
import { ViewProductsComponent } from '../view-products/view-products.component';
import { HomePageComponent } from '../home-page/home-page.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,SignUpComponent,LogInComponent,ViewProductsComponent,HomePageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'hci-frontend';
}
