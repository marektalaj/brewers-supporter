import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CalculatingService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-efficiency',
  templateUrl: './efficiency.component.html',
  styleUrls: ['./efficiency.component.css']
})
export class EfficiencyComponent implements OnInit {
  submitted = false;
  calculateForm: FormGroup;
  result = 0.0;

  constructor(private calcService: CalculatingService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      amount: [null, [Validators.required, Validators.min(1)]],
      gravity: [null, [Validators.required, Validators.min(1), Validators.max(25)]],
      maltAmount: [null, [Validators.required, Validators.min(1)]]
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate() {
    this.submitted = true;

    if (this.calculateForm.invalid) {
      return;
    }

    this.calcService.mashEfficiency(this.form.amount.value, this.form.gravity.value, this.form.maltAmount.value)
      .subscribe(data => {
        this.result = data;
      });

  }

}
