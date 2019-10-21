import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CalculatingService } from 'src/app/service/calculating-service.service';

@Component({
  selector: 'app-alcohol',
  templateUrl: './alcohol.component.html',
  styleUrls: ['./alcohol.component.css']
})
export class AlcoholComponent implements OnInit {

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

    calculate(){
      console.log(this.form.originalGravity.value , this.form.finalGravity.value)
      this.calcService.alcoholCalculation(this.form.originalGravity.value , this.form.finalGravity.value)
      .subscribe( data => {
        this.result = data;
      });

    }

}
