import { Component, OnInit } from '@angular/core';
import { CalculatingService } from 'src/app/service/calculating-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-correction',
  templateUrl: './correction.component.html',
  styleUrls: ['./correction.component.css']
})
export class CorrectionComponent implements OnInit {
  submitted = false;
  calculateForm: FormGroup;
  result = 0.0;
  addWater = true;

  constructor(private calcService: CalculatingService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      amount: [null, [Validators.required, Validators.min(1)]],
      measured: [null, [Validators.required, Validators.min(1), Validators.max(25)]],
      wanted: [null, [Validators.required, Validators.min(1), Validators.max(25)]]
    });
  }

  get form() { return this.calculateForm.controls; }



  calculate(){

    this.submitted = true;

    if(this.calculateForm.invalid){
      return;
    }
    
    if(this.form.measured.value < this.form.wanted.value){
      this.addWater = false;
    } else {
      this.addWater = true;
    }

    this.calcService.wortCorrection(this.form.amount.value , this.form.measured.value, this.form.wanted.value)
    .subscribe( data => {
      this.result = data;
    });

  }

}
