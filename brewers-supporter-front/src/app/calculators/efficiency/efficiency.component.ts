import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CalculatingServiceService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-efficiency',
  templateUrl: './efficiency.component.html',
  styleUrls: ['./efficiency.component.css']
})
export class EfficiencyComponent implements OnInit {

  calculateForm: FormGroup;
  result = 0.0;

  constructor(private calcService: CalculatingServiceService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      amount: null,
      gravity: null,
      maltAmount: null
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate(){
    this.calcService.mashEfficiency(this.form.amount.value , this.form.gravity.value, this.form.maltAmount.value)
    .subscribe( data => {
      this.result = data;
    });

  }

}
