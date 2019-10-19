import { Component, OnInit } from '@angular/core';
import { CalculatingServiceService } from 'src/app/service/calculating-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-correction',
  templateUrl: './correction.component.html',
  styleUrls: ['./correction.component.css']
})
export class CorrectionComponent implements OnInit {
  calculateForm: FormGroup;
  result = 0.0;
  addWater = true;

  constructor(private calcService: CalculatingServiceService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      amount: null,
      measured: null,
      wanted: null
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate(){
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
