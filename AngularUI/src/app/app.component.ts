import { Component } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams, HttpRequest, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "comcastui";
  value = "";
  setOfStrings = [];
  result: any;

  constructor(private http: HttpClient) {

  }

  onSubmit() {
    this.setOfStrings.push({ value: this.value });
    this.value = '';
  }

  sendReq() {
    const options: any = {
      body: {
        "setOfStrings": this.setOfStrings
      },
      responseType: 'json'
    };
    this.http.request("POST", "http://localhost:8081/lcs/", options).subscribe(res => {
      this.result = res;
    }, error => {
      if (error.error) {
        this.result = error.error;
      }
    })
  }
}
