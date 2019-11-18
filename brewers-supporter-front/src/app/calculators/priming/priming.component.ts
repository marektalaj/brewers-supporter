import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CalculatingService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-priming',
  templateUrl: './priming.component.html',
  styleUrls: ['./priming.component.css']
})
export class PrimingComponent implements OnInit {
  submitted = false;
  calculateForm: FormGroup;
  result = 0.0;

  constructor(private calcService: CalculatingService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      carbon: [null, [Validators.required, Validators.min(1)]],
      amount: [null, [Validators.required, Validators.min(1)]],
      temperature: [null, [Validators.required, Validators.min(1)]]
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate() {
    this.submitted = true;

    if (this.calculateForm.invalid) {
      return;
    }

    this.calcService.primingSugar(this.form.carbon.value, this.form.amount.value, this.form.temperature.value)
      .subscribe(data => {
        this.result = data;
      });

  }

}

