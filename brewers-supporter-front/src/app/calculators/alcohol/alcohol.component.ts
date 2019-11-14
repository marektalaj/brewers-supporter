import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalculatingService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-alcohol',
  templateUrl: './alcohol.component.html',
  styleUrls: ['./alcohol.component.css']
})
export class AlcoholComponent implements OnInit {

  submitted = false;
  calculateForm: FormGroup;
  result = 0.0;

  constructor(private calcService: CalculatingService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      originalGravity: [null, [Validators.required, Validators.min(1), Validators.max(25)]],
      finalGravity: [null, [Validators.required, Validators.min(1), Validators.max(25)]]
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate() {

    this.submitted = true;

    if (this.calculateForm.invalid) {
      return;
    }
    
    this.calcService.alcoholCalculation(this.form.originalGravity.value, this.form.finalGravity.value)
      .subscribe(data => {
        this.result = data;
      });

  }

}
