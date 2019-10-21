import { FormGroup, FormBuilder } from '@angular/forms';
import { CalculatingService } from './../../service/calculating-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-refactometer',
  templateUrl: './refactometer.component.html',
  styleUrls: ['./refactometer.component.css']
})
export class RefactometerComponent implements OnInit {

  calculateForm: FormGroup;
  result = 0.0;

  constructor(private calcService: CalculatingService,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.calculateForm = this.formBuilder.group({
      originalGravity: null,
      finalGravity: null
    });
  }

  get form() { return this.calculateForm.controls; }

  calculate() {
    console.log(this.form.originalGravity.value , this.form.finalGravity.value);
    this.calcService.refactometerCorrection(this.form.originalGravity.value , this.form.finalGravity.value)
    .subscribe( data => {
      this.result = data;
    },
    error => console.log(error)
    );

  }

}
