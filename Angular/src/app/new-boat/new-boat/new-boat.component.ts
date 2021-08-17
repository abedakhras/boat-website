import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { catchError, tap } from 'rxjs/operators';
import { throwError, BehaviorSubject } from 'rxjs';
import { Boat,BoatModel,Shipyard } from '@app/_models';
import { BoatsService } from '@app/_services/boats.service';


@Component({
  selector: 'boats-new-boat',
  templateUrl: './new-boat.component.html',
  styleUrls: ['./new-boat.component.css']
})
export class NewBoatComponent implements OnInit {
  newBoatForm: FormGroup;
  submitted = false;
  boatUrl: string="http://localhost:8080/boat";
  
  constructor(private boatsService: BoatsService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.newBoatForm = this.formBuilder.group({
      name: ['', Validators.required],
      shipyardName: ['', Validators.required],
      shipyardCountry: ['', Validators.required],
      model: ['', [Validators.required]],
      year: ['', Validators.required],
      size: ['', [Validators.required, Validators.pattern('[0-9]+')] ],
      type: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.newBoatForm.controls; }

  onReset() {
    this.submitted = false;
    this.newBoatForm.reset();
  }
  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    if (!errorRes.error || !errorRes.error.error) {
      return throwError(errorMessage);
    }
    return throwError(errorMessage);
  }
  onSubmit() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.newBoatForm.invalid) {
        return;
    }
    let formV=this.newBoatForm.controls
    let newBoat = new Boat(formV.name.value,formV.shipyardCountry.value,formV.shipyardName.value,formV.model.value,formV.year.value,formV.size.value,formV.type.value);
    this.boatsService.addBoat(newBoat).subscribe((res)=>{
      console.log(res)
    })
 
    alert('onSubmit Method not implemented!');
  }
}
