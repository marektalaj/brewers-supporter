import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CalculatingService } from './../../service/calculating-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-refactometer',
  templateUrl: './refactometer.component.html',
  styleUrls: ['./refactometer.component.css']
})
export class RefactometerComponent implements OnInit {

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
    this.calcService.refactometerCorrection(this.form.originalGravity.value, this.form.finalGravity.value)
      .subscribe(data => {
        this.result = data;
      },
        error => window.alert("Błąd serwera: " + error));
    ;

  }

}
