import { Component } from '@angular/core';
import { AppService } from './app.service';
import { MatInputModule } from "@angular/material/input";
import { Observable, takeUntil } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],

})
export class AppComponent {
  title = 'Wise Step';

  //input
  originalURL!: string;
  newURL: string ="";
  shortUrl!: string;


  constructor(private appService: AppService) { }

  shortenURL(originalURL: HTMLInputElement, country: HTMLSelectElement): void {
    console.log(`${originalURL.value}  ${country.value}`);
    this.newURL = "";

    const payload = {
      "location": country.value,
      "originalUrl": originalURL.value
    }

    this.appService.urlShortner(payload).subscribe((response) => {
      this.newURL = response.body;
    }
  );

  }




}
